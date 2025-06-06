package com.budget.service.impl;

import com.budget.constant.AdminConstant;
import com.budget.constant.MessageConstant;

import com.budget.context.BaseContext;
import com.budget.dto.EnrollDTO;
import com.budget.dto.MemberDTO;
import com.budget.dto.MemberLoginDTO;
import com.budget.entity.Member;
import com.budget.exception.*;
import com.budget.mapper.AccountMapper;
import com.budget.mapper.MemberMapper;
import com.budget.service.MemberService;
import com.budget.vo.MemberVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public Member login(MemberLoginDTO memberLoginDTO) {
        String username = memberLoginDTO.getUsername();
        String password = memberLoginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        Member member = memberMapper.getByUsername(username);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (member == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对

        password= DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(member.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }



        //3、返回实体对象
        return member;
        
    }

    @Override
    public void addMember(MemberDTO memberDTO) {
        String name = memberDTO.getName();
        Member existingMember = memberMapper.getByName(name);
        if (existingMember != null) {
            throw new MemberAlreadyExistsException("用户 " + name + " 已存在");
        }
        Member member = new Member();
        BeanUtils.copyProperties(memberDTO, member);
        //判断是否创建账号
        String username = member.getUsername();
        if (username != null) {
            existingMember = memberMapper.getByUsername(username);
            if(existingMember!=null) {
                throw new UsernameAlreadyExistException(MessageConstant.USERNAME_ALREADY_EXIST);
            }
            String password = member.getPassword();
            String md5Password=DigestUtils.md5DigestAsHex(password.getBytes());
            member.setPassword(md5Password);
        }
        member.setFamilyId(BaseContext.getFamilyId());
        memberMapper.insert(member);
    }

    @Override
    public List<MemberVO> getMemberByFamilyId(Long familyId) {
        return memberMapper.getMemberByFamilyId(familyId);
    }

    @Override
    public void deleteMemberById(Long id) {
        //不能删除管理员
        if(id.equals(AdminConstant.ADMIN_ID)){
            throw  new AdminException(MessageConstant.ADMIN_DELETE_NOT_ALLOWED);
        }
        //用户不能删除自己
        if(id.equals(BaseContext.getCurrentId())){
            throw  new MemberException(MessageConstant.MEMBER_DELETE_NOT_ALLOWED);
        }
        //删除用户会一并删除其相关账目
        accountMapper.deleteByMemberId(id);
        memberMapper.deleteById(id);
    }

    @Override
    public void updateMember(MemberDTO memberDTO) {
        if(memberDTO.getId().equals(AdminConstant.ADMIN_ID) ){
            throw  new AdminException(MessageConstant.ADMIN_UPDATE_NOT_ALLOWED);
        }
        Member member = new Member();
        BeanUtils.copyProperties(memberDTO, member);
        String password = member.getPassword();
        if(password !=null){
            String md5Password=DigestUtils.md5DigestAsHex(password.getBytes());
            member.setPassword(md5Password);
        }else {

        }

        memberMapper.update(member);
    }

    @Override
    public Member getById(Long id) {
        Member member = memberMapper.getById(id);
        member.setPassword(null);
        return member;
    }

    @Override
    public void enroll(EnrollDTO enrollDTO) {
        String name = enrollDTO.getName();
        Member existingMember1 = memberMapper.getByName(name);
        Member existingMember2 = memberMapper.getByUsername(enrollDTO.getUsername());
        if (existingMember1 != null) {
            throw new MemberAlreadyExistsException("用户 " + name + " 已存在");
        }
        if (existingMember2 != null) {
            throw new MemberAlreadyExistsException("账号已存在");
        }
        Member member = new Member();
        BeanUtils.copyProperties(enrollDTO, member);
        // 1. 查询当前最大familyId
        Long maxId = memberMapper.findMaxFamilyId();
        member.setFamilyId(maxId+1);
        member.setPassword(DigestUtils.md5DigestAsHex(enrollDTO.getPassword().getBytes()));
        memberMapper.insert(member);
    }
}

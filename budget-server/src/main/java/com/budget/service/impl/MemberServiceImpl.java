package com.budget.service.impl;

import com.budget.constant.MessageConstant;
import com.budget.constant.StatusConstant;
import com.budget.dto.MemberLoginDTO;
import com.budget.entity.Member;
import com.budget.exception.AccountLockedException;
import com.budget.exception.AccountNotFoundException;
import com.budget.exception.PasswordErrorException;
import com.budget.mapper.MemberMapper;
import com.budget.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
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

        if (member.getStatus() == StatusConstant.DISABLE) {
            //账号被锁定
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        //3、返回实体对象
        return member;
        
    }
}

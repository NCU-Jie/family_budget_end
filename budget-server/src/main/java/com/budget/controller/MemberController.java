package com.budget.controller;

import com.budget.constant.JwtClaimsConstant;

import com.budget.context.BaseContext;
import com.budget.dto.EnrollDTO;
import com.budget.dto.MemberDTO;
import com.budget.dto.MemberLoginDTO;
import com.budget.entity.Member;

import com.budget.exception.MemberAlreadyExistsException;
import com.budget.properties.JwtProperties;
import com.budget.result.Result;

import com.budget.service.MemberService;
import com.budget.utils.JwtUtil;

import com.budget.vo.MemberLoginVO;
import com.budget.vo.MemberVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/budget/member")
@Slf4j
@Api(tags="成员相关接口")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public Result<String> enroll(@RequestBody EnrollDTO enrollDTO) {
        try {
            log.info("用户注册{}", enrollDTO);
            memberService.enroll(enrollDTO);
            return Result.success();
        } catch (MemberAlreadyExistsException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 登录
     *
     * @param memberLoginDTO
     * @return
     */

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result<MemberLoginVO> login(@RequestBody MemberLoginDTO memberLoginDTO) {
        log.info("用户登录：{}", memberLoginDTO);

        Member member = memberService.login(memberLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.MEMBER_ID, member.getId());
        claims.put(JwtClaimsConstant.USERNAME, member.getUsername());
        claims.put(JwtClaimsConstant.NAME, member.getName());
        claims.put(JwtClaimsConstant.FAMILY_ID, member.getFamilyId());
        String token = JwtUtil.createJWT(
                jwtProperties.getSecretKey(),
                jwtProperties.getTtl(),
                claims);

        MemberLoginVO memberLoginVO = MemberLoginVO.builder()
                .id(member.getId())
                .userName(member.getUsername())
                .name(member.getName())
                .token(token)
                .build();

        return Result.success(memberLoginVO);
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    @ApiOperation("员工退出")
    public Result<String> logout() {
        return Result.success();
    }

    @PostMapping("/add")
    @ApiOperation("添加家庭成员")
    public Result<String> add(@RequestBody MemberDTO memberDTO) {
        try {
            log.info("添加家庭成员{}", memberDTO);
            memberService.addMember(memberDTO);
            return Result.success();
        } catch (MemberAlreadyExistsException e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("根据家庭id查询家庭成员")
    @GetMapping("/list")
    public Result<List<MemberVO>> getMemberByFamilyId() {
        Long familyId = BaseContext.getFamilyId();
        log.info("根据家庭id查询家庭成员{}", familyId);
        List<MemberVO> memberVOList = memberService.getMemberByFamilyId(familyId);
        return Result.success(memberVOList);
    }

    @ApiOperation("根据id删除家庭成员")
    @DeleteMapping("/delete/{id}")
    public Result<String> delete(@PathVariable Long id) {
        log.info("根据id删除家庭成员{}", id);
        memberService.deleteMemberById(id);
        return Result.success();
    }

    @ApiOperation("修改家庭成员")
    @PutMapping("/update")
    public Result<String> update(@RequestBody MemberDTO memberDTO) {
        log.info("修改家庭成员{}", memberDTO);
        memberService.updateMember(memberDTO);
        return Result.success();
    }
    @ApiOperation("根据id查询用户")
    @GetMapping("/{id}")
    public Result<Member> getById(@PathVariable Long id) {
        log.info("根据id查询用户{}", id);
        Member member = memberService.getById(id);
        return Result.success(member);
    }

}

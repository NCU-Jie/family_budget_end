package com.budget.controller;

import com.budget.constant.JwtClaimsConstant;

import com.budget.constant.PasswordConstant;
import com.budget.constant.StatusConstant;
import com.budget.context.BaseContext;
import com.budget.dto.MemberLoginDTO;
import com.budget.entity.Member;

import com.budget.properties.JwtProperties;
import com.budget.result.Result;

import com.budget.service.MemberService;
import com.budget.utils.JwtUtil;

import com.budget.vo.MemberLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/member")
@Slf4j
@Api(tags="成员相关接口")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private JwtProperties jwtProperties;
    /**
     * 登录
     *
     * @param memberLoginDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("员工登录")
    public Result<MemberLoginVO> login(@RequestBody MemberLoginDTO memberLoginDTO) {
        log.info("员工登录：{}", memberLoginDTO);

        Member member = memberService.login(memberLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.MEMBER_ID, member.getId());
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

}

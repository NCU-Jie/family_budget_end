package com.budget.service;

import com.budget.dto.MemberDTO;
import com.budget.dto.MemberLoginDTO;
import com.budget.entity.Member;
import com.budget.vo.MemberVO;

import java.util.List;

public interface MemberService {
    Member login(MemberLoginDTO memberLoginDTO);

    void addMember(MemberDTO memberDTO);

    List<MemberVO> getMemberByFamilyId(Long familyId);

    void deleteMemberById(Long id);

    void updateMember(MemberDTO memberVO);
}

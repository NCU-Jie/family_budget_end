package com.budget.service;

import com.budget.dto.MemberLoginDTO;
import com.budget.entity.Member;

public interface MemberService {
    Member login(MemberLoginDTO memberLoginDTO);
}

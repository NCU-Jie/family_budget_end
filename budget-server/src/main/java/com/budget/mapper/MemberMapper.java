package com.budget.mapper;

import com.budget.annotation.AutoFill;
import com.budget.entity.Member;
import com.budget.enumeration.OperationType;
import com.budget.vo.MemberVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Select("select family_id from member where id = #{id}")
    Long getFamilyIdById(Long id) ;

    @Select("select * from member where username = #{username}")
    Member getByUsername(String username);

    @AutoFill(OperationType.INSERT)
    void insert(Member member);

    List<MemberVO> getMemberByFamilyId(Long familyId);

    void deleteById(Long id);

    void update(Member member);

    Member getByName(String name);
}

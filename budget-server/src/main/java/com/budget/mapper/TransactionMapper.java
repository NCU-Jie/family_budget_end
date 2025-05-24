package com.budget.mapper;

import com.budget.annotation.AutoFill;
import com.budget.entity.Transaction;
import com.budget.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TransactionMapper {
    @AutoFill(OperationType.INSERT)
    @Select("insert into transaction(category_id,member_id,money,description,create_time,update_time,create_user,update_user,type_id,family_id) values (#{categoryId},#{memberId},#{money},#{description},#{createTime},#{updateTime},#{createUser},#{updateUser}, #{typeId},#{familyId})")
    void insert(Transaction transaction);
}

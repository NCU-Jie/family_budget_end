package com.budget.mapper;

import com.budget.annotation.AutoFill;
import com.budget.dto.AccountPageQueryDTO;
import com.budget.dto.StatisticQueryDTO;
import com.budget.entity.Account;
import com.budget.enumeration.OperationType;
import com.budget.vo.AccountVO;
import com.budget.vo.StatisticVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AccountMapper {
    @AutoFill(OperationType.INSERT)
    @Select("insert into account(category_id,member_id,money,description,create_time,update_time,create_user,update_user,type_id,family_id,name,record_date) values (#{categoryId},#{memberId},#{money},#{description},#{createTime},#{updateTime},#{createUser},#{updateUser}, #{typeId},#{familyId},#{name}, #{recordDate})")
    void insert(Account account);

    Page<AccountVO> pageQuery(AccountPageQueryDTO accountPageQueryDTO);

    List<Account> getAccountByCategoryId(Long categoryId, Long familyId);

    @Delete("delete from account where id = #{id}")
    void deleteById(Long id);

    @AutoFill(OperationType.UPDATE)
    void update(Account account);

    List<StatisticVO> summary(StatisticQueryDTO statisticQueryDTO);
}

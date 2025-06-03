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
    @Select("insert into account(category_id,member_id,money,description,create_time,update_time,create_user,update_user,type_id,family_id,member_name,account_date) values (#{categoryId},#{memberId},#{money},#{description},#{createTime},#{updateTime},#{createUser},#{updateUser}, #{typeId},#{familyId},#{memberName}, #{accountDate})")
    void insert(Account account);

    Page<AccountVO> pageQuery(AccountPageQueryDTO accountPageQueryDTO);

    List<Account> getAccountByCategoryId(Long categoryId, Long familyId);

    @Delete("delete from account where id = #{id}")
    void deleteById(Long id);

    @AutoFill(OperationType.UPDATE)
    void update(Account account);


    @Select("select a.*,c.name as categoryName from account a join category c on a.category_id= c.id where a.id = #{id}")
    AccountVO getById(Long id);
    List<StatisticVO> summary(StatisticQueryDTO statisticQueryDTO);
}

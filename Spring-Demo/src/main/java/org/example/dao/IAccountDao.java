package org.example.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.example.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountDao {

    @Select("SELECT * FROM account")
    List<Account> findAll();

    @Insert("INSERT INTO account (name,money) VALUES(#{name},#{money})")
    void saveAccount(Account account);
}

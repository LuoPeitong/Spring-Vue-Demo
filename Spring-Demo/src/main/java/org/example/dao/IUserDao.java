package org.example.dao;

import org.apache.ibatis.annotations.Select;
import org.example.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {

    @Select("SELECT username,password FROM user WHERE username = #{username}")
    User queryByUsername(User user);
}

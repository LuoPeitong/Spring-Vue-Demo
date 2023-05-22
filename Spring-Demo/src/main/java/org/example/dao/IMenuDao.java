package org.example.dao;

import org.apache.ibatis.annotations.Select;
import org.example.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMenuDao {

    @Select("SELECT * FROM menu ORDER BY id")
    List<Menu> getAll();
}

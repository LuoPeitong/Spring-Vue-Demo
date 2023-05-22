package org.example.dao;

import org.apache.ibatis.annotations.Select;
import org.example.model.Func;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFuncDao {

    @Select("SELECT * FROM func ORDER BY menu_id")
    List<Func> getAll();
}

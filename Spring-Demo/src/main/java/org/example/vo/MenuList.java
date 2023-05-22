package org.example.vo;

import lombok.Data;
import org.example.model.Func;

import java.util.List;

@Data
public class MenuList {

    private String id;
    private String title;
    private String img;
    private List<Func> funcList;
}

package org.example.service.impl;

import org.example.dao.IFuncDao;
import org.example.dao.IMenuDao;
import org.example.model.Func;
import org.example.model.Menu;
import org.example.service.MenuService;
import org.example.vo.MenuList;
import org.example.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private IMenuDao iMenuDao;

    @Autowired
    private IFuncDao iFuncDao;

    public Result getMenu() {
        List<MenuList> finalList = new ArrayList<>();
        MenuList menuList;

        int flag = 0;
        List<Func> sqlList = iFuncDao.getAll();
        List<Menu> sqlList2 = iMenuDao.getAll();
        for (Menu menu : sqlList2) {
            menuList = new MenuList();
            menuList.setId(menu.getId());
            menuList.setTitle(menu.getTitle());
            menuList.setImg(menu.getImg());
            List<Func> funcList = new ArrayList<>();
            for (int i = flag; i < sqlList.size(); i++) {
                if (sqlList.get(i).getMenuId().equals(menuList.getId())) {
                    funcList.add(sqlList.get(i));
                    flag++;
                } else {
                    break;
                }
            }
            menuList.setFuncList(funcList);
            finalList.add(menuList);
        }
        return Result.ok(finalList, "菜单请求成功");
    }
}

package org.example.service.impl;

import org.example.dao.IUserDao;
import org.example.model.User;
import org.example.service.UserService;
import org.example.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserDao iUserDao;

    @Override
    public Result login(User user) {
        User sqlUser = iUserDao.queryByUsername(user);
        if (user.getPassword().equals(sqlUser.getPassword())) {
            return new Result(200);
        } else {
            return new Result(400);
        }
    }
}

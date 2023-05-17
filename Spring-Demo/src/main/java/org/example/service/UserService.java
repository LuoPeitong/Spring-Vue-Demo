package org.example.service;

import org.example.model.User;
import org.example.vo.Result;

public interface UserService {

    Result login(User user);
}

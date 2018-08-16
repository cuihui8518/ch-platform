package com.cuihui.platform.impl;

import com.cuihui.platform.entity.UserDTO;
import com.cuihui.platform.impl.dao.UserDAO;
import com.cuihui.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<UserDTO> findUserList() {
        return userDAO.findUserList();
    }
}

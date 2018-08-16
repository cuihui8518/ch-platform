package com.cuihui.platform.service.impl;

import com.cuihui.platform.dao.UserDAO;
import com.cuihui.platform.dto.UserDTO;
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

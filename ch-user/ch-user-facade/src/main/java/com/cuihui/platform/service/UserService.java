package com.cuihui.platform.service;

import com.cuihui.platform.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findUserList();
}

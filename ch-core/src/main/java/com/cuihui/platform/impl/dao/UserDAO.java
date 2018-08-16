package com.cuihui.platform.impl.dao;

import com.cuihui.platform.entity.UserDTO;
import java.util.List;

public interface UserDAO {

    List<UserDTO> findUserList();
}

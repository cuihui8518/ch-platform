package com.cuihui.platform.dao;

import com.cuihui.platform.dto.UserDTO;
import java.util.List;

public interface UserDAO {

    List<UserDTO> findUserList();
}

package com.cuihui.platform.controller;

import com.cuihui.platform.dto.UserDTO;
import com.cuihui.platform.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/findUserList.do")
    public String findUserList(Model model) {
        LOGGER.info("call method findUserList");
        List<UserDTO> userList = userService.findUserList();
        model.addAttribute("userList", userList);
        model.addAttribute("name", "你好啊");
        return "hello";
    }
}

package com.cuihui.platform.controller;

import com.cuihui.platform.entity.UserDTO;
import com.cuihui.platform.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HelloWorldController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(Model model) {
        LOGGER.info("call method hello");
        List<UserDTO> userList = userService.findUserList();
        model.addAttribute("userList", userList);
        model.addAttribute("name", "你好啊");
        return "hello";
    }
}

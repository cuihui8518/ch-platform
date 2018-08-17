package com.cuihui.platform.service.impl;

import com.alibaba.fastjson.JSON;
import com.cuihui.platform.common.UserRedisKeys;
import com.cuihui.platform.dao.UserDAO;
import com.cuihui.platform.dto.UserDTO;
import com.cuihui.platform.service.UserService;
import com.cuihui.platform.utils.redis.RedisService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RedisService redisService;

    @Override
    public List<UserDTO> findUserList() {
        List<UserDTO> userDTOList = null;
        String userStr = redisService.getJedisCluster().get(UserRedisKeys.USER_LIST);
        if(StringUtils.isBlank(userStr)) {
            userDTOList = userDAO.findUserList();
            redisService.getJedisCluster().set(UserRedisKeys.USER_LIST, JSON.toJSONString(userDTOList));
        } else {
            LOGGER.info("缓存数据：" + userStr);
            userDTOList = JSON.parseArray(userStr, UserDTO.class);
        }
        return userDTOList;
    }
}

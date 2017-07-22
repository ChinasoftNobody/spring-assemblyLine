package com.lgh.chinasoft.spring.assemblyLine.service.impl;

import com.lgh.chinasoft.spring.assemblyLine.dao.UserMapper;
import com.lgh.chinasoft.spring.assemblyLine.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/7/22.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public int test() {
        return userMapper.test();
    }
}

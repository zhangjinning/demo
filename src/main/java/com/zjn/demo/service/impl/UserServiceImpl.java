package com.zjn.demo.service.impl;

import com.zjn.demo.entity.User;
import com.zjn.demo.mapper.UserMapper;
import com.zjn.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangjinning
 * @since 2026-02-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}

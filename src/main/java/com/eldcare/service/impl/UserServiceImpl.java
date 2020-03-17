package com.eldcare.service.impl;

import com.eldcare.entity.User;
import com.eldcare.mapper.UserMapper;
import com.eldcare.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zarf
 * @since 2020-03-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}

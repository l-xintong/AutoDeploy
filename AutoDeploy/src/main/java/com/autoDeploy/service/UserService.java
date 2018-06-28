package com.autoDeploy.service;

import com.autoDeploy.entity.User;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lee
 * @since 2018-05-18
 */
public interface UserService extends IService<User> {

	String selectPhoneNumById(Long id);

	boolean insert(User user);




}

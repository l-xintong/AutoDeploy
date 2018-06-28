package com.autoDeploy.service.Impl;

import com.autoDeploy.entity.User;
import com.autoDeploy.mapper.UserMapper;
import com.autoDeploy.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lee
 * @since 2018-05-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {



	@Override
	public String selectPhoneNumById(Long id) {
		return "18181974195";
	}

	@Transactional
	@Override
	public boolean insert(User entity) {
		System.out.println(entity.getUsername());
	    boolean b =	 super.insert(entity);
	//	 int a =5/0;
		 return b;




	}
}

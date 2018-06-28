package com.autoDeploy.service.Impl;

import com.autoDeploy.entity.City;
import com.autoDeploy.mapper.CityMapper;
import com.autoDeploy.service.CityService;
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
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {

	@Override
	@Transactional
	public boolean insert(City entity) {
		System.out.println(entity.getCityName());
		return super.insert(entity);
	}
}

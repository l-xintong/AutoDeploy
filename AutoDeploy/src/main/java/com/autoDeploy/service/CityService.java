package com.autoDeploy.service;

import com.autoDeploy.entity.City;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lee
 * @since 2018-05-18
 */
public interface CityService extends IService<City> {

	@Override
	boolean insert(City city);
}

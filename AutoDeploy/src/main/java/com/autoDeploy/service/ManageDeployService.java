package com.autoDeploy.service;


import com.autoDeploy.entity.ManageDeploy;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lee
 * @since 2018-05-21
 */
public interface ManageDeployService extends IService<ManageDeploy> {

	String  testCode(String phoneNum);

	Page<ManageDeploy> selectPage(Page<ManageDeploy> page, Map<String, Object> map);
	
}

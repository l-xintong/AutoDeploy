package com.autoDeploy.service;


import com.autoDeploy.entity.ManageJob;

import com.autoDeploy.entity.po.PoManageJob;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lee
 * @since 2018-05-21
 */
public interface ManageJobService extends IService<ManageJob> {

	Page<ManageJob> selectPageList(Page<ManageJob> page, Map<String, Object> map);

	List<PoManageJob> findAll(Map<String, Object> map);

	boolean saveFile(MultipartFile file, String filePath);

}

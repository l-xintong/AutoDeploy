package com.autoDeploy.mapper;


import com.autoDeploy.entity.ManageDeploy;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author lee
 * @since 2018-05-21
 */
@Mapper
@Repository
public interface ManageDeployMapper extends BaseMapper<ManageDeploy> {

	List<ManageDeploy> queryPage(Page<ManageDeploy> page, Map<String, Object> map);

}
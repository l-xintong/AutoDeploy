package com.autoDeploy.mapper;


import com.autoDeploy.entity.ManageJob;
import com.autoDeploy.entity.po.PoManageJob;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
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
public interface ManageJobMapper extends BaseMapper<ManageJob> {

	 List<ManageJob> selectPageList(Pagination page, Map<String, Object> map);

	 List<PoManageJob> findAll(Map<String, Object> map);

}
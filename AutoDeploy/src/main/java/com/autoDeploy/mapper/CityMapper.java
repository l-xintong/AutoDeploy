package com.autoDeploy.mapper;

import com.autoDeploy.entity.City;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author lee
 * @since 2018-05-18
 */
@Mapper
@Repository
public interface CityMapper extends BaseMapper<City> {

}
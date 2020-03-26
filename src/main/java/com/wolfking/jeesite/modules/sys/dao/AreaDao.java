/**
 */
package com.wolfking.jeesite.modules.sys.dao;

import com.wolfking.jeesite.common.persistence.TreeDao;
import com.wolfking.jeesite.modules.sys.entity.Area;
import org.apache.ibatis.annotations.Mapper;

/**
 * 区域DAO接口
 *
 */
@Mapper
public interface AreaDao extends TreeDao<Area> {

}

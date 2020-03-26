/**
 */
package com.wolfking.jeesite.modules.sys.dao;

import com.wolfking.jeesite.common.persistence.TreeDao;
import com.wolfking.jeesite.modules.sys.entity.Office;
import org.apache.ibatis.annotations.Mapper;

/**
 * 机构DAO接口
 *
 */
@Mapper
public interface OfficeDao extends TreeDao<Office> {

}

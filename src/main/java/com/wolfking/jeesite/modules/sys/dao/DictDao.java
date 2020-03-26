/**
 */
package com.wolfking.jeesite.modules.sys.dao;

import com.wolfking.jeesite.common.persistence.CrudDao;
import com.wolfking.jeesite.modules.sys.entity.Dict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 字典DAO接口
 *
 */
@Mapper
public interface DictDao extends CrudDao<Dict> {

    List<String> findTypeList(Dict dict);

}

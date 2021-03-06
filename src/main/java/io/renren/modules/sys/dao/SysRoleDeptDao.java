package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.SysRoleDeptEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色与部门对应关系
 *
 */
@Repository
public interface SysRoleDeptDao extends BaseDao<SysRoleDeptEntity> {
	
	/**
	 * 根据角色ID，获取部门ID列表
	 */
	List<Long> queryDeptIdList(Long roleId);
}

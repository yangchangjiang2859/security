package io.renren.modules.sys.service.impl;

import io.renren.modules.sys.dao.SysRoleDeptDao;
import io.renren.modules.sys.service.SysRoleDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 角色与部门对应关系
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017年6月21日 23:42:30
 */
@Service("sysRoleDeptService")
public class SysRoleDeptServiceImpl implements SysRoleDeptService {

	@Autowired
	private SysRoleDeptDao sysRoleDeptDao;

	@Override
	@Transactional
	public void saveOrUpdate(Long deptId, List<Long> roleIdList) {
		//先删除角色与菜单关系
		sysRoleDeptDao.delete(deptId);

		if(roleIdList.size() == 0){
			return ;
		}

		//保存角色与菜单关系
		Map<String, Object> map = new HashMap<>();
		map.put("deptId", deptId);
		map.put("roleIdList", roleIdList);
		sysRoleDeptDao.save(map);
	}

	@Override
	public List<Long> queryDeptIdList(Long deptId) {
		return sysRoleDeptDao.queryDeptIdList(deptId);
	}

}

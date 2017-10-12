package com.effecia.modules.sys.service;

import java.util.List;


/**
 * 角色与部门对应关系
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017年10月21日 23:42:30
 */
public interface SysRoleDeptService {
	
	void saveOrUpdate(Long roleId, List<Long> deptIdList);
	
	/**
	 * 根据角色ID，获取部门ID列表
	 */
	List<Long> queryDeptIdList(Long roleId);

	List<Long> queryRoleIdList(Long deptId);
	
}

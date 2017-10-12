package com.effecia.modules.sys.service;

import java.util.List;


/**
 * 角色与菜单对应关系
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017年10月18日 上午9:42:30
 */
public interface SysRoleMenuService {
	
	void saveOrUpdate(Long roleId, List<Long> menuIdList);
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);
	
}

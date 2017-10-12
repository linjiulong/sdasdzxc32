package com.effecia.modules.sys.dao;

import com.effecia.modules.sys.entity.SysMenuEntity;

import java.util.List;

/**
 * 菜单管理
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017年10月18日 上午9:33:01
 */
public interface SysMenuDao extends BaseDao<SysMenuEntity> {
	
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<SysMenuEntity> queryListParentId(Long parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenuEntity> queryNotButtonList();
	
	/**
	 * 查询用户的权限列表
	 */
	List<SysMenuEntity> queryUserList(Long userId);
}

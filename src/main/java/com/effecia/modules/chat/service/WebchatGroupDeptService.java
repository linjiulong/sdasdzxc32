package com.effecia.modules.chat.service;

import com.effecia.modules.chat.entity.WebchatGroupDeptEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-11 11:24:45
 */
public interface WebchatGroupDeptService {
	
	WebchatGroupDeptEntity queryObject(Integer id);

	WebchatGroupDeptEntity queryFind(Integer id,Long deptId);
	
	
	List<WebchatGroupDeptEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WebchatGroupDeptEntity webchatGroupDept);
	
	void update(WebchatGroupDeptEntity webchatGroupDept);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}

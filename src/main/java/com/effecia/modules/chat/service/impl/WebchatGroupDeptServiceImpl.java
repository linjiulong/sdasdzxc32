package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.WebchatGroupDeptDao;
import com.effecia.modules.chat.entity.WebchatGroupDeptEntity;
import com.effecia.modules.chat.service.WebchatGroupDeptService;



@Service("webchatGroupDeptService")
public class WebchatGroupDeptServiceImpl implements WebchatGroupDeptService {
	@Autowired
	private WebchatGroupDeptDao webchatGroupDeptDao;
	
	@Override
	public WebchatGroupDeptEntity queryObject(Integer id){
		return webchatGroupDeptDao.queryObject(id);
	}
	
	@Override
	public List<WebchatGroupDeptEntity> queryList(Map<String, Object> map){
		return webchatGroupDeptDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return webchatGroupDeptDao.queryTotal(map);
	}
	
	@Override
	public void save(WebchatGroupDeptEntity webchatGroupDept){
		webchatGroupDeptDao.save(webchatGroupDept);
	}
	
	@Override
	public void update(WebchatGroupDeptEntity webchatGroupDept){
		webchatGroupDeptDao.update(webchatGroupDept);
	}
	
	@Override
	public void delete(Integer id){
		webchatGroupDeptDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		webchatGroupDeptDao.deleteBatch(ids);
	}

	@Override
	public WebchatGroupDeptEntity queryFind(Integer id, Long deptId) {
		Map<String, Object> map=new HashMap<>();
		map.put("deptid", deptId);
		map.put("groupsid", id);
		return webchatGroupDeptDao.queryFind(map);
	}
	
}

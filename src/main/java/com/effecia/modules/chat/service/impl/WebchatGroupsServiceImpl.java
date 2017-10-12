package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.WebchatGroupDetailDao;
import com.effecia.modules.chat.dao.WebchatGroupsDao;
import com.effecia.modules.chat.entity.WebchatGroupsEntity;
import com.effecia.modules.chat.entity.WebchatUserEntity;
import com.effecia.modules.chat.service.WebchatGroupsService;



@Service("webchatGroupsService")
public class WebchatGroupsServiceImpl implements WebchatGroupsService {
	@Autowired
	private WebchatGroupsDao webchatGroupsDao;

	
	@Override
	public WebchatGroupsEntity queryObject(Integer id){
		return webchatGroupsDao.queryObject(id);
	}
	
	@Override
	public List<WebchatGroupsEntity> queryList(Map<String, Object> map){
		return webchatGroupsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return webchatGroupsDao.queryTotal(map);
	}
	
	@Override
	public void save(WebchatGroupsEntity webchatGroups){
		webchatGroupsDao.save(webchatGroups);
	}
	
	@Override
	public void update(WebchatGroupsEntity webchatGroups){
		webchatGroupsDao.update(webchatGroups);
	}
	
	@Override
	public void delete(Integer id){
		webchatGroupsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		webchatGroupsDao.deleteBatch(ids);
	}

	@Override
	public List<WebchatGroupsEntity> querySelect(Map<String, Object> map) {
		return webchatGroupsDao.querySelect(map);
	}


	
}

package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.WebchatFriendgroupDao;
import com.effecia.modules.chat.entity.WebchatFriendgroupEntity;
import com.effecia.modules.chat.service.WebchatFriendgroupService;



@Service("webchatFriendgroupService")
public class WebchatFriendgroupServiceImpl implements WebchatFriendgroupService {
	@Autowired
	private WebchatFriendgroupDao webchatFriendgroupDao;
	
	@Override
	public WebchatFriendgroupEntity queryObject(Integer id){
		return webchatFriendgroupDao.queryObject(id);
	}
	
	@Override
	public List<WebchatFriendgroupEntity> queryList(Map<String, Object> map){
		return webchatFriendgroupDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return webchatFriendgroupDao.queryTotal(map);
	}
	
	@Override
	public void save(WebchatFriendgroupEntity webchatFriendgroup){
		webchatFriendgroupDao.save(webchatFriendgroup);
	}
	
	@Override
	public void update(WebchatFriendgroupEntity webchatFriendgroup){
		webchatFriendgroupDao.update(webchatFriendgroup);
	}
	
	@Override
	public void delete(Integer id){
		webchatFriendgroupDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		webchatFriendgroupDao.deleteBatch(ids);
	}
	
}

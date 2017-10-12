package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.WebchatFriendgroupDetailDao;
import com.effecia.modules.chat.entity.WebchatFriendgroupDetailEntity;
import com.effecia.modules.chat.service.WebchatFriendgroupDetailService;



@Service("webchatFriendgroupDetailService")
public class WebchatFriendgroupDetailServiceImpl implements WebchatFriendgroupDetailService {
	@Autowired
	private WebchatFriendgroupDetailDao webchatFriendgroupDetailDao;
	
	@Override
	public WebchatFriendgroupDetailEntity queryObject(Integer id){
		return webchatFriendgroupDetailDao.queryObject(id);
	}
	
	@Override
	public List<WebchatFriendgroupDetailEntity> queryList(Map<String, Object> map){
		return webchatFriendgroupDetailDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return webchatFriendgroupDetailDao.queryTotal(map);
	}
	
	@Override
	public void save(WebchatFriendgroupDetailEntity webchatFriendgroupDetail){
		webchatFriendgroupDetailDao.save(webchatFriendgroupDetail);
	}
	
	@Override
	public void update(WebchatFriendgroupDetailEntity webchatFriendgroupDetail){
		webchatFriendgroupDetailDao.update(webchatFriendgroupDetail);
	}
	
	@Override
	public void delete(Integer id){
		webchatFriendgroupDetailDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		webchatFriendgroupDetailDao.deleteBatch(ids);
	}
	
}

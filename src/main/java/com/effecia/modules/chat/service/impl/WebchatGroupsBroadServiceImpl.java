package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.WebchatGroupsBroadDao;
import com.effecia.modules.chat.entity.WebchatGroupsBroadEntity;
import com.effecia.modules.chat.service.WebchatGroupsBroadService;



@Service("webchatGroupsBroadService")
public class WebchatGroupsBroadServiceImpl implements WebchatGroupsBroadService {
	@Autowired
	private WebchatGroupsBroadDao webchatGroupsBroadDao;
	
	@Override
	public WebchatGroupsBroadEntity queryObject(Integer id){
		return webchatGroupsBroadDao.queryObject(id);
	}
	
	@Override
	public List<WebchatGroupsBroadEntity> queryList(Map<String, Object> map){
		return webchatGroupsBroadDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return webchatGroupsBroadDao.queryTotal(map);
	}
	
	@Override
	public void save(WebchatGroupsBroadEntity webchatGroupsBroad){
		webchatGroupsBroadDao.save(webchatGroupsBroad);
	}
	
	@Override
	public void update(WebchatGroupsBroadEntity webchatGroupsBroad){
		webchatGroupsBroadDao.update(webchatGroupsBroad);
	}
	
	@Override
	public void delete(Integer id){
		webchatGroupsBroadDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		webchatGroupsBroadDao.deleteBatch(ids);
	}
	
}

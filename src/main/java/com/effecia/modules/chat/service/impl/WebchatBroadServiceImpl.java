package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.WebchatBroadDao;
import com.effecia.modules.chat.entity.WebchatBroadEntity;
import com.effecia.modules.chat.service.WebchatBroadService;



@Service("webchatBroadService")
public class WebchatBroadServiceImpl implements WebchatBroadService {
	@Autowired
	private WebchatBroadDao webchatBroadDao;
	
	@Override
	public WebchatBroadEntity queryObject(Integer id){
		return webchatBroadDao.queryObject(id);
	}
	
	@Override
	public List<WebchatBroadEntity> queryList(Map<String, Object> map){
		return webchatBroadDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return webchatBroadDao.queryTotal(map);
	}
	
	@Override
	public void save(WebchatBroadEntity webchatBroad){
		webchatBroadDao.save(webchatBroad);
	}
	
	@Override
	public void update(WebchatBroadEntity webchatBroad){
		webchatBroadDao.update(webchatBroad);
	}
	
	@Override
	public void delete(Integer id){
		webchatBroadDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		webchatBroadDao.deleteBatch(ids);
	}
	
}

package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.WebchatMessageboxDao;
import com.effecia.modules.chat.entity.WebchatMessageboxEntity;
import com.effecia.modules.chat.service.WebchatMessageboxService;



@Service("webchatMessageboxService")
public class WebchatMessageboxServiceImpl implements WebchatMessageboxService {
	@Autowired
	private WebchatMessageboxDao webchatMessageboxDao;
	
	@Override
	public WebchatMessageboxEntity queryObject(Integer id){
		return webchatMessageboxDao.queryObject(id);
	}
	
	@Override
	public List<WebchatMessageboxEntity> queryList(Map<String, Object> map){
		return webchatMessageboxDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return webchatMessageboxDao.queryTotal(map);
	}
	
	@Override
	public void save(WebchatMessageboxEntity webchatMessagebox){
		webchatMessageboxDao.save(webchatMessagebox);
	}
	
	@Override
	public void update(WebchatMessageboxEntity webchatMessagebox){
		webchatMessageboxDao.update(webchatMessagebox);
	}
	
	@Override
	public void delete(Integer id){
		webchatMessageboxDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		webchatMessageboxDao.deleteBatch(ids);
	}
	
}

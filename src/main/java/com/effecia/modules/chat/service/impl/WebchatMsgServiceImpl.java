package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.WebchatMsgDao;
import com.effecia.modules.chat.entity.WebchatMsgEntity;
import com.effecia.modules.chat.service.WebchatMsgService;



@Service("webchatMsgService")
public class WebchatMsgServiceImpl implements WebchatMsgService {
	@Autowired
	private WebchatMsgDao webchatMsgDao;
	
	@Override
	public WebchatMsgEntity queryObject(Integer id){
		return webchatMsgDao.queryObject(id);
	}
	
	@Override
	public List<WebchatMsgEntity> queryList(Map<String, Object> map){
		return webchatMsgDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return webchatMsgDao.queryTotal(map);
	}
	
	@Override
	public void save(WebchatMsgEntity webchatMsg){
		webchatMsgDao.save(webchatMsg);
	}
	
	@Override
	public void update(WebchatMsgEntity webchatMsg){
		webchatMsgDao.update(webchatMsg);
	}
	
	@Override
	public void delete(Integer id){
		webchatMsgDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		webchatMsgDao.deleteBatch(ids);
	}
 
	
}

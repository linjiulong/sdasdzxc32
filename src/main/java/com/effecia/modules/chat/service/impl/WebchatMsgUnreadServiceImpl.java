package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.WebchatMsgUnreadDao;
import com.effecia.modules.chat.entity.WebchatMsgUnreadEntity;
import com.effecia.modules.chat.service.WebchatMsgUnreadService;



@Service("webchatMsgUnreadService")
public class WebchatMsgUnreadServiceImpl implements WebchatMsgUnreadService {
	@Autowired
	private WebchatMsgUnreadDao webchatMsgUnreadDao;
	
	@Override
	public WebchatMsgUnreadEntity queryObject(Integer id){
		return webchatMsgUnreadDao.queryObject(id);
	}
	
	@Override
	public List<WebchatMsgUnreadEntity> queryList(Map<String, Object> map){
		return webchatMsgUnreadDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return webchatMsgUnreadDao.queryTotal(map);
	}
	
	@Override
	public void save(WebchatMsgUnreadEntity webchatMsgUnread){
		webchatMsgUnreadDao.save(webchatMsgUnread);
	}
	
	@Override
	public void update(WebchatMsgUnreadEntity webchatMsgUnread){
		webchatMsgUnreadDao.update(webchatMsgUnread);
	}
	
	@Override
	public void delete(Integer id){
		webchatMsgUnreadDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		webchatMsgUnreadDao.deleteBatch(ids);
	}
	
}

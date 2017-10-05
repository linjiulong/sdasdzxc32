package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.ChatGroupDao;
import com.effecia.modules.chat.entity.ChatGroupEntity;
import com.effecia.modules.chat.service.ChatGroupService;



@Service("chatGroupService")
public class ChatGroupServiceImpl implements ChatGroupService {
	@Autowired
	private ChatGroupDao chatGroupDao;
	
	@Override
	public ChatGroupEntity queryObject(Integer id){
		return chatGroupDao.queryObject(id);
	}
	
	@Override
	public List<ChatGroupEntity> queryList(Map<String, Object> map){
		return chatGroupDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return chatGroupDao.queryTotal(map);
	}
	
	@Override
	public void save(ChatGroupEntity chatGroup){
		chatGroupDao.save(chatGroup);
	}
	
	@Override
	public void update(ChatGroupEntity chatGroup){
		chatGroupDao.update(chatGroup);
	}
	
	@Override
	public void delete(Integer id){
		chatGroupDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		chatGroupDao.deleteBatch(ids);
	}
	
}

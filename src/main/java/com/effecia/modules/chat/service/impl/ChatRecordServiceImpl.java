package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.ChatRecordDao;
import com.effecia.modules.chat.entity.ChatRecordEntity;
import com.effecia.modules.chat.service.ChatRecordService;



@Service("chatRecordService")
public class ChatRecordServiceImpl implements ChatRecordService {
	@Autowired
	private ChatRecordDao chatRecordDao;
	
	@Override
	public ChatRecordEntity queryObject(Integer id){
		return chatRecordDao.queryObject(id);
	}
	
	@Override
	public List<ChatRecordEntity> queryList(Map<String, Object> map){
		return chatRecordDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return chatRecordDao.queryTotal(map);
	}
	
	@Override
	public void save(ChatRecordEntity chatRecord){
		chatRecordDao.save(chatRecord);
	}
	
	@Override
	public void update(ChatRecordEntity chatRecord){
		chatRecordDao.update(chatRecord);
	}
	
	@Override
	public void delete(Integer id){
		chatRecordDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		chatRecordDao.deleteBatch(ids);
	}
	
}

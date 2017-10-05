package com.effecia;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;






@Service
public class InitService {
 
	
//	@Resource
//	private HappyChatMain chatMain;
	
	@Resource
	private TaskExecutor taskExecutor;

	
	@PostConstruct
	public void init(){
		
//		taskExecutor.execute(chatMain);
//		taskExecutor.execute(gameServer);
		
	}


}

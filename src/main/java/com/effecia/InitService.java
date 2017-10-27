package com.effecia;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.effecia.common.netty.server.TcpServer;



@Service
public class InitService {

	@Resource
	private TcpServer Server;
	
	@Resource
	private TaskExecutor taskExecutor;
	
	@PostConstruct
	public void init(){

		taskExecutor.execute(Server);
		
		
	}
	
	
	
	
}

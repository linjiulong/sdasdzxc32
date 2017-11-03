package com.effecia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.effecia.common.netty.server.TcpServer;


@Service
public class InitService {

	@Resource
	private TaskExecutor taskExecutor;
	@Resource
	private TcpServer Server;

	
	@PostConstruct
	public void init(){

		taskExecutor.execute(Server);
		
		
	}
	
	
	
	
}

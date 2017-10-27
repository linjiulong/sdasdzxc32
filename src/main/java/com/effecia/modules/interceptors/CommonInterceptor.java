package com.effecia.modules.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


//public class CommonInterceptor extends HandlerInterceptorAdapter{  
	public class CommonInterceptor{  
		
//	private Logger log = LoggerFactory.getLogger(getClass());
//	 /**  
//     * 在业务处理器处理请求之前被调用  
//     * 如果返回false  
//     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 
//     * 如果返回true  
//     *    执行下一个拦截器,直到所有的拦截器都执行完毕  
//     *    再执行被拦截的Controller  
//     *    然后进入拦截器链,  
//     *    从最后一个拦截器往回执行所有的postHandle()  
//     *    接着再从最后一个拦截器往回执行所有的afterCompletion()  
//     */    
//    @Override    
//    public boolean preHandle(HttpServletRequest request,    
//            HttpServletResponse response, Object handler) throws Exception {    
//        log.info("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");   
//        log.info("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");   
//
//        log.info("==============执行顺序: 1、preHandle================");    
//        String requestUri = request.getRequestURI();  
//        String contextPath = request.getContextPath();  
//        String url = requestUri.substring(contextPath.length());  
//        
//        log.info("requestUri:"+requestUri);    
//        log.info("contextPath:"+contextPath);    
//        log.info("url:"+url);    
//		SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
//		log.info("user:"+user); 
//		log.info("Session:"+request.getSession()); 
//
//            return true;     
//    }    
//    
//    /** 
//     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作    
//     * 可在modelAndView中加入数据，比如当前时间 
//     */  
//    @Override    
//    public void postHandle(HttpServletRequest request,    
//            HttpServletResponse response, Object handler,    
//            ModelAndView modelAndView) throws Exception {     
//        log.info("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");   
//        log.info("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");   
//
//        log.info("==============执行顺序: 2、postHandle================");    
//		SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
//		log.info("user:"+user);  
//		log.info("Session:"+request.getSession()); 
//
//           
//    }    
//    
//    /**  
//     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等   
//     *   
//     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()  
//     */    
//    @Override    
//    public void afterCompletion(HttpServletRequest request,    
//            HttpServletResponse response, Object handler, Exception ex)    
//            throws Exception {    
//        log.info("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");   
//        log.info("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");   
//        log.info("==============执行顺序: 3、afterCompletion================");   
//		SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
//		log.info("user:"+user);  
//		log.info("Session:"+request.getSession()); 
//
//    }    
  
	
}

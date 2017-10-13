package com.effecia.modules.oss.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.effecia.common.exception.RRException;
import com.effecia.modules.sys.service.SysConfigService;
import com.effecia.common.utils.*;
import com.effecia.common.validator.ValidatorUtils;
import com.effecia.modules.oss.entity.SysOssEntity;
import com.effecia.modules.oss.service.SysOssService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;


/**
 * 文件上传
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-03-25 12:13:26
 */
@RestController
@RequestMapping("sys/oss")
public class SysOssController {
	@Autowired
	private SysOssService sysOssService;
    @Autowired
    private SysConfigService sysConfigService;

	

	/**
	 * 上传文件
	 */
	@RequestMapping("/upload")
	@RequiresPermissions("sys:oss:all")
	public R upload(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws Exception {
		if (file.isEmpty()) {
			throw new RRException("上传文件不能为空");
		}

		//上传文件

        String serverPath = request.getSession().getServletContext().getRealPath(""); 
        System.out.println("serverPath:"+serverPath);
        serverPath=serverPath+"/statics/upload/image/";
        
        Date date=new Date();
        String fileName = date.getTime()+file.getOriginalFilename();  
        
        File targetFile = new File(serverPath, fileName);  
        
        if(!new File(serverPath).isDirectory()){ 
            new File(serverPath).mkdirs();  
        }  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  

		
		
//		//保存文件信息
//		SysOssEntity ossEntity = new SysOssEntity();
//		ossEntity.setUrl(url);
//		ossEntity.setCreateDate(new Date());
//		sysOssService.save(ossEntity);
        return R.ok().put("url",request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath()+"/statics/upload/image/"+fileName);
	}



}

package com.effecia.modules.chat.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.effecia.modules.chat.entity.WebchatGroupDetailEntity;
import com.effecia.modules.chat.entity.WebchatUserEntity;
import com.effecia.modules.sys.entity.SysUserEntity;
import com.effecia.modules.chat.service.WebchatGroupDetailService;
import com.effecia.modules.chat.service.WebchatUserService;
import com.alibaba.fastjson.JSON;
import com.effecia.common.utils.PageUtils;
import com.effecia.common.utils.Query;
import com.effecia.common.utils.R;


/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
@RestController
@RequestMapping("webchatgroupdetail")
public class WebchatGroupDetailController {
	@Autowired
	private WebchatGroupDetailService webchatGroupDetailService;
	
	@Autowired
	private WebchatUserService webchatUserService;
	
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("webchatgroupdetail:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WebchatGroupDetailEntity> webchatGroupDetailList = webchatGroupDetailService.queryList(query);
		int total = webchatGroupDetailService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(webchatGroupDetailList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

	
	/**
	 * 群成员列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/select/{gid}")
	@RequiresPermissions("webchatgroupdetail:select")
	public R select(@PathVariable("gid") Integer gid,@RequestParam Map<String, Object> params){
		
		params.put("gid", gid);
		
		Long DeptId = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getDeptId();
		if(DeptId!=0){
			 
		}
		//查询列表数据
		Query query = new Query(params);
		
		List<WebchatGroupDetailEntity> webchatGroupDetailList = webchatGroupDetailService.queryList(query);
		
		
		int total = webchatGroupDetailService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(webchatGroupDetailList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{gid}")
	@RequiresPermissions("webchatgroupdetail:info")
	public R info(@PathVariable("gid") Integer gid){
		System.out.println("gid:"+gid);
		WebchatGroupDetailEntity webchatGroupDetail = webchatGroupDetailService.queryObject(gid);
		
		return R.ok().put("webchatGroupDetail", webchatGroupDetail);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("webchatgroupdetail:save")
	public R save(@RequestBody WebchatGroupDetailEntity webchatGroupDetail){
		
		
		Long DeptId = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getDeptId();
		Map<String,Object> params=new HashMap<>();
		if(DeptId!=0){
			params.put("DeptId", DeptId);
		}
		
		System.out.println("webchatGroupDetail:"+webchatGroupDetail);
		List<Object> users= JSON.parseArray(webchatGroupDetail.getUsers());
		if(users!=null){
			for (Object userid : users) {
				Date addtime=new Date();
				Integer id=Integer.parseInt(userid+"");
				webchatGroupDetail.setAddTime(addtime);
				webchatGroupDetail.setGStatus(0);
				webchatGroupDetail.setUid(id);
				
				webchatGroupDetail.setLevel(1);
				params.put("id", id);
				System.out.println("id:"+id);
				WebchatUserEntity   UserEntity= webchatUserService.finduser(params);
				webchatGroupDetail.setNickName(UserEntity.getUsername());
				System.out.println("=============");
				System.out.println("=============");
				System.out.println("UserEntity:"+UserEntity);
				System.out.println("webchatGroupDetail:"+webchatGroupDetail);
				System.out.println("=============");
				System.out.println("=============");
				if("0".equals(UserEntity.getSalt().toString())||"0"==UserEntity.getSalt().toString()){
					webchatGroupDetail.setLevel(1);
					System.out.println("修改："+params.toString());
					int count=webchatGroupDetailService.updategroup(webchatGroupDetail);
					System.out.println("count:"+count);
					if(count==0){
						webchatGroupDetailService.save(webchatGroupDetail);
					}
				}else {
					webchatGroupDetail.setLevel(2);
					webchatGroupDetailService.save(webchatGroupDetail);
				}
//				webchatGroupDetailService.save(webchatGroupDetail);
			}
		}
//		webchatGroupDetailService.save(webchatGroupDetail);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("webchatgroupdetail:update")
	public R update(@RequestBody WebchatGroupDetailEntity webchatGroupDetail){
		webchatGroupDetailService.update(webchatGroupDetail);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("webchatgroupdetail:delete")
	public R delete(@RequestBody Integer[] gids){
	  
		Map<String,Object> map=new HashMap<>();
		Integer[] uids=new Integer[gids.length-1];
			for (int i = 0; i < gids.length; i++) {
				if(i==0){
					 map.put("gid", gids[0]);
				}else {
					uids[i-1]=gids[i];
				}
			}
			map.put("ids", uids);
			System.out.println("--------delete------");
			System.out.println(map.toString());
		webchatGroupDetailService.deleteBatch(map);
		
		return R.ok();
	}
	
	@RequestMapping("/admins/{gid}-{uid}")
	@RequiresPermissions("webchatgroupdetail:admins")
	public R administrator(@PathVariable("gid") Integer gid,@PathVariable("uid") Integer uid){
	     Map<String,Object> map=new HashMap<>();
	     
	     map.put("gid", gid);
	     map.put("uid", uid);
	     System.out.println("map:"+map);
	     WebchatGroupDetailEntity WebchatGroupDetail=webchatGroupDetailService.queryFindObject(map);
	     Integer level=WebchatGroupDetail.getLevel();
	      if(level==1){
	    	  level=2;
	      }else if (level==2) {
	    	  level=1;
		}
	     WebchatGroupDetail.setLevel(level);
	     System.out.println("WebchatGroupDetail:"+WebchatGroupDetail);
		webchatGroupDetailService.update(WebchatGroupDetail);

	     
	     
		return R.ok();
	}

	@RequestMapping("/banned")
	@RequiresPermissions("webchatgroupdetail:banned")
	public R banned(@RequestBody WebchatGroupDetailEntity webchatGroupDetail){
	     System.out.println("WebchatGroupDetail:"+webchatGroupDetail);

	     
	     if(webchatGroupDetail.getBannedTime()==null||webchatGroupDetail.getBannedTime().toString()==""){
	    	 webchatGroupDetail.setGStatus(0);
	    	 webchatGroupDetail.setBannedTime(null);
	     }else {
	    	 
	    	 Date date=new Date();
	    	 
	    	 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS"); 
	    	 System.out.println(webchatGroupDetail.getBannedTime());
	    	 System.out.println(sdf1.format(date));
	    	 webchatGroupDetail.setGStatus(1);
		 }
		
	     webchatGroupDetailService.update(webchatGroupDetail);

		return R.ok();
	}
	
	
	
}

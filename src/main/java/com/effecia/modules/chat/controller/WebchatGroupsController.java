package com.effecia.modules.chat.controller;

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
import com.effecia.modules.chat.entity.WebchatGroupsEntity;
import com.effecia.modules.chat.entity.WebchatUserEntity;
import com.effecia.modules.sys.entity.SysUserEntity;
import com.effecia.modules.chat.service.WebchatGroupDetailService;
import com.effecia.modules.chat.service.WebchatGroupsService;
import com.effecia.modules.chat.service.WebchatUserService;
import com.alibaba.fastjson.JSON;
import com.effecia.common.utils.PageUtils;
import com.effecia.common.utils.Query;
import com.effecia.common.utils.R;
import com.effecia.common.validator.ValidatorUtils;
import com.effecia.common.validator.group.AddGroup;
import com.effecia.common.validator.group.UpdateGroup;


/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
@RestController
@RequestMapping("webchatgroups")
public class WebchatGroupsController {
	@Autowired
	private WebchatGroupsService webchatGroupsService;
	@Autowired
	private WebchatGroupDetailService webchatGroupDetailService;
	
	
	
	@Autowired
	private WebchatUserService webchatUserService;
	
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("webchatgroups:list")
	public R list(@RequestParam Map<String, Object> params){
		
		Long DeptId = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getDeptId();
		if(DeptId!=0){
			params.put("DeptId", DeptId);
		}
		System.out.println("params:"+params);
		System.out.println("DeptId:"+DeptId);
		//查询列表数据
        Query query = new Query(params);

		List<WebchatGroupsEntity> webchatGroupsList = webchatGroupsService.queryList(query);
		 
		
		
		int total = webchatGroupsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(webchatGroupsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 聊天群列表
	 */
	@RequestMapping("/select")
	@RequiresPermissions("webchatgroups:select")
	public R  select(@RequestParam Map<String, Object> params){
	
		Long DeptId = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getDeptId();
		if(DeptId!=0){
			params.put("DeptId", DeptId);
		}
		
		 System.out.println("DeptId:"+DeptId);
		
		//查询列表数据
		List<WebchatGroupsEntity> webchatGroupsEntity = webchatGroupsService.querySelect(params);
		for (WebchatGroupsEntity  GroupsEntity : webchatGroupsEntity) {
			System.out.println(GroupsEntity);
		}
		return R.ok().put("list", webchatGroupsEntity);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("webchatgroups:info")
	public R info(@PathVariable("id") Integer id){
		
		
		Long DeptId = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getDeptId();
		if(DeptId!=0){
		}
		
		WebchatGroupsEntity webchatGroups = webchatGroupsService.queryObject(id);
		
		return R.ok().put("webchatGroups", webchatGroups);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("webchatgroups:save")
	public R save(@RequestBody WebchatGroupsEntity webchatGroups){
		
		
		ValidatorUtils.validateEntity(webchatGroups, AddGroup.class);
		
		
		//新建群
		SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();

		
		Date date=new Date();
		webchatGroups.setAddTime(date);
		Integer DeptId = Integer.parseInt(((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getDeptId()+"");
		webchatGroups.setDeptId(DeptId);
		webchatGroups.setLevel(1);
		Integer uid=Integer.parseInt(""+user.getId());
		webchatGroups.setOwnerUid(uid);
		webchatGroupsService.save(webchatGroups);
		
		
		
		//往新群内添加成员
		
		List<Object> users= JSON.parseArray(webchatGroups.getUsers());
		WebchatGroupDetailEntity webchatGroupDetail=new WebchatGroupDetailEntity();
		webchatGroupDetail.setAddTime(date);
		webchatGroupDetail.setBannedTime(null);
		webchatGroupDetail.setSpeakTime(null);
		webchatGroupDetail.setGid(webchatGroups.getId());
		webchatGroupDetail.setGStatus(0);
		if(users!=null){
			for (Object userid : users) {
				int id=Integer.parseInt(userid+"");
				webchatGroupDetail.setUid(id);
				
				WebchatUserEntity   UserEntity= webchatUserService.queryObject(id);
				
				if("0".equals(UserEntity.getSalt().toString())||"0"==UserEntity.getSalt().toString()){
					webchatGroupDetail.setLevel(1);
					webchatGroupDetailService.update(webchatGroupDetail);
				}else {
					webchatGroupDetail.setLevel(2);
					webchatGroupDetailService.save(webchatGroupDetail);
				}
				System.out.println(webchatGroupDetail);
				webchatGroupDetailService.group_detail(Integer.parseInt(userid+""));
			}
		}
		
		
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("webchatgroups:update")
	public R update(@RequestBody WebchatGroupsEntity webchatGroups){
		ValidatorUtils.validateEntity(webchatGroups, UpdateGroup.class);
		
		 
		
		Long DeptId = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getDeptId();
		if(DeptId!=0){
		}		
		
		webchatGroupsService.update(webchatGroups);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("webchatgroups:delete")
	public R delete(@RequestBody Integer[] ids){
		Long DeptId = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getDeptId();
		if(DeptId!=0){
			for (Integer integer : ids) {
				 
			}
		}	
		webchatGroupsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

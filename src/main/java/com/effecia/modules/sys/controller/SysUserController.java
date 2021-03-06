package com.effecia.modules.sys.controller;


import com.effecia.common.annotation.SysLog;
import com.effecia.modules.sys.shiro.ShiroUtils;
import com.effecia.modules.sys.entity.SysDeptEntity;
import com.effecia.modules.sys.entity.SysUserEntity;
import com.effecia.common.utils.PageUtils;
import com.effecia.common.utils.Query;
import com.effecia.common.utils.R;
import com.effecia.common.validator.Assert;
import com.effecia.common.validator.ValidatorUtils;
import com.effecia.common.validator.group.AddGroup;
import com.effecia.common.validator.group.UpdateGroup;
import com.effecia.modules.sys.service.SysDeptService;
import com.effecia.modules.sys.service.SysRoleDeptService;
import com.effecia.modules.sys.service.SysUserRoleService;
import com.effecia.modules.sys.service.SysUserService;
import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统用户
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017年10月31日 上午10:40:10
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysDeptService sysDeptService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	
	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:user:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<SysUserEntity> userList = sysUserService.queryList(query);
		for (SysUserEntity sysUserEntity : userList) {
			System.out.println(sysUserEntity);
		}
		int total = sysUserService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
		System.out.println(pageUtil.toString());
		return R.ok().put("page", pageUtil);
	}

	
	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping("/info")
	public R info(){
		return R.ok().put("user", getUser());
	}
	
	/**
	 * 修改登录用户密码
	 */
	@SysLog("修改密码")
	@RequestMapping("/password")
	public R password(String password, String newPassword){
		Assert.isBlank(newPassword, "新密码不为能空");

		//原密码
		password = ShiroUtils.sha256(password, getUser().getSalt());
		//新密码
		newPassword = ShiroUtils.sha256(newPassword, getUser().getSalt());
				
		//更新密码
		int count = sysUserService.updatePassword(getUserId(), password, newPassword);
		if(count == 0){
			return R.error("原密码不正确");
		}
		
		return R.ok();
	}
	
	/**
	 * 用户信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("sys:user:info")
	public R info(@PathVariable("userId") Long userId){
		SysUserEntity user = sysUserService.queryObject(userId);
		
		System.out.println("userId:"+userId);
		//获取用户所属的角色列表
		List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
		
		System.out.println("roleIdList:"+roleIdList);
		System.out.println("user:"+user);
		//deptId
		user.setRoleIdList(roleIdList);
		System.out.println("user:"+user);

		return R.ok().put("user", user);
	
	}
	
	/**
	 * 保存用户
	 */
	@SysLog("保存用户")
	@RequestMapping("/save")
	@RequiresPermissions("sys:user:save")
	public R save(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user, AddGroup.class);
		SysDeptEntity DeptEntity=sysDeptService.queryObject(user.getDeptId());
		
		String name=DeptEntity.getName()+"_"+user.getUsername();
		user.setUsername(name);
		System.out.println("user："+user);
		sysUserService.save(user);
		return R.ok();
	}
	
	/**
	 * 修改用户
	 */
	@SysLog("修改用户")
	@RequestMapping("/update")
	@RequiresPermissions("sys:user:update")
	public R update(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user, UpdateGroup.class);
		

		sysUserService.update(user);
		
		return R.ok();
	}
	

	/**
	 * 充值
	 */
	@SysLog("充值额度")
	@RequestMapping("/recharge")
	@RequiresPermissions("sys:user:recharge")
	public R Recharge(@RequestBody SysUserEntity user){
			
//		ValidatorUtils.validateEntity(user, UpdateGroup.class);

		System.out.println("user:"+user);
		sysUserService.update(user);
		
		return R.ok();
	}
	
	/**
	 * 删除用户
	 */
	@SysLog("删除用户")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:user:delete")
	public R delete(@RequestBody Long[] userIds){
		if(ArrayUtils.contains(userIds, 1L)){
			return R.error("系统管理员不能删除");
		}
		
		if(ArrayUtils.contains(userIds, getUserId())){
			return R.error("当前用户不能删除");
		}
		
		sysUserService.deleteBatch(userIds);
		
		return R.ok();
	}
}

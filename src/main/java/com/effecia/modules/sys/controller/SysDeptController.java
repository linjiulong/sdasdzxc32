package com.effecia.modules.sys.controller;

import com.effecia.common.utils.Constant;
import com.effecia.common.utils.R;
import com.effecia.common.validator.ValidatorUtils;
import com.effecia.modules.chat.entity.WebchatGroupsEntity;
import com.effecia.modules.chat.service.WebchatGroupDetailService;
import com.effecia.modules.chat.service.WebchatGroupsService;
import com.effecia.modules.sys.entity.SysDeptEntity;
import com.effecia.modules.sys.service.SysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * 部门管理
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-06-20 15:23:47
 */
@RestController
@RequestMapping("/sys/dept")
public class SysDeptController extends AbstractController {
	
	@Autowired
	private SysDeptService sysDeptService;
	
	@Autowired
	private WebchatGroupsService webchatGroupsService;
	
	
	
	
	@Autowired
	private WebchatGroupDetailService webchatGroupDetailService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:dept:list")
	public List<SysDeptEntity> list(){
		List<SysDeptEntity> deptList = sysDeptService.queryList(new HashMap<String, Object>());
		return deptList;
	}

	/**
	 * 选择部门(添加、修改菜单)
	 */
	@RequestMapping("/select")
	@RequiresPermissions("sys:dept:select")
	public R select(){
		List<SysDeptEntity> deptList = sysDeptService.queryList(new HashMap<String, Object>());

		//添加一级
		if(getUserId() == Constant.SUPER_ADMIN){
			SysDeptEntity root = new SysDeptEntity();
			root.setDeptId(0L);
			root.setName("总公司");
			root.setParentId(-1L);
			root.setOpen(true);
			deptList.add(root);
		}

		return R.ok().put("deptList", deptList);
	}

	/**
	 * 上级部门Id(管理员则为0)
	 */
	@RequestMapping("/info")
	@RequiresPermissions("sys:dept:list")
	public R info(){
		long deptId = 0;
		if(getUserId() != Constant.SUPER_ADMIN){
			SysDeptEntity dept = sysDeptService.queryObject(getDeptId());
			deptId = dept.getParentId();
		}

		return R.ok().put("deptId", deptId);
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{deptId}")
	@RequiresPermissions("sys:dept:info")
	public R info(@PathVariable("deptId") Long deptId){
		SysDeptEntity dept = sysDeptService.queryObject(deptId);
		
		return R.ok().put("dept", dept);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:dept:save")
	public R save(@RequestBody SysDeptEntity dept){
		ValidatorUtils.validateEntity(dept);
		System.out.println("dept:"+dept);
		sysDeptService.save(dept);
		WebchatGroupsEntity webchatGroups=new WebchatGroupsEntity();
		
		Date date=new Date();
		webchatGroups.setAddTime(date);
		webchatGroups.setDesc("游客厅");
		webchatGroups.setName("游客大厅");
		webchatGroups.setLevel(0);
		webchatGroups.setDeptId(Integer.parseInt(dept.getDeptId()+""));
		webchatGroups.setAnno("欢迎进入游客大厅,请遵守本大厅聊天规则.");
		System.out.println("webchatGroups:"+webchatGroups);
		webchatGroupsService.save(webchatGroups);
		
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:dept:update")
	public R update(@RequestBody SysDeptEntity dept){
		ValidatorUtils.validateEntity(dept);
		sysDeptService.update(dept);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:dept:delete")
	public R delete(long deptId){
		//判断是否有子部门
		List<Long> deptList = sysDeptService.queryDetpIdList(deptId);
		if(deptList.size() > 0){
			return R.error("请先删除子公司");
		}

		sysDeptService.delete(deptId);
		
		return R.ok();
	}
	
}

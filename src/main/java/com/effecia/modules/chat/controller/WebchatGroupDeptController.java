package com.effecia.modules.chat.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.effecia.modules.chat.entity.WebchatGroupDeptEntity;
import com.effecia.modules.chat.service.WebchatGroupDeptService;
import com.effecia.common.utils.PageUtils;
import com.effecia.common.utils.Query;
import com.effecia.common.utils.R;


/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-11 11:24:45
 */
@RestController
@RequestMapping("webchatgroupdept")
public class WebchatGroupDeptController {
	@Autowired
	private WebchatGroupDeptService webchatGroupDeptService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("webchatgroupdept:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WebchatGroupDeptEntity> webchatGroupDeptList = webchatGroupDeptService.queryList(query);
		int total = webchatGroupDeptService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(webchatGroupDeptList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("webchatgroupdept:info")
	public R info(@PathVariable("id") Integer id){
		WebchatGroupDeptEntity webchatGroupDept = webchatGroupDeptService.queryObject(id);
		
		return R.ok().put("webchatGroupDept", webchatGroupDept);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("webchatgroupdept:save")
	public R save(@RequestBody WebchatGroupDeptEntity webchatGroupDept){
		webchatGroupDeptService.save(webchatGroupDept);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("webchatgroupdept:update")
	public R update(@RequestBody WebchatGroupDeptEntity webchatGroupDept){
		webchatGroupDeptService.update(webchatGroupDept);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("webchatgroupdept:delete")
	public R delete(@RequestBody Integer[] ids){
		webchatGroupDeptService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

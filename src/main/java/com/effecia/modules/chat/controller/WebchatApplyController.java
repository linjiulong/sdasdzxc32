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

import com.effecia.modules.chat.entity.WebchatApplyEntity;
import com.effecia.modules.chat.service.WebchatApplyService;
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
@RequestMapping("webchatapply")
public class WebchatApplyController {
	@Autowired
	private WebchatApplyService webchatApplyService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("webchatapply:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WebchatApplyEntity> webchatApplyList = webchatApplyService.queryList(query);
		int total = webchatApplyService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(webchatApplyList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{fromuser}")
	@RequiresPermissions("webchatapply:info")
	public R info(@PathVariable("fromuser") Integer fromuser){
		WebchatApplyEntity webchatApply = webchatApplyService.queryObject(fromuser);
		
		return R.ok().put("webchatApply", webchatApply);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("webchatapply:save")
	public R save(@RequestBody WebchatApplyEntity webchatApply){
		webchatApplyService.save(webchatApply);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("webchatapply:update")
	public R update(@RequestBody WebchatApplyEntity webchatApply){
		webchatApplyService.update(webchatApply);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("webchatapply:delete")
	public R delete(@RequestBody Integer[] fromusers){
		webchatApplyService.deleteBatch(fromusers);
		
		return R.ok();
	}
	
}

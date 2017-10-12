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

import com.effecia.modules.chat.entity.WebchatUserLogEntity;
import com.effecia.modules.chat.service.WebchatUserLogService;
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
@RequestMapping("webchatuserlog")
public class WebchatUserLogController {
	@Autowired
	private WebchatUserLogService webchatUserLogService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("webchatuserlog:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WebchatUserLogEntity> webchatUserLogList = webchatUserLogService.queryList(query);
		int total = webchatUserLogService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(webchatUserLogList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("webchatuserlog:info")
	public R info(@PathVariable("id") Integer id){
		WebchatUserLogEntity webchatUserLog = webchatUserLogService.queryObject(id);
		
		return R.ok().put("webchatUserLog", webchatUserLog);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("webchatuserlog:save")
	public R save(@RequestBody WebchatUserLogEntity webchatUserLog){
		webchatUserLogService.save(webchatUserLog);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("webchatuserlog:update")
	public R update(@RequestBody WebchatUserLogEntity webchatUserLog){
		webchatUserLogService.update(webchatUserLog);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("webchatuserlog:delete")
	public R delete(@RequestBody Integer[] ids){
		webchatUserLogService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

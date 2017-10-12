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

import com.effecia.modules.chat.entity.WebchatUserDetailEntity;
import com.effecia.modules.chat.service.WebchatUserDetailService;
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
@RequestMapping("webchatuserdetail")
public class WebchatUserDetailController {
	@Autowired
	private WebchatUserDetailService webchatUserDetailService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("webchatuserdetail:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WebchatUserDetailEntity> webchatUserDetailList = webchatUserDetailService.queryList(query);
		int total = webchatUserDetailService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(webchatUserDetailList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("webchatuserdetail:info")
	public R info(@PathVariable("id") Integer id){
		WebchatUserDetailEntity webchatUserDetail = webchatUserDetailService.queryObject(id);
		
		return R.ok().put("webchatUserDetail", webchatUserDetail);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("webchatuserdetail:save")
	public R save(@RequestBody WebchatUserDetailEntity webchatUserDetail){
		webchatUserDetailService.save(webchatUserDetail);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("webchatuserdetail:update")
	public R update(@RequestBody WebchatUserDetailEntity webchatUserDetail){
		webchatUserDetailService.update(webchatUserDetail);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("webchatuserdetail:delete")
	public R delete(@RequestBody Integer[] ids){
		webchatUserDetailService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

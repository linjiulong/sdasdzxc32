package com.effecia.modules.chat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.effecia.modules.chat.entity.WebchatUserEntity;
import com.effecia.modules.chat.service.WebchatUserService;
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
@RequestMapping("webchatuser")
public class WebchatUserController {
	@Autowired
	private WebchatUserService webchatUserService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("webchatuser:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WebchatUserEntity> webchatUserList = webchatUserService.queryList(query);
		int total = webchatUserService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(webchatUserList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 用户列表
	 */
	@RequestMapping("/select")
	@RequiresPermissions("webchatuser:select")
	public R  select(@RequestParam Map<String, Object> params){
		//查询列表数据
		List<WebchatUserEntity> webchatUserList = webchatUserService.querySelect(new HashMap<String, Object>());
		for (WebchatUserEntity webchatUserEntity : webchatUserList) {
			System.out.println(webchatUserEntity);
		}
		return R.ok().put("list", webchatUserList);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("webchatuser:info")
	public R info(@PathVariable("id") Integer id){
		WebchatUserEntity webchatUser = webchatUserService.queryObject(id);
		
		return R.ok().put("webchatUser", webchatUser);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("webchatuser:save")
	public R save(@RequestBody WebchatUserEntity webchatUser){
		webchatUserService.save(webchatUser);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("webchatuser:update")
	public R update(@RequestBody WebchatUserEntity webchatUser){
		webchatUserService.update(webchatUser);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("webchatuser:delete")
	public R delete(@RequestBody Integer[] ids){
		webchatUserService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

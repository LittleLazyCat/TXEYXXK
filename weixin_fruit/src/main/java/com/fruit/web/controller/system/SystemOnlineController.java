package com.fruit.web.controller.system;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fruit.web.controller.BaseController;
import com.fruit.web.shiro.session.dao.RedisShiroSessionDao;
import com.google.common.collect.Maps;

/**
 * 获取系统在线人数
 * 
 * @author jzx
 * @date 2016-10-12 10:34:01
 *
 */
@Controller
@RequestMapping("/online")
public class SystemOnlineController extends BaseController {

	@Autowired
	private RedisShiroSessionDao sessionDao;
	
	/**
	 * 获取权限列表
	 */
	@RequestMapping(value = "index")
	public @ResponseBody Map<String,Object> index() {
		Map<String,Object> map = Maps.newHashMap();
		map.put("count", sessionDao.getActiveSessions().size());
		return map;
	}
}

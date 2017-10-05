package com.fruit.web.controller.system.listener;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.web.controller.BaseController;
import com.fruit.web.model.ScheduleJob;
import com.fruit.web.service.system.listener.SystemCornService;
import com.fruit.web.service.system.listener.SystemScheduleJobService;

/**
 * 
 * @author jzx
 * @date 2016-09-14
 *
 */
@Controller
@RequestMapping("/schedule")
public class SystemTimerController extends BaseController {

	@Autowired
	private SystemScheduleJobService scheduleJobService;
	@Autowired
	private SystemCornService systemCornService;
	
	/**
	 * 获取定时任务列表
	 */
	@RequestMapping("list")
	public ModelAndView getAllJobs(Model model){
		List<ScheduleJob> scheduleJobs = scheduleJobService.getAllScheduleJob();
		return new ModelAndView("listener/schedule_list","data",scheduleJobs);
	}
	
	/** 
	 * 添加定时任务
	 */
	@RequiresPermissions("sys:quartz:add")
	@RequestMapping(value = "addSchedule", method = RequestMethod.POST)
	public String addSchedule(ScheduleJob scheduleJob) {
		scheduleJob.setStatus("1");
		scheduleJobService.add(scheduleJob);
		return "redirect:/schedule/list";
	}
	
	/**
	 * 暂停任务
	 */
	@RequiresPermissions("sys:quartz:stop")
	@RequestMapping(value= "/stop" , method = RequestMethod.GET)
	public String stop()  {
		String name = getPara("name");
		String group = getPara("group");
		scheduleJobService.stopJob(name, group);
		return "redirect:/schedule/list";
	}
	
	/**
	 * 恢复
	 */
	@RequiresPermissions("sys:quartz:resume")
	@RequestMapping("/resume")
	public String resume() {
		String name = getPara("name");
		String group = getPara("group");
		scheduleJobService.restartJob(name, group);
		return "redirect:/schedule/list";
	}
	
	/**
	 * 删除任务
	 */
	@RequiresPermissions("sys:quartz:delete")
	@RequestMapping("/delete")
	public String delete() {
		String name = getPara("name");
		String group = getPara("group");
		scheduleJobService.delJob(name, group);
		return "redirect:/schedule/list";
	}

	
	/**
	 * 立即运行一次
	 */
	@RequiresPermissions("sys:quartz:start")
	@RequestMapping("/startNow")
	public String stratNow() {
		String name = getPara("name");
		String group = getPara("group");
		scheduleJobService.startNowJob(name, group);
		return "redirect:/schedule/list";
	}
	
	/**
	 * 跳转到添加定时任务页面
	 */
	@RequestMapping(value = "toAddSchedule", method = RequestMethod.GET)
	public ModelAndView toAddSchedule(Model model) {
		model.addAttribute("data", systemCornService.loadCorn());
		return new ModelAndView("listener/schedule_add");
	}
	
}

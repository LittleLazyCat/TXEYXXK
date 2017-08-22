package com.txey.qytxl.dao.mybatis;

import java.util.List;

import com.txey.qytxl.model.Dept; 

public interface DeptMybatisDao {
	/**
	 * 
	 * 获得部门信息
	 * 
	 * @param 
	 *            
	 * 
	 * @return List<Dept> 返回查存到的部门信息
	 * @exception
	 * 
	 * 				@author
	 *                Alex Jones
	 * 
	 * @Time 2017-07-23 12:38:00
	 * 
	 * 
	 */
	public List<Dept> getDept();
	
	/**
	 * 
	 * 根据用户查询是否存在该用户
	 * 
	 * @param Name
	 *           科室名
	 * 
	 * @return List<Dept> 返回科室信息
	 * @exception
	 * 
	 * 				@author
	 *                Alex Jones
	 * 
	 * @Time 2017-04-20 12:27:00
	 * 
	 * 
	 */
	public List<Dept> findDeptByName(String Name);
}

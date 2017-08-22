package com.txey.qytxl.dao.mybatis;

 
import com.txey.qytxl.model.Employee;

import java.util.List;

public interface EmployeeMybatisDao {
	/**
	 * 
	 * 获得员工信息
	 * 
	 * @param 
	 *           
	 * 
	 * @return List<Employee> 返回员工信息
	 * @exception
	 * 
	 * 				@author
	 *                Alex Jones
	 * 
	 * @Time 2017-04-19 13:30:00
	 * 
	 * 
	 */
	public List<Employee> getEmployee();



	/**
	 *
	 * 根据用户姓名查询该用户信息
	 *
	 * @param Name
	 *        用户姓名
	 *
	 * @return List<Employee> 返回查询到的员工信息
	 * @exception
	 *
	 * 				@author
	 *                Alex Jones
	 *
	 * @Time 2017-04-20 12:27:00
	 *
	 *
	 */
	public List<Employee> findEmpByName(String Name);



	/**
	 *
	 * 根据用户编号查询该用户信息
	 *
	 * @param ygbh
	 *        员工编号
	 *
	 * @return Employee 返回查询到的员工信息
	 * @exception
	 *
	 * 				@author
	 *                Alex Jones
	 *
	 * @Time 2017-07-30 12:27:00
	 *
	 *
	 */
	public Employee findEmpByBh(String ygbh);

/**
 *
 * 根据用户编号查询该用户信息
 *
 * @param employee
 *        员工对象
 *
 * @return
 * @exception
 *
 * 				@author
 *                Alex Jones
 *
 * @Time 2017-07-30 12:27:00
 *
 *
 */
	public void updateEmp(Employee employee);

}

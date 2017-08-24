package com.txey.qytxl.service;

import com.txey.qytxl.dao.mybatis.DeptMybatisTemplateDao;
import com.txey.qytxl.dao.mybatis.EmployeeMybatisTemplateDao;
import com.txey.qytxl.model.Dept;
import com.txey.qytxl.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class TestRecordService {

	 
	@Autowired
	private DeptMybatisTemplateDao deptService;
	@Autowired
	private EmployeeMybatisTemplateDao employeeService;
	 
 
	@Test
	public void getDept() {
		List<Dept> deptList = deptService.getDept();
		for (Dept dl : deptList) {

			System.out.println(dl);
		}
	}

	@Test
	public void getEmployee() {
		List<Employee> employeeList = employeeService.getEmployee();
		for (Employee el : employeeList) {

			System.out.println(el);
		}
	}

	@Test
	public void findEmpByuserName() {
		List<Employee> employeeList = employeeService.findEmpByName("ZK");
		for (Employee el : employeeList) {
			System.out.println(el);
		}

	}


	@Test
	public void findEmpByuserBh() {
		Employee employee = employeeService.findEmpByBh("M028");

			System.out.println(employee);

	}


	@Test
	public void updateEmp(){
		Employee employee = new Employee();
		employee.setYgbh("M028");
		employee.setSjch("18367852176");
		employee.setXnw("712176");

		employeeService.updateEmp(employee);
	}


}

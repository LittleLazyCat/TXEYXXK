package com.txey.qytxl.service.mybatis;

import com.txey.qytxl.dao.mybatis.EmployeeMybatisTemplateDao;
import com.txey.qytxl.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EmployeeService {
	@Autowired
	private EmployeeMybatisTemplateDao employeeMybatisTemplateDao;

	public List<Employee> getEmployee() {
		return employeeMybatisTemplateDao.getEmployee();
	}

	public List<Employee> findEmpByName(String Name) {
		return employeeMybatisTemplateDao.findEmpByName(Name);
	}

	public Employee findEmpByYgbh(String ygbh){
		return employeeMybatisTemplateDao.findEmpByBh(ygbh);
	}

	public void updateEmp(Employee employee){
		employeeMybatisTemplateDao.updateEmp(employee);
	}
}

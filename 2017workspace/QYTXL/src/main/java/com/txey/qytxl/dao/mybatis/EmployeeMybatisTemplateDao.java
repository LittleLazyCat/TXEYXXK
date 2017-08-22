package com.txey.qytxl.dao.mybatis;

 
import com.txey.qytxl.model.Employee;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeMybatisTemplateDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<Employee> getEmployee() {
		EmployeeMybatisDao employeeMybatisDao = sqlSessionTemplate.getMapper(EmployeeMybatisDao.class);

		return employeeMybatisDao.getEmployee();
	}

	public List<Employee> findEmpByName(String Name) {
		EmployeeMybatisDao employeeMybatisDao = sqlSessionTemplate.getMapper(EmployeeMybatisDao.class);

		return employeeMybatisDao.findEmpByName("%"+Name+"%");
	}


	public Employee findEmpByBh(String ygbh){
		EmployeeMybatisDao employeeMybatisDao = sqlSessionTemplate.getMapper(EmployeeMybatisDao.class);
		return employeeMybatisDao.findEmpByBh(ygbh);
	}

	public void updateEmp(Employee employee){
		EmployeeMybatisDao employeeMybatisDao = sqlSessionTemplate.getMapper(EmployeeMybatisDao.class);
		employeeMybatisDao.updateEmp(employee);
	}

}

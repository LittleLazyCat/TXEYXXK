package com.txey.qytxl.dao.mybatis;

import com.txey.qytxl.model.Dept;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeptMybatisTemplateDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<Dept> getDept() {
		DeptMybatisDao deptMybatisDao = sqlSessionTemplate.getMapper(DeptMybatisDao.class);
		return deptMybatisDao.getDept();
	}
	
	public List<Dept> findDeptByName(String Name) {
		DeptMybatisDao deptMybatisDao = sqlSessionTemplate.getMapper(DeptMybatisDao.class);
		return deptMybatisDao.findDeptByName("%"+Name+"%");
	}

}

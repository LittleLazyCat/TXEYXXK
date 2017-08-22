package com.txey.qytxl.service.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.txey.qytxl.dao.mybatis.DeptMybatisTemplateDao;
import com.txey.qytxl.model.Dept; 

@Transactional
@Service
public class DeptService {
	@Autowired
	private DeptMybatisTemplateDao deptMybatisTemplateDao;
	
	public List<Dept> getDept() {
		return deptMybatisTemplateDao.getDept();
	}
	
	public List<Dept> findDeptByName(String Name) {
		return deptMybatisTemplateDao.findDeptByName(Name);
	}
}

package com.thinkgem.jeesite.test.service;

import com.thinkgem.jeesite.common.service.BaseService;

import com.thinkgem.jeesite.lzrabbit.MultipleDataSource;
import com.thinkgem.jeesite.test.dao.TestAreaDao;
import com.thinkgem.jeesite.test.entity.TestArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;



@Service
@Transactional(readOnly = true)
public class TestAreaService extends BaseService{


    @Autowired
    private TestAreaDao testAreaDao;


    public List<TestArea> getArea(){

        return testAreaDao.getArea();
    }
}

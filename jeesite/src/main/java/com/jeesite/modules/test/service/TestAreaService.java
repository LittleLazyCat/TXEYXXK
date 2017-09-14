package com.jeesite.modules.test.service;


import com.jeesite.common.service.BaseService;
import com.jeesite.modules.test.dao.TestAreaDao;
import com.jeesite.modules.test.entity.TestArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;



@Service
public class TestAreaService extends BaseService {


    @Autowired
    private TestAreaDao testAreaDao;


    public List<TestArea> getArea(){

        return testAreaDao.getArea();
    }
}

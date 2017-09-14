package com.jeesite.modules.test.dao;


import com.jeesite.common.persistence.annotation.MyBatisDao;
import com.jeesite.modules.test.entity.TestArea;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@MyBatisDao
public interface TestAreaDao {

    @Select("select * from DIM_AREA_CN")
    public List<TestArea> getArea();
}

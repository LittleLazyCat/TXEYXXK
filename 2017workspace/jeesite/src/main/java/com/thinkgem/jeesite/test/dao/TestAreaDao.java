package com.thinkgem.jeesite.test.dao;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.test.entity.TestArea;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@MyBatisDao
@Transactional
public interface TestAreaDao {
    @Select("select * from DIM_AREA_CN")
    public List<TestArea> getArea();
}

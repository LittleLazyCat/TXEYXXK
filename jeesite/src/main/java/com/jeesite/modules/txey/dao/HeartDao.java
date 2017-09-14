package com.jeesite.modules.txey.dao;




import com.jeesite.common.persistence.annotation.MyBatisDao;
import com.jeesite.modules.txey.entity.Heart;

import java.util.List;
@MyBatisDao
public interface HeartDao {
    //统计心电图室收费情况
    public List<Heart> heartStats(Heart heart);








}

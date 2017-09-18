package com.jeesite.modules.txey.dao;

import com.jeesite.common.persistence.annotation.MyBatisDao;
import com.jeesite.modules.txey.entity.Bcjl;

import java.util.List;

@MyBatisDao
public interface BcjlDao {
    /*
    根据病案号获得病人的病程记录
     */
    List<Bcjl> getBcjl(String bah);
}

package com.jeesite.modules.txey.dao;

import com.jeesite.common.persistence.annotation.MyBatisDao;
import com.jeesite.modules.txey.entity.Patient;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@MyBatisDao
public interface PatientDao {

    @Select("select brxm,csny,sfzh from zy_brry where brxm like '张守威'")
    public List<Patient> getPatient();
}

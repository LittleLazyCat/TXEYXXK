package com.txey.wxgzh.zyqd.service.impl;


import com.txey.wxgzh.zyqd.dao.InpatientDao;
import com.txey.wxgzh.zyqd.entity.Inpatient;
import com.txey.wxgzh.zyqd.service.InpatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("inpatientService")
public class InpatientServiceImpl implements InpatientService{
    @Autowired
    private InpatientDao inpatientDao;

    @Override
    public Inpatient getInpatientByZyhm(String zyhm) {
        return inpatientDao.getInpatientByZyhm(zyhm);
    }
}

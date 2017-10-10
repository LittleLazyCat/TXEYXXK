package com.txey.wxgzh.zyqd.service;

import com.txey.wxgzh.zyqd.entity.Inpatient;

public interface InpatientService {
    /**
     * 根据住院号查询病人的缴费信息
     *
     * @param zyhm
     *            住院病人
     * @return List
     */
    public Inpatient getInpatientByZyhm(String zyhm);
}

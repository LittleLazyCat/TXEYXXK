package com.txey.wxgzh.zyqd.service;

import com.txey.wxgzh.zyqd.entity.Inpatient;
import com.txey.wxgzh.zyqd.entity.Payment;

import java.util.List;

public interface PaymentService {
    /**
     * 根据住院号查询病人的缴费信息
     *
     * @param zyhm
     *            住院病人
     * @return List
     */
    public List<Payment> getPaymentByZyh(String zyhm);
}

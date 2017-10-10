package com.txey.wxgzh.zyqd.service.impl;


import com.txey.wxgzh.zyqd.dao.PaymentDao;
import com.txey.wxgzh.zyqd.entity.Inpatient;
import com.txey.wxgzh.zyqd.entity.Payment;
import com.txey.wxgzh.zyqd.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public List<Payment> getPaymentByZyh(String zyhm){
        return  paymentDao.getPaymentByZyh(zyhm);
    }
}

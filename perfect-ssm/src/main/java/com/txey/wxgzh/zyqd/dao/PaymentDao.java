package com.txey.wxgzh.zyqd.dao;



import com.txey.wxgzh.zyqd.entity.Inpatient;
import com.txey.wxgzh.zyqd.entity.Payment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDao {
    /**
     * 根据住院号查询病人的缴费信息
     *
     * @param zyhm
     *            住院病人
     * @return List
     */
    public List<Payment> getPaymentByZyh(String zyhm);
}

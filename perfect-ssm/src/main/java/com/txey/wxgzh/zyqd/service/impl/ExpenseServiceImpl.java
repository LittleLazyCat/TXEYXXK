package com.txey.wxgzh.zyqd.service.impl;


import com.sun.org.apache.bcel.internal.generic.NEW;
import com.txey.wxgzh.zyqd.dao.ExpenseDao;
import com.txey.wxgzh.zyqd.entity.Expense;
import com.txey.wxgzh.zyqd.entity.Inpatient;
import com.txey.wxgzh.zyqd.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("expenseService")
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseDao expenseDao;

    @Override
    public List<Expense> getExpenseByZyh(String zyhm) {
        return expenseDao.getExpenseByZyh(zyhm);
    }

    @Override
    public List<Expense> getExpenseDetailByzyh(String zyhm,String jfrq) {
        return expenseDao.getExpenseDetailByzyh(zyhm,jfrq);
    }


}

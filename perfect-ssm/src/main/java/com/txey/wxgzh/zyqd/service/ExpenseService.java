package com.txey.wxgzh.zyqd.service;

import com.txey.wxgzh.zyqd.entity.Expense;
import com.txey.wxgzh.zyqd.entity.Inpatient;

import java.util.Date;
import java.util.List;

public interface ExpenseService {
    /**
     * 根据住院号查询病人的费用信息
     *
     * @param zyhm
     *            住院病人
     * @return List
     */
    public List<Expense> getExpenseByZyh(String zyhm);

    /**
     * 根据住院号和费用日期查询病人某一天的费用信息
     *
     * @param zyhm
     *            住院病人
     * @return List
     */
    public List<Expense> getExpenseDetailByzyh(String zyhm,String jfrq);
}

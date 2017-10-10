package com.txey.wxgzh.zyqd.dao;


import com.txey.wxgzh.zyqd.entity.Expense;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseDao {
    /**
     * 根据住院号查询病人的费用信息
     *
     * @param zyhm
     *            住院病人
     * @return List
     */
    public List<Expense> getExpenseByZyh(@Param("zyhm") String zyhm);

    /**
     * 根据住院号和费用日期查询病人某一天的费用信息
     *
     * @param zyhm
     *            住院病人
     * @param jfrq
     *          费用生成日期
     * @return List
     */
    public List<Expense> getExpenseDetailByzyh(@Param("zyhm") String zyhm,@Param("jfrq") String jfrq);
}

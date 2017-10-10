package com.txey.wxgzh.zyqd.dao;




import com.txey.wxgzh.zyqd.entity.Inpatient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface InpatientDao {
    /**
     * 根据住院号查询病人的缴费信息
     *
     * @param zyhm
     *            住院病人
     * @return List
     */
    public Inpatient getInpatientByZyhm(String zyhm);
}

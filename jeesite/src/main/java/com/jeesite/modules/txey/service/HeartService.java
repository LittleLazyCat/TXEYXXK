package com.jeesite.modules.txey.service;




import com.jeesite.common.utils.DateUtils;
import com.jeesite.modules.txey.dao.HeartDao;
import com.jeesite.modules.txey.entity.Heart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class HeartService {
    @Autowired
    private HeartDao heartDao;
    public List<Heart> heartStats(Map<String, Object> paramMap){
        Heart heart = new Heart();
        Date beginDate = DateUtils.parseDate(paramMap.get("beginDate"));
        if (beginDate == null) {
            beginDate = DateUtils.setDays(new Date(), 1);
            paramMap.put("beginDate", DateUtils.formatDate(beginDate, "yyyy-MM-dd"));
        }
        heart.setbeginDate(beginDate);
        Date endDate = DateUtils.parseDate(paramMap.get("endDate"));
        if (endDate == null){
            endDate = DateUtils.addDays(DateUtils.addMonths(beginDate, 1), -1);
            paramMap.put("endDate", DateUtils.formatDate(endDate, "yyyy-MM-dd"));
        }
        heart.setendDate(endDate);
        return heartDao.heartStats(heart);
    }
}

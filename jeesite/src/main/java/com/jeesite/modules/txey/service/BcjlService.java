package com.jeesite.modules.txey.service;

import com.jeesite.modules.txey.dao.BcjlDao;
import com.jeesite.modules.txey.entity.Bcjl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BcjlService {
    @Autowired
    private BcjlDao bcjlDao;

    public List<Bcjl> getBcjl(Map<String, Object> paramMap) {
        String bah ="00263763";
        if(paramMap.get("bah")!= null)
        {
            bah = paramMap.get("bah").toString();
        }

        return bcjlDao.getBcjl(bah);
    }
}

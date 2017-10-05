package com.netctoss.action;

/**
 * Created by tan on 2017/2/9.
 */

import com.netctoss.dao.ICostDao;
import com.netctoss.entity.Cost;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 *  删除一条资费
 */
@Controller
@Scope("prototype")
public class DeleteCostAction {

    @Resource
    private ICostDao costDao;

    //  input
    private int id;

    public String delete(){
        costDao.delete(id);
        return "success";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package com.netctoss.action;

/**
 * Created by tan on 2017/2/6.
 */

import com.netctoss.dao.ICostDao;
import com.netctoss.entity.Cost;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 加载修改数据
 */

@Controller
@Scope("prototype")
public class ToUpdateCostAction {

    @Resource
    private ICostDao costDao;

    //  input
    private int id;

    //  output
    private Cost cost;

    public String load(){
        cost = costDao.findById(id);
        return "success";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }
}

package com.netctoss.action;

/**
 * Created by tan on 2017/2/9.
 */

import com.netctoss.dao.ICostDao;
import com.netctoss.entity.Cost;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.sql.Timestamp;


/**
 * 新增保存资费
 */

@Controller
@Scope("prototype")
public class AddCostAction {

    @Resource
    private ICostDao costDao;

    //  input
    private Cost cost;

    public String add(){
        //  初始化一些默认值
        initDefaultValue(cost);
        costDao.save(cost);
        return "success";
    }

    /**
     * 初始化默认值
     * @param cost
     */
    private void initDefaultValue(Cost cost){
        //  状态默认为暂停态
        cost.setStatus("1");
        //  创建时间默认为当前系统时间
        cost.setCreateTime(new Timestamp(System.currentTimeMillis()));
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

}

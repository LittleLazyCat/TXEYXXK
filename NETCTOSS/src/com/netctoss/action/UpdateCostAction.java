package com.netctoss.action;

import com.netctoss.dao.ICostDao;
import com.netctoss.entity.Cost;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by tan on 2017/2/6.
 */

/**
 * 保存修改
 */
@Controller
@Scope("prototype")
public class UpdateCostAction {

    @Resource
    private ICostDao costDao;

    //  input
    private Cost cost;

    public String update(){
        //  查询出要修改的原始对象，该对象为持久态
        Cost c = costDao.findById(cost.getId());
        //  将传入对象的属性复制到原始对象上，忽视不需要修改的列
        BeanUtils.copyProperties(cost,c,new String[]{"status","createTime","startTime"});
        /*
            将持久化对象更新，由于映射关系文件中设置了动态更新，。
            因此持久对象中值为 null 的列将不被更新
         */
        costDao.update(c);
        return "success";
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }
}

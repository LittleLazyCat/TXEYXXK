package com.netctoss.action;

import com.netctoss.dao.ICostDao;
import com.netctoss.entity.Cost;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tan on 2017/2/6.
 */

/**
 * 查询全部资费数据
 */
@Controller
@Scope("prototype")
public class FirstCostAction {

    @Resource
    private ICostDao costDao;

    //  input
    private int page = 1;
    private int pageSize;

    //  output
    private List<Cost> costs;

    private int totalPage;

    public String load(){
        costs = costDao.findByPage(page, pageSize);
        totalPage = costDao.findTotalPage(pageSize);
        return "success";
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Cost> getCosts() {
        return costs;
    }

    public void setCosts(List<Cost> costs) {
        this.costs = costs;
    }
}

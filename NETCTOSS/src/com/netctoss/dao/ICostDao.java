package com.netctoss.dao;

import com.netctoss.entity.Cost;

import java.util.List;

/**
 * Created by tan on 2017/2/4.
 */
public interface ICostDao {

    public List<Cost> findAll();




    public void delete(int id);

    /**
     * 查询某页资费数据
     * @param page 页码
     * @param pageSize  页容量
     * @return
     */
    public List<Cost> findByPage(int page,int pageSize);

    /**
     * 查询总页数
     * @param pageSize
     * @return
     */
    public int findTotalPage(int pageSize);

    /**
     * 根据 ID 查询资费数据
     * @param id
     * @return
     */
    public Cost findById(int id);

    /**
     * 修改资费数据
     * @param cost
     */
    public void update(Cost cost);

    /**
     * 新增保存资费数据
     * @param cost
     */
    public void save(Cost cost);
}

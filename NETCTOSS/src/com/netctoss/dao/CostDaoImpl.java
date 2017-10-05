package com.netctoss.dao;

import com.netctoss.entity.Cost;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import sun.print.SunPageSelection;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tan on 2017/2/4.
 */
@Repository
public class CostDaoImpl extends HibernateDaoSupport implements ICostDao {

    @Resource
    public void setSF(SessionFactory sf){
        super.setSessionFactory(sf);
    }

    @Override
    public List<Cost> findAll() {
        String hql = "from Cost";
        return getHibernateTemplate().find(hql);
    }

    @Override
    public Cost findById(int id) {
        return (Cost)getHibernateTemplate().get(Cost.class,id);
    }

    @Override
    public List<Cost> findByPage(final int page,final int pageSize) {
        /*
            executeFind 方法需要传入接口对象，该接口对象的 doInHibernate方法
            会在执行查询时自动被 Spring 调用，并且doInHibernate 方法的返回值
            将作为最终的结果返回
         */
        return getHibernateTemplate().executeFind(new HibernateCallback() {
            /*
                doInHibernate方法类似于回调函数，是在 executeFind方法内部被调用的。
                该方法中可以直接使用session, 这个 session 由 Spring 负责管理，不
                需要我们创建和关闭。
             */
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                String hql = "from Cost order by cost_id";
                Query query = session.createQuery(hql);
                /*
                    设置分页参数，注意在内层函数中调用外层函数的参数，
                    要求外层函数的参数必须是 final 的，因此需要将 page 、 pageSize 设置为 final
                 */
                query.setFirstResult((page-1)*pageSize);
                query.setMaxResults(pageSize);
                return query.list();
            }
        });
    }

    @Override
    public int findTotalPage(int pageSize) {
        String hql = "select count(*) from Cost";
        List<Object> list = getHibernateTemplate().find(hql);
        //  查询出总行数
        int rows = Integer.parseInt(list.get(0).toString());
        //  根据总行数计算总页数
        if(rows % pageSize == 0)
            return rows / pageSize;
        else
            return rows / pageSize + 1;
    }

    @Override
    public void update(Cost cost) {
        if(cost == null)return;
        getHibernateTemplate().update(cost);
    }

    @Override
    public void save(Cost cost) {
        if(cost == null)return;
        getHibernateTemplate().save(cost);
    }

    @Override
    public void delete(int id) {
        Cost c = new Cost();
        c.setId(id);
        getHibernateTemplate().delete(c);
    }
}

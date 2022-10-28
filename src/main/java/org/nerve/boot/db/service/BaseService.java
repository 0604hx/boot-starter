package org.nerve.boot.db.service;

/**
 * 适用于 mybatis-plus 的基础 Service 封装
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.nerve.boot.Pagination;
import org.nerve.boot.domain.ID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class BaseService<M extends BaseMapper<T>, T extends ID> extends ServiceImpl<M, T> {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected QueryHelper<T> queryHelper = new QueryHelper<>();

    public QueryWrapper<T> Q(){
        return Wrappers.query();
    }

    public QueryWrapper<T> EQ(String column, Object obj){
        return Q().eq(column, obj);
    }

    public UpdateWrapper<T> U() { return Wrappers.update(); }

    public UpdateWrapper<T> UF(String column, Object newVal){
        return U().set(column, newVal);
    }

    /**
     * 获取泛型的类名
     * @return
     */
    public String nameOfDomain(){
        return entityClass.getSimpleName();
    }

    /**
     * 基于 mybatis-plus 的分页查询
     * @param parameters
     * @param pagination
     * @return
     */
    public List<T> list(Map<String, Object> parameters, Pagination pagination){
        Page<T> p = Page.of(pagination.getPage(), pagination.getPageSize());
        page(p, queryHelper.buildFromMap(parameters));
        pagination.setTotal(p.getTotal());

        return p.getRecords();
    }
}

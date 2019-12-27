package com.mycompany.biz.dao.impl;

import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import org.stategen.framework.ibatis.util.PageQueryUtils;
import org.stategen.framework.ibatis.util.SqlDaoSupport;
import org.stategen.framework.lite.PageList;

/**
 * SqlDaoSupportBase
 * 该类为兼容ibatis和mybatis,不可以修改
 * </pre>
 */

@SuppressWarnings("deprecation")
public class SqlDaoSupportBase extends SqlMapClientDaoSupport implements SqlDaoSupport {

    public <T> int update(String statementName, Object params) {
        int effectCount = getSqlMapClientTemplate().update(statementName, params);
        return effectCount;
    }

    public <T> void insert(String statementName, T t) {
        getSqlMapClientTemplate().insert(statementName, t);
    }

    @SuppressWarnings({ "unchecked" })
    public <T> T selectOne(String statementName, Object params) {
        return (T) getSqlMapClientTemplate().queryForObject(statementName, params);
    }

    @SuppressWarnings({ "unchecked" })
    public <T> List<T> selectList(String statementName, Object params) {
        return getSqlMapClientTemplate().queryForList(statementName, params);
    }

    public <T> PageList<T> pageQuery(String statementName, Object params, int pageNum, int pageSize) {
        return PageQueryUtils.pageQuery(this, statementName, params, pageNum, pageSize);
    }

}

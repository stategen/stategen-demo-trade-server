/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.stategen.framework.ibatis.util.PageQueryUtils;
import org.stategen.framework.lite.PageList;

import com.mycompany.biz.dao.FileSummaryDao;
import com.mycompany.biz.domain.FileSummary;

/**
 * FileSummaryDao
 * <pre>
 * database table: file_summary
 * database table comments: FileSummary
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class FileSummaryDaoImpl extends SqlDaoSupportBase implements FileSummaryDao {

    /**
	 * 
	 * sql:insert into file_summary ( create_time , update_time , delete_flag , file_id , url , size , name , type , user_id ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?,?,?)
	 */
    public FileSummary insert(FileSummary fileSummary) throws DataAccessException {
        if (fileSummary == null) {
            throw new IllegalArgumentException("Can't insert a null data object into db.");
        }
        super.insert("FileSummary.insert", fileSummary);
        return fileSummary;
    }

    /**
	 * 
	 * sql:UPDATE file_summary SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and file_id = ?
	 */
    public String delete(String fileId) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("fileId", fileId);
        super.update("FileSummary.delete", params);
        return fileId;
    }

    /**
	 * 
	 * sql:UPDATE file_summary SET update_time= CURRENT_TIMESTAMP(6) , url = ? , size = ? , name = ? , type = ? , user_id = ? where delete_flag = 0 and file_id = ?
	 */
    public FileSummary update(FileSummary fileSummary) throws DataAccessException {
        if (fileSummary == null) {
            throw new IllegalArgumentException("Can't update by a null data object.");
        }
        super.update("FileSummary.update", fileSummary);
        return fileSummary;
    }

    /**
	 * 
	 * sql:select a.file_id, a.url, a.size, a.name, a.type, a.user_id, a.create_time, a.update_time, a.delete_flag from file_summary a where a.delete_flag = 0 and a.file_id = ?
	 */
    public FileSummary getFileSummaryByFileId(String fileId) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("fileId", fileId);
        return (FileSummary) super.selectOne("FileSummary.getFileSummaryByFileId", params);
    }

    /**
	 * 
	 * sql:select a.file_id, a.url, a.size, a.name, a.type, a.user_id, a.create_time, a.update_time, a.delete_flag from file_summary a where a.delete_flag = 0 and a.file_id=? and a.file_id in ( ? ) and a.size=? and a.size >=? and a.size <? and a.name=? and a.name like CONCAT('%',?,'%') and a.type=? and a.type in ( ? ) and a.user_id=? and a.user_id in ( ? ) and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
    public PageList<FileSummary> getPageList(FileSummary fileSummary, int pageSize, int pageNum) throws DataAccessException {
        return super.pageQuery("FileSummary.getPageList", fileSummary, pageNum, pageSize);
    }

    /**
	 * 
	 * sql:select a.file_id, a.url, a.size, a.name, a.type, a.user_id, a.create_time, a.update_time, a.delete_flag from file_summary a where a.delete_flag = 0 and 1=0 and a.file_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
    public List<FileSummary> getFileSummarysByFileIds(java.util.List<String> fileIds) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("fileIds", fileIds);
        return super.selectList("FileSummary.getFileSummarysByFileIds", params);
    }

    /**
	 * 
	 * sql:UPDATE file_summary SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and file_id in ( ? )
	 */
    public java.util.List<String> deleteByFileIds(java.util.List<String> fileIds) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("fileIds", fileIds);
        super.update("FileSummary.deleteByFileIds", params);
        return fileIds;
    }
}

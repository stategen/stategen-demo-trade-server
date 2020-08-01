/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.stategen.framework.lite.IIdGenerator;
import org.stategen.framework.lite.IdGenerateService;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.util.ServiceUtil;
import org.stategen.framework.util.StringUtil;

import com.mycompany.biz.dao.FileSummaryDao;
import com.mycompany.biz.domain.FileSummary;
import com.mycompany.biz.service.FileSummaryService;

/**
 * FileSummaryServiceImpl
 * <pre>
 * database table: upload_file
 * database table comments: FileSummary
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public class FileSummaryServiceImpl implements FileSummaryService, IdGenerateService<String> {

    @Resource
    private IIdGenerator idGenerator;

    @Value("${project.name}")
    private String projectName;

    @Resource(name = "fileSummaryDao")
    FileSummaryDao fileSummaryDao;

    @Override
    public String getProjectName() {
        return projectName;
    }

    /**
     * 
     * @see com.mycompany.biz.dao.FileSummaryDao#insert
     * @see com.mycompany.biz.service.FileSummaryService#insert
     */
    @Override
    public FileSummary insert(FileSummary fileSummary) {
        return fileSummaryDao.insert(fileSummary, this);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.FileSummaryDao#delete
     * @see com.mycompany.biz.service.FileSummaryService#delete
     */
    @Override
    public String delete(String fileId) {
        return fileSummaryDao.delete(fileId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.FileSummaryDao#update
     * @see com.mycompany.biz.service.FileSummaryService#update
     */
    @Override
    public FileSummary update(FileSummary fileSummary) {
        return fileSummaryDao.update(fileSummary);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.FileSummaryDao#getFileSummaryByFileId
     * @see com.mycompany.biz.service.FileSummaryService#getFileSummaryByFileId
     */
    @Override
    public FileSummary getFileSummaryByFileId(String fileId) {
        return fileSummaryDao.getFileSummaryByFileId(fileId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.FileSummaryDao#getFileSummarysByFileIds
     * @see com.mycompany.biz.service.FileSummaryService#getFileSummarysByFileIds
     */
    @Override
    public List<FileSummary> getFileSummarysByFileIds(java.util.List<String> fileIds) {
        return fileSummaryDao.getFileSummarysByFileIds(fileIds);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.FileSummaryDao#deleteByFileIds
     * @see com.mycompany.biz.service.FileSummaryService#deleteByFileIds
     */
    @Override
    public java.util.List<String> deleteByFileIds(java.util.List<String> fileIds) {
        return fileSummaryDao.deleteByFileIds(fileIds);
    }

    /*** 保存fileSummary,有id时更新，没有id时插入,并带回新的id，返回 fileSummary*/
    @Override
    public FileSummary saveFileSummary(FileSummary fileSummary) {
        if (fileSummary != null) {
            java.lang.String fileId = fileSummary.getFileId();
            if (StringUtil.isBlank(fileId)) {
                insert(fileSummary);
            } else {
                update(fileSummary);
            }
        }
        return fileSummary;
    }

    /*** 批量保存fileSummarys,有id时更新，没有id时插入,并带回新的id，返回 fileSummarys*/
    @Override
    public List<FileSummary> saveFileSummarys(List<FileSummary> fileSummarys) {
        for (FileSummary fileSummary : fileSummarys) {
            this.saveFileSummary(fileSummary);
        }
        return fileSummarys;
    }

    /**
     * 
     * @see com.mycompany.biz.dao.FileSummaryDao#getPageList
     * @see com.mycompany.biz.service.FileSummaryService#getPageList
     */
    @Override
    public PageList<FileSummary> getPageList(FileSummary fileSummary, int pageSize, int pageNum) {
        return fileSummaryDao.getPageList(fileSummary, pageSize, pageNum);
    }

    //-->
    //
    @Override
    public <D> void assignBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod, BiConsumer<D, FileSummary> destSetMethod) {
        ServiceUtil.interalAssignBeanTo(dests, destGetMethod, destSetMethod, this, FileSummaryServiceImpl::getFileSummarysByFileIds, FileSummary::getFileId);
    }

    @Override
    public <D, G> void assignBeansTo(Collection<D> dests, Function<? super D, G> destGetMethod, BiConsumer<D, List<FileSummary>> destSetMethod, BiConsumer<FileSummary, List<G>> resultSetQueryIdsFun, Function<? super FileSummary, G> resultGetGoupIdFun) {
        ServiceUtil.interalAssignBeansTo(dests, destGetMethod, destSetMethod, this, new FileSummary(), resultSetQueryIdsFun, resultGetGoupIdFun, 100);
    }

    @Override
    public <D> void mergeBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod) {
        ServiceUtil.interalMergeBeanTo(dests, destGetMethod, this, FileSummaryServiceImpl::getFileSummarysByFileIds, FileSummary::getFileId);
    }

    @Override
    public <T> String generateId(Class<T> bizTagClz) {
        return this.idGenerator.generateId(String.class, bizTagClz);
    }
}

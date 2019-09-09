package com.mycompany.biz.facadegen;

import java.io.IOException;
import java.util.Arrays;
import java.util.InvalidPropertiesFormatException;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.multipart.MultipartFile;
import org.stategen.framework.lite.Pagination;
import org.stategen.framework.progen.BaseGenFacadeProcessor;
import org.stategen.framework.progen.GenContext;
import org.stategen.framework.progen.PathType;
import org.stategen.framework.progen.TypescriptContextSetter;
import org.stategen.framework.util.CollectionUtil;
import org.stategen.framework.util.StringUtil;

import freemarker.template.TemplateException;


public class H5FacadeProcessor extends BaseGenFacadeProcessor {
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(H5FacadeProcessor.class);

    public H5FacadeProcessor() {
        super();
    }

    public static void main(String[] args) {
        H5FacadeProcessor h5FacadeProcessor = new H5FacadeProcessor();
        try {
            logger.info("================== h5 前端代码生成开始===========================");
            h5FacadeProcessor.genFacade();
            logger.info("================== h5 前端代码生成结束===========================");
        } catch (Exception e) {
            logger.error("生成前端代码时出错:", e);
        }
    }
 
    @Test
    public void gen() {
        main(null);
    }

    public void genFacade() throws InvalidPropertiesFormatException, IOException, TemplateException {
        new TypescriptContextSetter().setContext();
        
        //这里注册的将替代supper中的注册
        GenContext.registSimpleClz(Void.TYPE, "void");
        GenContext.registSimpleClz(Class.class, "string");
        GenContext.registSimpleClz(Pagination.class, "PaginationProps","import {PaginationProps} from 'antd/es/pagination'");
        GenContext.registSimpleClz(MultipartFile.class, "UploadFile","import {UploadFile} from 'antd/es/upload/interface'");
        
        GenContext.registIgnoreParamClz(HttpServletRequest.class);
        GenContext.registIgnoreParamAnnotationClz(CookieValue.class);
        GenContext.addStaticUtil(StringUtil.class);
        GenContext.addStaticUtil(CollectionUtil.class);
        GenContext.tempDirs =Arrays.asList("/typescript/ts-api","/typescript/ts-umi","/typescript/ts-umi-h5");
        GenContext.outDir="app-frontend-h5/src/intergrade/";


        PathType[] pathTypes = PathType.values();
        for (PathType pathType : pathTypes) {
            String nameStr = pathType.getWrapName() + "s";
            GenContext.put(pathType, nameStr);
        }
        super.scanControllerAndGenFacade();
    }

}

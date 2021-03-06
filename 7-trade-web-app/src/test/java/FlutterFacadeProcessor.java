
import java.io.IOException;
import java.util.Arrays;
import java.util.InvalidPropertiesFormatException;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.web.bind.annotation.CookieValue;
import org.stategen.framework.progen.BaseGenFacadeProcessor;
import org.stategen.framework.progen.FlutterContextSetter;
import org.stategen.framework.progen.GenContext;
import org.stategen.framework.progen.PathType;
import org.stategen.framework.util.CollectionUtil;
import org.stategen.framework.util.JSONUtil;
import org.stategen.framework.util.StringUtil;

import freemarker.template.TemplateException;

/**
 * 运行可以生成前端代码，用mvn package也会自动运行该代码生成前端
 *
 */
public class FlutterFacadeProcessor extends BaseGenFacadeProcessor {
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(FlutterFacadeProcessor.class);

    public FlutterFacadeProcessor() {
        super();
    }

    public static void main(String[] args) {
        FlutterFacadeProcessor flutterFacadeProcessor = new FlutterFacadeProcessor();
        try {
            logger.info("================== flutter 前端代码生成开始===========================");
            flutterFacadeProcessor.genFacade();
            logger.info("================== flutter 前端代码生成结束===========================");
        } catch (Exception e) {
            logger.error("生成前端代码时出错:", e);
        }
    }
 
    @Test
    public void gen() {
        main(null);
    }

    public void genFacade() throws InvalidPropertiesFormatException, IOException, TemplateException {
        new FlutterContextSetter().setContext();

        //这里注册的将替代supper中的注册
        GenContext.registSimpleClz(Void.TYPE, "void");
        GenContext.registSimpleClz(Class.class, "String");

        GenContext.registIgnoreParamClz(HttpServletRequest.class);
        GenContext.registIgnoreParamAnnotationClz(CookieValue.class);
        GenContext.addStaticUtil(StringUtil.class);
        GenContext.addStaticUtil(CollectionUtil.class);
        GenContext.addStaticUtil(JSONUtil.class);
        //
        GenContext.tempDirs = Arrays.asList("/flutter/dart-api", "/flutter/dart-flutter");
        GenContext.outDir = "app-frontend-flutter/lib/intergrade/";

        PathType[] pathTypes = PathType.values();
        for (PathType pathType : pathTypes) {
            String nameStr = pathType.getWrapName() + "s";
            GenContext.put(pathType, nameStr);
        }
        
        super.scanControllerAndGenFacade();
        
        
    }

}

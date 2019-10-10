package config;

import javax.servlet.DispatcherType;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JavaWebXml extends AbstractAnnotationConfigDispatcherServletInitializer {
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(JavaWebXml.class);

    @WebFilter(
            filterName = "CharacterEncodingFilter", urlPatterns = "/*",
            /*--*/
            dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD },
            /*--*/
            initParams = { @WebInitParam(name = "encoding", value = "UTF-8"),
                           /*--*/
                           @WebInitParam(name = "forceEncoding", value = "true") }
    )

    public static class CharacterEncodingFilter extends org.springframework.web.filter.CharacterEncodingFilter {

    }

    @WebFilter(filterName = "frameworkMultiFilter", urlPatterns = "/*")
    public static class MultiFilter extends org.stategen.framework.spring.mvc.MultiFilter {

    }

    @WebFilter(filterName = "CORSFilter", urlPatterns = "/*")
    @WebInitParam(name = "encoding", value = "UTF-8")
    public static class CORSFilter extends org.stategen.framework.spring.mvc.CORSFilter {

    }

    @WebFilter(filterName = "CORSFilter", urlPatterns = "/*")
    @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid*")
    public static class WebStatFilter extends com.alibaba.druid.support.http.WebStatFilter {

    }
    
    @WebInitParam(name="contextConfigLocation", value="classpath*:applicationContext.xml")
    public static class InitParamListener {

    }

    @WebListener
    public static class RequestContextListener extends org.springframework.web.context.request.RequestContextListener {

    }

    @WebListener
    public static class DriversShutdownListener extends org.stategen.framework.spring.util.DriversShutdownListener {

    }

    @WebServlet(name = "StatViewServlet", urlPatterns = "/druid/*",
            /*--*/
            initParams = {
                           /** 允许清空统计数据 */
                           @WebInitParam(name = "resetEnable", value = "true"),
                           /*<!-- 用户名 -->*/
                           @WebInitParam(name = "loginUsername", value = "druid"),
                           /*<!-- 密码 -->*/
                           @WebInitParam(name = "loginPassword", value = "druid")

            })
    public static class StatViewServlet extends com.alibaba.druid.support.http.StatViewServlet {
        private static final long serialVersionUID = 1L;

    }
    
    //为了与  破springboot 兼容，使用 AbstractAnnotationConfigDispatcherServletInitializer
//  @WebListener()
//  public static class ContextLoaderListener extends org.springframework.web.context.ContextLoaderListener {
//      
//      @Override
//      public void contextInitialized(ServletContextEvent event) {
//          if (logger.isInfoEnabled()) {
//              logger.info(new StringBuffer("输出info信息: event:").append(count).toString());
//              count++;
//          }
//          
//          ServletContext servletContext = event.getServletContext(); 
////          servletContext.setInitParameter("contextConfigLocation", "classpath*:applicationContext.xml");
//          
////          servletContext.removeAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//          super.contextInitialized(event);
//      }
//
//  }
//    @WebServlet(name="DispatcherServlet",urlPatterns = "/",loadOnStartup=1,
//            /**/
//            initParams =@WebInitParam(name="contextConfigLocation",value="classpath*:servletContext.xml")
//            )
//    
//    public static class DispatcherServlet extends org.springframework.web.servlet.DispatcherServlet{
//        private static final long serialVersionUID = 1L;
//    }

    @ImportResource("classpath*:applicationContext.xml")
    public static class RootConfig{
        
    }
    
    @ImportResource("classpath*:servletContext.xml")
    public static class ServletConfig{
        
    }
    
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { ServletConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
      return new String[] { "/" };
    }


}

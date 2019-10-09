package config;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

public class JavaWebXml  {

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

    @WebListener()
    public static class ContextLoaderListener extends org.springframework.web.context.ContextLoaderListener {
        @Override
        public void contextInitialized(ServletContextEvent event) {
            ServletContext servletContext = event.getServletContext(); 
            servletContext.setInitParameter("contextConfigLocation", "classpath*:applicationContext.xml");
            super.contextInitialized(event);
        }


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

    @WebServlet(name="DispatcherServlet",urlPatterns = "/",loadOnStartup=1,
            /**/
            initParams =@WebInitParam(name="contextConfigLocation",value="classpath*:servletContext.xml")
            )
    
    public static class DispatcherServlet extends org.springframework.web.servlet.DispatcherServlet{
        private static final long serialVersionUID = 1L;
    }



}

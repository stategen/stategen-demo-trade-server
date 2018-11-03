package com.mycompany.biz.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.stategen.framework.web.cookie.RequestUtil;

@Controller
/***没有 @ApiConfig 不生成前端代码 */
@RequestMapping
public class DefaultController {
    private static final String INDEX_HTML = "pages/index.html";
    private static final String PAGES = "pages";
    private static final String PAGES_SLASH = "pages/";
    

    @RequestMapping(value = { "/", "", "/index.html", INDEX_HTML, PAGES })
    public void index(HttpServletResponse response) throws IOException {
        String requestAppName = RequestUtil.getRequestAppName();
        String result = new StringBuffer(requestAppName).append(PAGES_SLASH).toString();
        response.sendRedirect(result);
    }

    @RequestMapping(value =  PAGES_SLASH )
    public String pages(HttpServletResponse response) throws IOException {
        return INDEX_HTML;
    }

    @RequestMapping(value = { "/pages/{route}" })
    public String pagesOfPage(String route, HttpServletResponse response) throws IOException {
        String result = INDEX_HTML;
        return result;
    }

//    @RequestMapping(value = { "/pages/service-worker.js" })
//    public String pagesOfServiceWoker(String node, HttpServletResponse response) throws IOException {
//        String result = null;
//        result = "pages/service-worker.js";
//        return result;
//    }

}

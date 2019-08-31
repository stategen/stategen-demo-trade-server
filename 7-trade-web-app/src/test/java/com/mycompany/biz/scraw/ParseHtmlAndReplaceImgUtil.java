package com.mycompany.biz.scraw;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseHtmlAndReplaceImgUtil {
    
//    String newsBody="<img alt="" src="/xiaoxiao2/uploads/artImage/image/20130711/20130711182603_176.png" />";
//    public static String HTTPHOST="http://58.192.23.75:8080";
//    Document doc = Jsoup.parse(newsBody);
//          Elements pngs = doc.select("img[src]");
//          for (Element element : pngs) {
//            String imgUrl = element.attr("src");
//            if (imgUrl.trim().startsWith("/")) {
//              imgUrl =HTTPHOST + imgUrl;
//              element.attr("src", imgUrl);
//            }
//          }
//          newsBody = doc.toString();
          
          
    public static String replaceImgTag(String htmlStr,List<ImageUrlChangeHandler> imageUrlChangeHandlers,String savePath,String newDomain) throws IOException, InterruptedException {

        //解析传递的字符串 parse 包含 <body>标签
        final String tag ="src";
        Document parse = Jsoup.parseBodyFragment(htmlStr);
        //解析传递字符串  parse 包含<html> <body>标签
        //Document parse = Jsoup.parse(htmlStr);
        //getElementById 和 getElementsByTag 方法跟 JavaScript 的方法名称是一样的，功能也完全一致

        Elements imgs = parse.getElementsByTag("img");
        for (Element img : imgs) {
            String linkSrc = img.attr(tag);
            ImageUrlChangeHandler handler =new ImageUrlChangeHandler();
            if (handler.handleImg(linkSrc,savePath,newDomain)){
                imageUrlChangeHandlers.add(handler);
                img.attr(tag, handler.newUrl);
            }
        }

        //newStr  该字符串包含<body>标签
        String newStr = parse.body().children().toString();

        //返回修改后字符串
        return newStr;
    }
}

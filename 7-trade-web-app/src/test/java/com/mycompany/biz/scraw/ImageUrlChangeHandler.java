package com.mycompany.biz.scraw;

import java.io.IOException;
import java.net.URL;

import org.stategen.framework.util.StringUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageUrlChangeHandler{
    String fileName;
    String path;
    String newUrl;
    String oldImageUrl;
    
    public <T> Boolean handleImg(String imageStr, String savePath,String newDomain) throws IOException, InterruptedException {
        if (imageStr != null && ( (imageStr.startsWith("http://") || imageStr.startsWith("https://") ) && !imageStr.startsWith(newDomain) )) {
            oldImageUrl =imageStr;
            URL url =new URL(imageStr);
            String urlFileName=url.getPath();
            fileName = StringUtil.trimLeftFormRightTo(urlFileName, "/");
            String folder =StringUtil.trimRight(urlFileName, fileName);
            newUrl=newDomain+urlFileName;
            path = savePath+folder;
            return true;
        }
        return false;
    }
}

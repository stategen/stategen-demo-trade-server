package com.mycompany.biz.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;

import com.mycompany.biz.domain.UploadFile;

@Controller
@ApiConfig(name="下传下载",menu=false,route=false,hidden=true)
public class UploadFileController extends UploadFileControllerBase {

    /*
    * 采用file.Transto 来保存上传的文件
    */
    @ApiRequestMappingAutoWithMethodName
    public List<UploadFile> upload(@RequestParam("files") CommonsMultipartFile[] files) throws IOException {
        long startTime = System.currentTimeMillis();
        List<UploadFile> result =new ArrayList<UploadFile>(files.length);
        
        for (CommonsMultipartFile file : files) {
            String name = file.getOriginalFilename();
            System.out.println("fileName：" + name);
            String newFilename =new Date().getTime() + name;
            String path = "/uploads/" + newFilename;
            File newFile = new File(path);
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);
            
            UploadFile uploadFile = new UploadFile();
            uploadFile.setName(name);
            uploadFile.setUrl("api/uploadFile/download/"+newFilename);;
            uploadFile.setSize(file.getSize());
            this.uploadFileService.insert(uploadFile);
            
        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法二的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return result;
        
    }

}

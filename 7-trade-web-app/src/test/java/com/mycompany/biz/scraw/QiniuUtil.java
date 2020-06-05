package com.mycompany.biz.scraw;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.stategen.framework.generator.util.FileHelpers;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class QiniuUtil {

    // 设置好账号的ACCESS_KEY和SECRET_KEY
    static final String ACCESS_KEY = ""; // 这两个登录七牛
    // 账号里面可以找到  进入 个人面板->个人中心->密钥管理可找到
    static final String SECRET_KEY = "";//

    // 普通上传
    public static void batchUpload(String folder, String bucketname) throws IOException, InterruptedException {
        // 密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        // 创建上传对象
        UploadManager uploadManager = new UploadManager();

        try {
            String upToken = auth.uploadToken(bucketname);
            List<File> searchAllNotIgnoreFile = FileHelpers.searchAllNotIgnoreFile(new File(folder));
            int count = 0;
            StringBuilder sb = null;
            for (File file : searchAllNotIgnoreFile) {
                if (file.exists() && file.isFile() && !file.isHidden() && file.canRead()) {
                    String canonicalPath = file.getCanonicalPath();
                    canonicalPath = canonicalPath.replace("\\", "/");
                    String key = FileHelpers.getRelativePath(folder, canonicalPath);
                    key = key.substring(1);
                    // 调用put方法上传
                    Response res = uploadManager.put(canonicalPath, key, upToken);
                    // 打印返回的信息
                    count++;
                    String out = count + "<====>" + res.isOK() + ":" + res.bodyString();
                    if (count % 100 == 0) {
                        sb = null;
                        System.out.println(out);
                    } else {
                        if (sb == null) {
                            sb = new StringBuilder();
                        }
                        sb.append(out).append('\n');
                    }
                }
            }
            if (sb != null) {
                System.out.println(sb.toString());
            }

        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                // 响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                // ignore
            }
        }
    }

}
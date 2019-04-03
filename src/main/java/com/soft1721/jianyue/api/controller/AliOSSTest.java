package com.soft1721.jianyue.api.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;

import java.io.File;
import java.net.URL;
import java.util.Date;

public class AliOSSTest {
    public static void main(String[] args) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高
        String accessKeyId = "LTAIb4yR6H2XY2kU";
        String accessKeySecret = "zW0DeNu8MzNUEmETN3DLmzhjct3C4d";
        String bucketName = "fsr-soft1721";
        String filedir = "avatar/";
        String fileKey = "hello.jpg";
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件
        PutObjectResult putResult = ossClient.putObject(bucketName, filedir + fileKey, new File("D:\\FSR.jpg"));
        //时间戳
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, filedir + fileKey, expiration);
        System.out.println(url);
        ossClient.shutdown();
    }
}
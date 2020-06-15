package com.soft1851.evaluation.util;

/**
 * 描述:
 *
 * @author：wzw
 * @create 2020-05-25 8:47
 */

import com.aliyun.oss.OSSClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 描述:
 * 阿里云图片上传工具类
 *
 * @author：Guorc
 * @create 2020-05-06 13:23
 */
@Slf4j
public class AliOssUtil {
    public static String upload(MultipartFile sourceFile) {
        // 获取文件名
        String fileName = sourceFile.getOriginalFilename();
        //uuid生成主文件名
        String prefix = UUID.randomUUID().toString();
        assert fileName != null;
        //源文件的扩展名
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //创建File类型的临时文件
        File tempFile = null;
        try {
            tempFile = File.createTempFile(prefix, suffix);
            // 将MultipartFile转换成File
            sourceFile.transferTo(tempFile);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        assert tempFile != null;
        return upload(tempFile);
    }


    public static String upload(File file) {
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAImZo6Cvi2uB6R";
        String accessKeySecret = "JIU16T0ND8haUneY6Kwxh9rTbP1pCB";
        String bucketName = "evaluation-wd";
        String filePath = "QRcode/";
        String fileName = file.getName();
        String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."));
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件到指定位置，并使用UUID更名
        ossClient.putObject(bucketName, filePath + newFileName, file);
        // 拼接URL
        String url = "https://evaluation-wd.oss-cn-beijing.aliyuncs.com/QRcode/" + newFileName;
        ossClient.shutdown();
        return url;
    }

    public static void main(String[] args) {
        File file = new File("E:\\test\\88194282-1923-4b98-adaf-b9b9d5ed7544.jpg");
        System.out.println(upload(file));
    }
}


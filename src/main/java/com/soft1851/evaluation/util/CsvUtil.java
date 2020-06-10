package com.soft1851.evaluation.util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/6/9 9:30
 * @Description:
 */
public class CsvUtil {
    public static List<String> getContent(String url,int col){
        List<String> result = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(url));
            //去掉标题行
            reader.readLine();
            String line;
            while ((line=reader.readLine())!=null){
                String[] item = line.split(",");
                result.add(item[col-1]);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static List<com.soft1851.evaluation.domain.model.List> getAll() throws Exception{
        List<com.soft1851.evaluation.domain.model.List> result = new ArrayList<>();
        List<String> urlList = new ArrayList<>();
        urlList.add("C:\\Users\\Administrator\\Desktop\\新建文件夹\\1.csv");
        urlList.add("C:\\Users\\Administrator\\Desktop\\新建文件夹\\2.csv");
//        urlList.add("C:\\Users\\Administrator\\Desktop\\新建文件夹\\3.csv");
        for (int i = 0;i < urlList.size(); i++){
            BufferedReader reader = new BufferedReader(new FileReader(urlList.get(i)));
            //去掉表头
            reader.readLine();
            String line;
            while ((line=reader.readLine())!=null){
                String[] item = line.split(",");
                String participate;
                if (i == 1){
                    participate = item[4];
                    com.soft1851.evaluation.domain.model.List list = com.soft1851.evaluation.domain.model.List.builder()
                            .img(item[2])
                            .participate(Integer.valueOf(participate.substring(3,participate.length()-1)))
                            .title(item[0])
                            .type(i)
                            .build();
                    result.add(list);
                } else {
                    participate = item[3];
                    com.soft1851.evaluation.domain.model.List list = com.soft1851.evaluation.domain.model.List.builder()
                            .img(item[2])
                            .participate(Integer.valueOf(participate.substring(3,participate.length()-1)))
                            .title(item[0])
                            .type(i)
                            .build();
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static List<String> getQuestion() throws Exception{
        List<String> urlList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        urlList.add("C:\\Users\\Administrator\\Desktop\\新建文件夹\\1.csv");
        urlList.add("C:\\Users\\Administrator\\Desktop\\新建文件夹\\2.csv");
        for (int i = 0; i< urlList.size(); i++){
            //去掉表头
            BufferedReader reader = new BufferedReader(new FileReader(urlList.get(i)));
            String line;
            //去掉标题行
            reader.readLine();
            while ((line = reader.readLine())!=null){
                String[] item = line.split(",");
                result.add(item[1]);
            }
        }
        return result;
    }


    public static void main(String[] args) throws Exception {
//        System.out.println(CsvUtil.getContent("C:\\Users\\Administrator\\Desktop\\新建文件夹\\2.csv",3));
//        System.out.println(CsvUtil.getAll().size());
//        String str = "abcdefg";
//        System.out.println("截取最后一个字符串生成的新字符串为: " + str.substring(1,str.length()-1));
        System.out.println(CsvUtil.getQuestion());
    }
}


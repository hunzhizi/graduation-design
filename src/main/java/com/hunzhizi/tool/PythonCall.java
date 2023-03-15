package com.hunzhizi.tool;

import com.hunzhizi.controller.result.Result;
import com.hunzhizi.controller.result.dto.Analysis;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-13 22:26
 * program: graduation-design
 * description:
 */
@Slf4j
public class PythonCall {
    public static final String UPLODA_DIR = "E:\\img\\graduationDesign\\";
    public static final String INFER_DIR = "E:\\img\\infer\\";



    public static void main(String[] args) throws IOException, InterruptedException {
//        System.out.println(analyzeColor(UPLODA_DIR + "flower.jpg"));
//        System.out.println(labelImg(UPLODA_DIR + "person.jpg"));
        List<String> strings = analyzeColor(UPLODA_DIR + "flower.jpg");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    /**
     * 分析图片的主要色彩，返回RGB 的String
     * @param imgAddress 图片位置的全路径
     * @return
     */
    public static List<String> analyzeColor(String imgAddress) {
        Runtime runtime = Runtime.getRuntime();
        StringBuilder rgb = new StringBuilder();
        log.info("开始执行脚本");
        try {
            Process process = runtime.exec("cmd /c  E:\\py\\conda\\anaconda\\installing\\envs\\python3_ml\\python.exe " +
                    "E:/py/code_practice/graduationDesign/ImageToColors.py" +
                    " --directory " + imgAddress +
                    " --num-theme " + "6");
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    String line;
                    try {
                        BufferedReader stderr = new BufferedReader(new InputStreamReader(process.getErrorStream(), "GBK"));
                        while ((line = stderr.readLine()) != null) {
                            System.out.println("stderr:" + line);
                        }
                    } catch (Exception e) {

                    }

                }
            }.start();

            log.info("==============打印结果==============");
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    String line;
                    try {
                        BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
                        while ((line = stdout.readLine()) != null) {
                            log.info("stdout:" + line);
                            rgb.append(line);

                        }
                    } catch (Exception e) {

                    }
                }
            }.start();
            int exitVal = process.waitFor();
            if (0 != exitVal) {
                System.out.println("执行脚本失败");
            }
            System.out.println("执行脚本成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<String> strings = new ArrayList<>();
        rgb.deleteCharAt(0);
        rgb.deleteCharAt(rgb.length() - 1);
        while (rgb.length() > 0) {
            int last = rgb.lastIndexOf("]");
            last++;
            if (last < rgb.length()) {
                rgb.delete(last, rgb.length());
            }
            int left = rgb.lastIndexOf("[");
            strings.add(rgb.substring(left));
            rgb.delete(left, rgb.length());
        }
        for (String string : strings) {
            System.out.println(string);
        }
        return strings;
    }

    /**
     * 对图片进行打标，将图片保存,
     * @param imgAddress
     * @return List<Integer> 返回在enums中的对应的标签
     */
    public static List<Integer> labelImg(String imgAddress){
        Runtime runtime = Runtime.getRuntime();
        ArrayList<Integer> res = new ArrayList<>();
        try {
            Process process = runtime.exec("cmd /c E:\\py\\conda\\anaconda\\installing\\envs\\graduation-design\\python.exe " +
                    "E:/py/code_practice/graduationDesign/yolov5/detect.py" +
                    " --source " + imgAddress +
                    " --project E:\\img" +
                    " --name infer" +
                    " --exist-ok" +
                    " --save-txt");
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    String line;
                    try {
                        BufferedReader stderr = new BufferedReader(new InputStreamReader(process.getErrorStream(), "GBK"));
                        while ((line = stderr.readLine()) != null) {
                            log.info("stderr:" + line);
                        }
                    } catch (Exception e) {

                    }

                }
            }.start();

            log.info("==============打印结果==============");
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    String line;
                    try {
                        BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
                        while ((line = stdout.readLine()) != null) {
                            log.info("stdout:" + line);
                            // +1 是因为java这里设计是从1开始分类的
                            res.add(((int)Float.parseFloat(line))+1);
                        }
                    } catch (Exception e) {

                    }
                }
            }.start();
            int exitVal = process.waitFor();
            if (0 != exitVal) {
                System.out.println("执行脚本失败");
            }
            System.out.println("执行脚本成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

}



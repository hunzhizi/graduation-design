//package com.hunzhizi.controller;
//
//import com.hunzhizi.controller.result.Result;
//
//import com.hunzhizi.controller.result.dto.Analysis;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//
///**
// * @author 魂之子
// * @since 2023-02-21 14:12
// * program: graduation-design
// * description: 用于进行java和python模块的通讯
// */
//@RestController
//@Slf4j
//@RequestMapping("/pythoncall")
//
//public class PythonCallController {
//
//    public static String UPLODA_DIR = "E:\\img\\graduationDesign\\";
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        Process process = Runtime.getRuntime().
//                exec("cmd /k start E:\\py\\conda\\anaconda\\installing\\envs\\graduation-design\\python.exe E:/py/code_practice/graduationDesign/yolov5/detect.py" +
//                        " --source E:\\py\\code_practice\\graduationDesign\\yolov5\\data\\images\\bus.jpg" +
//                        " --project E:\\img" +
//                        " --name infer" +
//                        " --exist-ok");
//        // cmd /c 表示关闭terminal /k 表示开启terminal
////        Process process = Runtime.getRuntime().
////                exec("cmd /k start E:\\py\\conda\\anaconda\\installing\\envs\\python3_ml\\python.exe E:/py/code_practice/graduationDesign/ImageToColors.py");
//
//
//    }
//
//    /**
//     * 函数用于分析颜色和识别物体
//     * @param imgFile 表示传进来的图片
//     * @param httpServletRequest
//     * @return
//     */
//    @PostMapping("/analysis")
//    @CrossOrigin
//    public Result analysis(@RequestParam("imgFile") MultipartFile imgFile,
//                           HttpServletRequest httpServletRequest,
//                           Integer k) throws IOException {
//        log.info("k:" + k);
//        String orgName = imgFile.getOriginalFilename();
//        imgFile.transferTo(new File(UPLODA_DIR+orgName));
//        log.info("originalFileName: " + orgName);
//        Thread thread1 = new Thread(new Runnable() {
//            @SneakyThrows
//            @Override
//            public void run() {
//                Process process = Runtime.getRuntime().
//                        exec("cmd /k start E:\\py\\conda\\anaconda\\installing\\envs\\graduation-design\\python.exe " +
//                                "E:/py/code_practice/graduationDesign/yolov5/detect.py" +
//                                " --source " + UPLODA_DIR + orgName +
//                                " --project E:\\img"+
//                                " --name infer" +
//                                " --exist-ok" +
//                                " --save-txt");
//            }
//        });
//
//        Thread thread2 = new Thread(new Runnable() {
//            @SneakyThrows
//            @Override
//            public void run() {
//                Process process = Runtime.getRuntime().
//                        exec("cmd /k start E:\\py\\conda\\anaconda\\installing\\envs\\python3_ml\\python.exe " +
//                                "E:/py/code_practice/graduationDesign/ImageToColors.py" +
//                                " --directory " +UPLODA_DIR + orgName +
//                                " --num-theme " + k);
//
//            }
//        });
//        thread1.start();
//        thread2.start();
//        try {
//            thread1.join();
//            thread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        File file = new File("E:\\img\\graduationDesign\\rgb.txt");
//        FileReader fileReader = new FileReader(file);
//        StringBuilder rgb = new StringBuilder();
//        char[] chars = new char[4096];
//        int i = 0;
//        while((i = fileReader.read(chars))!=-1){
//            for (int j = 0; j < i; j++) {
//                System.out.print(chars[j]);
//                rgb.append(chars[j]);
//            }
//        }
//        ArrayList<String> strings = new ArrayList<>();
//        rgb.deleteCharAt(0);
//        rgb.deleteCharAt(rgb.length()-1);
//        while(rgb.length()>0){
//            int last = rgb.lastIndexOf("]");
//            last++;
//            if(last< rgb.length()){
//                rgb.delete(last,rgb.length());
//            }
//            int left = rgb.lastIndexOf("[");
//            strings.add(rgb.substring(left));
//            rgb.delete(left,rgb.length());
//        }
//        for (String string : strings) {
//            System.out.println(string);
//        }
//
//        Analysis analysis = new Analysis(strings, "E:\\img\\infer\\" + orgName);
//
//        return new Result(1,analysis);
//    }
//
//
//}

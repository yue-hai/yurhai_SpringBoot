package com.yuehai.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 月海
 * @create 2022/2/11 19:33
 */

// 文件上传测试
// 表明是控制层
@Controller
// 注入日志类，以后不用在控制台 打印
@Slf4j
public class FormTestController {

    // 跳转到文件上传表单页面
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    /**
     * MultipartFile 自动封装上传过来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    // @RequestParam("email")：获取指定的请求参数，并赋值给后面定义的参数
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         // 获取指定的上传的文件，并交给 MultipartFile 自动封装
                         @RequestPart("headerImg") MultipartFile headerImg,
                         // 也可自动封装多个文件
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息：email={}，username={}，headerImg={}，photos={}",
                email,username,headerImg.getSize(),photos.length);

        // 判断上传的 headerImg（头像）是否为空
        if(!headerImg.isEmpty()){
            // 不为空，则保存到文件服务器
            // getOriginalFilename()：获取文件的原始名称（上传时的名称）
            String originalFilename = headerImg.getOriginalFilename();
            // 设置保存到的位置
            headerImg.transferTo(new File("E:\\cache\\" + originalFilename));
        }

        // 判断上传的 photos（生活照）长度是否大于 0
        if(photos.length > 0){
            // 不为空，则遍历保存到文件服务器，OSS服务器
            for (MultipartFile photo : photos) {
                // 判断本次遍历的 photos（生活照）是否为空
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\cache\\" + originalFilename));
                }
            }
        }

        // 跳转到类路径下的 templates 文件夹下的 main.html 页面
        return "main";
    }
}

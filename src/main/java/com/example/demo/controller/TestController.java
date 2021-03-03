package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.path.PathUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("test")
public class TestController {

    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "Do you like van♂ 游戏？";
    }

    /**
     * 打开演示freemarker模板的页面
     * @return
     */
    @GetMapping("openFreemarkerWeb")
    public String openFreemarkerWeb(Model model){
        List<User> list = new ArrayList<User>();
        list.add(new User(1L,"张一",1,"张一"));
        list.add(new User(2L,"张二",2,"张二"));
        list.add(new User(3L,"张三",3,"张三"));
        list.add(new User(4L,"张四",4,"张四"));
        list.add(new User(5L,"张五",5,"张五"));
        list.add(new User(6L,"张六",6,"张六"));
        model.addAttribute("list",list);

        return "freemarkerDemo";
    }

    @GetMapping("openUploadModelAndView")
    public ModelAndView openUploadModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fileUpload");

        return modelAndView;
    }

    @GetMapping("openUploadWeb")
    public String openUploadWeb(){
        return "fileUpload";
    }

    @PostMapping("upload")
    @ResponseBody
    public String upload(MultipartFile upload,String username){
        System.out.println("----账号：" + username);
        System.out.println("----input的name：" + upload.getName());
        System.out.println("----上传的文件名：" + upload.getOriginalFilename());
        return username;
    }

    /**
     * 获取项目的各个路径
     * @return
     */
    @GetMapping("getPath")
    @ResponseBody
    public void getPath() throws FileNotFoundException {
        System.out.println("类加载器路径ClassUtils：" + ClassUtils.getDefaultClassLoader().getResource("").getPath()); // /D:/workspace/goodgoodstudy-daydayup/target/classes/
        System.out.println("ResourceUtils路径：" + ResourceUtils.getURL("classpath:").getPath()); // /D:/workspace/goodgoodstudy-daydayup/target/classes/
        // System.out.println("获取当前项目所在路径：" + System.getProperty("user.dir")); // D:\workspace\goodgoodstudy-daydayup(不用这种)
        System.out.println("项目根路径：" + PathUtils.getResourceBasePath()); // D:\workspace\goodgoodstudy-daydayup
    }

    /**
     * 下载日志
     * @param request
     * @param response
     */
    @GetMapping("downloadLog")
    public void downloadLog(HttpServletRequest request, HttpServletResponse response){
        File file = new File(PathUtils.getResourceBasePath() + "/log/log.log");
        // 设置响应头和客户端保存的文件名
        response.setCharacterEncoding("UTF-8");
//        response.setContentType("multipart/form-data");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Diposition","attachment:fileName=" + file.getName());
        System.out.println("将要下载的文件名是：" + file.getName());
        InputStream in = null;
        ServletOutputStream out = null;
        try{
            // 文件的复制
            in = new FileInputStream(file);
            out = response.getOutputStream();
            // 循环读取
            byte[] b = new byte[1024];
            int length = 0;
            while ((length = in.read(b)) > 0){
                out.write(b,0,length);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 专门用于触发空指针异常
     */
    @GetMapping("triggerNullPointerException")
    public void triggerNullPointerException(){
        String str = null;
        str.length();
    }



}

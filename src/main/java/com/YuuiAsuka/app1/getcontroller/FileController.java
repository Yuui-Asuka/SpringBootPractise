package com.YuuiAsuka.app1.getcontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import com.YuuiAsuka.app1.domain.JsonData;

//通过Controller来跳转到index.html文件
@Controller

@PropertySource({"classpath:application.properties"})
public class FileController {

    @RequestMapping(value = "/v1/gopage")
    public Object index(){
        return "index.html";
    }

    @Value("${web.file.path}")
    private String filePath;

    //upload对应的是form表单的upload,同时也对应xml配置文件里面的upload
    @RequestMapping(value = "upload")
    @ResponseBody
    //该参数对应的是form表单的name名称，如果不设定该参数，file的名称就要和表单里的一样
    public JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request){
        String name = request.getParameter("name");
        System.out.println("用户名 "+name);

        String fileName = file.getOriginalFilename();
        System.out.println("上传文件名为:"+fileName);

        assert fileName != null;
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传后缀名为 "+suffixName);

        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath+fileName);

        try{
            //transferTo方法用于高效的文件保存，效率比原先的FileOutStream高
            file.transferTo(dest);
            return new JsonData(0,"success to upload......", fileName);
        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
        }return new JsonData(-1, "fail to upload..");
    }
}

package com.hiyond.web.controller;

import com.hiyond.common.tools.UuidUtils;
import com.hiyond.entity.UploadEntity;
import com.hiyond.web.controller.base.BaseController;
import net.sf.json.JSONObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;

@Controller
@RequestMapping("upload")
@Scope(value = "prototype")
public class UploadController extends BaseController {

    private static Logger logger = Logger.getLogger(UploadController.class);

    private static String resources = "D:\\hiyond\\resources\\";

    @RequestMapping("upload")
    public Object upload() {
        return "upload/upload";
    }

    @RequestMapping(value = "uploadFile",method = RequestMethod.POST)
    public void uploadFile(MultipartFile file, UploadEntity uploadEntity, HttpServletResponse response) throws IOException {
        logger.info("上传文件开始。。。"+"uploadEntity:"+ ToStringBuilder.reflectionToString(uploadEntity));
        System.out.println(file.getOriginalFilename());
        BufferedOutputStream bufferedOutputStream = null;
        String state = "ok";
        String msg = "操作成功";
        String picPath = null;
        try {
            String[] limitImgType = {"jpg".toLowerCase().trim(),"png".toLowerCase().trim()};
            String fileName = file.getOriginalFilename();
            String fileType = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();

            if(!Arrays.asList(limitImgType).contains(fileType)){
                state = "error";
                msg = "不支持的文件类型,请选择上传的文件格式为：";
                StringBuilder sb = new StringBuilder(msg);
                for (int i = 0 ; i < limitImgType.length; i++) {
                    String s = "*."+limitImgType[i];
                    if(i < limitImgType.length -1){
                        s += ",";
                    }
                    sb.append(s);
                }
                msg = sb.toString();
                return ;
            }
            fileName = "images\\"+UuidUtils.getUUID()+".png";
            File file1 = new File(resources+fileName);
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file1));
            bufferedOutputStream.write(file.getBytes());
            picPath = fileName.replaceAll("\\\\","/");
        }catch (Exception e){
            state = "error";
            msg = "操作失败";
            logger.error(e.getMessage());
        }finally {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("state",state);
            jsonObject.put("msg",msg);
            if(StringUtils.isNoneBlank(picPath)){
                jsonObject.put("picPath",picPath);
            }
            super.responseWrite(jsonObject, response);
            if(bufferedOutputStream != null){
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            }
        }

    }
}

package com.zhaolg5.singleton.userinfo.controller;

import com.zhaolg5.singleton.userinfo.bean.ImageInfo;
import com.zhaolg5.singleton.userinfo.service.interfaces.IUserInfoSV;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaolg on 2018/5/20
 *
 * @return
 * @throws Exception
 */
@RestController
public class ImageUploadContrinller {

    @Value("${web.upload-path}")
    private String path;

    @Autowired
    IUserInfoSV userInfoSV;

    @RequestMapping(value = {"/imageUpload"} ,method = RequestMethod.POST ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public String imageUpLoad(@Param("file") MultipartFile file, @Param("openid") String  openid,@RequestParam("userid") String userId,@RequestParam("sortId") String sortId)throws Exception{
        JSONObject param = new JSONObject();
        if (!file.isEmpty()) {
            if (file.getContentType().contains("image")) {
                String fileName = file.getOriginalFilename();
                int size = (int) file.getSize();

                File dest = new File(path + openid +"/" + fileName);
                //判断文件父目录是否存在
                if(!dest.getParentFile().exists()){
                    dest.getParentFile().mkdir();
                }
                file.transferTo(dest);

                List<ImageInfo> list = new ArrayList<>();
                ImageInfo imageInfo = new ImageInfo();
                imageInfo.setImageUrl("/"+openid+"/" + fileName);
                imageInfo.setUserId(Long.valueOf(userId));
                imageInfo.setSortId(Long.valueOf(sortId));
                list.add(imageInfo);

                userInfoSV.deleteImage(Long.valueOf(userId),Long.valueOf(sortId));
                userInfoSV.saveImageInfoList(list);
                param.put("msgCode","1");
                param.put("imageUrl",imageInfo.getImageUrl());
                param.put("imageId",sortId);
            } else {
                param.put("msgCode","10003");
                param.put("msgDesc","上传的文件不是图片类型，请重新上传!");
            }
            return param.toString();
        } else {
            param.put("msgCode","10003");
            param.put("msgDesc","上传的文件不是图片类型，请重新上传!");
            return param.toString();
        }
    }

}

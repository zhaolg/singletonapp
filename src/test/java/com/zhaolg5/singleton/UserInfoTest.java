package com.zhaolg5.singleton;

import com.zhaolg5.singleton.userinfo.bean.ImageInfo;
import com.zhaolg5.singleton.userinfo.bean.UserInfo;
import com.zhaolg5.singleton.userinfo.service.interfaces.IUserInfoSV;
import com.zhaolg5.singleton.userinfo.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaolg on 2018/5/16
 *
 * @return
 * @throws Exception
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingletonApplication.class )
public class UserInfoTest {

    @Autowired
    IUserInfoSV userInfoSV;

    @Test
    public void testSave(){
        UserInfo userInfo = new UserInfo();
        userInfo.setBirthday(DateUtils.getYYYYMMDD("1992-05-17"));
        userInfo.setCollege("山西大学");
        userInfo.setCountry("中国");
        userInfo.setCreateDate(DateUtils.getNowDate());
        userInfo.setCurrCity("上海");
        userInfo.setCurrProvince("上海");
        userInfo.setNativeCity("包头");
        userInfo.setNativeProvince("内蒙古");
        userInfo.setEdu("本科");
        userInfo.setGender(1);
        userInfo.setSelfIntroduction("我就是我，不一样的烟火");
        userInfo.setRemark("测试数据");
        userInfo.setUserName("赵林刚");
        userInfo.setState("U");
        userInfoSV.save(userInfo);

        long userId = userInfo.getUserId();

        List<ImageInfo> list = new ArrayList<>();

        ImageInfo imageInfo = new ImageInfo();
        imageInfo.setUserId(userId);
        imageInfo.setImageUrl("/data/userinfo/1/1.jpg");
        list.add(imageInfo);

        ImageInfo imageInfo1 = new ImageInfo();
        imageInfo1.setUserId(userId);
        imageInfo1.setImageUrl("/data/userinfo/1/1.jpg");
        list.add(imageInfo1);

        userInfoSV.saveImageInfoList(list);

    }








}

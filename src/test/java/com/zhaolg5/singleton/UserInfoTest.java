package com.zhaolg5.singleton;

import com.zhaolg5.singleton.userinfo.bean.ImageInfo;
import com.zhaolg5.singleton.userinfo.bean.UserInfo;
import com.zhaolg5.singleton.userinfo.bean.UserTag;
import com.zhaolg5.singleton.userinfo.bean.WebChatConfig;
import com.zhaolg5.singleton.userinfo.common.WXAppletUserInfo;
import com.zhaolg5.singleton.userinfo.service.interfaces.IUserInfoSV;
import com.zhaolg5.singleton.userinfo.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    WebChatConfig chatConfig;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WXAppletUserInfo wxAppletUserInfo;

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
        userInfo.setOpenId("o9rMn487dTk1KltS22B0qCt5hGHM");
        userInfoSV.save(userInfo);

        long userId = userInfo.getUserId();

        List<ImageInfo> list = new ArrayList<>();

        ImageInfo imageInfo = new ImageInfo();
        imageInfo.setUserId(userId);
        imageInfo.setImageUrl("/o9rMn487dTk1KltS22B0qCt5hGHM/fbb.jpg");
        list.add(imageInfo);

        ImageInfo imageInfo1 = new ImageInfo();
        imageInfo1.setUserId(userId);
        imageInfo1.setImageUrl("/o9rMn487dTk1KltS22B0qCt5hGHM/hg.gif");
        list.add(imageInfo1);

        ImageInfo imageInfo2 = new ImageInfo();
        imageInfo2.setUserId(userId);
        imageInfo2.setImageUrl("/o9rMn487dTk1KltS22B0qCt5hGHM/lh.jpeg");
        list.add(imageInfo2);

        userInfoSV.saveImageInfoList(list);

        List<UserTag> listTag = new ArrayList<>();

        UserTag userTag1 = new UserTag();
        userTag1.setUserId(userId);
        userTag1.setTagName("成熟稳重");
        userTag1.setTagType("primary");
        listTag.add(userTag1);

        UserTag userTag2 = new UserTag();
        userTag2.setUserId(userId);
        userTag2.setTagName("心地善良");
        userTag2.setTagType("primary");
        listTag.add(userTag2);


        UserTag userTag3 = new UserTag();
        userTag3.setUserId(userId);
        userTag3.setTagName("游泳");
        userTag3.setTagType("danger");
        listTag.add(userTag3);

        UserTag userTag4 = new UserTag();
        userTag4.setUserId(userId);
        userTag4.setTagName("乒乓球");
        userTag4.setTagType("danger");
        listTag.add(userTag4);

        UserTag userTag5 = new UserTag();
        userTag5.setUserId(userId);
        userTag5.setTagName("湖南张家界");
        userTag5.setTagType("warn");
        listTag.add(userTag5);

        UserTag userTag6 = new UserTag();
        userTag6.setUserId(userId);
        userTag6.setTagName("西安");
        userTag6.setTagType("warn");
        listTag.add(userTag6);

        UserTag userTag7 = new UserTag();
        userTag7.setUserId(userId);
        userTag7.setTagName("北京");
        userTag7.setTagType("warn");
        listTag.add(userTag7);

        UserTag userTag8 = new UserTag();
        userTag8.setUserId(userId);
        userTag8.setTagName("三亚");
        userTag8.setTagType("warn");
        listTag.add(userTag8);

        userInfoSV.saveUserTagList(listTag);
    }

    @Test
    public void TestGetWebChatConfig(){
        System.out.println(chatConfig.getAppId());
        System.out.println(chatConfig.getSecret());
        System.out.println(chatConfig.getWebChaturl());
    }

    @Test
    public void TestGetUserOpenId(){
        String jsonStr = restTemplate.getForEntity("https://api.weixin.qq.com/sns/jscode2session?appid={0}&&secret={1}&js_code={2}&grant_type=authorization_code", String.class, chatConfig.getAppId(), chatConfig.getSecret(),"081QOIWi2KUtoI0bl6Vi2P6OWi2QOIWO").getBody();
        System.out.println(jsonStr);
    }

    @Test
    public void TestGetOpenIdByCode()throws Exception{
        String code = "011AdOzG1MCeP70xi6xG14KXzG1AdOz2";
        String userInfo = wxAppletUserInfo.getUserInfo(code);
        System.out.println(userInfo);
    }





}

package com.zhaolg5.singleton;

import com.zhaolg5.singleton.userinfo.bean.UserInfo;
import com.zhaolg5.singleton.userinfo.service.interfaces.IUserInfoSV;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        UserInfo aa = new UserInfo();
        aa.setUserName("赵林刚");
        aa.setState("U");
        userInfoSV.save(aa);
    }








}

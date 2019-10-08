package com.zhaolg5.singleton;

import com.zhaolg5.singleton.userinfo.dto.AddressRespDto;
import com.zhaolg5.singleton.userinfo.utils.IpAddressUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author lingang.zhao
 * @version 1.0
 * @date 2019/10/2 1:32 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingletonApplication.class )
public class IPAddress {

    @Resource
    private IpAddressUtils ipAddressUtils;

    @Test
    public void testIp(){

        String ip = "175.42.0.25";

        AddressRespDto address = ipAddressUtils.getAddress(ip);

        System.out.println(address);


    }


}

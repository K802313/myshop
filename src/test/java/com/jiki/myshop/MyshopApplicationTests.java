package com.jiki.myshop;

import com.jiki.myshop.dao.ShopUserInfoMapper;
import com.jiki.myshop.pojo.ShopUserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyshopApplicationTests {

    @Autowired
    private ShopUserInfoMapper shopUserInfoMapper;
    @Test
    void contextLoads() {
    }

    @Test
    public void ShopUserInfo() {
        ShopUserInfo shopUserInfo = shopUserInfoMapper.selectByPrimaryKey(1);
        System.out.println(shopUserInfo);
    }

}

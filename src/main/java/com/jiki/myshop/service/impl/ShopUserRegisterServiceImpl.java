package com.jiki.myshop.service.impl;

import com.jiki.myshop.dao.ShopUserLoginMapper;
import com.jiki.myshop.pojo.ShopUserLogin;
import com.jiki.myshop.service.ShopUserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

/**
 * 注册业务实现类
 * @author k_802
 */
@Service
public class ShopUserRegisterServiceImpl implements ShopUserRegisterService {

    @Autowired
    private ShopUserLoginMapper registerMapper;

    /**
     * 用户注册
     * @param shopUserLogin 用户信息
     * @return 是否注册成功
     */
    @Override
    public boolean userRegister(ShopUserLogin shopUserLogin) {
        String s = registerMapper.selectByUserName(shopUserLogin.getUsername());
        if (!StringUtils.isEmpty(s)) {
            return false;
        }
        shopUserLogin.setLockState("0");
        LocalDateTime localDateTime = LocalDateTime.now();
        shopUserLogin.setCreateTime(localDateTime);
        shopUserLogin.setUpdateTime(localDateTime);
        int insert = registerMapper.insert(shopUserLogin);
        return insert==1;
    }
}

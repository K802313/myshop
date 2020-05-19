package com.jiki.myshop.service.impl;

import com.jiki.myshop.dao.ShopUserLoginMapper;
import com.jiki.myshop.pojo.ShopUserLogin;
import com.jiki.myshop.service.ShopUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiki
 */
@Service
public class ShopUserLoginServiceImpl implements ShopUserLoginService {

    @Autowired
    private ShopUserLoginMapper shopUserLoginMapper;

    @Override
    public ShopUserLogin getUserInfo(String username) {
        return shopUserLoginMapper.selectByUserNameU(username);
    }
}

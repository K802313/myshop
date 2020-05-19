package com.jiki.myshop.service;

import com.jiki.myshop.pojo.ShopUserLogin;

/**
 * 注册业务
 * @author k_802
 */
public interface ShopUserRegisterService {

    /**
     * 进行用户注册
     * @param shopUserLogin 用户信息
     * @return 是否注册成功
     */
    boolean userRegister(ShopUserLogin shopUserLogin);

}

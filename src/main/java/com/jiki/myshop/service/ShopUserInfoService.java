package com.jiki.myshop.service;

import com.jiki.myshop.pojo.ShopUserInfo;

import java.util.List;

/**
 * @author k_802
 */
public interface ShopUserInfoService {

    boolean save(ShopUserInfo shopUserInfo);

    boolean delete(Integer id);

    boolean delets(Integer [] ids);

    boolean update(ShopUserInfo shopUserInfo);

    ShopUserInfo selectOne(ShopUserInfo shopUserInfo);

    List<ShopUserInfo> selectList(ShopUserInfo shopUserInfo);

}

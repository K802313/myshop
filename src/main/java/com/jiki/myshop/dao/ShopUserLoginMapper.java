package com.jiki.myshop.dao;


import com.jiki.myshop.pojo.ShopUserLogin;
import org.springframework.stereotype.Repository;

/**
 * 用户登录注册持久层
 * @author k_802
 */
@Repository
public interface ShopUserLoginMapper {

    /**
     * 判断用户是否存在
     * @param username 用户名
     * @return 用户名
     */
    String selectByUserName(String username);

    /**
     * 获取整个用户登录信息
     * @param username 用户名
     * @return
     */
    ShopUserLogin selectByUserNameU(String username);

    int deleteByPrimaryKey(Integer id);

    /**
     * 用户信息注册
     * @param shopUserLogin
     * @return 是否注册成功
     */
    int insert(ShopUserLogin shopUserLogin);

    int insertSelective(ShopUserLogin record);

    ShopUserLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopUserLogin record);

    int updateByPrimaryKey(ShopUserLogin record);
}
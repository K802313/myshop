package com.jiki.myshop.service.impl;

import com.jiki.myshop.dao.ShopUserInfoMapper;
import com.jiki.myshop.pojo.ShopUserInfo;
import com.jiki.myshop.service.ShopUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopUserInfoServiceImpl implements ShopUserInfoService {

    @Autowired
    private ShopUserInfoMapper shopUserInfoMapper;

    @Override
    public boolean save(ShopUserInfo shopUserInfo) {

        return shopUserInfoMapper.insert(shopUserInfo)==1;
    }

    @Override
    public boolean delete(Integer id) {

        return shopUserInfoMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean delets(Integer[] ids) {
        return false;
    }

    @Override
    public boolean update(ShopUserInfo shopUserInfo) {
        return shopUserInfoMapper.updateByPrimaryKey(shopUserInfo)==1;
    }

    @Override
    public ShopUserInfo selectOne(ShopUserInfo shopUserInfo) {
        return shopUserInfoMapper.selectByPrimaryKey(shopUserInfo.getId());
    }

    @Override
    public List<ShopUserInfo> selectList(ShopUserInfo shopUserInfo) {
        return shopUserInfoMapper.selectList(shopUserInfo);
    }

}

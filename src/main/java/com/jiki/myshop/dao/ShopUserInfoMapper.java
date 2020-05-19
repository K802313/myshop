package com.jiki.myshop.dao;

import com.jiki.myshop.pojo.ShopUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author k_802
 */

@Repository
public interface ShopUserInfoMapper {

    List<ShopUserInfo> selectList(ShopUserInfo shopUserInfo);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopUserInfo record);

    int insertSelective(ShopUserInfo record);

    ShopUserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopUserInfo record);

    int updateByPrimaryKey(ShopUserInfo record);
}

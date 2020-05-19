package com.jiki.myshop.controller;

import com.jiki.myshop.exception.CommonEnum;
import com.jiki.myshop.pojo.ShopUserInfo;
import com.jiki.myshop.service.ShopUserInfoService;
import com.jiki.myshop.util.ResultBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author k_802
 */
@RestController
@RequestMapping("/userinfo")
@Validated
public class ShopUserInfoController {

    @Autowired
    private ShopUserInfoService shopUserInfoService;

    @RequestMapping("/list")
    public ResultBody getList() {
        List<ShopUserInfo> shopUserInfos = shopUserInfoService.selectList(null);
        return ResultBody.success(shopUserInfos);
    }

    @PostMapping("/del")
    public ResultBody delInfo(@NotNull(message = "id信息为空") Integer id) {
        boolean delete = shopUserInfoService.delete(id);
        return delete?ResultBody.success():new ResultBody(CommonEnum.DATA_PROCESS_ERROR);
    }

    @PostMapping("/save")
    public ResultBody save(ShopUserInfo shopUserInfo) {
        boolean save = shopUserInfoService.save(shopUserInfo);
        return save?ResultBody.success():new ResultBody(CommonEnum.DATA_PROCESS_ERROR);
    }

}

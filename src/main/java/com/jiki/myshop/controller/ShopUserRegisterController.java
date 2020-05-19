package com.jiki.myshop.controller;

import com.jiki.myshop.controller.vo.User;
import com.jiki.myshop.exception.CommonEnum;
import com.jiki.myshop.pojo.ShopUserLogin;
import com.jiki.myshop.service.ShopUserRegisterService;
import com.jiki.myshop.util.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 用户注册接口
 *
 * @author k_802
 */
@Slf4j
@Validated
@RestController
public class ShopUserRegisterController {
    @Autowired
    private ShopUserRegisterService shopUserRegisterService;

    @PostMapping("/user-register")
    public ResultBody userRegister(@Valid User user) {
        ShopUserLogin shopUserLogin = new ShopUserLogin();
        BeanUtils.copyProperties(user, shopUserLogin);
        return shopUserRegisterService.userRegister(shopUserLogin) ? new ResultBody(CommonEnum.SUCCESS) : new ResultBody(CommonEnum.DATA_PROCESS_ERROR);
    }


}

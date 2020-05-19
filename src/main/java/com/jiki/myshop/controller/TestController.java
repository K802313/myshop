package com.jiki.myshop.controller;


import com.jiki.myshop.controller.vo.User;
import com.jiki.myshop.exception.CommonEnum;
import com.jiki.myshop.util.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author k_802
 */
@RestController
@Validated
@CrossOrigin
@Slf4j
public class TestController {

//    @PostMapping("/getUser")
//    public String getUserStr(@NotBlank(message = "用户名为空")String name,
//                             @Max(value = 99, message = "不能大于99岁") @NotNull (message = "age不能为空")Integer age) {
//        return "name: " + name + " ,age:" + age;
//    }
//
//    @PostMapping("/getJson")
//    public ResultBody getJsonPost(@RequestBody User user,HttpServletRequest request) {
//        ResultBody resultBody = new ResultBody(CommonEnum.SUCCESS.getResultCode(), "成功");
//        resultBody.setResult(user);
//        return resultBody;
//    }
//
//    @GetMapping("/getJson")
//    public ResultBody getJsonGet(HttpServletRequest request,User user) {
//        ResultBody resultBody = new ResultBody(CommonEnum.SUCCESS.getResultCode(), "成功");
//        resultBody.setResult(user);
//        return resultBody;
//    }
}

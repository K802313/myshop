package com.jiki.myshop.controller;




import com.jiki.myshop.controller.vo.User;
import com.jiki.myshop.exception.CommonEnum;
import com.jiki.myshop.util.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author k_802
 */
@Slf4j
@RestController
public class ShopUserLoginController {

    @RequestMapping("/tologin")
    public String toLogin() {
        return "请登录";
    }


    @PostMapping("/login")
    public ResultBody login(@Validated User user) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUsername(),
                user.getPassword()
        );
        try {
            subject.login(usernamePasswordToken);

        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new ResultBody(CommonEnum.USER_LOGIN_ERROR);
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return new ResultBody(CommonEnum.USER_AUTH_ERROR);
        } catch (Exception e){
            e.printStackTrace();
            return new ResultBody(CommonEnum.USER_LOGIN_ERROR);
        }
        return new ResultBody(CommonEnum.SUCCESS);
    }

    @RequestMapping("/index")
    public ResultBody index() {
        return new ResultBody(CommonEnum.SUCCESS.getResultCode(),"主页");
    }
    @RequestMapping("/error1")
    public ResultBody error() {
        return new ResultBody(CommonEnum.USER_AUTH_ERROR);
    }
}

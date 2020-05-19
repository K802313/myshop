package com.jiki.myshop.exception;

/**
 * @author k_802
 */

public enum CommonEnum implements BaseErrorInfoInterface {
    //数据操作错误定义
    SUCCESS("0", "成功!"),
    BODY_NOT_MATCH("400","请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401","请求的数字签名不匹配!"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503","服务器正忙，请稍后再试!"),
    DATA_PROCESS_ERROR("1010","服务数据处理异常,请稍后再试!"),
    USER_LOGIN_ERROR("1011","用户名或密码错误"),
    USER_AUTH_ERROR("1012","认证失败")
    ;


    /**
     * 响应码
     */
    private String resultCode;

    /**
     * 响应信息
     */
    private String resultMsg;

    CommonEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return this.resultCode;
    }

    @Override
    public String getResultMsg() {
        return this.resultMsg;
    }
}

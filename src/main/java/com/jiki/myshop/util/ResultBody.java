package com.jiki.myshop.util;

import com.jiki.myshop.exception.BaseErrorInfoInterface;
import com.jiki.myshop.exception.CommonEnum;



/**
 * 响应实体
 * @author k_802
 */

public class ResultBody {
    private String code;
    private String message;
    private Object result;

    public ResultBody() {
    }

    public ResultBody(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultBody(BaseErrorInfoInterface errorinfo) {
        this.code=errorinfo.getResultCode();
        this.message = errorinfo.getResultMsg();
    }

    /**
     * 数据请求成功
     * @return 封装的返回实体
     */
    public static ResultBody success() {
        return success(null);
    }

    /**
     * 数据请求成功
     * @param data 响应数据
     * @return 封装的返回实体
     */
    public static ResultBody success(Object data) {
        ResultBody resultBody = new ResultBody(CommonEnum.SUCCESS.getResultCode(),CommonEnum.SUCCESS.getResultMsg());
        resultBody.setResult(data);
        return resultBody;
    }

    /**
     * 数据请求失败
     * @param errorInfo 错误信息
     * @return 封装的返回实体
     */
    public static ResultBody error(BaseErrorInfoInterface errorInfo) {
        ResultBody resultBody = new ResultBody(errorInfo.getResultCode(),errorInfo.getResultMsg());
        resultBody.setResult(null);
        return resultBody;
    }

    /**
     * 请求失败
     * @param code 错误码
     * @param message 错误信息
     * @return 响应实体
     */
    public static ResultBody error(String code,String message) {
        ResultBody resultBody = new ResultBody(code,message);
        resultBody.setResult(null);
        return resultBody;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

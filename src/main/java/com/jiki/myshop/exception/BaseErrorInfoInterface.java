package com.jiki.myshop.exception;

/**
 * @author k_802
 */
public interface BaseErrorInfoInterface {
    /**
     * 获取错误码
     * @return 错误码
     */
    String getResultCode();

    /**
     * 获取信息
     * @return 信息
     */
    String getResultMsg();
}

package com.jiki.myshop.exception;


import com.jiki.myshop.util.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Set;

/**
 * 全局异常统一处理
 *
 * @author k_802
 */
@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBody exception(Exception e) {
        log.error(e.getMessage(),e.fillInStackTrace());
        return new ResultBody(CommonEnum.SERVER_BUSY);
    }

    /**
     * sdf
     * @param e 当使用@validated 进行单个字段参数校验失败对象
     * @return 校验结果
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultBody methodArgumentNotValidException(MethodArgumentNotValidException e) {
        String resultMsg = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ResultBody(CommonEnum.BODY_NOT_MATCH.getResultCode(), resultMsg);
    }

    /**
     * @param exception 当使用@validated 进行单个字段参数校验失败对象
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object exceptionHandler(ConstraintViolationException exception) {
        String resultMsg = "";
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        for (ConstraintViolation<?> violation : constraintViolations) {
            resultMsg = violation.getMessage();
        }

        return new ResultBody(CommonEnum.BODY_NOT_MATCH.getResultCode(), resultMsg);
    }

    /**
     * @param b 当使用@validated 进行对象参数校验失败对象
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultBody bindException(BindException b) {
        String resultMsg = b.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ResultBody(CommonEnum.BODY_NOT_MATCH.getResultCode(), resultMsg);
    }


}

package cn.dlj1.cms.exception;

import cn.dlj1.cms.response.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class WebExceptionHandle {

    private static final Log log = LogFactory.getLog(WebExceptionHandle.class);

    /**
     * 属性绑定异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result bindException(BindException exception) {
        return new Result.Fail(exception.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exception(Exception exception) {
        exception.printStackTrace();
        log.error(String.format("异常:[%s]", exception.getMessage()));
        return Result.FAIL;
    }
}

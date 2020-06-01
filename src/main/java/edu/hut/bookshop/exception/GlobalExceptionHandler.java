package edu.hut.bookshop.exception;

import edu.hut.bookshop.util.ResultCode;
import edu.hut.bookshop.util.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @Description: 全局异常处理
 * @Author: guozongchao
 * @Date: 2020/5/28 0:55
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 自定义异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(CustomizeException.class)
    public ResultVO customizeExceptionHandler(CustomizeException e){
        log.error(e.getMessage());
        return new ResultVO(e.getCode(),e.getMsg(),null);
    }

    /**
     * 参数校验异常处理和数据绑定异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    public ResultVO methodArgumentNotValidExceptionHandler(Exception e) {
        ResultVO resultVO = new ResultVO(ResultCode.ARGUMENT_NOT_VALID, null);
        if(e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException ex= (MethodArgumentNotValidException)e;
            BindingResult bindingResult = ex.getBindingResult();
            ObjectError error = bindingResult.getAllErrors().get(0);
            resultVO.setMsg(resultVO.getMsg()+"："+error.getDefaultMessage());
        }else {
            BindException ex=(BindException)e;
            BindingResult bindingResult = ex.getBindingResult();
            ObjectError error = bindingResult.getAllErrors().get(0);
            resultVO.setMsg(resultVO.getMsg()+"："+error.getDefaultMessage());
        }

        return resultVO;
    }


    /**
     * 其他异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultVO ExceptionHandler(Exception e){
        log.error(e.getMessage());
        return new ResultVO(ResultCode.UNKNOWN_ERROR,e.getMessage());
    }
}

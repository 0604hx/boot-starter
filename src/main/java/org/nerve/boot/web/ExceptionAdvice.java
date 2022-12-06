package org.nerve.boot.web;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.nerve.boot.Result;
import org.nerve.boot.web.auth.AuthHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
@Order(Integer.MIN_VALUE)
public class ExceptionAdvice {

    @Resource
    private AuthHolder holder;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @ExceptionHandler
    public Result handler(HttpServletRequest request, Exception e){
        logger.error("[异常]: "+ExceptionUtils.getMessage(e), e);

//        val trace           = Trace.of(request, holder.get())
//        trace.path          = request.servletPath
//        trace.ok            = false
//        trace.exception     = ExceptionUtils.getMessage(e)
//        traceService.log(trace)

        holder.clean();
        return Result.fail(e);
    }

    @ResponseBody
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result for404(HttpServletRequest request){
        logger.info("[404] {}", request.getServletPath());
        return Result.fail("404");
    }
}

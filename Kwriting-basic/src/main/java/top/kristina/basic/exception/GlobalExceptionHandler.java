package top.kristina.basic.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.kristina.core.common.vo.ResponseVO;
import top.kristina.core.exception.ApiException;
import top.kristina.core.exception.error.ErrorCode;
import javax.naming.AuthenticationException;


/**
 * 全局异常处理
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

//    /**
//     * 权限校验异常
//     */
//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseVO<?> handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request) {
//        log.error("请求地址'{}',权限校验失败'{}'", request.getRequestURI(), e.getMessage());
//        return ResponseVO.fail(new ApiException(ErrorCode.Business.PERMISSION_NOT_ALLOWED_TO_OPERATE));
//    }
//
//
//    /**
//     * 业务异常
//     */
    @ExceptionHandler(ApiException.class)
    public ResponseVO<?> handleServiceException(ApiException e) {
        log.error(e.getMessage(), e);
        log.error(e.getMessage(),e);
        log.error("用户名或密码错误");
        return ResponseVO.fail(e, e.getPayload());
    }
//
//    /**
//     * 捕获缓存类当中的错误
//     */
//
//
//    /**
//     * 拦截未知的运行时异常
//     */
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseVO<?> handleRuntimeException(RuntimeException e, HttpServletRequest request) {
//        String errorMsg = String.format("请求地址'%s',发生未知异常.", request.getRequestURI());
//        log.error(errorMsg, e);
//        return ResponseVO.fail(new ApiException(ErrorCode.Internal.INTERNAL_ERROR, e.getMessage()));
//    }
//
//    /**
//     * 系统异常
//     */
//    @ExceptionHandler(Exception.class)
//    public ResponseVO<?> handleException(Exception e, HttpServletRequest request) {
//        String errorMsg = String.format("请求地址'%s',发生未知异常.", request.getRequestURI());
//        log.error(errorMsg, e);
//        return ResponseVO.fail(new ApiException(ErrorCode.Internal.INTERNAL_ERROR, e.getMessage()));
//    }
//
//    /**
//     * 自定义验证异常
//     */
//    @ExceptionHandler(BindException.class)
//    public ResponseVO<?> handleBindException(BindException e) {
//        log.error(e.getMessage(), e);
//        String message = e.getAllErrors().get(0).getDefaultMessage();
//        return ResponseVO.fail(new ApiException(ErrorCode.Client.COMMON_REQUEST_PARAMETERS_INVALID, message));
//    }
//
//    /**
//     * 自定义验证异常
//     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseVO<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        log.error(e.getMessage(), e);
//        String message = e.getBindingResult().getFieldError().getDefaultMessage();
//        return ResponseVO.fail(new ApiException(ErrorCode.Client.COMMON_REQUEST_PARAMETERS_INVALID, message));
//    }

//    @ExceptionHandler(AuthenticationException.class)
//    public ResponseVO<?> handleAuthenticationException(AuthenticationException e) {
//        log.error(e.getMessage(), e);
//     return ResponseVO.fail(new ApiException(ErrorCode.Client.COMMON_REQUEST_PARAMETERS_INVALID, e.getMessage()));
//    }

    @ExceptionHandler(BadCredentialsException.class)
    public  ResponseVO<?> handleBadCredentialsException(BadCredentialsException e) {
        log.error(e.getMessage(),e);
        log.error("用户名或密码错误");
        return  ResponseVO.fail(new ApiException(ErrorCode.Business.USER_CACHE_IS_EXPIRE, e.getMessage()));
    }


}

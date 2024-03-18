package top.kristina.core.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import top.kristina.core.exception.ApiException;
import top.kristina.core.exception.error.ErrorCode;
import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVO<T> implements Serializable {

    private Integer code;

    private String msg;

    @JsonInclude
    private T data;

    public static <T> ResponseVO<T> ok() {
        return build(null, ErrorCode.SUCCESS.code(), ErrorCode.SUCCESS.message());
    }

    public static <T> ResponseVO<T> ok(T data) {
        return build(data, ErrorCode.SUCCESS.code(), ErrorCode.SUCCESS.message());
    }

    public static <T> ResponseVO<T> fail() {
        return build(null, ErrorCode.FAILED.code(), ErrorCode.FAILED.message());
    }

    public static <T> ResponseVO<T> fail(T data) {
        return build(data, ErrorCode.FAILED.code(), ErrorCode.FAILED.message());
    }

    public static <T> ResponseVO<T> fail(ApiException exception) {
        return build(null, exception.getErrorCode().code(), exception.getMessage());
    }

    public static <T> ResponseVO<T> fail(ApiException exception, T data) {
        return build(data, exception.getErrorCode().code(), exception.getMessage());
    }

    public static <T> ResponseVO<T> build(T data, Integer code, String msg) {
        return new ResponseVO<>(code, msg, data);
    }

}

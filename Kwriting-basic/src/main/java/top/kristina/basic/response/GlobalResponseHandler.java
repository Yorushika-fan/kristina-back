package top.kristina.basic.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import top.kristina.core.common.vo.ResponseVO;

@RestControllerAdvice
@Slf4j
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return !returnType.getDeclaringClass().getName().contains("OpenApi");
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 判断body是否为ResponseVO类型

        if (body instanceof String){
            log.info("返回值类型为String");
            try {
                return  objectMapper.writeValueAsString(ResponseVO.ok(body));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        if (body instanceof ResponseVO) {
            return body;
        }
        return   ResponseVO.ok(body);
    }

}

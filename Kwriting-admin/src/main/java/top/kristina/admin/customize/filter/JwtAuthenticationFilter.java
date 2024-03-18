package top.kristina.admin.customize.filter;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.jwt.JWTPayload;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import top.kristina.basic.cache.redis.RedisUtil;
import top.kristina.core.constant.CommonConstant;
import top.kristina.core.exception.ApiException;
import top.kristina.core.exception.error.ErrorCode;
import top.kristina.core.utils.Jwt.JwtUtil;
import top.kristina.service.admin.system.model.entity.SysUser;
import top.kristina.service.admin.system.model.vo.UserInfo;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Resource
    private RedisUtil redisUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //验证 Token
        String token = request.getHeader(CommonConstant.JWT_HEADER);
        if (Objects.isNull(token)){
            log.info("请求头中没有token");
            doFilter(request,response,filterChain);
            return;
        }

        if (!JwtUtil.verifyToken(token)){
            log.info("token不合法");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("token不合法");
            return;
        }

        String userId = JwtUtil.parseToken(token).getPayload(CommonConstant.JWT_PLAYLOAD_USER_KEY).toString();
        UserInfo loginVo = redisUtil.getCacheObject(CommonConstant.CACHE_USER_INFO + userId);

        //登录过期
        if (JwtUtil.isExpire(token)){
            log.info("登录过期");
            throw  new ApiException
                    (ErrorCode.Business.USER_CACHE_IS_EXPIRE);
        }

        SysUser user = BeanUtil.copyProperties(loginVo, SysUser.class);
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

            doFilter(request,response,filterChain);

    }
}

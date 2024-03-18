package top.kristina.service.admin.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kristina.basic.cache.redis.RedisUtil;
import top.kristina.core.constant.CommonConstant;
import top.kristina.core.utils.Jwt.JwtUtil;
import top.kristina.service.admin.system.mapper.SysUserMapper;
import top.kristina.service.admin.system.model.dto.UserParams;
import top.kristina.service.admin.system.model.entity.Role;
import top.kristina.service.admin.system.model.entity.SysUser;
import top.kristina.service.admin.system.model.vo.LoginVO;
import top.kristina.service.admin.system.model.vo.TokenVO;
import top.kristina.service.admin.system.model.vo.UserInfo;
import top.kristina.service.admin.system.service.SysUserService;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static top.kristina.core.constant.CommonConstant.CACHE_USER_EXPIRE;


@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService{


    @Resource
    private RedisUtil redisUtil;
    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public LoginVO login(UserParams userParams) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userParams.getUsername(), userParams.getPassword());
        Authentication authenticate =authenticationManager.authenticate(authenticationToken);

        //认证
        if (!authenticate.isAuthenticated()){
            log.error("用户名或密码错误");
            throw new BadCredentialsException("用户名或密码错误");
        }


        //授权
        SysUser user= (SysUser)authenticate.getPrincipal();
        UserInfo userInfo = BeanUtil.copyProperties(user, UserInfo.class);
        List<String> roleList = user.getRoles().stream().map(Role::getRoleName).toList();

        //缓存登录信息
        redisUtil.setCacheObject(CommonConstant.CACHE_USER_INFO+user.getId(),userInfo,CACHE_USER_EXPIRE, TimeUnit.MINUTES);


        return new LoginVO()
                .setUsername(user.getUsername())
                .setRoles(roleList)
                .setAccessToken(JwtUtil.createToken(user.getId().toString()))
                .setRefreshToken(JwtUtil.createRefreshToken(user.getId().toString()))
                .setExpires(DateTime.now().offsetNew(DateField.MINUTE, CommonConstant.JWT_TOKEN_EXPIRE_TIME ));
    }

    @Override
    public TokenVO refreshToken(String refreshToken) {

        log.error(JwtUtil.parseToken(refreshToken).toString());
        if (!JwtUtil.verifyToken(refreshToken)){
            throw  new BadCredentialsException("refreshToken无效");
        }

        if (JwtUtil.isExpire(refreshToken)){
            throw new BadCredentialsException("登录过期");
        }
        String userId = String.valueOf(JwtUtil.getUserId(refreshToken));


        UserInfo userInfo = redisUtil.getCacheObject(CommonConstant.CACHE_USER_INFO + userId);

        if(Objects.isNull(userInfo)){
            SysUser user = this.getById(userId);
             userInfo = BeanUtil.copyProperties(user, UserInfo.class);
            redisUtil.setCacheObject(CommonConstant.CACHE_USER_INFO+userId,userInfo,CACHE_USER_EXPIRE, TimeUnit.MINUTES);
        }else {
            redisUtil.expire(CommonConstant.CACHE_USER_INFO + userId, CommonConstant.CACHE_USER_EXPIRE, TimeUnit.MINUTES);
        }

        return new TokenVO()
                .setAccessToken(JwtUtil.createToken(userId))
                .setRefreshToken(JwtUtil.createRefreshToken(userId))
                .setExpires(DateTime.now().offsetNew(DateField.MINUTE, CommonConstant.JWT_TOKEN_EXPIRE_TIME - 2));
    }
}


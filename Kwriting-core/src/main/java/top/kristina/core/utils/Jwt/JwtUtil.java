package top.kristina.core.utils.Jwt;


import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import top.kristina.core.constant.CommonConstant;

import java.util.Date;
import java.util.HashMap;

@Slf4j
public class JwtUtil {

    public static String createToken(String username,Integer expire){
        DateTime now = DateTime.now();
        HashMap<String, Object> payload = new HashMap<>();
        payload.put(JWTPayload.ISSUED_AT, DateTime.now());
        payload.put(JWTPayload.EXPIRES_AT, now.offsetNew(DateField.MINUTE, expire));
        payload.put(JWTPayload.NOT_BEFORE, now);
        payload.put(CommonConstant.JWT_PLAYLOAD_USER_KEY,username);
        return JWTUtil.createToken(payload, CommonConstant.JWT_KEY.getBytes());
    }
    public static String createToken(String username){
        return createToken(username,CommonConstant.JWT_TOKEN_EXPIRE_TIME);
    }

    public  static  boolean verifyToken(String token){
        return JWTUtil.verify(token, CommonConstant.JWT_KEY.getBytes());
    }


    public static JWT parseToken(String token){
        return JWTUtil.parseToken(token);
    }

    public static String createRefreshToken(String username){
        return  createToken(username,CommonConstant.JWT_REFRESH_TOKEN_EXPIRE_TIME);
    }

    public static boolean isExpire(String token){

        JWT jwt = parseToken(token);
        long expireTime  = Long.parseLong(jwt.getPayload(JWTPayload.EXPIRES_AT).toString());
        long currentTime =  new Date().getTime() / 1000;


        return expireTime - currentTime < 0;
    }

    public static long getUserId(String token){
        return Long.parseLong(parseToken(token).getPayload(CommonConstant.JWT_PLAYLOAD_USER_KEY).toString());
    }


}

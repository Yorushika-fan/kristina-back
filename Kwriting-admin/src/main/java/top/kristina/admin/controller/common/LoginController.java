package top.kristina.admin.controller.common;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import top.kristina.service.admin.system.model.dto.RefreshDTO;
import top.kristina.service.admin.system.model.vo.LoginVO;
import top.kristina.service.admin.system.model.vo.TokenVO;
import top.kristina.service.admin.system.service.SysUserService;
import top.kristina.service.admin.system.model.dto.UserParams;


/**
 * 登录接口
 */
@RestController
@Slf4j
@Tag(name = "登录相关接口")
public class LoginController {
    @Resource
    private SysUserService userService;


    /**
     * 登录接口
     * @param userParams
     * @return
     */
    @Operation(description = "登录")
    @PostMapping("/login")
    public LoginVO doLogin(@RequestBody UserParams userParams) {
        return  userService.login(userParams);
    }

    @Operation(description = "刷新token")
    @PostMapping("/refresh")
    public TokenVO refreshToken(@RequestBody RefreshDTO params) {

        return userService.refreshToken(params.getRefreshToken());
    }
//    @GetMapping("/oauth/notify")
//    public String gitee(@RequestParam("code") String code) {
//        // 获取token
//        Map<String ,Object> map = new HashMap<>();
//        map.put("grant_type","authorization_code");
//        map.put("code",code);
//        map.put("client_id","b50165d539175170f628b40f2eeee8fcbbef0541bbd749ffe0deab59ef569375");
//        map.put("redirect_uri","http://localhost8989/oauth/notify");
//        map.put("client_secret","cde5d1a9bffb21d714bb60901f24ce5258c3f71f748e6b0de9d57f0a15f8c22d");
//        // https://gitee.com/oauth/token?grant_type=authorization_code&code={code}&client_id={client_id}&redirect_uri={redirect_uri}&client_secret={client_secret}
//        // 通过code获取access_token
//        String post = HttpUtil.post("https://gitee.com/oauth/token", map);
//        System.out.println("post==========>" + post);
//        // 根据access token获取用户信息，调用openApi
//        GiteeBody giteeBody = JSONUtil.toBean(post, GiteeBody.class);
//        System.out.println("giteeBody=-====>" + giteeBody.getAccessToken());
//        String userInfo = HttpUtil.get("https://gitee.com/api/v5/user?access_token=" + giteeBody.getAccessToken());
//        String name = (String)JSONUtil.parseObj(userInfo).get("name");
//        System.out.println("用户名===》" + name);
//        return name;
//    }

}

package top.kristina.service.admin.system.model.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;


@Data
@Schema(description = "登录返回数据")
@Accessors(chain = true)
public class LoginVO {
    @Schema(description = "token")
    private  String accessToken;
    @Schema(description = "刷新token")
    private String refreshToken;
    @Schema(description = "用户名")
    private   String username;
    @Schema(description = "角色")
    private List<String> roles;
    @Schema(description = "过期时间")
    private Date expires;
}

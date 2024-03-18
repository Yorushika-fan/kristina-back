package top.kristina.service.admin.system.model.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户参数")
public class UserParams {

    @Schema(description = "用户名")
    private  String username;
    @Schema(description = "密码")
    private  String password;
    @Schema(description = "验证码")
    private  String code;
}

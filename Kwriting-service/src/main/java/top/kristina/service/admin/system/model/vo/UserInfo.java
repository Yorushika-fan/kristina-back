package top.kristina.service.admin.system.model.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.kristina.service.admin.system.model.entity.Role;

import java.util.Set;

@Data
@Schema(description = "登录")
public class UserInfo {

    @Schema(description = "用户ID")
    private Long id;
    @Schema(description = "用户名")
    private  String username;
    @Schema(description = "邮箱")
    private String email;
    @Schema(description = "角色")
    private Set<Role>  roles;
    @Schema(description = "权限")
    private Set<String> perms;
}

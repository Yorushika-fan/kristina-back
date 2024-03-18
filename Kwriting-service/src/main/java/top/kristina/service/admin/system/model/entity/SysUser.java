package top.kristina.service.admin.system.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 后台用户表
 */
@Schema(description="后台用户表")
@Data
@TableName(value = "ums_sys_user")
public class SysUser implements Serializable, UserDetails {
    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    @Schema(description="用户ID")
    @NotNull(message = "用户ID不能为null")
    private Long id;

    /**
     * 用户账号
     */
    @TableField(value = "username")
    @Schema(description="用户账号")
    @Size(max = 30,message = "用户账号最大长度要小于 30")
    @NotBlank(message = "用户账号不能为空")
    private String username;

    /**
     * 用户昵称
     */
    @TableField(value = "nickname")
    @Schema(description="用户昵称")
    @Size(max = 30,message = "用户昵称最大长度要小于 30")
    @NotBlank(message = "用户昵称不能为空")
    private String nickname;

    /**
     * 用户邮箱
     */
    @TableField(value = "email")
    @Schema(description="用户邮箱")
    @Size(max = 50,message = "用户邮箱最大长度要小于 50")
    private String email;

    /**
     * 手机号码
     */
    @TableField(value = "mobile")
    @Schema(description="手机号码")
    @Size(max = 11,message = "手机号码最大长度要小于 11")
    private String mobile;

    /**
     * 用户性别（0男 1女 2未知）
     */
    @TableField(value = "gender")
    @Schema(description="用户性别（0男 1女 2未知）")
    private Integer gender;

    /**
     * 头像地址
     */
    @TableField(value = "avatar")
    @Schema(description="头像地址")
    @Size(max = 100,message = "头像地址最大长度要小于 100")
    private String avatar;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    @Schema(description="密码")
    @Size(max = 100,message = "密码最大长度要小于 100")
    private String password;

    /**
     * 帐号状态（0正常 1停用）
     */
    @TableField(value = "`status`")
    @Schema(description="帐号状态（0正常 1停用）")
    private Integer status;

    /**
     * 创建者
     */
    @TableField(value = "creator")
    @Schema(description="创建者")
    private Long creator;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @Schema(description="创建时间")
    private Date createTime;

    /**
     * 更新者
     */
    @TableField(value = "updater")
    @Schema(description="更新者")
    private Long updater;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @Schema(description="更新时间")
    private Date updateTime;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @Schema(description="备注")
    @Size(max = 500,message = "备注最大长度要小于 500")
    private String remark;

    @TableField(value = "deleted")
    @Schema(description="")
    @TableLogic
    private Byte deleted;

    @TableField(exist = false)
    @Schema(description="角色信息")
    private Set<Role> roles = new HashSet<>();

    @TableField(exist = false)
    @Schema(description="权限信息")
    private Set<String> perms = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(Objects.nonNull(perms) && !perms.isEmpty()) {
            // 返回权限信息
            return perms.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
        }
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public String getPassword() {
        return password;
    }
}
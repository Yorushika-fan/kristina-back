package top.kristina.service.admin.system.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Schema
@Data
@TableName(value = "ums_role")
public class Role {
    /**
     * 角色id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @Schema(description="角色id")
    @NotNull(message = "角色id不能为null")
    private Long id;

    /**
     * 角色标识
     */
    @TableField(value = "role_label")
    @Schema(description="角色标识")
    @Size(max = 255,message = "角色标识最大长度要小于 255")
    private String roleLabel;

    /**
     * 角色名字
     */
    @TableField(value = "role_name")
    @Schema(description="角色名字")
    @Size(max = 255,message = "角色名字最大长度要小于 255")
    private String roleName;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @Schema(description="排序")
    private Integer sort;

    /**
     * 状态：0：可用，1：不可用
     */
    @TableField(value = "`status`")
    @Schema(description="状态：0：可用，1：不可用")
    private Integer status;

    /**
     * 是否删除：0: 未删除，1：已删除
     */
    @TableField(value = "deleted")
    @Schema(description="是否删除：0: 未删除，1：已删除")
    @TableLogic
    private Integer deleted;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @Schema(description="备注")
    @Size(max = 255,message = "备注最大长度要小于 255")
    private String remark;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @Schema(description="创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    @Schema(description="修改时间")
    private Date updateTime;
}
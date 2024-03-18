package top.kristina.service.admin.system.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Schema
@Data
@TableName(value = "ums_menu")
public class Menu {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @Schema(description="主键")
    @NotNull(message = "主键不能为null")
    private Long id;

    /**
     * 父id
     */
    @TableField(value = "parent_id")
    @Schema(description="父id")
    @NotNull(message = "父id不能为null")
    private Long parentId;

    /**
     * 菜单名
     */
    @TableField(value = "menu_name")
    @Schema(description="菜单名")
    @Size(max = 255,message = "菜单名最大长度要小于 255")
    private String menuName;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @Schema(description="排序")
    private Integer sort;

    /**
     * 类型：0，目录，1菜单，2：按钮
     */
    @TableField(value = "menu_type")
    @Schema(description="类型：0，目录，1菜单，2：按钮")
    private Integer menuType;

    /**
     * 权限标识
     */
    @TableField(value = "perms")
    @Schema(description="权限标识")
    @Size(max = 255,message = "权限标识最大长度要小于 255")
    private String perms;

    /**
     * 图标
     */
    @TableField(value = "icon")
    @Schema(description="图标")
    @Size(max = 255,message = "图标最大长度要小于 255")
    private String icon;

    /**
     * 是否删除
     */
    @TableField(value = "deleted")
    @Schema(description="是否删除")
    private Integer deleted;

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
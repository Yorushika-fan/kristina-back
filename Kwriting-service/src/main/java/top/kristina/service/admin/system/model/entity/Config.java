package top.kristina.service.admin.system.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Schema
@Data
@TableName(value = "blog_config")
public class Config {
    /**
     * 配置信息主键id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @Schema(description="配置信息主键id")
    @NotNull(message = "配置信息主键id不能为null")
    private Long id;

    /**
     * 配置项名称
     */
    @TableField(value = "`name`")
    @Schema(description="配置项名称")
    @Size(max = 128,message = "配置项名称最大长度要小于 128")
    @NotBlank(message = "配置项名称不能为空")
    private String name;

    /**
     * 配置项信息
     */
    @TableField(value = "`value`")
    @Schema(description="配置项信息")
    @Size(max = 1000,message = "配置项信息最大长度要小于 1000")
    @NotBlank(message = "配置项信息不能为空")
    private String value;

    /**
     * 逻辑删除 ,0不删除，1删除
     */
    @TableField(value = "deleted")
    @Schema(description="逻辑删除 ,0不删除，1删除")
    @NotNull(message = "逻辑删除 ,0不删除，1删除不能为null")
    private Byte deleted;

    /**
     * 创建者
     */
    @TableField(value = "create_by")
    @Schema(description="创建者")
    @Size(max = 64,message = "创建者最大长度要小于 64")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @Schema(description="创建时间")
    private Date createTime;

    /**
     * 更新者
     */
    @TableField(value = "update_by")
    @Schema(description="更新者")
    @Size(max = 64,message = "更新者最大长度要小于 64")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @Schema(description="更新时间")
    private Date updateTime;
}
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
@TableName(value = "blog_link")
public class Link {
    /**
     * 友链主键id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @Schema(description="友链主键id")
    @NotNull(message = "友链主键id不能为null")
    private Long id;

    /**
     * 友链名称
     */
    @TableField(value = "`name`")
    @Schema(description="友链名称")
    @Size(max = 128,message = "友链名称最大长度要小于 128")
    @NotBlank(message = "友链名称不能为空")
    private String name;

    /**
     * 友链地址
     */
    @TableField(value = "address_url")
    @Schema(description="友链地址")
    @Size(max = 128,message = "友链地址最大长度要小于 128")
    @NotBlank(message = "友链地址不能为空")
    private String addressUrl;

    /**
     * 友链头像
     */
    @TableField(value = "logo_url")
    @Schema(description="友链头像")
    @Size(max = 128,message = "友链头像最大长度要小于 128")
    @NotBlank(message = "友链头像不能为空")
    private String logoUrl;

    /**
     * 友链描述
     */
    @TableField(value = "description")
    @Schema(description="友链描述")
    @Size(max = 200,message = "友链描述最大长度要小于 200")
    @NotBlank(message = "友链描述不能为空")
    private String description;

    /**
     * 友链状态,0 审核中，1审核通过，2审核失败
     */
    @TableField(value = "`status`")
    @Schema(description="友链状态,0 审核中，1审核通过，2审核失败")
    @NotNull(message = "友链状态,0 审核中，1审核通过，2审核失败不能为null")
    private Byte status;

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
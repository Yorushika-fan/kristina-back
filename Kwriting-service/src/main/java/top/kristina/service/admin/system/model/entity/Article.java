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
@TableName(value = "blog_article")
public class Article {
    /**
     * 文章id(主键)
     */
    @TableId(value = "id", type = IdType.INPUT)
    @Schema(description="文章id(主键)")
    @NotNull(message = "文章id(主键)不能为null")
    private Long id;

    /**
     * 文章标题
     */
    @TableField(value = "title")
    @Schema(description="文章标题")
    @Size(max = 128,message = "文章标题最大长度要小于 128")
    @NotBlank(message = "文章标题不能为空")
    private String title;

    /**
     * 文章自定义路径
     */
    @TableField(value = "url")
    @Schema(description="文章自定义路径")
    @Size(max = 128,message = "文章自定义路径最大长度要小于 128")
    @NotBlank(message = "文章自定义路径不能为空")
    private String url;

    /**
     * 文章封面
     */
    @TableField(value = "cover_pic")
    @Schema(description="文章封面")
    @Size(max = 200,message = "文章封面最大长度要小于 200")
    @NotBlank(message = "文章封面不能为空")
    private String coverPic;

    /**
     * 文章内容
     */
    @TableField(value = "content")
    @Schema(description="文章内容")
    @NotBlank(message = "文章内容不能为空")
    private String content;

    /**
     * 文章分类 -1 默认分类
     */
    @TableField(value = "category_id")
    @Schema(description="文章分类 -1 默认分类")
    @NotNull(message = "文章分类 -1 默认分类不能为null")
    private Integer categoryId;

    /**
     * 分类名称
     */
    @TableField(value = "category_name")
    @Schema(description="分类名称")
    @Size(max = 128,message = "分类名称最大长度要小于 128")
    @NotBlank(message = "分类名称不能为空")
    private String categoryName;

    /**
     * 文章状态,1草稿,2已发布,3回收箱
     */
    @TableField(value = "`status`")
    @Schema(description="文章状态,1草稿,2已发布,3回收箱")
    @NotNull(message = "文章状态,1草稿,2已发布,3回收箱不能为null")
    private Byte status;

    /**
     * 逻辑删除 ,0不删除，1删除
     */
    @TableField(value = "deleted")
    @Schema(description="逻辑删除 ,0不删除，1删除")
    @NotNull(message = "逻辑删除 ,0不删除，1删除不能为null")
    private Byte deleted;

    /**
     * 文章阅读量
     */
    @TableField(value = "article_views")
    @Schema(description="文章阅读量")
    @NotNull(message = "文章阅读量不能为null")
    private Long articleViews;

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
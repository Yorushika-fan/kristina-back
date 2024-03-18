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
@TableName(value = "blog_comment")
public class Comment {
    /**
     * 评论主键id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @Schema(description="评论主键id")
    @NotNull(message = "评论主键id不能为null")
    private Long id;

    /**
     * 文章id
     */
    @TableField(value = "article_id")
    @Schema(description="文章id")
    @NotNull(message = "文章id不能为null")
    private Long articleId;

    /**
     * 评论类型 1文章评论，关于我页面评论
     */
    @TableField(value = "`type`")
    @Schema(description="评论类型 1文章评论，关于我页面评论")
    @NotNull(message = "评论类型 1文章评论，关于我页面评论不能为null")
    private Byte type;

    /**
     * 根评论id
     */
    @TableField(value = "root_comment_id")
    @Schema(description="根评论id")
    private Long rootCommentId;

    /**
     * 回复目标的评论id
     */
    @TableField(value = "to_comment_id")
    @Schema(description="回复目标的评论id")
    private Long toCommentId;

    /**
     * 评论内容
     */
    @TableField(value = "content")
    @Schema(description="评论内容")
    @Size(max = 1000,message = "评论内容最大长度要小于 1000")
    @NotBlank(message = "评论内容不能为空")
    private String content;

    /**
     * 点赞数
     */
    @TableField(value = "like_count")
    @Schema(description="点赞数")
    @NotNull(message = "点赞数不能为null")
    private Integer likeCount;

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
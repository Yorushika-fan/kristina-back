package top.kristina.service.admin.system.model.vo;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 文章视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Schema(name = "ArticleVo",description = "文章返回格式")
public class ArticleVO {

    @Schema(name = "文章id")
    private Long id;
    @Schema(name = "文章标题")
    private String title;
    @Schema(name = "文章短链接")
    private String url;
    @Schema(name = "文章内容")
    private String content;
    @Schema(name = "类别id")
    private Integer categoryId;
    @Schema(name = "类别名称")
    private String categoryName;
    @Schema(name = "标签")
    private List<TagVO> tags;
    @Schema(name = "创建时间")
    private LocalDateTime updateTime;
    @Schema(name = "浏览量")
    private Long articleViews;
    @Schema(name = "状态")
    private Integer status;


}


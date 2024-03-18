package top.kristina.service.admin.system.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "CategoryVo",description = "分类返回格式")
public class CategoryVO {

    @Schema(description = "分类id")
    private Long id;
    @Schema(description = "分类名称")
    private String name;

    @Schema(description = "创建人")
    private  String createBy;

    @Schema(description = "创建时间")
    private Date createTime;

}
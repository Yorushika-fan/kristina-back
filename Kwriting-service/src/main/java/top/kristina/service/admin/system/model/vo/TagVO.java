package top.kristina.service.admin.system.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Schema(name = "TagVo", description = "标签返回格式")
public class TagVO {

    @Schema(name = "id",description = "标签id")
    private Long id;

    @Schema(name = "name",description = "标签名称")
    private  String name;

    @Schema(description = "创建人")
    private String createBy;

    @Schema(description = "创建时间")
    private Date  createTime;
}

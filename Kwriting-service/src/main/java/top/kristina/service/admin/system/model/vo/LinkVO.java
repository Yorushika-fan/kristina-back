package top.kristina.service.admin.system.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *  友链视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Schema(name = "LinkVo", description = "友链返回格式")
public class LinkVO {

    @Schema(name="友链id")
    private Long id;
    @Schema(name="友链名称")
    private String name;
    @Schema(name="友链地址")
    private String addressUrl;
    @Schema(name =  "头像地址")
    private String logoUrl;
    @Schema(name = "描述")
    private String description;
    @Schema(name = "状态")
    private Integer status;
    @Schema(name = "创建人")
    private String createBy;
    @Schema(name = "创建时间")
    private Date createTime;
}
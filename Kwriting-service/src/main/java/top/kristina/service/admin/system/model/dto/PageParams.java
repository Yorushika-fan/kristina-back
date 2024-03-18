package top.kristina.service.admin.system.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "分页参数", description = "分页参数")
public class PageParams {

    @Schema(description = "每页数量")
    @NotNull(message = "每页数量不能为空")
    @Min(value = 1, message = "每页数量不能小于1")
    @Max(value = 100, message = "每页数量不能大于100")
    private Integer pageSize;

    @Min(value = 1, message = "当前页码不能小于1")
    @NotNull(message = "当前页码不能为空")
    @Schema(description = "当前页码")
    private Integer pageNum;
}
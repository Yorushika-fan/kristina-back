package top.kristina.service.admin.system.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Tag(name="分类参数")
public class CategoryParams {

    @Schema(name = "分类id")
    @NotNull(message = "分类id不能为空")
    private Long id;

    @NotNull(message = "分类名称不能为空")
    @NotEmpty(message =  "分类名称不能为空")
    @Schema(name = "分类名称")
    private String name;
}

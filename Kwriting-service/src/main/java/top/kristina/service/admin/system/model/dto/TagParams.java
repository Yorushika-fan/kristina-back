package top.kristina.service.admin.system.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Tag(name = "标签参数", description = "标签参数")
public class TagParams {

    @NotNull(message = "不能添加空标签")
    @NotBlank(message = "不能添加空标签")
    @Schema(name = "标签名称", description = "标签名称")
    private String name;
}

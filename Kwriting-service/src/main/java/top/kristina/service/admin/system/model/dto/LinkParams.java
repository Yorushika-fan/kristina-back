package top.kristina.service.admin.system.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Schema(name = "友链参数", description = "友链参数")
public class LinkParams {

    @Schema(name="友链名称")
    @NotNull(message = "友链名称不能为空")
    @NotBlank(message = "友链名称不能为空")
    private String name;

    @Schema(name="友链地址")

    @Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", message = "友链地址格式不正确")
    private String addressUrl;

    @Schema(name =  "头像地址")
    @Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", message = "头像地址格式不正确")
    private String logoUrl;

    @Schema(name = "描述")
    private String description;

}

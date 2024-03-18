package top.kristina.service.admin.system.model.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "刷新缓存")
public class RefreshDTO {
    private String refreshToken;
}

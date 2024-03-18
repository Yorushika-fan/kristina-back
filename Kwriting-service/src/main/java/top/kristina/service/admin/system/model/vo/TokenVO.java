package top.kristina.service.admin.system.model.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@Schema(description = "刷新 Token信息")
public class TokenVO {
    private  String accessToken;
    private  String refreshToken;
    private Date expires;
}

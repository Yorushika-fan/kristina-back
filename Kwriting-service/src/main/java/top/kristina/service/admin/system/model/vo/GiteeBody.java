package top.kristina.service.admin.system.model.vo;

import lombok.Data;

@Data
public class GiteeBody {

    private String accessToken;
    private String tokenType;
    private String refreshToken;
}

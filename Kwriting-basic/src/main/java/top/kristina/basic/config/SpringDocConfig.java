package top.kristina.basic.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI kristinaBootApi() {
        return new OpenAPI()
                .info(new Info().title("Kwriting后台管理系统")
                        .description("Kwriting API 演示")
                        .version("v1.8.0")
                        .license(new License().name("MIT 3.0").url("https://github.com/valarchie/AgileBoot-Back-End")))
                .externalDocs(new ExternalDocumentation()
                        .description("Kwriting后台管理系统接口文档")
                        .url("https://juejin.cn/column/7159946528827080734"));
    }

}
package top.kristina.admin;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = "top.kristina")
@MapperScan("top.kristina.service.admin.system.mapper")
public class adminApplication {
    public static void main(String[] args) {

        SpringApplication.run(adminApplication.class, args);
    }
}
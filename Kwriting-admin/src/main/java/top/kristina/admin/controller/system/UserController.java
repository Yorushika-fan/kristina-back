package top.kristina.admin.controller.system;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统用户接口
 */
@RestController
@RequestMapping("/user")
@Tag(name = "系统用户", description = "系统用户相关接口")
public class UserController {

    @GetMapping
    public String user(){
        return  "user";
    }
}

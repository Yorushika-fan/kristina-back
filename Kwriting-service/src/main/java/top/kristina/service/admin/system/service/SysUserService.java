package top.kristina.service.admin.system.service;

import top.kristina.service.admin.system.model.dto.UserParams;
import top.kristina.service.admin.system.model.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import top.kristina.service.admin.system.model.vo.LoginVO;
import top.kristina.service.admin.system.model.vo.TokenVO;

public interface SysUserService extends IService<SysUser>{

    LoginVO login(UserParams userParams);

    TokenVO refreshToken(String refreshToken);
}

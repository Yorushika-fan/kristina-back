package top.kristina.service.admin.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.kristina.service.admin.system.model.entity.Role;
import top.kristina.service.admin.system.model.entity.SysUser;

import java.util.List;

public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectUserByUsername(@Param("username") String username);
}
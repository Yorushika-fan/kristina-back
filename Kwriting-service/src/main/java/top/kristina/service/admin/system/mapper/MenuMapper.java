package top.kristina.service.admin.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.kristina.service.admin.system.model.entity.Menu;

import java.util.Set;

public interface MenuMapper extends BaseMapper<Menu> {
    Set<Menu> selectMenuByRoleId(@Param("roleIds") Set<Long> roleIds);
}
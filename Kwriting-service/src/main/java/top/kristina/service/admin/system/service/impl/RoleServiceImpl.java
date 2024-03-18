package top.kristina.service.admin.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kristina.service.admin.system.mapper.RoleMapper;
import top.kristina.service.admin.system.model.entity.Role;
import top.kristina.service.admin.system.service.RoleService;
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService{

}

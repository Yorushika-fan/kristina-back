package top.kristina.service.admin.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.kristina.service.admin.system.mapper.MenuMapper;
import top.kristina.service.admin.system.mapper.SysUserMapper;
import top.kristina.service.admin.system.model.entity.Menu;
import top.kristina.service.admin.system.model.entity.Role;
import top.kristina.service.admin.system.model.entity.SysUser;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserMapper userMapper;

    @Resource
    private MenuMapper menuMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userMapper.selectUserByUsername(username);

        // 查询用户角色和权限
        if(Objects.nonNull(user)) {

            Set<Role> roles =  user.getRoles();
            Set<String> perms = user.getPerms();

            Set<Long> roleIds = new HashSet<>(roles.size());
            roles.forEach(role -> roleIds.add(role.getId()));

            menuMapper.selectMenuByRoleId(roleIds).
                    forEach(menu -> perms.add(menu.getPerms()));
        }

        return  user;
    }
}

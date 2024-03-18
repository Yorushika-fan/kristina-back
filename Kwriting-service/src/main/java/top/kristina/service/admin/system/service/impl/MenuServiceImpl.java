package top.kristina.service.admin.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kristina.service.admin.system.mapper.MenuMapper;
import top.kristina.service.admin.system.model.entity.Menu;
import top.kristina.service.admin.system.service.MenuService;
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService{

}

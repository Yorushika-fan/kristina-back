package top.kristina.service.admin.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kristina.service.admin.system.mapper.ConfigMapper;
import top.kristina.service.admin.system.model.entity.Config;
import top.kristina.service.admin.system.service.ConfigService;
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService{

}

package top.kristina.service.admin.system.service;

import top.kristina.service.admin.system.model.dto.LinkParams;
import top.kristina.service.admin.system.model.dto.PageParams;
import top.kristina.service.admin.system.model.entity.Link;
import com.baomidou.mybatisplus.extension.service.IService;
import top.kristina.service.admin.system.model.vo.LinkVO;
import top.kristina.service.admin.system.model.vo.PageVO;

import java.util.List;

public interface LinkService extends IService<Link>{
    PageVO<LinkVO> getLinkByPage(PageParams params);

    LinkVO getLinkDetails(Long id);

    void addLink(LinkParams params);

    void deleteLink(List<Long> ids);

}

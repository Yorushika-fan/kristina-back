package top.kristina.service.admin.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kristina.service.admin.system.mapper.LinkMapper;
import top.kristina.service.admin.system.model.dto.LinkParams;
import top.kristina.service.admin.system.model.dto.PageParams;
import top.kristina.service.admin.system.model.entity.Link;
import top.kristina.service.admin.system.model.vo.LinkVO;
import top.kristina.service.admin.system.model.vo.PageVO;
import top.kristina.service.admin.system.service.LinkService;
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService{

    @Override
    public PageVO<LinkVO> getLinkByPage(PageParams params) {
        Page<Link> page = new Page(params.getPageNum(), params.getPageSize());
        page = this.page(page);
        long total = page.getTotal();
        List<Link> links = page.getRecords();

        return new PageVO<LinkVO>()
                .setRows(BeanUtil.copyToList(links, LinkVO.class))
                .setTotal(total);
    }

    @Override
    public LinkVO getLinkDetails(Long id) {

        return BeanUtil.copyProperties(this.getById(id), LinkVO.class);
    }


    @Override
    public void addLink(LinkParams params) {
        this.save(BeanUtil.copyProperties(params, Link.class));
    }

    @Override
    public void deleteLink(List<Long> ids) {
        this.removeByIds(ids);
    }
}



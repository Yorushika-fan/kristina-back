package top.kristina.service.admin.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kristina.service.admin.system.model.dto.PageParams;
import top.kristina.service.admin.system.model.dto.TagParams;
import top.kristina.service.admin.system.model.entity.Tag;
import top.kristina.service.admin.system.mapper.TagMapper;
import top.kristina.service.admin.system.model.vo.PageVO;
import top.kristina.service.admin.system.model.vo.TagVO;
import top.kristina.service.admin.system.service.TagService;
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService{


    @Override
    public PageVO<TagVO> getTags(PageParams params) {
        IPage<Tag> page = new Page<>(params.getPageNum(), params.getPageSize());
        page = this.page(page);
        long total = page.getTotal();
        List<Tag> tags = page.getRecords();
        return new PageVO<TagVO>().setTotal(total).setRows(BeanUtil.copyToList(tags, TagVO.class));
    }

    @Override
    public void addTag(TagParams  params) {

        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Tag::getName, params.getName());
        Tag tag = this.getOne(queryWrapper);
        //查询是否已经存在
        if (Objects.nonNull(tag)){
            throw new IllegalArgumentException("标签已经存在");
        }
        this.save(BeanUtil.copyProperties(params, Tag.class));
    }

    @Override
    public void updateTag(TagParams tagParams, Long id) {
//        this.updateById(BeanUtil.copyProperties(tagParams, Tag.class).setId(id));
    }


    @Override
    public void deleteTag(List<Long> tagIds) {
//        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Tag::getName, tagParams.getName());
//        this.remove(queryWrapper);
        this.removeBatchByIds(tagIds);
    }

    @Override
    public List<TagVO> getAllTags() {
        return BeanUtil.copyToList(this.list(), TagVO.class);
    }
}






package top.kristina.service.admin.system.service;

import top.kristina.service.admin.system.model.dto.PageParams;
import top.kristina.service.admin.system.model.dto.TagParams;
import top.kristina.service.admin.system.model.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;
import top.kristina.service.admin.system.model.vo.PageVO;
import top.kristina.service.admin.system.model.vo.TagVO;

import java.util.List;

public interface TagService extends IService<Tag>{
    PageVO<TagVO> getTags(PageParams params);

    void addTag(TagParams params);

    void updateTag(TagParams tagParams,Long id);

    void deleteTag(List<Long> tagIds);

    List<TagVO> getAllTags();

}

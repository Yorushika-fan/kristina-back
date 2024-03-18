package top.kristina.admin.controller.system;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.kristina.service.admin.system.model.dto.PageParams;
import top.kristina.service.admin.system.model.dto.TagParams;
import top.kristina.service.admin.system.model.vo.PageVO;
import top.kristina.service.admin.system.model.vo.TagVO;
import top.kristina.service.admin.system.service.TagService;

import java.util.List;


/**
 * 标签接口
 */
@RestController
@RequestMapping("/tag")
@Tag(name = "标签管理",description =  "标签相关接口")
public class TagController {

    @Resource
    private TagService tagService;

    /**
     * 分页获取标签
     */
    @GetMapping
    @Operation(summary = "分页获取标签")
    public PageVO<TagVO> getTags(@Validated PageParams params) {
        return  tagService.getTags(params);
    }

    /**
     *  获取所有标签
     * @return
     */
    @GetMapping("/all")
    @Operation(summary = "获取所有标签")
    public List<TagVO> getAllTags() {
        return tagService.getAllTags();
    }

    /**
     * 获取单个标签
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "获取单个标签")
    public TagVO getTag(@PathVariable("id") @Min(value = 1) Long id) {
        return BeanUtil.copyProperties(tagService.getById(id), TagVO.class);
    }
    /**
     * 添加标签
     */
    @PostMapping
    @Operation(summary = "添加标签")
    public void addTag(@RequestBody TagParams  params) {
        tagService.addTag(params);
    }

    /**
     *
     * 更新标签
     * @param tagParams
     */
    @PutMapping("/{id}")
    @Operation(summary = "更新标签")
    public void updateTag(@RequestBody @Validated TagParams tagParams, @PathVariable("id") Long id) {
        tagService.updateTag(tagParams,id);
    }

    /**
     *
     * 删除标签||批量删除
     */
    @DeleteMapping("")
    @Operation(summary = "删除标签||批量删除")
    public void deleteTag(@RequestBody  List<Long> tagIds) {
        tagService.deleteTag(tagIds);
    }



}

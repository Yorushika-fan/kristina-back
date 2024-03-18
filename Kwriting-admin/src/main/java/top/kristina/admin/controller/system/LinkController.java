package top.kristina.admin.controller.system;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.kristina.service.admin.system.model.dto.LinkParams;
import top.kristina.service.admin.system.model.dto.PageParams;
import top.kristina.service.admin.system.model.vo.LinkVO;
import top.kristina.service.admin.system.model.vo.PageVO;
import top.kristina.service.admin.system.service.LinkService;

import java.util.List;

/**
 * 友链接口
 */
@RestController
@RequestMapping("/link")
@Tag(name = "友链管理",description =  "友链相关接口")
public class LinkController {

    @Resource
    private LinkService linkService;
    /**
     *  分页获取友链
     * @param params
     * @return
     */
    @GetMapping
    @Operation(summary = "分页获取友链")
    public PageVO<LinkVO> getLink(@Validated PageParams params) {
        return linkService.getLinkByPage(params);
    }

    /**
     *   获取友链详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "获取友链详情")
    public LinkVO getLinkDetails(@PathVariable("id") Long id) {
        return linkService.getLinkDetails(id);
    }


    /**
     * 添加友链
     * @return
     */
    @PostMapping
    @Operation(summary = "添加友链")
    public void addLink(@RequestBody @Validated LinkParams params) {
        linkService.addLink(params);
    }

    /**
     * 删除友链 || 批量删除友链
     * @param ids
     */
    @DeleteMapping
    @Operation(summary = "删除友链 || 批量删除友链")
    public void  deleteLink( @RequestBody  List<Long> ids) {
        linkService.deleteLink(ids);
    }
}

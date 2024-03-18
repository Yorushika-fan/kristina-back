package top.kristina.admin.controller.system;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.kristina.service.admin.system.model.dto.ArticleParams;
import top.kristina.service.admin.system.model.dto.PageParams;
import top.kristina.service.admin.system.model.vo.ArticleVO;
import top.kristina.service.admin.system.model.vo.PageVO;
import top.kristina.service.admin.system.service.ArticleService;


import java.util.List;

/**
 * 文章管理
 */
@RestController
@RequestMapping("/article")
@Tag(name = "文章接口", description = "文章相关接口")
@Slf4j
public class ArticleController {

    @Resource
    private ArticleService articleService;


    /**
     *  分页获取文章列表
     * @param params
     * @return
     */
    @GetMapping
    @Operation(summary = "获取文章列表", description = "获取文章列表")
    public PageVO<ArticleVO> getArticle(@Validated PageParams params) {
        return articleService.getArticlePage(params);
    }

    /**
     * 获取文章详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "获取详情", description = "获取详情")
    public ArticleVO getArticle(@NotNull(message = "文章id不能为空") @PathVariable Long id){
        return articleService.getArticleDetail(id);
    }



    /**
     * 添加文章
     * @param params
     */
    @PostMapping()
    @Operation(summary = "添加文章", description = "添加文章", tags = "文章接口")
    public void add(@RequestBody @Validated ArticleParams params) {
        articleService.addArticle(params);
    }

    /**
     *  更新文章
     * @param articleIds
     */
    @DeleteMapping()
    @Operation(summary =  "删除文章", description = "删除文章")
    public void deleteArticle(@RequestBody List<Long> articleIds){
       log.error(articleIds.toString());
        articleService.deleteArticles(articleIds);
    }

    /**
     * 更新文章`
     */
    @PutMapping
    @Operation(summary = "更新文章", description = "更新文章")
    public void updateArticle(@RequestBody @Validated ArticleParams params) {
        articleService.updateArticle(params);
    }


}


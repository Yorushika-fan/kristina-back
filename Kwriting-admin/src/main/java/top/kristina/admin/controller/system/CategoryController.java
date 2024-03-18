package top.kristina.admin.controller.system;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.kristina.service.admin.system.model.dto.CategoryParams;
import top.kristina.service.admin.system.model.dto.PageParams;
import top.kristina.service.admin.system.model.vo.CategoryVO;
import top.kristina.service.admin.system.model.vo.PageVO;
import top.kristina.service.admin.system.service.CategoryService;

import java.util.List;


/**
 * 分类接口
 */
@RestController
@RequestMapping("/category")
@Tag(name = "分类管理", description = "分类管理")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 获取所有分类
     * @return
     */
    @GetMapping("/all")
    @Operation(summary = "获取所有分类")
    public List<CategoryVO> getAll() {
        return categoryService.getCategoryList();

    }

    /**
     * 分页获取分类
     * @param params
     * @return
     */
    @GetMapping
    @Operation(summary = "分页获取分类")
    public PageVO<CategoryVO> getCategoryPage(@Validated PageParams params) {
        return categoryService.getCategoryPage(params);
    }

    /**
     * 查询分类详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "查询分类详情")
    public CategoryVO get(@PathVariable @NotNull Long id) {
        return categoryService.getCategoryDetails(id);
    }

    /**
     *  添加分类
     * @param params
     */
    @PostMapping
    @Operation(summary = "添加分类")
    public void add(@RequestBody @Validated CategoryParams params) {
        categoryService.addCategory(params);
    }

    /**
     * 删除分类
     * @param
     */
    @DeleteMapping
    @Operation(summary = "删除分类")
    public void delete(@RequestBody List<Long> categoryIds) {
        categoryService.deleteCategory(categoryIds);
    }


    /**
     *  修改分类
     * @param params
     */
    @PutMapping
    @Operation(summary = "修改分类")
    public void update(@RequestBody @Validated CategoryParams params) {
        categoryService.updateCategory(params);
    }

}
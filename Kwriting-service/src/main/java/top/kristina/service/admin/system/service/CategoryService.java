package top.kristina.service.admin.system.service;

import top.kristina.service.admin.system.model.dto.CategoryParams;
import top.kristina.service.admin.system.model.dto.PageParams;
import top.kristina.service.admin.system.model.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import top.kristina.service.admin.system.model.vo.CategoryVO;
import top.kristina.service.admin.system.model.vo.PageVO;

import java.util.List;

public interface CategoryService extends IService<Category>{
    List<CategoryVO> getCategoryList();

    void addCategory(CategoryParams params);

    void deleteCategory(List<Long> categoryIds);

    void updateCategory(CategoryParams params);

    CategoryVO getCategoryDetails(Long id);

    PageVO<CategoryVO> getCategoryPage(PageParams params);

}

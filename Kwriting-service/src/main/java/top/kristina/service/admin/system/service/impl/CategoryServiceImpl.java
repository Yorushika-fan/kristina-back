package top.kristina.service.admin.system.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kristina.service.admin.system.model.dto.CategoryParams;
import top.kristina.service.admin.system.model.dto.PageParams;
import top.kristina.service.admin.system.model.entity.Category;
import top.kristina.service.admin.system.mapper.CategoryMapper;
import top.kristina.service.admin.system.model.vo.CategoryVO;
import top.kristina.service.admin.system.model.vo.PageVO;
import top.kristina.service.admin.system.service.CategoryService;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{


    @Override
    public List<CategoryVO> getCategoryList() {
        return BeanUtil.copyToList(this.list(), CategoryVO.class);
    }

    @Override
    public void addCategory(CategoryParams  params) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getName, params.getName());
        Category category = this.getOne(queryWrapper);

        if (Objects.nonNull(category)) {
            throw new IllegalArgumentException("分类已存在");
        }
        this.save(new Category().setName(params.getName()));
    }

    @Override
    public void deleteCategory(List<Long> categoryIds) {
        this.removeBatchByIds(categoryIds);
    }

    @Override
    public void updateCategory(CategoryParams params) {
        Category category = this.getById(params.getId());
        if (Objects.isNull(category)) {
            throw new IllegalArgumentException("分类不存在");
        }
        this.updateById(category.setName(params.getName()));
    }

    @Override
    public CategoryVO getCategoryDetails(Long id) {
        return BeanUtil.copyProperties(this.getById(id), CategoryVO.class);
    }

    @Override
    public PageVO<CategoryVO> getCategoryPage(PageParams params) {

        Page<Category> page = new Page(params.getPageNum(),params.getPageSize());
        page = this.page(page);
        long total = page.getTotal();
        List<CategoryVO> rows = BeanUtil.copyToList(page.getRecords(), CategoryVO.class);

        return new PageVO<CategoryVO>()
                .setRows(rows)
                .setTotal(total);
    }

}

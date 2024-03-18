package top.kristina.service.admin.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kristina.service.admin.system.model.dto.ArticleParams;
import top.kristina.service.admin.system.model.dto.PageParams;
import top.kristina.service.admin.system.model.entity.Article;
import top.kristina.service.admin.system.mapper.ArticleMapper;
import top.kristina.service.admin.system.model.vo.ArticleVO;
import top.kristina.service.admin.system.model.vo.PageVO;
import top.kristina.service.admin.system.model.vo.TagVO;
import top.kristina.service.admin.system.service.ArticleService;
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService{
    @Override
    public PageVO<ArticleVO> getArticlePage(PageParams params) {


        Page<Article> page = new Page<>(params.getPageNum(), params.getPageSize());
        page = this.page(page);
        List<TagVO> tags = new ArrayList<>();
        tags.add(new TagVO().setId(1l).setName("java"));
        tags.add(new TagVO().setId(2l).setName("spring"));
        tags.add(new TagVO().setId(3l).setName("springboot"));

        List<ArticleVO> rows = BeanUtil.copyToList(page.getRecords(), ArticleVO.class).stream().map(
                articleVO -> articleVO.setTags(tags)
        ).toList();
        long total = page.getTotal();
        return new PageVO<ArticleVO>()
                .setRows(rows)
                .setTotal(total);
    }

    @Override
    public void addArticle(ArticleParams params) {
        this.save(BeanUtil.copyProperties(params, Article.class));
    }

    @Override
    public ArticleVO getArticleDetail(Long id) {
        List<TagVO> tags = new ArrayList<>();
        tags.add(new TagVO().setId(1l).setName("java"));
        tags.add(new TagVO().setId(2l).setName("spring"));
        tags.add(new TagVO().setId(3l).setName("springboot"));
        Article article = getById(id);
        if(Objects.isNull(article)){
            throw new RuntimeException("文章不存在");
        }
        return BeanUtil.copyProperties(article, ArticleVO.class).setTags(tags);
    }

    @Override
    public void deleteArticles(List<Long> articleIds) {
        this.removeBatchByIds(articleIds);
    }

    @Override
    public void updateArticle(ArticleParams params) {
        this.updateById(BeanUtil.copyProperties(params, Article.class));
    }
}



package top.kristina.service.admin.system.service;

import top.kristina.service.admin.system.model.dto.ArticleParams;
import top.kristina.service.admin.system.model.dto.PageParams;
import top.kristina.service.admin.system.model.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import top.kristina.service.admin.system.model.vo.ArticleVO;
import top.kristina.service.admin.system.model.vo.PageVO;

import java.util.List;

public interface ArticleService extends IService<Article>{
    PageVO<ArticleVO> getArticlePage(PageParams params);

    void addArticle(ArticleParams params);
    ArticleVO getArticleDetail(Long id);

    void deleteArticles(List<Long> articleIds);

    void updateArticle(ArticleParams params);

}

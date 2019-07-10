package techcourse.myblog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techcourse.myblog.domain.Article;
import techcourse.myblog.domain.ArticleRepository;

@Service
public class ArticleService {


    @Autowired
    ArticleRepository articleRepository;

    public void save(Article article){
        articleRepository.save(article);
    }

}

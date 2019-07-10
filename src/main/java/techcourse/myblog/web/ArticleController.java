package techcourse.myblog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import techcourse.myblog.domain.Article;
import techcourse.myblog.service.ArticleService;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles/new")
    public String articleCreateForm() {
        return "article-edit";
    }

    @GetMapping("/writing")
    public String writeArticle() {
        return "article-edit";
    }

    @PostMapping("/articles")
    public String createArticle(@ModelAttribute Article article, Model model) {
        model.addAttribute("article", article);
        articleService.save(article);
        return "article";
    }
}

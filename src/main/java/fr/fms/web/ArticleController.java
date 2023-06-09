package fr.fms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@Controller
public class ArticleController {

	@Autowired
	IBusinessImpl iBusinessImpl;

	@GetMapping("/index")
	public String index(Model model, @RequestParam(name = "category", defaultValue = "0") long idCat) {

		// recuperer les articles
		Page<Article> page = iBusinessImpl.getArticlesPaginateByKeyWord(0, "");
		List<Article> listArticles = page.getContent();
		model.addAttribute("articles", listArticles);

		// recuperer les categories
		List<Category> categories = iBusinessImpl.getCategories();
		model.addAttribute("categories", categories);
		Category category = iBusinessImpl.getCategoryById(idCat);
		model.addAttribute("currentCategory", category.getId());
		return "index";
	}

}

package fr.fms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.business.IBusinessImpl;
import fr.fms.dao.ArticleRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@Controller
public class ArticleController {
	
	

	@Autowired
	IBusinessImpl iBusinessImpl;

	@GetMapping("/index")
	public String index(Model model, @RequestParam(name = "category", defaultValue = "0") long idCat,
			@RequestParam(name = "keyword", defaultValue = "") String kw,
			@RequestParam(name = "page", defaultValue = "0") int page) {

		Page<Article> pages = null;
		
		if(idCat!=0) {
			Category category = iBusinessImpl.getCategoryById(idCat);
			model.addAttribute("currentCategory", category.getId());
			pages = iBusinessImpl.getArticleByCategoryAndDescription(idCat, kw, page);
		}else {
			pages = iBusinessImpl.getArticlesPaginateByKeyWord(page, kw);
		}
		model.addAttribute("keyword",kw);
		
		// recuperer les articles par keyword
		
		List<Article> listArticles = pages.getContent();
		model.addAttribute("articles", listArticles);

		// recuperer les categories
		List<Category> categories = iBusinessImpl.getCategories();
		model.addAttribute("categories", categories);

		
		model.addAttribute("pages", new int[pages.getTotalPages()]);
		model.addAttribute("currentPage",page);
		
		return "index";
	}
	@GetMapping("/delete")
	public String delete(Long id, int page,String keyword) {
		iBusinessImpl.deleteArticle(id);
		return "redirect:/index?page="+page+"&keyword="+keyword;
	}

}

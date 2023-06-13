package fr.fms.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@Controller
public class ArticleController {
	
	@Autowired
	CartController cartController;

	@Autowired
	IBusinessImpl iBusinessImpl;

	@GetMapping("/index")
	public String index(Model model, @RequestParam(name = "category", defaultValue = "0") long idCat,
			@RequestParam(name = "keyword", defaultValue = "") String kw,
			@RequestParam(name = "page", defaultValue = "0") int page) {

		Page<Article> pages = null;

		if (idCat != 0) {
			Category category = iBusinessImpl.getCategoryById(idCat);
			model.addAttribute("currentCategory", category.getId());
			pages = iBusinessImpl.getArticleByCategoryAndDescription(idCat, kw, page);
		} else {
			pages = iBusinessImpl.getArticlesPaginateByKeyWord(page, kw);
		}
		model.addAttribute("keyword",kw);
		// recuperer les articles par keyword

		List<Article> listArticles = pages.getContent();
		model.addAttribute("articles", listArticles);

		// recuperer les categories
		List<Category> categories = iBusinessImpl.getCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("cartSize", cartController.cart.size());

		model.addAttribute("pages", new int[pages.getTotalPages()]);
		model.addAttribute("currentPage", page);

		return "index";
	}
	@GetMapping("/delete")
	public String delete(Long id, int page,String keyword) {
		iBusinessImpl.deleteArticle(id);
		return "redirect:/index?page="+page+"&keyword="+keyword;
	}

	// Formulaire pour créer un article.
	@GetMapping("/article") // La route devrait indiquer articles/create et ne devrait pas passer par index.
	public String articleForm(Model model) {

		// recuperer les categories
		List<Category> categories = iBusinessImpl.getCategories();
		Category currentCategory = categories.get(0);

		model.addAttribute("categories", categories);
		model.addAttribute("article", new Article());
		model.addAttribute("currentCategory", currentCategory);
		return "newArticle";
	}

	// Méthode qui crée un article en base de données.
	@PostMapping("/save")
	public String save(@Valid Article article, BindingResult bindingResult, Long cateId) {
		if (bindingResult.hasErrors()) {
			return "newArticle";
		}
		Category category = iBusinessImpl.getCategoryById(cateId);
		article.setCategory(category);
		iBusinessImpl.saveArticle(article);
		return "redirect:/index"; // Rester dans le formulaire de création pour rentrer plusieurs articles, retour
									// à l'index par Home dans la Navbar
	}

	// Méthode qui récupère l'article sélectionné dans un formulaire et l'update.
	@GetMapping("/edit")
	public String showEditForm(Long id, Model model) {
		List<Category> categories = iBusinessImpl.getCategories();
		Article article = iBusinessImpl.getArticleById(id);
		model.addAttribute("categories", categories);
		model.addAttribute("article", article);
		return "editArticle";
	}
}

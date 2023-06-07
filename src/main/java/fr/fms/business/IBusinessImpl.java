package fr.fms.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

public class IBusinessImpl implements IBusiness {

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Page<Article> getArticles(int page) {
		final int SIZE = 5;
		return articleRepository.findAll(PageRequest.of(page, SIZE));
	}

	// TODO
	@Override
	public Page<Article> getArticleByCategory(long idCat) {
		Page<Article> articles = null;
		return articles;
	}

	@Override
	public List<Category> getCategories() {
		return categoryRepository.findAll();

	}

}

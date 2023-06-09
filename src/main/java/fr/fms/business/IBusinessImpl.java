package fr.fms.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;


@Service
public class IBusinessImpl implements IBusiness {

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Page<Article> getArticlesPaginateByKeyWord(int page, String kw) {
		final int SIZE = 5;
		return articleRepository.findByDescriptionContains(kw, PageRequest.of(page, SIZE));
	}


	@Override
	public List<Category> getCategories() {
		return categoryRepository.findAll();

	}

	@Override
	public Category getCategoryById(Long idCat) {
		return categoryRepository.findById(idCat).get();
	}

	@Override
	public Page<Article> getArticleByCategoryAndDescription(long idCat, String keyword,int page) {
		final int SIZE = 5;
		return articleRepository.findByCategoryIdAndDescriptionContains(idCat, keyword,  PageRequest.of(page, SIZE));
	}

}

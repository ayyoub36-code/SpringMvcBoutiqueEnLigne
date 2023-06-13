package fr.fms.business;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.dao.CustomerRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import fr.fms.entities.Customer;

@Service
public class IBusinessImpl implements IBusiness {

	private static final Logger LOGGER = LoggerFactory.getLogger(IBusinessImpl.class);

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CustomerRepository customerRepository;

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
		Optional<Category> optional = categoryRepository.findById(idCat);

		if (optional.isPresent()) {
			return optional.get();
		}
		LOGGER.warn("Categorie introuvable !");
		return null;
	}

	@Override
	public Page<Article> getArticleByCategoryAndDescription(long idCat, String keyword, int page) {
		final int SIZE = 5;
		return articleRepository.findByCategoryIdAndDescriptionContains(idCat, keyword, PageRequest.of(page, SIZE));
	}

	@Override
	public void saveArticle(Article article) {
		articleRepository.save(article);
	}

	@Override
	public Article getArticleById(Long id) {
		Optional<Article> optional = articleRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		LOGGER.warn("Article introuvable !");
		return null;
	}

	@Override
	public void deleteArticle(Long id) {
		articleRepository.deleteById(id);

	}

	@Override
	public Customer getCustomerById(Long id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		LOGGER.warn("Customer introuvable !");
		return null;
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	// Customer
}

package fr.fms.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Article;

public interface ArticleRepository extends JpaRepository<Article,Long>{

	// tous les articles par mot clé 
	Page<Article> findByDescriptionContains(String description, Pageable pageable);
	Page<Article> findByCategoryIdAndDescriptionContains(Long categoryId,String keyword, Pageable pageable);
}

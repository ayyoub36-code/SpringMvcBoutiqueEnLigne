package fr.fms.business;

import java.util.List;

import org.springframework.data.domain.Page;

import fr.fms.entities.Article;
import fr.fms.entities.Category;

public interface IBusiness {

	// TODO : javadoc
	// Afficher articles
	public Page<Article> getArticles(int page);

	// afficher toutes les categories
	public List<Category> getCategories();

	// get all article of category avec la pagination
	public Page<Article> getArticleByCategory(long idCat);
	
	// CRUD sur les articles 
	// creation d'un article
	// update d'un article
	// delete d'un article
	
	// recherche par mot clé 
	// enregistrer le customer 
	// enregistrer la commande
	
	

}

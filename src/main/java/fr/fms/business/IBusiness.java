package fr.fms.business;

import java.util.List;

import org.springframework.data.domain.Page;

import fr.fms.entities.Article;
import fr.fms.entities.Category;

public interface IBusiness {

	// TODO : javadoc

	// Afficher articles par pagination et mot clé
	public Page<Article> getArticlesPaginateByKeyWord(int page, String kw);

	// afficher toutes les categories
	public List<Category> getCategories();

	// afficher une categorie
	public Category getCategoryById(Long idCat);

	// obtenir eds pages d' articles correspondant à la categorie et au keyword an parametre
	public Page<Article> getArticleByCategoryAndDescription(long idCat, String keyword, int page);

	

	// CRUD sur les articles
	// creation d'un article TODO Christian
	// update d'un article TODO Christian
	// delete d'un article TODO Nicolas
	// + commencer à regaredr la bar nav (href -> th:href, logo, etc)
	// recherche par mot clé 
	// enregistrer le customer
	// enregistrer la commande

}

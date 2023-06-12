package fr.fms.business;

import java.util.List;

import org.springframework.data.domain.Page;

import fr.fms.entities.Article;
import fr.fms.entities.Category;

public interface IBusiness {

	// Afficher articles par pagination et mot clé
	public Page<Article> getArticlesPaginateByKeyWord(int page, String kw);

	// afficher toutes les categories
	public List<Category> getCategories();

	// afficher une categorie
	public Category getCategoryById(Long idCat);

	// obtenir eds pages d' articles correspondant à la categorie et au keyword an
	public Page<Article> getArticleByCategoryAndDescription(long idCat, String keyword, int page);

	// Créer et enregistrer un nouvel article.
	public void saveArticle(Article article);

	// Méthode pour récupérer l'article sélectionné.
	public Article getArticleById(Long id);

	// delete d'un article
	public void deleteArticle(Long id);
	
	// saveCustomer
	// saveOrder



}

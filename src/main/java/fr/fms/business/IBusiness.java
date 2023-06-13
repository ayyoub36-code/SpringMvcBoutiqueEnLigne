package fr.fms.business;

import java.util.List;

import org.springframework.data.domain.Page;

import fr.fms.entities.Article;
import fr.fms.entities.Category;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;

public interface IBusiness {

	/**
	 * Afficher articles par pagination et mot clé
	 * 
	 * @param numéro  de la page
	 * @param keyword
	 */
	public Page<Article> getArticlesPaginateByKeyWord(int page, String kw);

	/**
	 * afficher toutes les categories
	 * 
	 * @return liste des catégories
	 */
	public List<Category> getCategories();

	/**
	 * afficher une categorie
	 * 
	 * @param idCat
	 * @return catégorie
	 */
	public Category getCategoryById(Long idCat);

	/**
	 * obtenir les pages d'articles correspondant à la categorie et au keyword
	 * 
	 * @param idCat
	 * @param keyword
	 * @param page
	 * @return une page
	 */
	public Page<Article> getArticleByCategoryAndDescription(long idCat, String keyword, int page);

	/**
	 * Créer et enregistrer un nouvel article.
	 * 
	 * @param article
	 */
	public void saveArticle(Article article);

	/**
	 * Méthode pour récupérer l'article sélectionné.
	 * 
	 * @param id
	 * @return article
	 */
	public Article getArticleById(Long id);

	/**
	 * delete d'un article
	 * 
	 * @param id
	 */
	public void deleteArticle(Long id);

	/**
	 * trouver un customer par id
	 * 
	 * @param id
	 * @return
	 */
	public Customer getCustomerById(Long id);

	/**
	 * save customer
	 * 
	 * @param customer
	 * @return customer
	 */
	public Customer saveCustomer(Customer customer);

	/**
	 * save order
	 * 
	 * @param order
	 * @return order
	 */
	public Order saveOrder(Order order);

	/**
	 * save OrderItem
	 * 
	 * @param orderItem
	 */
	public void saveOrderItem(OrderItem orderItem);

}

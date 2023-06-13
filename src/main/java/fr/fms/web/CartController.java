package fr.fms.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Article;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;

@Controller
public class CartController {

	@Autowired
	IBusinessImpl iBusinessImpl;

	private OrderItem orderItem;
	private boolean trouve;
	protected List<OrderItem> cart = new ArrayList<>();

	// panier affichage CartController (structure d enregistrement List(ArrayList)
	@GetMapping("/cart")
	public String cart(Model model) {
		model.addAttribute("cart", cart);
		return "cart";
	}

	@GetMapping("/add")
	public String addToCart(Model model, Long id, int page, String keyword, Long category) {
		Article article = iBusinessImpl.getArticleById(id);
		System.out.println("cart.size()  " + cart.size());

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		model.addAttribute("cart", cart);
		System.out.println("cart size : " + cart.size());
		return "redirect:/index?page=" + page + "&keyword=" + keyword + "&category" + category;
	}

	// => panier) et recuperer le cart.size => Navbarre
	// add to cart button addToCart(index) => OrderItem => quantity ++
	// delete from cart

	// enregistrer la commande
}

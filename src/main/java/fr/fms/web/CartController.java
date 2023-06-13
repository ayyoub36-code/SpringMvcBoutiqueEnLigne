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

//		trouve=false;
//	cart.stream().forEach(o ->{
//		
//		if(o.getArticle().getId()==id) {
//			o.setQuantity(o.getQuantity() + 1);
//			trouve=true;
//		
//	}else {
//
//		trouve=false;
//	}
//	});
//		if(trouve==false) {
//			orderItem = new OrderItem(null, 1, article, new Order());
//			cart.add(orderItem);
//		}
		
		
//		orderItem = cart.stream().filter(o -> {return o.getArticle().getId().equals(id);}).findAny().orElse(null);
//		
//			orderItem.setQuantity(orderItem.getQuantity() + 1);
//
//		
//
//			orderItem = new OrderItem(null, 1, article, new Order());
//
//			cart.add(orderItem);

		
		model.addAttribute("cart", cart);
		System.out.println("cart size : " + cart.size());
		return "redirect:/index?page=" + page + "&keyword=" + keyword + "&category" + category;
	}

	// => panier) et recuperer le cart.size => Navbarre
	
	
	// add to cart button addToCart(index) => OrderItem => quantity ++
	
	
	
	// delete from cart

	
	
	
	// enregistrer la commande
}

package fr.fms.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Article;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;

@Controller
public class CartController {

	@Autowired
	IBusinessImpl iBusinessImpl;

	protected List<OrderItem> cart = new ArrayList<>();
	protected double total = 0;

	@GetMapping("/cart")
	public String cart(Model model) {

		for (OrderItem orderItem : cart) {
			total += orderItem.getArticle().getUnitaryPrice() * orderItem.getQuantity();
		}

		model.addAttribute("total", total);
		model.addAttribute("cart", cart);
		model.addAttribute("cartSize", cart.size());
		return "cart";
	}

	@GetMapping("/add")
	public String addToCart(Model model, Long id, int page, String keyword, Long category) {

		Article article = iBusinessImpl.getArticleById(id);

		if (article == null) {
			return "404";
		}

		OrderItem orderItem = null;

		if (findFirst(id) != null) {
			orderItem = findFirst(id);
			orderItem.setQuantity(orderItem.getQuantity() + 1);
		} else {
			orderItem = new OrderItem(null, 1, article, new Order());
			cart.add(orderItem);
		}

		model.addAttribute("cart", cart);

		return "redirect:/index?page=" + page + "&keyword=" + keyword + "&category" + category;
	}

	@GetMapping("/remove")
	public String remove(Model model, Long id) {
		cart.stream().filter(o -> o.getArticle().getId().equals(id)) // Condition here
				.findFirst().ifPresent(cart::remove);
		model.addAttribute("cart", cart);
		if (cart.isEmpty())
			return "redirect:/index";
		return "redirect:/cart";
	}

	public OrderItem findFirst(Long id) {
		return cart.stream().filter(o -> o.getArticle().getId().equals(id)).findAny().orElse(null);
	}

	// TODO : order.html => div (recap du panier) div(recap du customer) => valider
	// (enregitre la commande et redirige vers page de remerciement)
	// nicolas page remerciement
}

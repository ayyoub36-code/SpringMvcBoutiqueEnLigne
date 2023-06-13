package fr.fms.web;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Customer;

import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;

@Controller
public class OrderController {

	@Autowired
	CartController cartController;
	@Autowired
	IBusinessImpl iBusinessImpl;

	Customer customer;

	@GetMapping("/order")
	public String order(Model model) {
		customer = (Customer) model.asMap().get("customer");
		model.addAttribute("customer", customer);
		model.addAttribute("total", cartController.total);
		model.addAttribute("cart", cartController.cart);
		model.addAttribute("cartSize", cartController.cart.size());
		return "order";
	}

	@GetMapping("/saveOrder")
	public String saveOrder(Model model) {
		Customer customerVal = iBusinessImpl.saveCustomer(customer); // saveAndFlush(customer)
		Order orderVal = iBusinessImpl // saveAndFlush(order)
				.saveOrder(new Order(null, Date.valueOf(LocalDate.now()), cartController.total, customerVal, null));

		for (OrderItem o : cartController.cart) {
			OrderItem oi = new OrderItem(null, o.getQuantity(), o.getArticle(), orderVal);
			iBusinessImpl.saveOrderItem(oi);
		}

		cartController.cart = new ArrayList<>();
		model.addAttribute("cart", cartController.cart);
		model.addAttribute("customer", customerVal);
		model.addAttribute("cartSize", cartController.cart.size());
		return "confirm";
	}

}

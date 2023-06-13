package fr.fms.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Customer;


@Controller
public class OrderController {

	@Autowired
	IBusinessImpl iBusinessImpl;
	
	@Autowired
	CartController cartController;
	
	@GetMapping("/order")
	public String order(Model model, Customer customer ) {
//		Customer cust = (Customer) model.getAttribute("customer");
//		model.addAttribute("customer", customer);
		
		model.addAttribute("total",cartController.total);
		model.addAttribute("cart",cartController.cart);
		model.addAttribute("cartSize",cartController.cart.size());
		return "order";
	}
}

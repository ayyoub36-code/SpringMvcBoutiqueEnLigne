package fr.fms.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Customer;

@Controller
public class CustomerController {

	@Autowired
	CartController cartController;

	@Autowired
	IBusinessImpl iBusinessImpl;

	@GetMapping("/customer")
	public String customerForm(Model model) {

		model.addAttribute("cartSize", cartController.cart.size());
		model.addAttribute("customer", new Customer());
		return "newCustomer";
	}

	// Méthode qui crée un customer en base de données.
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "newCustomer";
		}
		iBusinessImpl.saveCustomer(customer);
		return "redirect:/order";
	}
}

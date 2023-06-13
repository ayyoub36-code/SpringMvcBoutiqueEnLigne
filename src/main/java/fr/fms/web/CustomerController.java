package fr.fms.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Customer;

@Controller
public class CustomerController {

	@Autowired
	CartController cartController;

	@Autowired
	IBusinessImpl iBusinessImpl;

	Customer cust;

	@GetMapping("/customer")
	public String customerForm(Model model) {

		model.addAttribute("cartSize", cartController.cart.size());
		model.addAttribute("customer", new Customer());
		return "newCustomer";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "newCustomer";
		}
		cust = customer;
		// envoie vers un orderController
		redirectAttributes.addFlashAttribute("customer", cust);
		return "redirect:/order";
	}
}

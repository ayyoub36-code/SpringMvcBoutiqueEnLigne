package fr.fms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fms.business.IBusinessImpl;

@Controller
public class OrderController {

	@Autowired
	IBusinessImpl iBusinessImpl;
	
	@GetMapping("/order")
	public String order() {
		return "order";
	}
}

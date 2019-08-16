package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.Customer;
import domain.CustomerLogin;
import service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	@Resource
	private CustomerService customerservice;
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("loginBean") CustomerLogin cl,Errors errors,HttpSession session){
		if(errors.hasFieldErrors()){
			return "customer/login";
		}
		Customer customer = null;
		customer = customerservice.login(cl.getCname());
		if(customer == null || !customer.getCpw().equals(cl.getCpw())){
			errors.reject("","Error with password/username");
			return "customer/login";
		}
		session.setAttribute("customer", customer);
		return "redirect:/customer/index.jsp";
	}
}

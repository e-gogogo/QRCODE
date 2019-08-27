package controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import domain.Customer;

import domain.CustomerLogin;
import service.CustomerService;
import util.VerificationCode;

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
			errors.reject("","用户名或密码错误");
			return "customer/login";
		}
		session.setAttribute("customer", customer);
		return "redirect:/customer/index.jsp";
	}
	
	@RequestMapping(value = "/forgetPassword",method = RequestMethod.POST,produces = "text/html;charset=UTF-8;")
	public String forgetPassword(@RequestBody String Cmail,HttpSession session) throws  UnsupportedEncodingException, MessagingException{
		Cmail=URLDecoder.decode(Cmail,"utf-8");
		String[] mail = Cmail.split("=");
		Customer customer = null;
		customer = customerservice.login(mail[1]);
		if(customer == null){
			return "error";
		}
		String verificationCode = VerificationCode.sendMail(mail[1]);
		session.setAttribute("Cmail", mail[1]);
		session.setAttribute("verificationCode", verificationCode);
		
		return "redirect:/customer/index.jsp";
	}
	
	@RequestMapping(value = "/verify",method = RequestMethod.POST ,produces = "text/html;charset=UTF-8;")
	public String verify(@RequestBody String Cmail,String Code,HttpSession session) throws UnsupportedEncodingException{
		Cmail=URLDecoder.decode(Cmail,"utf-8");
		String[] str = Cmail.split("&");
		String[] mail = str[0].split("=");
		Customer customer = null;
		customer = customerservice.login(mail[1]);
		if(customer == null){
			return "error";
		}
		if(!mail[1].equals(session.getAttribute("Cmail"))){
			return "error";
		}else if(!Code.equals(session.getAttribute("verificationCode"))){
			return "error";
		}
		return "redirect:/customer/index.jsp";
	}
	
	@RequestMapping(value = "/resetPassword",method = RequestMethod.POST ,produces = "text/html;charset=UTF-8;")
	public String resetPassword(@RequestBody String Cpw,HttpSession session){
		String[] newCpw = Cpw.split("=");
		String Cmail = (String) session.getAttribute("Cmail");
		Customer customer = customerservice.login(Cmail);
		customer.setCpw(newCpw[1]);
		customerservice.resetPassword(customer);
		return "redirect:/customer/login.jsp";
	}
	@RequestMapping(value = "/registerVerify",method = RequestMethod.POST,produces = "text/html;charset=UTF-8;")
	public String registerVerify(@RequestBody String Cmail,HttpSession session) throws  UnsupportedEncodingException, MessagingException{
		Cmail=URLDecoder.decode(Cmail,"utf-8");
		String[] mail = Cmail.split("=");
		Customer customer = null;
		customer = customerservice.login(mail[1]);
		if(customer != null){
			return "error";
		}
		String verificationCode = VerificationCode.sendMail(mail[1]);
		session.setAttribute("Cmail", mail[1]);
		session.setAttribute("verificationCode", verificationCode);
		
		return "redirect:/customer/index.jsp";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST ,produces = "text/html;charset=UTF-8;")
	public String register(String Cmail,String Code,String Cpw,String Cname,HttpSession session) throws UnsupportedEncodingException{
		Cmail=URLDecoder.decode(Cmail,"utf-8");
		Customer customer = null;
		customer = customerservice.login(Cname);
		if(customer != null){
			return "error";
		}
		if(!Cmail.equals(session.getAttribute("Cmail"))){
			return "error";
		}else if(!Code.equals(session.getAttribute("verificationCode"))){
			return "error";
		}
		customer = new Customer();
		customer.setCmail(Cmail);
		customer.setCname(Cname);
		customer.setCpw(Cpw);
		customerservice.addCustomer(customer);
		return "redirect:/customer/index.jsp";
	}
	
	
}

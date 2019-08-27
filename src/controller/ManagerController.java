package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.Customer;
import domain.Manager;
import domain.ManagerLogin;
import domain.SaleInfo;
import service.ManagerService;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {
	
	private static final String Manager = null;
	@Resource
	ManagerService managerservice;
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("mloginBean") ManagerLogin ml, Errors errors,HttpSession session){
		if(errors.hasFieldErrors()){
			return "manager/login";
		}
		Manager manager = null;
		manager = managerservice.login(ml.getMid());
		if(manager == null || manager.getMid()!=ml.getMid()){
			errors.reject("","用户名或密码错误");
			return "customer/login";
		}
		session.setAttribute("manager", manager);
		return "redirect:/customer/index.jsp";
	}
	
	@RequestMapping(value = "/Search",method = RequestMethod.POST)
	public List<SaleInfo> search(String whetherall,String Mname,HttpSession session){
		Manager manager= (Manager) session.getAttribute("Manager");
		String mname = manager.getMname();
		if (whetherall == null) {
			
			return managerservice.getListByName(mname);
		}
		
		else {
			return managerservice.getAllListByName(mname);
		}
		
	}
}

package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Manager;
import domain.ManagerLogin;
import domain.Product;
import domain.QrCode;
import net.sf.json.JSONObject;
import service.ManagerService;
import util.CreateQrcode;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {
	
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
		return "redirect:/manager/productList.jsp";
	}
	@RequestMapping(value = "/createQrcode",method = RequestMethod.POST ,produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String createQrcode(int Pid,HttpSession session) throws IOException{
		Manager manager = (Manager) session.getAttribute("manager");		
		QrCode qrcode = new QrCode();
		Product product = managerservice.getProductByPid(Pid);
		String path = "D:/work/qrcode/WebContent/image/qrcode" + Pid +".png";
		//String qrdata = product.getPadd() + "?" + manager.getMid() + "";
		String qrdata="hello,world";
		qrcode.setQrData(qrdata);
		qrcode.setSavePath(path);
		qrcode.setBackColor();
		qrcode.setMainColor();
		qrcode.setQRVersion();
		CreateQrcode.create(qrcode);
		JSONObject oj = new JSONObject();
		oj.put("savePath", path);
		return oj.toString();
	}
}

package service;

import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import dao.CustomerMapper;
import domain.Customer;

@Service
@Scope
public class CustomerService {
	@Resource
	CustomerMapper customermapper;
	
	public Customer login(String Cname){
		Customer customer = null;
		if(isEmail(Cname)){
			customer = customermapper.getCustomerByCmail(Cname);
		}else{
			customer = customermapper.getCustomerByCname(Cname);

		}
		return customer;
	}
	public void resetPassword(Customer customer){
		customermapper.updateCustomerCpw(customer);
	}
	public static boolean isEmail(String s) {    
	    return Pattern.compile("\\w+@{1}\\w+\\.{1}\\w+").matcher(s).matches();    
	}
	public void addCustomer(Customer customer){
		customermapper.addCustomer(customer);
	}
}

package service;

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
		customer = customermapper.getCustomerByCname(Cname);
		return customer;
	}
}

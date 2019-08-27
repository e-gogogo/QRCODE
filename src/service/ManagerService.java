package service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import dao.ManagerMapper;
import domain.Manager;
import domain.Product;


@Service
@Scope
public class ManagerService {

	@Resource
	ManagerMapper managermapper;
	
	public Manager login(int Mid){		
		Manager manager = null;
		manager = managermapper.getManagerByMid(Mid);
		return manager;
	}
	
	public Product getProductByPid(int Pid){
		Product product = null;
		product = managermapper.getProductByPid(Pid);
		return product;
	}
}

package service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import dao.ManagerMapper;
import domain.Manager;
<<<<<<< HEAD
import domain.Product;
=======
import domain.SaleInfo;
import util.QueryInfo;
import util.QueryInfoAll;

import java.util.List;
import domain.SaleInfo;
>>>>>>> 8ddb3304cecf0f996da4c9bcb6653935242c1645


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
	
	public List<SaleInfo> getListByName(String name) {		
		return (new QueryInfo().getListByName(name));
	}
	public List<SaleInfo> getAllListByName(String name) {		
		return (new QueryInfoAll().getListByName(name));
	}
	
	public Product getProductByPid(int Pid){
		Product product = null;
		product = managermapper.getProductByPid(Pid);
		return product;
	}
}

package service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import dao.ManagerMapper;
import domain.Manager;
import domain.SaleInfo;
import util.QueryInfo;
import util.QueryInfoAll;

import java.util.List;
import domain.SaleInfo;


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
}

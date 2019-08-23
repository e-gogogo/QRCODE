package service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import dao.ManagerMapper;
import domain.Manager;


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
}

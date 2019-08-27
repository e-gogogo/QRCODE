package dao;

import domain.Manager;
import domain.Product;

public interface ManagerMapper {
	public Manager getManagerByMid(int Mid);
	public Product getProductByPid(int Pid);
	
}

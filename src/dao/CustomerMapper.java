package dao;

import domain.Customer;
import domain.Product;
import domain.SalesList;

public interface CustomerMapper {
	public Customer getCustomerByCname(String Cname);
	public Customer getCustomerByCmail(String Cmail);
	public Product getProductByPid(int Pid);
	
	public void updateCustomerCpw(Customer customer);
	public void addCustomer(Customer customer);
	public void addSalesList(SalesList saleslist);
}

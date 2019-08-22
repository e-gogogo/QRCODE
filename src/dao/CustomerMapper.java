package dao;

import domain.Customer;

public interface CustomerMapper {
	public Customer getCustomerByCname(String Cname);
	public Customer getCustomerByCmail(String Cmail);
	public void updateCustomerCpw(Customer customer);
}

package dao;

import domain.Customer;

public interface CustomerMapper {
	public Customer getCustomerByCname(String Cname);
}

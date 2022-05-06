package van.hung.SpringAPI.sevice;

import java.util.List;

import van.hung.SpringAPI.model.Customers;

public interface iCustomerManager {
	public List<Customers> getCustomerByName(String name);
	public List<Customers> getAllCustomer();
	public boolean deleteCustomer(int id);
	public Customers addCustomer(Customers d);
	public int updateCustomer(int id,Customers d);
}

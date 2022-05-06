package van.hung.SpringAPI.sevice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import van.hung.SpringAPI.DTO.ProductDTO;
import van.hung.SpringAPI.model.Category;
import van.hung.SpringAPI.model.Customers;
import van.hung.SpringAPI.model.Product;
import van.hung.SpringAPI.repository.CategoryRepository;
import van.hung.SpringAPI.repository.CustomerRepository;
import van.hung.SpringAPI.repository.ProductRepository;
@Service
public class CustomerManagerImp implements iCustomerManager{
	@Autowired
	CustomerRepository customerrepository;
	
	@Override
	public List<Customers> getCustomerByName(String name) {
		// TODO Auto-generated method stub
		return customerrepository.getCustomerByParam(name);
	}

	@Override
	public List<Customers> getAllCustomer() {
		// TODO Auto-generated method stub
//			List<ProductDTO> listproductdto=new ArrayList<ProductDTO>(10);
//			List<Product>listproduct=productrepository.getAllProduct();
//
//			ProductDTO productdto = null;
//			for(int i=0;i<listproduct.size();i++) {
//
//				productdto=new ProductDTO();
//			
//				
//				productdto.setId_product(listproduct.get(i).getId_product());
//				productdto.setName(listproduct.get(i).getName());
//				productdto.setPrice(listproduct.get(i).getPrice());
//				productdto.setQuantity(listproduct.get(i).getQuantity());
//				System.out.println("asdfasdfasdf");
//				System.out.println("aaaaaaa"+listproduct.get(i));
//				try {
//					productdto.setId_category(listproduct.get(i).getCategory().getId_category());
//					
//				} catch (Exception e) {
//					// TODO: handle exception
//					e.getStackTrace();
//				}
//				listproductdto.add(productdto);
//					
//			}			
		
//		return listproductdto;
		return customerrepository.getAllCustomer();
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		try {
			Customers cdel=customerrepository.getById(id);
			if(cdel!=null) {
				customerrepository.delete(cdel);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return false;
	}

	@Override
	public Customers addCustomer(Customers c) {
		// TODO Auto-generated method stub
		return customerrepository.save(c);
	}

	@Override
	public int updateCustomer(int id, Customers c) {
		// TODO Auto-generated method stub
		try {
			Customers cup=customerrepository.getById(id);
			System.out.println("asdfasdf"+cup);
			if(cup!=null) {
				cup.setName(c.getAddress());
				cup.setEmail(c.getEmail());
				cup.setName(c.getName());
				System.out.println(c.getId_customer());
				cup.setPhone(c.getPhone());
				cup.setAdmin(c.getAdmin());
				
				customerrepository.save(cup);
				return 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return 0;
	}

}

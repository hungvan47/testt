package van.hung.SpringAPI.sevice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import van.hung.SpringAPI.DTO.ProductDTO;
import van.hung.SpringAPI.model.Category;
import van.hung.SpringAPI.model.Product;
import van.hung.SpringAPI.repository.CategoryRepository;
import van.hung.SpringAPI.repository.ProductRepository;
@Service
public class ProductManagerImp implements iProductManager{
	@Autowired
	ProductRepository productrepository;
	
	@Override
	public List<Product> getProductByName(String name) {
		// TODO Auto-generated method stub
		return productrepository.getProductByParam(name);
	}

	@Override
	public List<ProductDTO> getAllProduct() {
		// TODO Auto-generated method stub
			List<ProductDTO> listproductdto=new ArrayList<ProductDTO>(10);
			List<Product>listproduct=productrepository.getAllProduct();

			ProductDTO productdto = new ProductDTO();
			for(int i=0;i<listproduct.size();i++) {
				
				try {
					productdto.setId_product(listproduct.get(i).getId_product());
					productdto.setName(listproduct.get(i).getName());
					productdto.setPrice(listproduct.get(i).getPrice());
					productdto.setQuantity(listproduct.get(i).getQuantity());
					System.out.println("asdfasdfasdf");
					
					System.out.println("asdfadfasasdfasd");
					productdto.setId_category(listproduct.get(i).getCategory().getId_category());
					System.out.println("aaaaaaa"+listproduct.get(i).getCategory().getId_category());
				} catch (Exception e) {
					// TODO: handle exception
				}
				listproductdto.add(productdto);
					
			}			
		
		return listproductdto;
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		try {
			Product pdel=productrepository.getById(id);
			if(pdel!=null) {
				productrepository.delete(pdel);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return false;
	}

	@Override
	public Product addProduct(Product d) {
		// TODO Auto-generated method stub
		return productrepository.save(d);
	}

	@Override
	public int updateProduct(int id, Product d) {
		// TODO Auto-generated method stub
		try {
			Product pup=productrepository.getById(id);
			System.out.println("asdfasdf"+pup);
			if(pup!=null) {
				pup.setName(d.getName());
				pup.setQuantity(d.getQuantity());
				System.out.println(d.getId_product());
				
				productrepository.save(pup);
				return 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return 0;
	}

}

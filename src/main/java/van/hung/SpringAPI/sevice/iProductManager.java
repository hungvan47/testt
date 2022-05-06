package van.hung.SpringAPI.sevice;

import java.util.List;

import van.hung.SpringAPI.dto.ProductDTO;
import van.hung.SpringAPI.model.Product;

public interface iProductManager {
	List<Product> getProductByName(String name);
	List<ProductDTO> getAllProduct();
	boolean deleteProduct(int id);
	Product addProduct(ProductDTO d);
	int updateProduct(int id,Product d);
}

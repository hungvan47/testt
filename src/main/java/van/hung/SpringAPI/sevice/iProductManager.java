package van.hung.SpringAPI.sevice;

import java.util.List;

import van.hung.SpringAPI.DTO.ProductDTO;
import van.hung.SpringAPI.model.Product;

public interface iProductManager {
	public List<Product> getProductByName(String name);
	public List<ProductDTO> getAllProduct();
	public boolean deleteProduct(int id);
	public Product addProduct(Product d);
	public int updateProduct(int id,Product d);
}

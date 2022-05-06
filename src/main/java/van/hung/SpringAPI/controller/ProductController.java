package van.hung.SpringAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import van.hung.SpringAPI.dto.ProductDTO;
import van.hung.SpringAPI.model.Product;
import van.hung.SpringAPI.sevice.iProductManager;

@RequestMapping("/product")
@RestController
public class ProductController {
	@Autowired
	iProductManager iProductManager;
	
	@GetMapping("/getAllProduct")
	public List<ProductDTO> getAll(){
		return iProductManager.getAllProduct();
	}
	
	@GetMapping("/getByNameProduct")
	public List<Product>getByName(@RequestParam("name") String name){
		return iProductManager.getProductByName(name);
	}
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody ProductDTO d) {
		return iProductManager.addProduct(d);
	}
	
	@DeleteMapping("/deleteProduct")
	public boolean delProduct(@RequestParam("id_product") int id) {
		return iProductManager.deleteProduct(id);
	}
	@PutMapping("/putProduct")
	public int updateProduct(@RequestParam("id_product") int id,@RequestBody Product d) {
		return iProductManager.updateProduct(id, d);
	}
}

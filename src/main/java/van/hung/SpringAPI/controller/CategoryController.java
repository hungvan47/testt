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

import van.hung.SpringAPI.model.Category;
import van.hung.SpringAPI.sevice.iCategoryManager;

@RequestMapping("/category")
@RestController
public class CategoryController {

	@Autowired
	iCategoryManager icategorymanager;
	
	@GetMapping("/getAllCategory")
	public List<Category> getAll(){
		return icategorymanager.getAll();
	}
	
	@GetMapping("/getByNameCategory")
	public List<Category>getByName(@RequestParam("name") String name){
		return icategorymanager.getCategoryByName(name);
	}
	
	@PostMapping("/addCategory")
	public Category addCategory(@RequestBody Category c) {
		return icategorymanager.addCategory(c);
	}
	
	@DeleteMapping("/deleteCategory")
	public boolean delCategory(@RequestParam("id_category") int id) {
		return icategorymanager.deleteCategory(id);
	}
	@PutMapping("/putCategory")
	public int updateCategory(@RequestParam("id_category") int id,@RequestBody Category c) {
		return icategorymanager.updateCategory(id, c);
	}
}

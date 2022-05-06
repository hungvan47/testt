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

import van.hung.SpringAPI.model.Customers;
import van.hung.SpringAPI.sevice.iCustomerManager;

@RequestMapping("/customer")
@RestController
public class CustomerController {
	@Autowired
	iCustomerManager icustomermanager;
	
	@GetMapping("/getAllCustomer")
	public List<Customers> getAll(){
		return icustomermanager.getAllCustomer();
	}
	
	@GetMapping("/getByNameCustomer")
	public List<Customers>getByName(@RequestParam("name") String name){
		return icustomermanager.getCustomerByName(name);
	}
	
	@PostMapping("/addCustomer")
	public Customers addCustomer(@RequestBody Customers c) {
		return icustomermanager.addCustomer(c);
	}
	
	@DeleteMapping("/deleteCustomer")
	public boolean delCustomer(@RequestParam("id_customer") int id) {
		return icustomermanager.deleteCustomer(id);
	}
	@PutMapping("/putCustomer")
	public int updateCustomer(@RequestParam("id_customer") int id,@RequestBody Customers c) {
		return icustomermanager.updateCustomer(id, c);
	}
}

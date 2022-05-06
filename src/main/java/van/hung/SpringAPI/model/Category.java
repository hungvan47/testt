package van.hung.SpringAPI.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="categorys")
//@JsonIgnoreProperties(value={"referenceList", "handler","hibernateLazyInitializer"},ignoreUnknown = true,allowSetters = true)
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id_category")
	public int id_category;
	@JsonProperty("name")
	public String name;
	@JsonProperty("quantity")
	public int quantity;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	public List<Product>list_product=new ArrayList<Product>(12);
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public List<Product> getList_product() {
		return list_product;
	}
	public void setList_product(List<Product> list_product) {
		this.list_product = list_product;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int id_category, String name, int quantity, List<Product> list_product) {
		super();
		this.id_category = id_category;
		this.name = name;
		this.quantity = quantity;
		this.list_product = list_product;
	}
	
	
}

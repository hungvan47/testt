package van.hung.SpringAPI.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
@Table(name="products")
//@JsonIgnoreProperties(value={"referenceList", "handler","hibernateLazyInitializer"},ignoreUnknown = true,allowSetters = true)

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id_product")
	public int id_product;
	@JsonProperty("name")
	public String name;
	@JsonProperty("price")
	public float price;
	@JsonProperty("quantity")
	public int quantity;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_category")
	public Category category;
	
	@ManyToMany(mappedBy = "list_product")
	public List<Orders>list_order;

	public int getId_product() {
		return id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float f) {
		this.price = f;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Orders> getList_order() {
		return list_order;
	}

	public void setList_order(List<Orders> list_order) {
		this.list_order = list_order;
	}

	public Product(int id_product, String name, int price, int quantity, Category category, List<Orders> list_order) {
		super();
		this.id_product = id_product;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category= category;
		this.list_order = list_order;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}

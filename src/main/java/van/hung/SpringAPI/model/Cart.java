package van.hung.SpringAPI.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cart;
	private String title;
	private int quantity;
	private float total_price;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	List<Orders>list_order;

	public int getId_cart() {
		return id_cart;
	}

	public void setId_cart(int id_cart) {
		this.id_cart = id_cart;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public List<Orders> getList_order() {
		return list_order;
	}

	public void setList_order(List<Orders> list_order) {
		this.list_order = list_order;
	}

	public Cart(int id_cart, String title, int quantity, float total_price, List<Orders> list_order) {
		super();
		this.id_cart = id_cart;
		this.title = title;
		this.quantity = quantity;
		this.total_price = total_price;
		this.list_order = list_order;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

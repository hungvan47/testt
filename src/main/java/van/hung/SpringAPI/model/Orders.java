package van.hung.SpringAPI.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_order;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private float total_price;
	
	@ManyToMany
	@JoinTable(name="product_orders",
	joinColumns = @JoinColumn(name="order_id"),
	inverseJoinColumns = @JoinColumn(name="product_id"))
	private List<Product>list_product;
	
	@ManyToOne
	@JoinColumn(name="id_customer")
	private Customers customer;
	
	@ManyToOne
	@JoinColumn(name="id_cart")
	private Cart cart;
}

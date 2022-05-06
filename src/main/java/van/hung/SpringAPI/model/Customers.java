package van.hung.SpringAPI.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="customers")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_customer;
	private String address;
	private String email;
	private String name;
	private String phone;
	
	
	@ManyToOne
	@JoinColumn(name="id_admin")
	private admin admin;
	
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Orders>list_order;


	public int getId_customer() {
		return id_customer;
	}


	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public admin getAdmin() {
		return admin;
	}


	public void setAdmin(admin admin) {
		this.admin = admin;
	}


	public List<Orders> getList_order() {
		return list_order;
	}


	public void setList_order(List<Orders> list_order) {
		this.list_order = list_order;
	}


	public Customers(int id_customer, String address, String email, String name, String phone,
			van.hung.SpringAPI.model.admin admin, List<Orders> list_order) {
		super();
		this.id_customer = id_customer;
		this.address = address;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.admin = admin;
		this.list_order = list_order;
	}


	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

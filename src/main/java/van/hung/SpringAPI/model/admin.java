package van.hung.SpringAPI.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value={"referenceList", "handler","hibernateLazyInitializer"},allowSetters = true)
@Entity
@Table(name="admin")
public class admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_admin;
	private String name;
	private String password;
	
	@JsonProperty("admin")
	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
	List<Customers>list_customer;

	public int getId_admin() {
		return id_admin;
	}

	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Customers> getList_customer() {
		return list_customer;
	}

	public void setList_customer(List<Customers> list_customer) {
		this.list_customer = list_customer;
	}

	public admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public admin(int id_admin, String name, String password, List<Customers> list_customer) {
		super();
		this.id_admin = id_admin;
		this.name = name;
		this.password = password;
		this.list_customer = list_customer;
	}
	 
}

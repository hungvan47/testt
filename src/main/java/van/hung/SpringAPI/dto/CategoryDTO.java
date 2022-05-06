package van.hung.SpringAPI.dto;

public class CategoryDTO {
	private int id_category;
	private String name;
	private int quantity;
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
	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

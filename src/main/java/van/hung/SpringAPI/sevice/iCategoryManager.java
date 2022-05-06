package van.hung.SpringAPI.sevice;

import java.util.List;

import van.hung.SpringAPI.model.Category;

public interface iCategoryManager {
	public List<Category> getCategoryByName(String name);
	public List<Category>getAll();
	public boolean deleteCategory(int id);
	public Category addCategory(Category c);
	public int updateCategory(int id,Category c);
}

package van.hung.SpringAPI.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import van.hung.SpringAPI.model.Category;
import van.hung.SpringAPI.repository.CategoryRepository;
@Service
public class CategoryManagerImp implements iCategoryManager{
	@Autowired
	CategoryRepository categoryrepository;

	@Override
	public List<Category> getCategoryByName(String name) {
		// TODO Auto-generated method stub
		return categoryrepository.getCategoryByParam(name);
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return categoryrepository.getAll();
	}

	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		try {
			Category cdel=categoryrepository.getById(id);
			if(cdel!=null) {
				categoryrepository.delete(cdel);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return false;
	}

	@Override
	public Category addCategory(Category c) {
		// TODO Auto-generated method stub
		return categoryrepository.save(c);
	}


	@Override
	public int updateCategory(int id, Category c) {
		// TODO Auto-generated method stub
		try {
			Category cup=categoryrepository.getById(id);
			System.out.println("asdfasdf"+cup);
			if(cup!=null) {
				cup.setName(c.getName());
				cup.setQuantity(c.getQuantity());
				System.out.println(c.getId_category());
				
				categoryrepository.save(cup);
				return 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return 0;
	}

}

package van.hung.SpringAPI.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import van.hung.SpringAPI.model.Category;

@Transactional
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	//them
	@Query(value="insert into categorys values (:id,:name,:quantity)",nativeQuery = true)
	public Category addCategory(@Param("id") int id,@Param("name") String name,@Param("quantity") int quantity);
	
	//getByname
	@Query(value="select * from categorys where name like concat('%',:keysearch,'%')",nativeQuery = true)
	public List<Category>getCategoryByParam(@Param("keysearch") String keysearch);
	
	//getAll
	@Query(value="select id_category,name,quantity from categorys",nativeQuery = true)
	public List<Category>getAll();
	
	//delete
	@Query(value="delete from categorys where id_category=:keydel",nativeQuery = true)
	public boolean deleteCategory(@Param("keydel") int id);
	
	//update
	@Modifying
	@Query(value="update categorys set name=:nameNew, quantity=:numquantity where id_category=:keyup",nativeQuery = true)
	public int updateCategory(@Param("nameNew")String name,@Param("numquantity")int quantity,@Param("keyup")int id);
}

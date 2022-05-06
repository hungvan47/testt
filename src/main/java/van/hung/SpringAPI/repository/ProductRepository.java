package van.hung.SpringAPI.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import van.hung.SpringAPI.model.Product;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	//them
		@Query(value="insert into products values (:id,:name,:price,:quantity,:id_category)",nativeQuery = true)
		public Product addProduct(@Param("id") int id,@Param("name") String name,@Param("price") float price
				,@Param("quantity") int quantity,@Param("id_category") int id_category);
		
		//getByname
		@Query(value="select * from products where name like concat('%',:keysearch,'%')",nativeQuery = true)
		public List<Product>getProductByParam(@Param("keysearch") String keysearch);
		
		//getAll
		@Query(value="select id_product,name,price,quantity,id_category from products",nativeQuery = true)
		public List<Product>getAllProduct();
		
		//delete
		@Query(value="delete from products where id_product=:keydel",nativeQuery = true)
		public boolean deleteProduct(@Param("keydel") int id);
		
		//update
		@Modifying
		@Query(value="update products set name=:nameNew,price=:priceNew quantity=:quantityNew,:id_categoryNew where id_product=:keyup",nativeQuery = true)
		public int updateProduct(@Param("nameNew")String name,@Param("priceNew") float price,@Param("quantityNew")int quantity,@Param("id_categoryNew") int id_cotegory,@Param("keyup")int id);
}

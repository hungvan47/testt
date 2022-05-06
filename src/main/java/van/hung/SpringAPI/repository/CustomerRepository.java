package van.hung.SpringAPI.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import van.hung.SpringAPI.DTO.ProductDTO;
import van.hung.SpringAPI.model.Category;
import van.hung.SpringAPI.model.Customers;
import van.hung.SpringAPI.model.Product;

@Transactional
@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer>{
	//them
		@Query(value="insert into customers values (:id_customer,:address,:email,:name,:phone,:id_admin)",nativeQuery = true)
		public Customers addCustomers(@Param("id_customer") int id,@Param("address") String address,@Param("email") String email
				,@Param("name") String name,@Param("phone") String phone,@Param("id_admin")int id_admin);
		
		//getByname
		@Query(value="select * from customers where name like concat('%',:keysearch,'%')",nativeQuery = true)
		public List<Customers>getCustomerByParam(@Param("keysearch") String keysearch);
		
		//getAll
		@Query(value="select * from customers",nativeQuery = true)
		public List<Customers>getAllCustomer();
		
		//delete
		@Query(value="delete from Customers where id_customer=:keydel",nativeQuery = true)
		public boolean deleteCustomer(@Param("keydel") int id);
		
		//update
		@Modifying
		@Query(value="update products set address=:addressNew,email=:emailNew,name=:nameNew,phone=:phoneNew,id_admin=:id_adminNew where id_customer=:keyup",nativeQuery = true)
		public int updateCustomer(@Param("addressNew")String address,@Param("emailNew") String email,@Param("name")String name
				,@Param("phone") int phone,@Param("id_admin") int id_admin,@Param("keyup")int id);
}

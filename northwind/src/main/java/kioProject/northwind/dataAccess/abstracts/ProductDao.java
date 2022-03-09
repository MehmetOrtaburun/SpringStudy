package kioProject.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kioProject.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	// ismine göre ürünü çekeriz
	Product getByProductName(String productName); 
	
	// ürün adı ve categoryId ye göre where koşulu 
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	
	// ürün ismine göre veya categoyId ye göre where kosulu, tek data veya birden fazla data gelir
	List<Product> getByProductNameOrCategory(String productName, int categoryId);
	
	List<Product> getByCategoryIn(List<Integer> categories);
	
	// ürün isimleri içinde belirli bir ürün ismi geçenleri where ile listeler
	List<Product> getByProductNameContains(String productName);
	
	// ürün isimleri belirli bir kelime ile başlayıp belirli bir kelime ile biten 
	List<Product> getByProductNameStartsWith(String productName);
	
	// jpql yazımı; Bu Query yazımı için anotation kullanırız. Entity göre sql cümlesi yazarız. 
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")  
	List<Product> getByNameAndCategory(String productName, int categoryId);
	
	
	
	
	

}

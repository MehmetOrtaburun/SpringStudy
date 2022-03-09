package kioProject.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kioProject.northwind.business.abstracts.ProductService;
import kioProject.northwind.core.utilities.results.DataResult;
import kioProject.northwind.core.utilities.results.Result;
import kioProject.northwind.core.utilities.results.SuccessDataResult;
import kioProject.northwind.core.utilities.results.SuccessResult;
import kioProject.northwind.dataAccess.abstracts.ProductDao;
import kioProject.northwind.entities.concretes.Product;
import kioProject.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductManager(ProductDao productDao) {

		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {

		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(Product product) {

		this.productDao.save(product);

		return new SuccessResult("Ürün eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {

		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName), "Data listelendi");

	}

	@Override
	public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<Product>(
				this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory(productName, categoryId),
				"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),
				"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),
				"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId),
				"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<Product>> getAllSorted(String aramaKriteri) {

		Sort sort = Sort.by(Sort.Direction.DESC, aramaKriteri);
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort), "Başarılı");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(), "Data listelendi");
	}

}

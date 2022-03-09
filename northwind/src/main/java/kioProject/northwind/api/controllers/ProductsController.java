package kioProject.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kioProject.northwind.business.abstracts.ProductService;
import kioProject.northwind.core.utilities.results.DataResult;
import kioProject.northwind.core.utilities.results.Result;
import kioProject.northwind.entities.concretes.Product;
import kioProject.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	DataResult<List<Product>> getAll() {
		return this.productService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);

	}

	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}

	@GetMapping("/getByProductNameAndCategory_CategoryId")
	public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam("productName") String productName,
			@RequestParam("categoryId") int categoryId) {

		return this.productService.getByProductNameAndCategory(productName, categoryId);
	}

	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {

		return this.productService.getByProductNameContains(productName);

	}

	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(@RequestParam int pageNo, @RequestParam int pageSize) {

		return this.productService.getAll(pageNo, pageSize);
	}

	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted(@RequestParam String aramaKriteri) {
		return this.productService.getAllSorted(aramaKriteri);
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return this.productService.getProductWithCategoryDetails();
	}

}

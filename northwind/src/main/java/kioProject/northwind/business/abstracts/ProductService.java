package kioProject.northwind.business.abstracts;

import java.util.List;

import kioProject.northwind.entities.concretes.Product;

public interface ProductService {
	List<Product> getAll();

}

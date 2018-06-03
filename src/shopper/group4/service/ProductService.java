package shopper.group4.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import shopper.group4.entity.Category;
import shopper.group4.entity.Product;

public interface ProductService {
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void delete(int id);
	public List<Product> getAllProduct(int f,int l);
	public List<Product> getProductByCategory(int idCategory,int f,int l);
	public Product getProduct(int id);
	public Category getCate(int id);
	public List<Product>findByName(String productName);
	public List<Product>topSale(int f,int l);
	public List<Category>getCategory();
}

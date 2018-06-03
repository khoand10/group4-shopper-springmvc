package shopper.group4.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopper.group4.dao.ProductDAO;
import shopper.group4.entity.Category;
import shopper.group4.entity.Product;
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public void addProduct(Product product) {
		productDAO.addProduct(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
		
	}

	@Override
	public void delete(int id) {
		productDAO.delete(id);
		
	}

	@Override
	public List<Product> getAllProduct(int f,int l) {
		return productDAO.getAllProduct(f,l);
	}

	@Override
	public List<Product> getProductByCategory(int idCategory,int f,int l) {
		return productDAO.getProductByCategory(idCategory,f,l);
	}

	@Override
	public Product getProduct(int id) {
		return (Product) this.productDAO.getProduct(id);
	}

	@Override
	public List<Product> findByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getCategory() {
		return productDAO.getCategory();
	}

	@Override
	public List<Product> topSale(int f,int l) {
		return productDAO.topSale(f,l);
	}

	@Override
	public Category getCate(int id) {
		return productDAO.getCate(id);
	}

}

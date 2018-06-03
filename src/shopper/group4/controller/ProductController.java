package shopper.group4.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shopper.group4.dao.ProductDAOImpl;
import shopper.group4.dao.UsersDAOImpl;
import shopper.group4.entity.Category;
import shopper.group4.entity.Product;
import shopper.group4.entity.Users;
import shopper.group4.service.ProductService;
import shopper.group4.service.UsersService;

@Controller
@RequestMapping("/home/")
//@RequestMapping(value="/home")
public class ProductController {
	@Autowired
	//ServletContext application;
	
	ProductService productService;
	@RequestMapping("index")
	public String loadIndex(HttpSession sessionn) {
		List<Product>listpro1 = productService.getProductByCategory(01,0,4);
		List<Product>listpro2 = productService.getProductByCategory(01,4,4);
		List<Product>listpro3 = productService.getProductByCategory(02,0,4);
		List<Product>listpro4 = productService.getProductByCategory(02,4,4);
		List<Category>list = productService.getCategory();
		sessionn.setAttribute("listCategory", list);
		sessionn.setAttribute("product1", listpro1);
		sessionn.setAttribute("product2", listpro2);
		sessionn.setAttribute("product3", listpro3);
		sessionn.setAttribute("product4", listpro4);
		return "home/index";
	}
	
	//all product page
	@RequestMapping(value="product_all")
	public String loadPageProduct(@RequestParam(value="page",defaultValue="1",required=true)String page,ModelMap model) {
		switch (page) {
		case "1":{
			List<Product>listPage1=productService.getAllProduct(0, 9);
			model.addAttribute("page1",listPage1);
			break;
		}
		case "2":{
			List<Product>listPage2=productService.getAllProduct(8, 9);
			model.addAttribute("page1",listPage2);
			break;
		}
		case "3":{
			List<Product>listPage3=productService.getAllProduct(17, 9);
			model.addAttribute("page1",listPage3);
			break;
		}
		default:
			List<Product>listPage1=productService.getAllProduct(0, 9);
			model.addAttribute("page1",listPage1);
			break;
		}
		return "home/product";
	}
	
	//product_detail page
	@RequestMapping("product_detail")
	public String productDetail(@RequestParam("id_product")int id_product,HttpSession session) {
		Product product=productService.getProduct(id_product);
		session.setAttribute("product_detail",product);
		return "home/product-detail";
	}
	
	//product theo category
	@RequestMapping("product_category")
	public String loadProductTheoCategory(@RequestParam("id_category")int id_category,ModelMap model,
			@RequestParam(value="page",defaultValue="1",required=true)String page
			) {
		model.addAttribute("idcate",id_category);
		switch (page) {
		case "1":{
			List<Product>listPage1=productService.getProductByCategory(id_category, 0, 9);
			model.addAttribute("page1",listPage1);
			break;
		}
		case "2":{
			List<Product>listPage2=productService.getProductByCategory(id_category, 8, 9);
			model.addAttribute("page1",listPage2);
			break;
		}
		case "3":{
			List<Product>listPage3=productService.getProductByCategory(id_category, 17, 9);
			model.addAttribute("page1",listPage3);
			break;
		}
		default:
			List<Product>listPage1=productService.getAllProduct(0, 9);
			model.addAttribute("page1",listPage1);
			break;
		}
		return "home/product-category";
	}
	@RequestMapping("product_bestSeller")
	public String loadBestSeller(@RequestParam(value="page",defaultValue="1",required=true)String page,ModelMap model) {
		switch (page) {
		case "1":{
			List<Product>listPage1=productService.topSale(0,9);
			model.addAttribute("page1",listPage1);
			break;
		}
		case "2":{
			List<Product>listPage2=productService.topSale(8,9);
			model.addAttribute("page1",listPage2);
			break;
		}
		case "3":{
			List<Product>listPage3=productService.topSale(17, 9);
			model.addAttribute("page1",listPage3);
			break;
		}
		default:
			List<Product>listPage1=productService.getAllProduct(0, 9);
			model.addAttribute("page1",listPage1);
			break;
		}
		return "home/product-topsale";
	}
	@RequestMapping("admin/product")
	public String loadProduct(ModelMap model,@RequestParam(value="page",defaultValue="1",required=true)String page,
			HttpSession session
			) {
		switch (page) {
		case "1":{
			List<Product>listPage1=productService.getAllProduct(0, 9);
			model.addAttribute("listproduct",listPage1);
			break;
		}
		case "2":{
			List<Product>listPage2=productService.getAllProduct(8, 9);
			model.addAttribute("listproduct",listPage2);
			break;
		}
		case "3":{
			List<Product>listPage3=productService.getAllProduct(17, 9);
			model.addAttribute("listproduct",listPage3);
			break;
		}
		default:
			List<Product>listPage1=productService.getAllProduct(0, 9);
			model.addAttribute("listproduct",listPage1);
			break;
		}
		model.addAttribute("product_input",new Product());
		List<Category>list = productService.getCategory();
		session.setAttribute("listCate", list);
		return "admin/product";
	}
	
	@RequestMapping(value = "admin/editpro/{id_product}", method = RequestMethod.GET)
	public String addCountry(@ModelAttribute("id_product")int id, ModelMap model) {
		Product product =productService.getProduct(id);
		model.addAttribute("product_input",product);
		List<Product>list=productService.getAllProduct(0, 9);
		model.addAttribute("listproduct",list);
		return "admin/product";
	}
	
	@RequestMapping(value = "admin/deletepro/{id_product}", method = RequestMethod.GET)
	public String delete(@PathVariable("id_product")int id) {
		productService.delete(id);
		return "redirect:product.htm";
	}
	@RequestMapping(value ="admin/addpro", method = RequestMethod.POST)
	public String addCountry(@RequestParam("link")String linkimages,ModelMap model,
			@RequestParam("productname")String name,
			@RequestParam("fabrication")String fabrication,
			@RequestParam("color")String color,
			@RequestParam("images")String images,
			@RequestParam("depcriptions")String depcriptions,
			@RequestParam("amount")int amount,
			@RequestParam("unitprice")int unitprice,
			@RequestParam("discount")int discount,
			@RequestParam("id_product")int id_product,
			@RequestParam("category")int id_category
			) {
		Product product1 = productService.getProduct(id_product);
		Product product = new Product();
		product.setImages("/Shopper/themes/images/ladies/"+linkimages);
		product.setProductname(name);
		product.setFabrication(fabrication);
		product.setColor(color);
		product.setDepcriptions(depcriptions);
		product.setAmount(amount);
		product.setUnitprice(unitprice);
		product.setDiscount(discount);
		Category cate = productService.getCate(id_category);
		product.setCategory(cate);
		cate.getProducts().add(product);
		if(product1==null) {
			productService.addProduct(product);
		}else {
			product.setId_product(id_product);
			productService.updateProduct(product);
		}
		return "redirect:product.htm";
} 
	
}

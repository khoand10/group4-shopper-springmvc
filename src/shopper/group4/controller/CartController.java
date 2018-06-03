package shopper.group4.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shopper.group4.entity.Bills;
import shopper.group4.entity.Cart;
import shopper.group4.entity.Cartdetail;
import shopper.group4.entity.Category;
import shopper.group4.entity.Product;
import shopper.group4.entity.Users;
import shopper.group4.service.CartService;
import shopper.group4.service.ProductService;
import shopper.group4.service.ProductServiceImpl;
import shopper.group4.service.UsersService;
import shopper.group4.service.UsersServiceImpl;

@Transactional
@Controller
@RequestMapping("/home/")
public class CartController {
	
	@Autowired CartService cartService;
	
	//@SuppressWarnings({ "unchecked", "unused" })
	@RequestMapping(value="addToCart",method=RequestMethod.POST)
	public String addToCart(HttpSession session,HttpServletResponse response,
			@RequestParam("UserName")String id_user,
			@RequestParam("size")String size,
			@RequestParam("moneys")int moneys,
			@RequestParam(value="Id_cart",defaultValue="13",required=true)int Id_cart,
			@CookieValue(value="id_cart_anonymust",defaultValue="13",required=false)int id_cart_anonymust,
			@RequestParam("amount")int amount,HttpServletRequest request
			) {
		Product product = (Product)session.getAttribute("product_detail");
		if(13==Id_cart) {
			if(id_cart_anonymust==13) {

				Cart cart = cartService.getCart(2);
				Cartdetail cartdetail = new Cartdetail(size, amount, moneys,1);
				cartdetail.setProduct(product);
				product.getCarts().add(cartdetail);
				cartdetail.setCart(cart);
				cart.getCarts().add(cartdetail);
				cartService.add(cartdetail);
				String id="2";
				Cookie cookie = new Cookie("id_cart_anonymust", id);
				response.addCookie(cookie);
				return "redirect:cart-info.htm?Id_cart="+id+"";
			}else {
				Cartdetail c = cartService.getCartdetailWithPro(product.getId_product(),id_cart_anonymust);
				if(c==null) {
				Cart cart = cartService.getCart(id_cart_anonymust);
				Cartdetail cartdetail = new Cartdetail(size, amount, moneys,1);
				cartdetail.setProduct(product);
				product.getCarts().add(cartdetail);
				cartdetail.setCart(cart);
				cart.getCarts().add(cartdetail);
				cartService.add(cartdetail);
				}else {
					c.setAmount(amount+c.getAmount());
					cartService.update(c);
				}
				return "redirect:cart-info.htm?Id_cart="+id_cart_anonymust+"";
			}
		}else {
			Cartdetail c = cartService.getCartdetailWithPro(product.getId_product(),Id_cart);
			if(c==null) {
			Cart cart = cartService.getCart(Id_cart);
			Cartdetail cartdetail = new Cartdetail(size, amount, moneys,1);
			cartdetail.setProduct(product);
			product.getCarts().add(cartdetail);
			cartdetail.setCart(cart);
			cart.getCarts().add(cartdetail);
			cartService.add(cartdetail);
			}else {
				c.setAmount(amount+c.getAmount());
				cartService.update(c);
			}
			return "redirect:cart-info.htm?Id_cart="+Id_cart+"";
		}
	}
	
	@RequestMapping("cart-info")
	public String cartInfo(@RequestParam(value="Id_cart",defaultValue="13",required=true)int Id_cart,HttpSession session,HttpServletRequest request,
			@CookieValue(value="id_cart_anonymust",defaultValue="13",required=false)int id_cart_anonymust
			) {
		if(Id_cart==13) {
			if(id_cart_anonymust==13) {
				List<Cartdetail>list = new ArrayList<Cartdetail>();
				session.setAttribute("list", list);
			}else {
			List<Cartdetail>list = cartService.getAll(id_cart_anonymust,1);
			session.setAttribute("list", list);
			int total=0;
			for(Cartdetail cart:list) {
				total+=cart.getMoneys()*cart.getAmount();
			}
			session.setAttribute("total", total);
			session.setAttribute("Id_cart", id_cart_anonymust);
			}
		}else {
		List<Cartdetail>list = cartService.getAll(Id_cart,1);
		session.setAttribute("list", list);
		int total=0;
		for(Cartdetail cart:list) {
			total+=cart.getMoneys()*cart.getAmount();
		}
		session.setAttribute("total", total);
		session.setAttribute("Id_cart", Id_cart);
		}
		return "home/cart";
	}
	@RequestMapping("delete-product")
	public String deleteCart(@RequestParam("id_cartdetail")int id_cart,HttpSession session) {
		cartService.delete(cartService.getCartdetail(id_cart));
		return "redirect:cart-info.htm?Id_cart="+session.getAttribute("Id_cart")+"";
	}
	
	@RequestMapping("willBuy")
	public String checkout(@RequestParam(value="Id_cart",defaultValue="13",required=true)int Id_cart,HttpSession session,
			@RequestParam(value="Id_cartdetail",defaultValue="13",required=true)int[] id_cartdetail,
			@CookieValue(value="id_cart_anonymust",defaultValue="13",required=false)int id_cart_anonymust
			) {
		if(Id_cart==13) {
			if(id_cart_anonymust==13) {
				return "redirect:index.htm";
			}else {
				for (int i : id_cartdetail) {
					Cartdetail ct= cartService.getCartdetail(i);
					ct.setStatus(2);
					cartService.update(ct);
				}
				session.setAttribute("list", cartService.getAll(id_cart_anonymust,2));
				int total=0;
				for(Cartdetail cart:cartService.getAll(id_cart_anonymust,2)) {
					total+=cart.getMoneys()*cart.getAmount();
				}
				session.setAttribute("total", total);
				session.setAttribute("Id_cart", id_cart_anonymust);
			}
		}else {
		for (int i : id_cartdetail) {
			Cartdetail ct= cartService.getCartdetail(i);
			ct.setStatus(2);
			cartService.update(ct);
		}	
		session.setAttribute("infor-user",session.getAttribute("user"));
		session.setAttribute("list", cartService.getAll(Id_cart,2));
		int total=0;
		for(Cartdetail cart:cartService.getAll(Id_cart,2)) {
			total+=cart.getMoneys()*cart.getAmount();
		}
		session.setAttribute("total", total);
		session.setAttribute("Id_cart", Id_cart);
		}
		return "home/check-out";
	}
	@RequestMapping("cancle")
	public String cancle(@RequestParam("Id_cancle")int[] Id_cancle,
			@RequestParam(value="Id_cart")int Id_cart,
			@CookieValue(value="id_cart_anonymust",defaultValue="13",required=false)int id_cart_anonymust
			) {
		for (int i : Id_cancle) {
			Cartdetail ct= cartService.getCartdetail(i);
			ct.setStatus(1);
			cartService.update(ct);
		}
			return "redirect:cart-info.htm?Id_cart="+Id_cart+"";
	}
	@RequestMapping("checkout")
	public String checkout(@RequestParam("fullname")String fullname,
			@RequestParam("address")String address,
			@RequestParam("phone")String phone,
			@RequestParam("notes")String notes,
			@RequestParam("total")int total,
			@RequestParam("Id_cancle")int[] Id_cancle, //thay bang getParametervalue("Id_cancle") se luu 
			@RequestParam("Id_cart")int Id_cart,ModelMap model
			
			) {
		Bills bills = cartService.getCart(Id_cart).getBills();
		bills.setFullname(fullname);
		bills.setAddress(address);
		bills.setPhone(phone);
		bills.setNote(notes);
		bills.setTotals(total);
		cartService.updateBills(bills);
		for (int i : Id_cancle) {
			Cartdetail ct= cartService.getCartdetail(i);
			ct.setStatus(3);
			cartService.update(ct);
		}
		model.addAttribute("message","success");
		return "home/buysuccess";
	}
	@RequestMapping("admin/cart")
	public String loadProduct(ModelMap model,
			HttpSession session
			) {
		session.setAttribute("listcart", cartService.getAllCart());
		return "admin/cart";
	}
	@RequestMapping(value = "admin/deletecart/{id_cart}", method = RequestMethod.GET)
	public String delete(@PathVariable("id_cart")int id) {
		cartService.delete(cartService.getCartdetail(id));
		return "redirect:/home/admin/cart.htm";
	}
	
/*	@RequestMapping(value = "admin/editpro/{id_product}", method = RequestMethod.GET)
	public String addCountry(@ModelAttribute("id_product")int id, ModelMap model) {
		Product product =productService.getProduct(id);
		model.addAttribute("product_input",product);
		List<Product>list=productService.getAllProduct(0, 9);
		model.addAttribute("listproduct",list);
		return "admin/product";
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
	*/
	
	
}

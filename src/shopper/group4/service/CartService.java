package shopper.group4.service;

import java.util.List;

import shopper.group4.entity.Bills;
import shopper.group4.entity.Cart;
import shopper.group4.entity.Cartdetail;

public interface CartService {
	public void add(Cartdetail cartdetail);
	public void delete(Cartdetail cartdetail);
	public List<Cartdetail> getAll(int Id_cart,int status); 
	public List<Cartdetail> getAllCart(); 
	public void update(Cartdetail cartdetail);
	public void updateBills(Bills bills);
	public Cartdetail getCartdetail(int id_cartdetail);
	public Cart getCart(int Id_cart);
	public Bills getBills(int id_bills);
	public Cartdetail getCartdetailWithPro(int id_product,int id_cart);
}

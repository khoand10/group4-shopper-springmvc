package shopper.group4.dao;

import java.util.List;

import shopper.group4.entity.Bills;
import shopper.group4.entity.Cart;
import shopper.group4.entity.Cartdetail;

public interface CartDAO {
	public void add(Cartdetail cartdetail);
	public void delete(Cartdetail cartdetail);
	public List<Cartdetail> getAll(int Id_Cart,int status); 
	public List<Cartdetail> getAllCart(); 
	public void update(Cartdetail cartdetail);
	public void updateBills(Bills bills);
	public Cartdetail getCartdetail(int id_cartdetail);
	public Cartdetail getCartdetailWithPro(int id_product,int id_cart);
	public Cart getCart(int id_cart);
	public Bills getBills(int id_bills);
}

package shopper.group4.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopper.group4.dao.CartDAO;
import shopper.group4.entity.Bills;
import shopper.group4.entity.Cart;
import shopper.group4.entity.Cartdetail;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService{

	@Autowired CartDAO cartDAO;
	
	@Override
	public void add(Cartdetail cartdetail) {
		cartDAO.add(cartdetail);
		
	}

	@Override
	public void delete(Cartdetail cartdetail) {
		cartDAO.delete(cartdetail);
		
	}

	@Override
	public List<Cartdetail> getAll(int Id_cart,int status) {
		return cartDAO.getAll(Id_cart,status);
	}

	@Override
	public void update(Cartdetail cartdetail) {
		cartDAO.update(cartdetail);
		
	}

	@Override
	public Cartdetail getCartdetail(int id_cartdetail) {
		return cartDAO.getCartdetail(id_cartdetail);
	}

	@Override
	public Cart getCart(int Id_cart) {
		return cartDAO.getCart(Id_cart);
	}

	@Override
	public Cartdetail getCartdetailWithPro(int id_product,int id_cart) {
		return cartDAO.getCartdetailWithPro(id_product,id_cart);
	}

	@Override
	public void updateBills(Bills bills) {
		cartDAO.updateBills(bills);
	}

	@Override
	public Bills getBills(int id_bills) {
		return cartDAO.getBills(id_bills);
	}

	@Override
	public List<Cartdetail> getAllCart() {
		 return cartDAO.getAllCart();
	}

}

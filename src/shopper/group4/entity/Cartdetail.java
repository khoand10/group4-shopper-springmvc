package shopper.group4.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cartdetail")
public class Cartdetail {
	@Id
	@GeneratedValue
	private int Id_cartdetail;
	private String size;
	private int amount;
	private int moneys;
	private int status;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Id_Product")
	private Product product;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Id_Cart")
	private Cart cart;
	
	public Cartdetail() {
		// TODO Auto-generated constructor stub
	}

	public Cartdetail(String size, int amount, int moneys,int status) {
		super();
		this.size = size;
		this.amount = amount;
		this.moneys = moneys;
		this.status=status;
	}

	
	
	public int getId_cartdetail() {
		return Id_cartdetail;
	}

	public void setId_cartdetail(int id_cartdetail) {
		Id_cartdetail = id_cartdetail;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getMoneys() {
		return moneys;
	}

	public void setMoneys(int moneys) {
		this.moneys = moneys;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
}
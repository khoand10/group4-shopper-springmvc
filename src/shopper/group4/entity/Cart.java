package shopper.group4.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class Cart {
	@Id
	@GeneratedValue
	private int id_cart;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Id_bills")
	private Bills bills;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="UserName")
	private Users user;
	
	@OneToMany(mappedBy="cart",fetch=FetchType.EAGER)
	private Set<Cartdetail>carts = new HashSet<Cartdetail>();
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(Bills bills) {
		super();
		this.bills = bills;
	}

	public Cart(int id_cart, Bills bills, Users user, Set<Cartdetail> carts) {
		super();
		this.id_cart = id_cart;
		this.bills = bills;
		this.user = user;
		this.carts = carts;
	}

	public int getId_cart() {
		return id_cart;
	}

	public void setId_cart(int id_cart) {
		this.id_cart = id_cart;
	}

	public Bills getBills() {
		return bills;
	}

	public void setBills(Bills bills) {
		this.bills = bills;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Set<Cartdetail> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cartdetail> carts) {
		this.carts = carts;
	}
	
	
	
}
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
@Table(name="Product")
public class Product {
	@Id
	@GeneratedValue
	private int id_product;
	private String productname;
	private String fabrication;
	private String color;
	private String images;	
	private String depcriptions;
	private int amount;
	private int unitprice;
	private int discount;
	@ManyToOne
	@JoinColumn(name="ID_category")
	private Category category;
	
	@OneToMany(mappedBy="product",fetch=FetchType.EAGER)
	private Set<Cartdetail>cartdetails = new HashSet<Cartdetail>();
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int id_product, String productname, String fabrication, String color, String images,
			String depcriptions, int amount, int unitprice, int discount) {
		super();
		this.id_product = id_product;
		this.productname = productname;
		this.fabrication = fabrication;
		this.color = color;
		this.images = images;
		this.depcriptions = depcriptions;
		this.amount = amount;
		this.unitprice = unitprice;
		this.discount = discount;
	}
	
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getFabrication() {
		return fabrication;
	}
	public void setFabrication(String fabrication) {
		this.fabrication = fabrication;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getDepcriptions() {
		return depcriptions;
	}
	public void setDepcriptions(String depcriptions) {
		this.depcriptions = depcriptions;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Set<Cartdetail> getCartdetails() {
		return cartdetails;
	}
	public void setCartdetails(Set<Cartdetail> cartdetails) {
		this.cartdetails = cartdetails;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Cartdetail> getCarts() {
		return cartdetails;
	}
	public void setCarts(Set<Cartdetail> carts) {
		this.cartdetails = carts;
	}
	
}
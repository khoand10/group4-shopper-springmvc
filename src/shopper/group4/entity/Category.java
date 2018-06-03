package shopper.group4.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue
	private int id_category;
	private String name_category;
	@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
	private Set<Product>products = new HashSet<Product>();
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(int id_category, String name_category) {
		super();
		this.id_category = id_category;
		this.name_category = name_category;
	}
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public String getName_category() {
		return name_category;
	}
	public void setName_category(String name_category) {
		this.name_category = name_category;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Category [id_category=" + id_category + ", name_category=" + name_category + "]";
	}
}

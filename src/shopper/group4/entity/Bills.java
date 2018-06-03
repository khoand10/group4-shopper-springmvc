package shopper.group4.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Bills")
public class Bills {
	@Id
	@GeneratedValue
	private int Id_bills;
	private String fullname;
	private String address;
	private String phone;
	private String note;
	private int totals;
	private String status;
	
	@OneToMany(mappedBy="bills",fetch=FetchType.EAGER)
	private Set<Cart>carts = new HashSet<Cart>();
	public Bills() {
		// TODO Auto-generated constructor stub
	}
	public Bills(int id_bills, String fullname, String address, String phone, String note, int totals, String status,
			Set<Cart> carts) {
		super();
		Id_bills = id_bills;
		this.fullname = fullname;
		this.address = address;
		this.phone = phone;
		this.note = note;
		this.totals = totals;
		this.status = status;
		this.carts = carts;
	}
	public int getId_bills() {
		return Id_bills;
	}
	public void setId_bills(int id_bills) {
		Id_bills = id_bills;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getTotals() {
		return totals;
	}
	public void setTotals(int totals) {
		this.totals = totals;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<Cart> getCarts() {
		return carts;
	}
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}
	
}

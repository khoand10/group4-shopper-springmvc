package shopper.group4.entity;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.validator.constraints.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/*
table users
mapping with table users of database
 */
@Entity
@Table(name="Users")
public class Users {
	@Id
	@NotBlank(message="Không được để trống họ và tên !")
	private String username;
	@NotBlank(message="Không được để trống pass word !")
	private String password;
	@Email(message="Email không hợp lệ!")
	private String email;
	@NotBlank(message="Không được để trống address !")
	private String address;
	@NotBlank(message="Không được để trống phone !")
	private String phone;
	@NotBlank(message="Không được để trống fullname !")
	private String fullname;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="mm/dd/yyyy")
	private Date birthday;
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
	private Collection<Cart>carts = new HashSet<Cart>();
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	public Users(String username, String password, String email, String address, String phone, String fullname,
			Date birthday) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.fullname = fullname;
		this.birthday = birthday;
	}
	public Users(String username, String password, String email, String address, String phone, String fullname,
			Date birthday, Set<Cart> carts) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.fullname = fullname;
		this.birthday = birthday;
//		this.carts = carts;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}
	public Collection<Cart> getCarts() {
		return carts;
	}
	
}
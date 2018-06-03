package shopper.group4.dao;

import java.util.List;

import shopper.group4.entity.Admin;
import shopper.group4.entity.Users;

public interface UsersDAO {
	public void addUsers(Users users);
	public void updateUsers(Users users);
	public void delete(String uname);
	public List<Users> getAllUsers();
	public Users getUsers(String uname);
	public Users checkLogin(String uname,String pass);
	public List<Users>findUsersByName(String fullName);
	public Admin getAdmin(String uname);
}

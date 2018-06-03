package shopper.group4.service;

import java.util.List;

import shopper.group4.entity.Admin;
import shopper.group4.entity.Users;

public interface UsersService {
	public void addUsers(Users users);
	public void updateUsers(Users users);
	public void delete(String uname);
	public List<Users> getAllUsers();
	public Users getUsers(String uname);
	public Users checkLogin(String uname,String pass);
	public List<Users>findUsersByName(String fullName);
	public Admin getAdmin(String uname);
}

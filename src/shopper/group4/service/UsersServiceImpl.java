package shopper.group4.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopper.group4.dao.UsersDAO;
import shopper.group4.entity.Admin;
import shopper.group4.entity.Users;
@Service("userService")
@Transactional
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersDAO usersDAO;
	@Override
	public void addUsers(Users users) {
		usersDAO.addUsers(users);
		
	}

	@Override
	public void updateUsers(Users users) {
		usersDAO.updateUsers(users);
		
	}

	@Override
	public void delete(String uname) {
		usersDAO.delete(uname);
		
	}

	@Override
	public List<Users> getAllUsers() {
		return usersDAO.getAllUsers();
	}

	@Override
	public Users getUsers(String uname) {
		return usersDAO.getUsers(uname);
	}

	@Override
	public List<Users> findUsersByName(String fullName) {
		return usersDAO.findUsersByName(fullName);
	}

	@Override
	public Users checkLogin(String uname, String pass) {
		return usersDAO.checkLogin(uname, pass);
	}

	@Override
	public Admin getAdmin(String uname) {
		return usersDAO.getAdmin(uname);
	}

}

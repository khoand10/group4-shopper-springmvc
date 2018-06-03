package shopper.group4.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shopper.group4.entity.Admin;
import shopper.group4.entity.Users;

@Repository
public class UsersDAOImpl implements UsersDAO{

	private static final Admin Admin = null;
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void addUsers(Users users) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(users);
	}

	@Override
	public void updateUsers(Users users) {
		Session session = sessionFactory.getCurrentSession();
		session.update(users);
	}

	@Override
	public void delete(String uname) {
		Session session = sessionFactory.getCurrentSession();
		Users user = (Users)session.load(Users.class, uname);
		if(null!=user)session.delete(user);
		
	}

	@Override
	public List<Users> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Users.class);
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return cr.list();
	}

	@Override
	public Users getUsers(String uname) {
		Session session = sessionFactory.getCurrentSession();
		return (Users)session.get(Users.class, uname);
	}

	@Override
	public List<Users> findUsersByName(String fullName) {
		return null;
	}

	@Override
	public Users checkLogin(String uname, String pass) {
		Session session = sessionFactory.getCurrentSession();
//		String hql = "FROM USERS USER WHERE USER.USERNAME= :USERNAME AND USER.PASSWORD= :PASSWORD";
//		Query query = session.createQuery(hql);
//		query.setParameter("USERNAME",uname);
//		query.setParameter("PASSWORD", pass);
//		query.ex
		Users user = getUsers(uname);
		if(uname.equals(user.getUsername()) && pass.equals(user.getPassword())){
			return user;
		}else {
			return null;
		}
	}

	@Override
	public Admin getAdmin(String uname) {
		Session session = sessionFactory.getCurrentSession();
		return (Admin)session.get(Admin.class, uname);
	}

}

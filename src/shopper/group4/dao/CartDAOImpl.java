package shopper.group4.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shopper.group4.entity.Bills;
import shopper.group4.entity.Cart;
import shopper.group4.entity.Cartdetail;
import shopper.group4.entity.Users;
@Repository
public class CartDAOImpl implements CartDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	public void add(Cartdetail cartdetail) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(cartdetail);
	}

	@Override
	public void delete(Cartdetail cartdetail) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartdetail);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cartdetail> getAll(int Id_cart,int status) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Cartdetail c WHERE c.cart="+Id_cart+" and c.status="+status+"";
		Query query=session.createQuery(hql);
		return query.list();
	}

	@Override
	public void update(Cartdetail cartdetail) {
		Session session = sessionFactory.getCurrentSession();
		session.update(cartdetail);
	}
	@Override
	public Cartdetail getCartdetail(int id_cartdetail) {
		Session session = sessionFactory.getCurrentSession();
		return (Cartdetail)session.get(Cartdetail.class, id_cartdetail);
	}
	@Override
	public Cart getCart(int id_cart) {
		Session session = sessionFactory.getCurrentSession();
		return (Cart)session.get(Cart.class, id_cart);
	}
	@Override
	public Cartdetail getCartdetailWithPro(int id_product,int id_cart) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Cartdetail c where c.product="+id_product+"and c.cart="+id_cart+"";
		Query query=session.createQuery(hql);
		return (Cartdetail)query.uniqueResult();
	}
	@Override
	public void updateBills(Bills bills) {
		Session session = sessionFactory.getCurrentSession();
		session.update(bills);
	}
	@Override
	public Bills getBills(int id_bills) {
		Session session = sessionFactory.getCurrentSession();
		return (Bills)session.get(Bills.class, id_bills);
	}
	@Override
	public List<Cartdetail> getAllCart() {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Cartdetail.class);
		return cr.list();
	}

}

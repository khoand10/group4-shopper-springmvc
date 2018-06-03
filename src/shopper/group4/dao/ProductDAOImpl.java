package shopper.group4.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shopper.group4.entity.Category;
import shopper.group4.entity.Product;
@Repository
public class ProductDAOImpl implements ProductDAO<Product> {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	public void addProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(product);
	}

	@Override
	public void updateProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(product);
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product p = (Product) session.load(Product.class, id);
		if (null != p) {
			session.delete(p);
		}
		
	}

	@Override
	public List getAllProduct(int f,int l) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Product p ORDER BY p.id_product DESC ";
		Query query=session.createQuery(hql);
		query.setFirstResult(f);
		query.setMaxResults(l);
		return query.list();
	}

	@Override
	public Product getProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Product)session.get(Product.class, id);
	}

	@Override
	public List<Product> findByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductByCategory(int idCategory,int f,int l) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Product E WHERE E.category = "+idCategory+"";
		Query query=session.createQuery(hql);
		query.setFirstResult(f);
		query.setMaxResults(l);
		return query.list();
	}
	@Override
	public List<Category> getCategory() {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Category.class);
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Category>list=cr.list();
		return list;
	}
	@Override
	public List<Product> topSale(int f,int l){
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Product p ORDER BY p.discount DESC";
		Query query=session.createQuery(hql);
		query.setFirstResult(f);
		query.setMaxResults(l);
		return query.list();
	}
	@Override
	public Category getCate(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Category)session.get(Category.class, id);
	}
	
}

package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import model.KeyList;
import model.Users;
import view.UserView;

@Transactional
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(user);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	@Override
	public void updateUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(user);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> userList() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Users> users = null;
		try {
			users = (List<Users>) session.createQuery("FROM Users").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return users;
	}

	@Override
	public Users getUserByUID(String uid) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Users user = null;
		try {
			Query hql = session.createQuery("FROM Users WHERE uid like'" + uid + "'");
			user = (Users) hql.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return user;
	}

	@Override
	public void updateKeyList(KeyList keylist) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(keylist);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserView getUserView(String uid) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Object[] objects = null;
		UserView view = new UserView();
		try {
			Query hql = session.createQuery("FROM Users u, KeyList k WHERE u.uid = k.uid AND k.uid='" + uid + "'");
			objects = (Object[]) hql.uniqueResult();

			Users u = (Users) objects[0];
			KeyList k = (KeyList) objects[1];
			view.setViewUid(u.getUid());
			view.setViewUname(u.getUname());
			view.setViewUrankId("" + u.getRanks().getId());
			view.setViewUrankDes(u.getRanks().getDes());
			view.setViewUdept(u.getDepartment().getDes());
			view.setViewUstatus("" + u.getStatus());
			view.setViewUpass(k.getKeyss());
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return view;
	}

}

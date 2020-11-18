package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import model.KeyList;
import model.LoginList;
import model.StudentBio;
import model.Users;
import view.LoginView;

@Transactional
public class LoginDAOImpl implements LoginDAO {

	private SessionFactory sessionFactory;

	public LoginDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public KeyList getKeyList(String uid) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		KeyList keylist = null;
		try {
			Query hql = session.createQuery("from KeyList where uid='" + uid + "'");
			keylist = (KeyList) hql.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return keylist;
	}

	@Override
	public LoginView getUser(String uid) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Object[] objects = null;
		LoginView view = new LoginView();
		try {
			Query hql = session.createQuery("FROM Users u, KeyList k WHERE u.uid=k.uid AND k.uid='" + uid + "'");
			objects = (Object[]) hql.uniqueResult();
			Users u = (Users) objects[0];
			KeyList k = (KeyList) objects[1];
			view.setViewUid(k.getUid());
			view.setViewPassword(k.getKeyss());
			view.setViewName(u.getUname());
			view.setViewRank(u.getRanks().getDes());
			view.setViewStatus(String.valueOf(u.getStatus()));
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return view;
	}

	@Override
	public LoginView getStudent(String uid) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Object[] objects = null;
		LoginView view = new LoginView();
		try {
			Query hql = session.createQuery("FROM StudentBio s, KeyList k WHERE s.uid=k.uid AND k.uid='" + uid + "'");
			objects = (Object[]) hql.uniqueResult();
			StudentBio s = (StudentBio) objects[0];
			KeyList k = (KeyList) objects[1];
			view.setViewUid(k.getUid());
			view.setViewPassword(k.getKeyss());
			view.setViewName(s.getNamee());
			view.setViewRank("Student");
			view.setViewStatus(s.getStatus());
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return view;
	}

	@Override
	public void addLogin(LoginList loginList) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(loginList);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	@Override
	public void updateLogin(LoginList loginList) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(loginList);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}
	
	@Override
	public LoginList getLogin(String loginId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		LoginList loginList = null;
		try {
			Query hql = session.createQuery("FROM LoginList where loginid='" + loginId + "'");
			loginList = (LoginList) hql.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return loginList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LoginList> getLoginList() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<LoginList> loginList = null;
		try {
			Query hql = session.createQuery("FROM LoginList");
			loginList = (List<LoginList>) hql.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return loginList;
	}


	/*
	 * public void addMessage(UserMessage message) { Session session =
	 * sessionFactory.getCurrentSession(); try { session.beginTransaction();
	 * session.save(message); } catch (HibernateException e) { e.printStackTrace();
	 * session.getTransaction().rollback(); } session.getTransaction().commit(); }
	 * 
	 * public List<UserMessage> getMessages(int seen) { Session session =
	 * sessionFactory.getCurrentSession(); session.beginTransaction();
	 * List<UserMessage> messages = null; try { messages = (List<UserMessage>)
	 * session.createQuery("FROM message WHERE seen=" + seen).list(); } catch
	 * (HibernateException e) { e.printStackTrace();
	 * session.getTransaction().rollback(); } session.getTransaction().commit();
	 * return messages; }
	 */
}

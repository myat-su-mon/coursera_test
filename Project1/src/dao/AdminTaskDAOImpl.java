package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import model.CurrentYear;
import model.SiteStatus;
import model.UserMessage;

@Transactional
public class AdminTaskDAOImpl implements AdminTaskDAO{

	private SessionFactory sessionFactory;
	
	public AdminTaskDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public CurrentYear getCurrentYear() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		CurrentYear curYr = null;
		try {
			curYr = (CurrentYear) session.createQuery("FROM CurrentYear").uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return curYr;
	}

	@Override
	public void updateCurrentYear(CurrentYear curYr) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(curYr);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}
	
	@Override
	public SiteStatus getStatus() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		SiteStatus status = null;
		try {
			status = (SiteStatus) session.createQuery("FROM SiteStatus").uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return status;
	}

	@Override
	public void updateSiteStatus(SiteStatus status) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(status);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	public void addMessage(UserMessage message) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(message);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	public List<UserMessage> getMessages(int seen) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<UserMessage> messages = null;
		try {
			messages = (List<UserMessage>) session.createQuery("FROM usermessage WHERE seen=" + seen).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return messages;
	}

}

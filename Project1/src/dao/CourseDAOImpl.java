package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import model.CoreSubject;
import model.CurrentYear;
import model.MajorSubject;
import model.SpecializedMajor;

@Transactional
public class CourseDAOImpl implements CourseDAO {

	private SessionFactory sessionFactory;

	public CourseDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public CurrentYear getCurYear() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		CurrentYear curyear = null;
		try {
			curyear = (CurrentYear) session.createQuery("FROM CurrentYear").uniqueResult();
			System.out.println(curyear.getcurYr() + curyear.getcurSem());
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return curyear;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SpecializedMajor> getSpecializedMajors() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<SpecializedMajor> specMajors = null;
		try {
			specMajors = (List<SpecializedMajor>) session.createQuery("FROM SpecializedMajor").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return specMajors;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CoreSubject> getCoreSubjects(int coreId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> objects = null;
		List<CoreSubject> coreSubjects = new ArrayList<CoreSubject>();
		try {
			Query hql = session.createQuery("FROM CoreSubject cs, CoreCategory cc, Department d"
					+ " WHERE cs.status=0 AND cs.department=d.id AND cs.subcategory=cc.id AND cc.id=" + coreId);
			objects = (List<Object[]>) hql.list();

			for (Object[] obj : objects) {
				CoreSubject core = (CoreSubject) obj[0];
				coreSubjects.add(core);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return coreSubjects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MajorSubject> getMajorSubjects() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object> objects = null;
		List<MajorSubject> majorSubjects = new ArrayList<MajorSubject>();
		try {
			Query hql = session.createQuery("FROM MajorSubject WHERE status=0");
			objects = (List<Object>) hql.list();

			for (Object obj : objects) {
				MajorSubject major = (MajorSubject) obj;
				majorSubjects.add(major);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return majorSubjects;
	}

	@Override
	public void newCoreSubject(CoreSubject coreSubject) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(coreSubject);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	@Override
	public void updateCoreSubject(CoreSubject coreSubject) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(coreSubject);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	@Override
	public void deleteCoreSubject(CoreSubject coresub) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		try {
			session.beginTransaction();
			session.saveOrUpdate(coresub);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	@Override
	public CoreSubject getCoreDetail(String subcode) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Object[] objects = null;
		CoreSubject coreSubject = new CoreSubject();
		try {
			Query hql = session.createQuery("FROM CoreSubject cs, Department d, CoreCategory cc WHERE cs.subcode='"
					+ subcode + "' AND cs.department=d.id AND cs.subcategory=cc.id");
			objects = (Object[]) hql.uniqueResult();

			coreSubject = (CoreSubject) objects[0];
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return coreSubject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MajorSubject> getMajorCore(String specialized) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<MajorSubject> majorSubjects = new ArrayList<MajorSubject>();
		try {
			Query hql = session.createQuery("FROM MajorSubject WHERE status=0 AND " + specialized + "=0");
			majorSubjects = (List<MajorSubject>) hql.list();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return majorSubjects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MajorSubject> getMajorElective(String specialized) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<MajorSubject> majorSubjects = new ArrayList<MajorSubject>();
		try {
			Query hql = session.createQuery("FROM MajorSubject WHERE status=0 AND " + specialized + "=1");
			majorSubjects = (List<MajorSubject>) hql.list();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return majorSubjects;
	}

	@Override
	public MajorSubject getMajorDetail(String subcode) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		MajorSubject majorSubject = new MajorSubject();
		try {
			Query hql = session.createQuery("FROM MajorSubject WHERE subcode='" + subcode + "'");
			majorSubject = (MajorSubject) hql.uniqueResult();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return majorSubject;
	}

	@Override
	public void newMajorSubject(MajorSubject majorSubject) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(majorSubject);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	@Override
	public void updateMajorSubject(MajorSubject majorSubject) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(majorSubject);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	@Override
	public void deleteMajorSubject(MajorSubject majorsub) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		try {
			session.beginTransaction();
			session.saveOrUpdate(majorsub);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

}

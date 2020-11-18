package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import model.CurrentYear;
import model.Hostel;
import model.RegDate;
import model.Scholar;
import model.SpecializedMajor;
import model.StateRegion;
import model.StuSubjectCore;
import model.StuSubjectMajor;
import model.StudentBio;
import model.Township;
import view.StudentView;

@Transactional
public class StudentDAOImpl implements StudentDAO {

	private SessionFactory sessionFactory;

	public StudentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentView> getStdByBlood(String blood) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object> objects = null;
		List<StudentView> views = new ArrayList<StudentView>();

		try {
			Query hql = session.createQuery("FROM StudentBio sb WHERE sb.blood='" + blood + "'");
			objects = (List<Object>) hql.list();

			for (Object obj : objects) {
				StudentView view = new StudentView();
				StudentBio sb = (StudentBio) obj;
				view.setViewSId(sb.getSid());
				view.setViewNameMyan(sb.getNamem());
				view.setViewSpecializedMajor(sb.getMajor().getDes());
				view.setViewBloodType(sb.getBlood());
				view.setViewPhone(sb.getPhno());
				view.setViewEmail(sb.getEmail());
				view.setViewStatus(sb.getStatus());
				views.add(view);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return views;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentView> getStdByCoreSub(String coreSub, String curYrSem) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> objects = null;
		List<StudentView> views = new ArrayList<StudentView>();

		try {
			Query hql = session
					.createQuery("FROM StudentBio sb, StuSubjectCore ssc WHERE sb.sid=ssc.sid AND ssc.subcode='"
							+ coreSub + "' AND ssc.semester='" + curYrSem + "' ORDER BY ssc.sid");
			objects = (List<Object[]>) hql.list();

			for (Object[] obj : objects) {
				StudentView view = new StudentView();
				StudentBio sb = (StudentBio) obj[0];
				StuSubjectCore ssc = (StuSubjectCore) obj[1];
				view.setViewSId(sb.getSid());
				view.setViewNameMyan(sb.getNamem());
				view.setViewSpecializedMajor(sb.getMajor().getDes());
				view.setViewPhone(sb.getPhno());
				view.setViewEmail(sb.getEmail());
				view.setViewStatus(sb.getStatus());
				view.setViewCoreSubject(ssc.getSubcode());
				view.setViewSection("" + ssc.getRoom());
				views.add(view);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return views;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentView> getStdByHostel(String gender, String entYr) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> objects = null;
		List<StudentView> views = new ArrayList<StudentView>();

		try {
			Query hql = session.createQuery("FROM StudentBio sb, Hostel h WHERE sb.sid=h.sid AND sb.gender='" + gender
					+ "' AND h.entyear='" + entYr + "'");
			objects = (List<Object[]>) hql.list();

			for (Object[] obj : objects) {
				StudentView view = new StudentView();
				StudentBio sb = (StudentBio) obj[0];
				Hostel h = (Hostel) obj[1];
				view.setViewSId(sb.getSid());
				view.setViewNameMyan(sb.getNamem());
				view.setViewSpecializedMajor(sb.getMajor().getDes());
				view.setViewPhone(sb.getPhno());
				view.setViewEmail(sb.getEmail());
				view.setViewStatus(sb.getStatus());
				view.setViewGender(sb.getGender());
				view.setViewHostel(h.getHostel().getDes());
				views.add(view);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return views;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentView> getStdByMajorSub(String majorSub, String curYrSem) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> objects = null;
		List<StudentView> views = new ArrayList<StudentView>();

		try {
			Query hql = session
					.createQuery("FROM StudentBio sb, StuSubjectMajor ssm WHERE sb.sid=ssm.sid AND ssm.subcode='"
							+ majorSub + "' AND ssm.semester='" + curYrSem + "' ORDER BY ssm.sid");
			objects = (List<Object[]>) hql.list();

			for (Object[] obj : objects) {
				StudentView view = new StudentView();
				StudentBio sb = (StudentBio) obj[0];
				StuSubjectMajor ssm = (StuSubjectMajor) obj[1];
				view.setViewSId(sb.getSid());
				view.setViewNameMyan(sb.getNamem());
				view.setViewSpecializedMajor(sb.getMajor().getDes());
				view.setViewPhone(sb.getPhno());
				view.setViewEmail(sb.getEmail());
				view.setViewStatus(sb.getStatus());
				view.setViewMajorSubject(ssm.getSubcode());
				view.setViewSection("" + ssm.getRoom());
				views.add(view);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return views;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentView> getStdByRegistration(String startDate, String endDate) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> objects = null;
		List<StudentView> views = new ArrayList<StudentView>();

		try {
			Query hql = session.createQuery("FROM StudentBio sb, RegDate rd WHERE sb.sid=rd.sid AND rd.rdate between '"
					+ startDate + "' AND '" + endDate + "'");
			objects = (List<Object[]>) hql.list();

			for (Object[] obj : objects) {
				StudentView view = new StudentView();
				StudentBio sb = (StudentBio) obj[0];
				RegDate rd = (RegDate) obj[1];
				view.setViewSId(sb.getSid());
				view.setViewNameMyan(sb.getNamem());
				view.setViewSpecializedMajor(sb.getMajor().getDes());
				view.setViewPhone(sb.getPhno());
				view.setViewEmail(sb.getEmail());
				view.setViewStatus(sb.getStatus());
				view.setViewRegDate(rd.getRdate());
				views.add(view);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return views;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentView> getStdByScholar() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> objects = null;
		List<StudentView> views = new ArrayList<StudentView>();

		try {
			Query hql = session.createQuery("FROM StudentBio sb, Scholar sc WHERE sb.sid=sc.sid");
			objects = (List<Object[]>) hql.list();

			for (Object[] obj : objects) {
				StudentView view = new StudentView();
				StudentBio sb = (StudentBio) obj[0];
				Scholar sc = (Scholar) obj[1];
				view.setViewSId(sb.getSid());
				view.setViewNameMyan(sb.getNamem());
				view.setViewSpecializedMajor(sb.getMajor().getDes());
				view.setViewPhone(sb.getPhno());
				view.setViewEmail(sb.getEmail());
				view.setViewStatus(sb.getStatus());
				view.setViewEntYear(sc.getEntYear());
				views.add(view);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return views;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentView> getStdBySpecialized(String major) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> objects = null;
		List<StudentView> views = new ArrayList<StudentView>();

		try {
			Query hql = session.createQuery(
					"FROM StudentBio sb, SpecializedMajor sp WHERE sb.major=sp.id AND sp.des='" + major + "'");
			objects = (List<Object[]>) hql.list();

			for (Object[] obj : objects) {
				StudentView view = new StudentView();
				StudentBio sb = (StudentBio) obj[0];
				view.setViewSId(sb.getSid());
				view.setViewNameMyan(sb.getNamem());
				view.setViewSpecializedMajor(sb.getMajor().getDes());
				view.setViewPhone(sb.getPhno());
				view.setViewEmail(sb.getEmail());
				view.setViewStatus(sb.getStatus());
				views.add(view);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return views;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentView> getStdByState(int stateId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<StudentBio> students = null;
		List<StudentView> views = new ArrayList<StudentView>();

		try {
			Query hql = session.createQuery("FROM StudentBio WHERE stateregion='" + stateId + "'");
			students = (List<StudentBio>) hql.list();

			for (StudentBio std : students) {
				StudentView view = new StudentView();
				view.setViewSId(std.getSid());
				view.setViewNameMyan(std.getNamem());
				view.setViewSpecializedMajor(std.getMajor().getDes());
				view.setViewStateRegionId(""+std.getStateRegion().getId());
				view.setViewStateRegionDes(std.getStateRegion().getDes());
				view.setViewTownshipDes(std.getTownship().getDes());
				view.setViewPhone(std.getPhno());
				view.setViewEmail(std.getEmail());
				view.setViewStatus(std.getStatus());
				views.add(view);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return views;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentView> getStdByTownship(int townshipId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<StudentBio> students = null;
		List<StudentView> views = new ArrayList<StudentView>();

		try {
			Query hql = session.createQuery("FROM StudentBio WHERE township='" + townshipId + "'");
			students = (List<StudentBio>) hql.list();

			for (StudentBio std : students) {
				StudentView view = new StudentView();
				view.setViewSId(std.getSid());
				view.setViewNameMyan(std.getNamem());
				view.setViewSpecializedMajor(std.getMajor().getDes());
				view.setViewTownshipId(""+std.getTownship().getId());
				view.setViewTownshipDes(std.getTownship().getDes());
				view.setViewPhone(std.getPhno());
				view.setViewEmail(std.getEmail());
				view.setViewStatus(std.getStatus());
				views.add(view);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return views;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StateRegion> getStateRegionList() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> objects = null;
		List<StateRegion> stateregions = new ArrayList<StateRegion>();
		try {
			Query hql = session.createQuery("SELECT DISTINCT s.id, s.des FROM StateRegion s, StudentBio sb WHERE s.id=sb.stateregion");
			objects = (List<Object[]>) hql.list();
			for (Object[] obj : objects) {
				StateRegion state = new StateRegion();
				state.setId((int) obj[0]);
				state.setDes((String) obj[1]);
				stateregions.add(state);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return stateregions;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Township> getTownshipList() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> objects = null;
		List<Township> townships = new ArrayList<Township>();
		try {
			Query hql = session.createQuery("SELECT DISTINCT t.id, t.des FROM Township t, StudentBio sb WHERE t.id=sb.township");
			objects = (List<Object[]>) hql.list();
			for (Object[] obj : objects) {
				Township township = new Township();
				township.setId((int) obj[0]);
				township.setDes((String) obj[1]);
				townships.add(township);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return townships;
	}

	@Override
	public String getCurYrSem() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String curYrSem = null;
		try {
			CurrentYear curyear = (CurrentYear) session.createQuery("FROM CurrentYear").uniqueResult();
			curYrSem = "" + curyear.getcurYr() + curyear.getcurSem();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return curYrSem;
	}

}

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
import model.Department;
import model.EType;
import model.MajorSubject;
import model.StuSubjectCore;
import model.StuSubjectMajor;
import model.SubjectClassroomTeacher;
import model.TimeTable;
import model.TimeTableExam;
import model.TimeTableList;
import model.Users;
import view.TimetableView;

@Transactional
public class TimetableDAOImpl implements TimetableDAO {

	private SessionFactory sessionFactory;

	public TimetableDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public CurrentYear getCurYear() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		CurrentYear curyear = null;
		try {
			curyear = (CurrentYear) session.createQuery("from CurrentYear").uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return curyear;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TimetableView> getCoreTimetable(String sid, String curYrSem) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> objects = null;
		List<TimetableView> views = new ArrayList<TimetableView>();

		try {
			Query query = session.createQuery(
					"FROM TimeTable t, TimeTableList tl, StuSubjectCore core, SubjectClassroomTeacher sct, Users u "
							+ "WHERE core.sid=" + sid + " AND core.semester=" + curYrSem
							+ " AND tl.subcode=core.subcode AND tl.room=core.room AND tl.acayr=core.semester"
							+ " AND tl.subcode=sct.subcode AND tl.room=sct.room AND tl.acayr=sct.semester"
							+ " AND tl.day=t.dayy AND tl.perio=t.perio" + " AND sct.sid=u.uid ORDER BY t.dayy");
			objects = (List<Object[]>) query.list();

			for (Object[] obj : objects) {
				TimeTable t = (TimeTable) obj[0];
				TimeTableList tl = (TimeTableList) obj[1];
				StuSubjectCore core = (StuSubjectCore) obj[2];
				SubjectClassroomTeacher sct = (SubjectClassroomTeacher) obj[3];
				Users u = (Users) obj[4];
				TimetableView view = new TimetableView();
				view.setViewDay("" + t.getDayy());
				view.setViewPeriod("" + t.getPerio());
				view.setViewStartTime(t.getFro());
				view.setViewEndTime(t.getToo());
				view.setViewSubCode(tl.getSubcode());
				view.setViewSection("" + tl.getRoom());
				view.setViewSemester(tl.getAcayr());
				view.setViewSid(core.getSid());
				view.setViewTeacher(u.getUname());
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
	public List<TimetableView> getMajorTimetable(String sid, String curYrSem) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> objects = null;
		List<TimetableView> views = new ArrayList<TimetableView>();

		try {
			Query query = session.createQuery(
					"FROM TimeTable t, TimeTableList tl, StuSubjectMajor major, SubjectClassroomTeacher sct, Users u "
							+ "WHERE major.sid=" + sid + " AND major.semester=" + curYrSem
							+ " AND tl.subcode=major.subcode AND tl.room=major.room AND tl.acayr=major.semester"
							+ " AND tl.subcode=sct.subcode AND tl.room=sct.room AND tl.acayr=sct.semester"
							+ " AND tl.day=t.dayy AND tl.perio=t.perio" + " AND sct.sid=u.uid ORDER BY t.dayy");
			objects = (List<Object[]>) query.list();

			for (Object[] obj : objects) {
				TimeTable t = (TimeTable) obj[0];
				TimeTableList tl = (TimeTableList) obj[1];
				StuSubjectMajor core = (StuSubjectMajor) obj[2];
				SubjectClassroomTeacher sct = (SubjectClassroomTeacher) obj[3];
				Users u = (Users) obj[4];
				TimetableView view = new TimetableView();
				view.setViewDay("" + t.getDayy());
				view.setViewPeriod("" + t.getPerio());
				view.setViewStartTime(t.getFro());
				view.setViewEndTime(t.getToo());
				view.setViewSubCode(tl.getSubcode());
				view.setViewSection("" + tl.getRoom());
				view.setViewSemester(tl.getAcayr());
				view.setViewSid(core.getSid());
				view.setViewTeacher(u.getUname());
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
	public List<TimetableView> getCoreExam(String sid, String curYrSem) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> objects = null;
		List<TimetableView> views = new ArrayList<TimetableView>();

		try {
			Query query = session.createQuery("FROM TimeTableExam te, EType e, StuSubjectCore ss, CoreSubject cs"
					+ " WHERE ss.sid=" + sid + " AND te.semester=" + curYrSem
					+ " AND te.subcode=ss.subcode AND te.semester=ss.semester AND te.etype=e.id"
					+ " AND ss.subcode=cs.subcode ORDER BY te.datee");
			objects = (List<Object[]>) query.list();

			for (Object[] obj : objects) {
				TimetableView view = new TimetableView();
				TimeTableExam te = (TimeTableExam) obj[0];
				EType e = (EType) obj[1];
				StuSubjectCore ss = (StuSubjectCore) obj[2];
				CoreSubject cs = (CoreSubject) obj[3];
				view.setViewDate(te.getDatee());
				view.setViewStartTime(te.getStime());
				view.setViewEndTime(te.getEtime());
				view.setViewExamType(e.getEtype());
				view.setViewSubCode(ss.getSubcode());
				view.setViewSubName(cs.getSubname());
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
	public List<TimetableView> getMajorExam(String sid, String curYrSem) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> objects = null;
		List<TimetableView> views = new ArrayList<TimetableView>();

		try {
			Query query = session.createQuery("FROM TimeTableExam te, EType e, StuSubjectMajor ss, MajorSubject ms"
					+ " WHERE ss.sid=" + sid + " AND te.semester=" + curYrSem
					+ " AND te.subcode=ss.subcode AND te.semester=ss.semester AND te.etype=e.id"
					+ " AND ss.subcode=ms.subcode ORDER BY te.datee");
			objects = (List<Object[]>) query.list();

			for (Object[] obj : objects) {
				TimetableView view = new TimetableView();
				TimeTableExam te = (TimeTableExam) obj[0];
				EType e = (EType) obj[1];
				StuSubjectMajor ss = (StuSubjectMajor) obj[2];
				MajorSubject ms = (MajorSubject) obj[3];
				view.setViewDate(te.getDatee());
				view.setViewStartTime(te.getStime());
				view.setViewEndTime(te.getEtime());
				view.setViewExamType(e.getEtype());
				view.setViewSubCode(ss.getSubcode());
				view.setViewSubName(ms.getSubname());
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
	public List<TimetableView> teacherList(int deptId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> objects = null;
		List<TimetableView> views = new ArrayList<TimetableView>();

		try {
			Query hql = session
					.createQuery("FROM Users u, Department d WHERE u.department=d.id AND u.status=0 AND d.id='" + deptId
							+ "' ORDER BY d.des");
			objects = (List<Object[]>) hql.list();

			for (Object[] obj : objects) {
				TimetableView view = new TimetableView();
				Users u = (Users) obj[0];
				Department d = (Department) obj[1];
				view.setViewUid(u.getUid());
				view.setViewUname(u.getUname());
				view.setViewUdepartmentId("" + d.getId());
				view.setViewUdepartmentDes(d.getDes());
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
	public List<TimetableView> teacherTimetable(String uid, String yrSem) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> objects = null;
		List<TimetableView> views = new ArrayList<TimetableView>();

		try {
			Query hql = session.createQuery("FROM Users u, SubjectClassroomTeacher sct, TimeTableList tl, TimeTable t "
					+ "WHERE u.uid=sct.sid AND sct.subcode=tl.subcode AND sct.room=tl.room AND sct.semester=tl.acayr "
					+ "AND tl.day=t.dayy AND tl.perio=t.perio AND tl.acayr='" + yrSem + "' AND u.uid='" + uid
					+ "' ORDER BY t.dayy");
			objects = (List<Object[]>) hql.list();

			for (Object[] obj : objects) {
				TimetableView view = new TimetableView();
				Users u = (Users) obj[0];
				SubjectClassroomTeacher sct = (SubjectClassroomTeacher) obj[1];
				TimeTableList tl = (TimeTableList) obj[2];
				TimeTable t = (TimeTable) obj[3];
				view.setViewUid(u.getUid());
				view.setViewUname(u.getUname());
				view.setViewSubCode(tl.getSubcode());
				view.setViewSection("" + tl.getRoom());
				view.setViewDay("" + t.getDayy());
				view.setViewPeriod("" + t.getPerio());
				view.setViewStartTime(t.getFro());
				view.setViewEndTime(t.getToo());
				views.add(view);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return views;
	}

}

package dao;

import java.util.List;

import model.CurrentYear;
import view.TimetableView;

public interface TimetableDAO {

	public CurrentYear getCurYear();

	public List<TimetableView> getCoreTimetable(String sid, String curYrSem);

	public List<TimetableView> getMajorTimetable(String sid, String curYrSem);

	public List<TimetableView> getCoreExam(String sid, String curYrSem);

	public List<TimetableView> getMajorExam(String sid, String curYrSem);

	public List<TimetableView> teacherList(int deptId);

	public List<TimetableView> teacherTimetable(String uid, String yrSem);

}

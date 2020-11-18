package dao;

import java.util.List;

import model.CoreSubject;
import model.CurrentYear;
import model.MajorSubject;
import model.SpecializedMajor;

public interface CourseDAO {

	public CurrentYear getCurYear();

	public List<SpecializedMajor> getSpecializedMajors();

	public List<CoreSubject> getCoreSubjects(int coreId);

	public List<MajorSubject> getMajorSubjects();

	public void newCoreSubject(CoreSubject coreSubject);

	public void updateCoreSubject(CoreSubject coreSubject);
	
	public void deleteCoreSubject(CoreSubject coresub);

	public CoreSubject getCoreDetail(String subcode);
	
	public List<MajorSubject> getMajorCore(String specialized);
	
	public List<MajorSubject> getMajorElective(String specialized);
	
	public MajorSubject getMajorDetail(String subcode);
	
	public void newMajorSubject(MajorSubject majorSubject);
	
	public void updateMajorSubject(MajorSubject majorSubject);
	
	public void deleteMajorSubject(MajorSubject majorsub);

}

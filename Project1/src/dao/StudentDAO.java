package dao;

import java.util.List;

import model.StateRegion;
import model.Township;
import view.StudentView;

public interface StudentDAO {

	public List<StudentView> getStdByBlood(String blood);

	public List<StudentView> getStdByCoreSub(String coreSub, String curYrSem);

	public List<StudentView> getStdByHostel(String gender, String entYr);

	public List<StudentView> getStdByMajorSub(String majorSub, String curYrSem);

	public List<StudentView> getStdByRegistration(String startDate, String endDate);

	public List<StudentView> getStdByScholar();

	public List<StudentView> getStdBySpecialized(String major);

	public List<StudentView> getStdByState(int stateId);

	public List<StudentView> getStdByTownship(int townshipId);
	
	public List<StateRegion> getStateRegionList();
	
	public List<Township> getTownshipList();
	
	public String getCurYrSem();

}

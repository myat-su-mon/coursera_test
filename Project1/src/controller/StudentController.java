package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.StudentDAO;
import model.CurrentYear;
import model.StateRegion;
import model.Township;
import view.StudentView;

@Controller
public class StudentController {

	@Autowired
	private StudentDAO studentDAO;

	@RequestMapping(value = "/blood", method = RequestMethod.GET)
	public String searchByBlood(Model model) {
		return "query-by-blood-type";
	}

	@RequestMapping(value = "/blood", method = RequestMethod.POST)
	public String blood(Model model, @RequestParam String blood) {
		List<StudentView> stdList = studentDAO.getStdByBlood(blood);
		String queryby = "Blood Type : " + blood;
		model.addAttribute("queryby", queryby);
		model.addAttribute("stdlist", stdList);
		return "query-by-blood-type";
	}

	@RequestMapping(value = "/coresub", method = RequestMethod.GET)
	public String searchByCoreSub(Model model) {
		return "query-by-core-subject";
	}

	@RequestMapping(value = "/coresub", method = RequestMethod.POST)
	public String coreSub(Model model, @RequestParam String core) {
		String curYrSem = studentDAO.getCurYrSem();
		List<StudentView> stdList = studentDAO.getStdByCoreSub(core, curYrSem);
		String queryby = "Core Subject : " + core;
		model.addAttribute("queryby", queryby);
		model.addAttribute("stdlist", stdList);
		return "query-by-core-subject";
	}

	@RequestMapping(value = "/hostel", method = RequestMethod.GET)
	public String searchByHostel(Model model) {
		return "query-by-hostel";
	}

	@RequestMapping(value = "/hostel", method = RequestMethod.POST)
	public String hostel(Model model, @RequestParam String gender, @RequestParam String entYr) {
		List<StudentView> stdList = studentDAO.getStdByHostel(gender, entYr);
		String queryby = "Hostel : " + gender;
		model.addAttribute("queryby", queryby);
		model.addAttribute("stdlist", stdList);
		return "query-by-hostel";
	}

	@RequestMapping(value = "/majorsub", method = RequestMethod.GET)
	public String searchByMajorsub(Model model) {
		return "query-by-major-subject";
	}

	@RequestMapping(value = "/majorsub", method = RequestMethod.POST)
	public String majorsub(Model model, @RequestParam String major) {
		String curYrSem = studentDAO.getCurYrSem();
		List<StudentView> stdList = studentDAO.getStdByMajorSub(major, curYrSem);
		String queryby = "Major Subject : " + major;
		model.addAttribute("queryby", queryby);
		model.addAttribute("stdlist", stdList);
		return "query-by-major-subject";
	}

	@RequestMapping(value = "/regdate", method = RequestMethod.GET)
	public String searchByRegDate(Model model) {
		return "query-by-registration-date";
	}

	@RequestMapping(value = "/regdate", method = RequestMethod.POST)
	public String regDate(Model model, @RequestParam String start, @RequestParam String end) {
		List<StudentView> stdList = studentDAO.getStdByRegistration(start, end);
		String queryby = "Registration Date between : " + start + " and " + end;
		model.addAttribute("queryby", queryby);
		model.addAttribute("stdlist", stdList);
		return "query-by-registration-date";
	}

	@RequestMapping(value = "/scholar", method = RequestMethod.GET)
	public String searchByScholar(Model model) {
		return "query-by-scholar-apply";
	}

	@RequestMapping(value = "/scholar", method = RequestMethod.POST)
	public String scholar(Model model) {
		List<StudentView> stdList = studentDAO.getStdByScholar();
		String queryby = "Scholar Apply";
		model.addAttribute("queryby", queryby);
		model.addAttribute("stdlist", stdList);
		return "query-by-scholar-apply";
	}

	@RequestMapping(value = "/specialized", method = RequestMethod.GET)
	public String searchBySpecialized(Model model) {
		return "query-by-specialized-major";
	}

	@RequestMapping(value = "/specialized", method = RequestMethod.POST)
	public String specialized(Model model, @RequestParam String major) {
		List<StudentView> stdList = studentDAO.getStdBySpecialized(major);
		String queryby = "Specialized Major : " + major;
		model.addAttribute("queryby", queryby);
		model.addAttribute("stdlist", stdList);
		return "query-by-specialized-major";
	}

	@RequestMapping(value = "/stateregion", method = RequestMethod.GET)
	public String searchByStateRegion(Model model) {
		List<StateRegion> stateregions = studentDAO.getStateRegionList();
		model.addAttribute("stateregions", stateregions);
		return "query-by-state-region";
	}

	@RequestMapping(value = "/stateregion", method = RequestMethod.POST)
	public String stateRegion(Model model, @RequestParam String stateregion) {
		int stateId = Integer.parseInt(stateregion);
		List<StudentView> stdList = studentDAO.getStdByState(stateId);
		String queryby = "State Region : " + stdList.get(0).getViewStateRegionDes();
		model.addAttribute("queryby", queryby);
		model.addAttribute("stdlist", stdList);
		List<StateRegion> stateregions = studentDAO.getStateRegionList();
		model.addAttribute("stateregions", stateregions);
		return "query-by-state-region";
	}

	@RequestMapping(value = "/township", method = RequestMethod.GET)
	public String searchByTownship(Model model) {
		List<Township> townships = studentDAO.getTownshipList();
		model.addAttribute("townships", townships);
		return "query-by-township";
	}

	@RequestMapping(value = "/township", method = RequestMethod.POST)
	public String township(Model model, @RequestParam String township) {
		int townshipId = Integer.parseInt(township);
		List<StudentView> stdList = studentDAO.getStdByTownship(townshipId);
		String queryby = "Township : " + stdList.get(0).getViewTownshipDes();
		model.addAttribute("queryby", queryby);
		model.addAttribute("stdlist", stdList);
		List<Township> townships = studentDAO.getTownshipList();
		model.addAttribute("townships", townships);
		return "query-by-township";
	}

}

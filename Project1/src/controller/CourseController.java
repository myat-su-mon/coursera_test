package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.CourseDAO;
import model.CoreSubject;
import model.MajorSubject;
import model.SpecializedMajor;
import service.ServiceClass;

@Controller
public class CourseController {

	@Autowired
	private CourseDAO courseDAO;

	@RequestMapping(value = "/courselist")
	public String courseList(Model model) {
		List<SpecializedMajor> specMajors = courseDAO.getSpecializedMajors();
		model.addAttribute("specmajors", specMajors);
		return "course-list";
	}

	@RequestMapping(value = "/coresublist")
	public String coreSubList(Model model) {
		List<CoreSubject> foundation = courseDAO.getCoreSubjects(1);
		List<CoreSubject> knowledge = courseDAO.getCoreSubjects(2);
		List<CoreSubject> perspectives = courseDAO.getCoreSubjects(3);
		List<CoreSubject> supporting = courseDAO.getCoreSubjects(4);
		List<List<CoreSubject>> coresubjects = new ArrayList<List<CoreSubject>>();
		coresubjects.add(foundation);
		coresubjects.add(knowledge);
		coresubjects.add(perspectives);
		coresubjects.add(supporting);
		model.addAttribute("coresubjects", coresubjects);
		return "core-subject-list";
	}

	@RequestMapping(value = "/coresubdetail")
	public String coreSubDetail(Model model, @RequestParam String subcode) {
		CoreSubject coreSubject = courseDAO.getCoreDetail(subcode);
		model.addAttribute("coresub", coreSubject);
		return "core-subject-detail";
	}

	@RequestMapping(value = "/coresubupdate")
	public String coreSubUpdate(Model model, @RequestParam String subcode) {
		CoreSubject coreSubject = courseDAO.getCoreDetail(subcode);
		List<CoreSubject> foundation = courseDAO.getCoreSubjects(1);
		List<CoreSubject> knowledge = courseDAO.getCoreSubjects(2);
		List<CoreSubject> perspectives = courseDAO.getCoreSubjects(3);
		List<CoreSubject> supporting = courseDAO.getCoreSubjects(4);
		model.addAttribute("coresub", coreSubject);
		model.addAttribute("foundation", foundation);
		model.addAttribute("knowledge", knowledge);
		model.addAttribute("perspectives", perspectives);
		model.addAttribute("supporting", supporting);
		List<MajorSubject> majorSubjects = courseDAO.getMajorSubjects();
		model.addAttribute("majorsubjects", majorSubjects);
		return "core-subject-update";
	}

	@RequestMapping(value = "/coresubupdate", method = RequestMethod.POST)
	public String updateCoreSub(Model model, @ModelAttribute("coresub") CoreSubject coresub) {
		courseDAO.updateCoreSubject(coresub);
		model.addAttribute("message", "Successfully Updated!");
		return "core-subject-update";
	}
	
	@RequestMapping(value = "/coresubdelete")
	public String deleteCoreSub(Model model, @RequestParam String subcode) {
		CoreSubject coresub = courseDAO.getCoreDetail(subcode);
		courseDAO.deleteCoreSubject(coresub);
		return "course-list";
	}

	@RequestMapping(value = "/newcoresub")
	public String coreSubInsert(Model model) {
		List<CoreSubject> foundation = courseDAO.getCoreSubjects(1);
		List<CoreSubject> knowledge = courseDAO.getCoreSubjects(2);
		List<CoreSubject> perspectives = courseDAO.getCoreSubjects(3);
		List<CoreSubject> supporting = courseDAO.getCoreSubjects(4);
		model.addAttribute("foundation", foundation);
		model.addAttribute("knowledge", knowledge);
		model.addAttribute("perspectives", perspectives);
		model.addAttribute("supporting", supporting);
		List<MajorSubject> majorSubjects = courseDAO.getMajorSubjects();
		model.addAttribute("majorsubjects", majorSubjects);
		return "core-subject-insert";
	}

	@RequestMapping(value = "/newcoresub", method = RequestMethod.POST)
	public String insertCoreSub(Model model, @ModelAttribute("coresub") CoreSubject coresub) {
		courseDAO.newCoreSubject(coresub);
		return "core-subject-insert";
	}
	
	@RequestMapping(value = "/majorsublist")
	public String majorSubList(Model model, @RequestParam String specialized) {
		ServiceClass service = new ServiceClass();
		String fieldName = service.getSubjectMajorField(specialized);
		List<MajorSubject> majorCore = courseDAO.getMajorCore(fieldName);
		model.addAttribute("majorcore", majorCore);
		List<MajorSubject> majorElectives = courseDAO.getMajorElective(fieldName);
		model.addAttribute("majorelective", majorElectives);
		model.addAttribute("majorname", specialized);
		return "major-subject-list";
	}
	
	@RequestMapping(value = "/majorsubdetail")
	public String majorSubDetail(Model model, @RequestParam String subcode) {
		MajorSubject majorSubject = courseDAO.getMajorDetail(subcode);
		model.addAttribute("majorsub", majorSubject);
		ServiceClass service = new ServiceClass();
		String categories = service.getSub(majorSubject.getBis(), majorSubject.getCsf(), 
				majorSubject.getKe(), majorSubject.getSe(), majorSubject.getNt(), majorSubject.getEmb());
		model.addAttribute("categories", categories);
		return "major-subject-detail";
	}
	
	@RequestMapping(value = "/majorsubupdate")
	public String majorSubUpdate(Model model, @RequestParam String subcode) {
		MajorSubject majorSubject = courseDAO.getMajorDetail(subcode);
		List<CoreSubject> foundation = courseDAO.getCoreSubjects(1);
		List<CoreSubject> knowledge = courseDAO.getCoreSubjects(2);
		List<CoreSubject> perspectives = courseDAO.getCoreSubjects(3);
		List<CoreSubject> supporting = courseDAO.getCoreSubjects(4);
		model.addAttribute("majorsub", majorSubject);
		model.addAttribute("foundation", foundation);
		model.addAttribute("knowledge", knowledge);
		model.addAttribute("perspectives", perspectives);
		model.addAttribute("supporting", supporting);
		List<MajorSubject> majorSubjects = courseDAO.getMajorSubjects();
		model.addAttribute("majorsubjects", majorSubjects);
		return "major-subject-update";
	}

	@RequestMapping(value = "/majorsubupdate", method = RequestMethod.POST)
	public String updateMajorSub(Model model, @ModelAttribute("majorsub") MajorSubject majorsub) {
		courseDAO.updateMajorSubject(majorsub);
		return "major-subject-update";
	}
	
	@RequestMapping(value = "/majorsubdelete")
	public String deleteMajorSub(Model model, @RequestParam String subcode) {
		MajorSubject majorsub = courseDAO.getMajorDetail(subcode);
		courseDAO.deleteMajorSubject(majorsub);
		return "major-subject-list";
	}
	
	@RequestMapping(value = "/newmajorsub")
	public String majorSubInsert(Model model) {
		List<CoreSubject> foundation = courseDAO.getCoreSubjects(1);
		List<CoreSubject> knowledge = courseDAO.getCoreSubjects(2);
		List<CoreSubject> perspectives = courseDAO.getCoreSubjects(3);
		List<CoreSubject> supporting = courseDAO.getCoreSubjects(4);
		model.addAttribute("foundation", foundation);
		model.addAttribute("knowledge", knowledge);
		model.addAttribute("perspectives", perspectives);
		model.addAttribute("supporting", supporting);
		List<MajorSubject> majorSubjects = courseDAO.getMajorSubjects();
		model.addAttribute("majorsubjects", majorSubjects);
		return "major-subject-insert";
	}

	@RequestMapping(value = "/newmajorsub", method = RequestMethod.POST)
	public String insertMajorSub(Model model, @ModelAttribute("majorsub") MajorSubject majorsub) {
		courseDAO.newMajorSubject(majorsub);
		return "major-subject-insert";
	}
	
}

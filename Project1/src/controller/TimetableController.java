package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.TimetableDAO;
import model.CurrentYear;
import service.ComplexComparator;
import service.DateComparator;
import service.DayComparator;
import service.PeriodComparator;
import view.TimetableView;

@Controller
public class TimetableController {

	@Autowired
	private TimetableDAO timetableDAO;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/stdtimetable", method = RequestMethod.GET)
	public String stdTimetable(Model model) {
		String sid = "22211";
		CurrentYear cur = timetableDAO.getCurYear();
		String curYrSem = "" + cur.getcurYr() + cur.getcurSem();
		
		List<TimetableView> views = new ArrayList<TimetableView>();
		List<TimetableView> core = timetableDAO.getCoreTimetable(sid, curYrSem);
		List<TimetableView> major = timetableDAO.getMajorTimetable(sid, curYrSem);

		views = ListUtils.union(core, major);
		ComplexComparator complexComparator = new ComplexComparator(DayComparator.class, PeriodComparator.class);
		Collections.sort(views, complexComparator);
		
		int mon=0; int tue=0; int wed=0; int thur=0; int fri=0;
		for (TimetableView view : views) {
			switch (view.getViewDay()) {
			case "2": mon ++; break;
			case "3": tue ++; break;
			case "4": wed ++; break;
			case "5": thur ++; break;
			case "6": fri ++; break;
			}
		}
		model.addAttribute("mon", mon);
		model.addAttribute("tue", tue);
		model.addAttribute("wed", wed);
		model.addAttribute("thur", thur);
		model.addAttribute("fri", fri);
		model.addAttribute("timetables", views);
		return "std-timetable";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/examtimetable", method = RequestMethod.GET)
	public String examTimetable(Model model) {
		String sid = "22211";
		CurrentYear cur = timetableDAO.getCurYear();
		String curYrSem = "" + cur.getcurYr() + cur.getcurSem();
		
		List<TimetableView> views = new ArrayList<TimetableView>();
		List<TimetableView> coreExam = timetableDAO.getCoreExam(sid, curYrSem);
		List<TimetableView> majorExam = timetableDAO.getMajorExam(sid, curYrSem);
		
		for(TimetableView view : coreExam) {
			System.out.println("core :" +view.getViewDate());
		}
		
		for(TimetableView view : majorExam) {
			System.out.println("major :" +view.getViewDate());
		}
		
		views = ListUtils.union(coreExam, majorExam);
		Collections.sort(views, new DateComparator());
		model.addAttribute("timetables", views);
		return "exam-timetable";
	}
	
	@RequestMapping(value = "/teacherlist", method = RequestMethod.GET )
	public String teacherList(Model model) {
		List<TimetableView> dept2 = timetableDAO.teacherList(2);
		model.addAttribute("dept2", dept2);
		
		List<TimetableView> dept3 = timetableDAO.teacherList(3);
		model.addAttribute("dept3", dept3);
		
		List<TimetableView> dept4 = timetableDAO.teacherList(4);
		model.addAttribute("dept4", dept4);
		
		List<TimetableView> dept5 = timetableDAO.teacherList(5);
		model.addAttribute("dept5", dept5);
		
		List<TimetableView> dept6 = timetableDAO.teacherList(6);
		model.addAttribute("dept6", dept6);
		
		List<TimetableView> dept7 = timetableDAO.teacherList(7);
		model.addAttribute("dept7", dept7);
		
		List<TimetableView> dept8 = timetableDAO.teacherList(8);
		model.addAttribute("dept8", dept8);
		
		List<TimetableView> dept9 = timetableDAO.teacherList(9);
		model.addAttribute("dept9", dept9);
		
		model.addAttribute("teacher", "list");
		return "teacher-timetable";
	}
	
	@RequestMapping(value = "/teachertimetable", method = RequestMethod.GET)
	public String teacherTimetable(Model model, @RequestParam String uid) {
		CurrentYear cur = timetableDAO.getCurYear();
		String curYrSem = "" + cur.getcurYr() + cur.getcurSem();
		
		List<TimetableView> views = timetableDAO.teacherTimetable(uid, curYrSem);
		ComplexComparator complexComparator = new ComplexComparator(DayComparator.class, PeriodComparator.class);
		Collections.sort(views, complexComparator);
		
		int mon=0; int tue=0; int wed=0; int thur=0; int fri=0;
		for (TimetableView view : views) {
			switch (view.getViewDay()) {
			case "2": mon ++; break;
			case "3": tue ++; break;
			case "4": wed ++; break;
			case "5": thur ++; break;
			case "6": fri ++; break;
			}
		}
		
		model.addAttribute("mon", mon);
		model.addAttribute("tue", tue);
		model.addAttribute("wed", wed);
		model.addAttribute("thur", thur);
		model.addAttribute("fri", fri);
		
		model.addAttribute("timetables", views);
		model.addAttribute("teacher", "timetable");
		return "teacher-timetable";
	}
	
}

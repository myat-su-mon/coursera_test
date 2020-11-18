package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.AdminTaskDAO;
import model.CurrentYear;
import model.SiteStatus;
import model.UserMessage;
import service.ServiceClass;

@Controller
public class AdminTaskController {

	@Autowired
	private AdminTaskDAO adminTaskDAO;
	
	@RequestMapping(value = "/setacademic", method = RequestMethod.GET)
	public String displayAcademicYear(Model model) {
		CurrentYear curyear = adminTaskDAO.getCurrentYear();
		model.addAttribute("curyear", curyear);
		return "set-academic-year";
	}

	@RequestMapping(value = "/setacademic", method = RequestMethod.POST)
	public String setAcademicYear(Model model, @ModelAttribute("curyear") CurrentYear curyear) {
		adminTaskDAO.updateCurrentYear(curyear);
		model.addAttribute("message", "Update Successful!");
		curyear = adminTaskDAO.getCurrentYear();
		return "set-academic-year";
	}
	
	@RequestMapping(value = "/sitestatus", method = RequestMethod.GET)
	public String siteStatus() {
		return "site-status";
	}

	@RequestMapping(value = "/updatestatus", method = RequestMethod.POST)
	public String updateStatus(Model model, @RequestParam String status) {
		SiteStatus siteStatus = adminTaskDAO.getStatus();
		siteStatus.setTvalue(status);
		adminTaskDAO.updateSiteStatus(siteStatus);
		model.addAttribute("message", "Update Successful");
		return "site-status";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(Model model) {
		model.addAttribute("sent", "no");
		return "contact";
	}
	
	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public String team() {
		return "team";
	}

	@RequestMapping(value = "/sendmessage", method = RequestMethod.POST)
	public String sendMessage(Model model, @RequestParam String name, @RequestParam String email,
			@RequestParam String subject, @RequestParam String message) {
		UserMessage userMessage = new UserMessage();
		ServiceClass service = new ServiceClass();
		userMessage.setName(name);
		userMessage.setEmail(email);
		userMessage.setSubject(subject);
		userMessage.setMessage(message);
		userMessage.setDate(service.getTodayDate());
		userMessage.setTime(service.getTodayTime());
		adminTaskDAO.addMessage(userMessage);
		model.addAttribute("sent", "yes");
		return "redirect:/contact";
	}

	@RequestMapping(value = "/viewmessage", method = RequestMethod.POST)
	public String viewMessage(Model model) {
		List<UserMessage> messages = adminTaskDAO.getMessages(0);
		model.addAttribute("messages", messages);
		return "report";
	}

}

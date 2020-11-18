package controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dao.LoginDAO;
import model.KeyList;
import model.LoginList;
import service.ServiceClass;
import view.LoginView;

@Controller
@SessionAttributes("loginUser")
public class LogInController {

	@Autowired
	private LoginDAO loginDAO;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(Model model, @RequestParam String uid, @RequestParam String password) {
		ServiceClass service = new ServiceClass();
		uid = uid.trim();
		password = service.EncDec(password.trim(), 1);
		LoginView loginUser = null;
		ModelAndView mv = new ModelAndView();
		try {
			KeyList keylist = loginDAO.getKeyList(uid);
			if (keylist.getRanks() == 5) {
				loginUser = loginDAO.getStudent(uid);
			} else {
				loginUser = loginDAO.getUser(uid);
			}
			if (uid.equals(loginUser.getViewUid()) && password.equals(loginUser.getViewPassword())
					&& loginUser.getViewStatus().equals("0")) {
				mv.setViewName("index");
				mv.addObject("loginuser", loginUser);
				addToLoginList(loginUser.getViewUid());
			} else {
				model.addAttribute("message", "User Name or Password is incorrect!");
				mv.setViewName("login");
				mv.addObject("loginuser", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(Model model, @RequestParam String loginId) {
		updateToLoginList(loginId);
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("loginUser", null);
		model.addAttribute("message", "successfully logout!");
		return mv;
	}
	
	@RequestMapping(value = "/loginlist", method = RequestMethod.GET)
	public String loginList(Model model) {
		List<LoginList> loginList = loginDAO.getLoginList();
		model.addAttribute("loginlist", loginList);
		return "login-list";
	}
	
	public void addToLoginList(String uid) {
		LoginList loginList = new LoginList();
		ServiceClass service = new ServiceClass();
		String loginId = String.valueOf(new Date().getTime());
		String entDate = service.getTodayDate();
		String entTime = service.getTodayTime();
		String exitDate = "";
		String exitTime = "";
		loginList.setLoginid(loginId);
		loginList.setUid(uid);
		loginList.setEntdate(entDate);
		loginList.setEnttime(entTime);
		loginList.setExtdate(exitDate);
		loginList.setExttime(exitTime);
		loginDAO.addLogin(loginList);
	}
	
	public void updateToLoginList(String loginId) {
		LoginList loginList = loginDAO.getLogin(loginId);
		ServiceClass service = new ServiceClass();
		String exitDate = service.getTodayDate();
		String exitTime = service.getTodayTime();
		loginList.setExtdate(exitDate);
		loginList.setExttime(exitTime);
		loginDAO.updateLogin(loginList);
	}

}

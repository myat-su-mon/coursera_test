package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.UserDAO;
import model.KeyList;
import model.Users;
import service.ServiceClass;
import view.UserView;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@RequestMapping("/newuser")
	public String newUser(Model model) {
		model.addAttribute("newuser", new Users());
		return "new-user";
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(Model model, @ModelAttribute("newuser") Users user) {
		userDAO.addUser(user);
		model.addAttribute("success", "New User Added successfully!");
		return "new-user";
	}

	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public String userList(Model model) {
		List<Users> users = userDAO.userList();
		model.addAttribute("userlist", users);
		return "user-list";
	}

	@RequestMapping(value = "/searchuser", method = RequestMethod.POST)
	public String searchUser(Model model, @RequestParam String uid) {
		Users user = userDAO.getUserByUID(uid);
		model.addAttribute("userlist", user);
		return "user-list";
	}

	@RequestMapping(value = "/validateuser", method = RequestMethod.GET)
	public String validateUser(Model model, @RequestParam String uid) {
		Users user = userDAO.getUserByUID(uid);
		if (user.getStatus() == 0) {
			user.setStatus(1);
		} else {
			user.setStatus(0);
		}
		userDAO.updateUser(user);
		model.addAttribute("userlist", user);
		return "user-list";
	}

	@RequestMapping(value = "/passreset", method = RequestMethod.GET)
	public String passReset(Model model, @RequestParam String uid) {
		UserView view = userDAO.getUserView(uid);
		ServiceClass service = new ServiceClass();
		String viewUpass = service.PasswordGenerate();
		view.setViewUpass(viewUpass);
		model.addAttribute("user", view);
		return "usr-pass-reset";
	}

	@RequestMapping(value = "/passreset", method = RequestMethod.POST)
	public String resetPass(Model model, @RequestParam String uid, @RequestParam String pass) {
		ServiceClass service = new ServiceClass();
		String keyss = service.EncDec(pass, 1);
		KeyList keylist = new KeyList();
		keylist.setUid(uid);
		keylist.setKeyss(keyss);
		userDAO.updateKeyList(keylist);
		model.addAttribute("message", "Password Reset Successfully!");
		return "usr-pass-reset";
	}

	@RequestMapping(value = "/passchange", method = RequestMethod.GET)
	public String passChange(Model model, @RequestParam String uid) {
		UserView view = userDAO.getUserView(uid);
		model.addAttribute("user", view);
		return "usr-pass-change";
	}

	@RequestMapping(value = "/passchange", method = RequestMethod.POST)
	public String changePass(Model model, @RequestParam String uid, @RequestParam String curpass,
			@RequestParam String newpass, @RequestParam String confirmpass) {
		UserView view = userDAO.getUserView(uid);
		String password = view.getViewUpass();
		int ranks = Integer.parseInt(view.getViewUrankId());

		ServiceClass service = new ServiceClass();
		String currentPass = service.EncDec(curpass, 1);

		if (currentPass.equals(password)) {
			if (newpass.equals(confirmpass)) {
				String keyss = service.EncDec(newpass, 1);
				KeyList keylist = new KeyList();
				keylist.setUid(uid);
				keylist.setKeyss(keyss);
				keylist.setRanks(ranks);
				userDAO.updateKeyList(keylist);
				model.addAttribute("message", "Your password is successfully updated!");
			} else {
				model.addAttribute("message", "New passwords do not match! Please try again");
			}
		} else {
			model.addAttribute("message", "Your password is incorrect!");
		}
		return "usr-pass-change";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

}

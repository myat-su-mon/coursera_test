package dao;

import java.util.List;

import model.KeyList;
import model.LoginList;
import view.LoginView;

public interface LoginDAO {

	public KeyList getKeyList(String uid);

	public LoginView getUser(String uid);

	public LoginView getStudent(String uid);

	public void addLogin(LoginList loginList);

	public void updateLogin(LoginList loginList);
	
	public LoginList getLogin(String loginId);
	
	public List<LoginList> getLoginList();

}

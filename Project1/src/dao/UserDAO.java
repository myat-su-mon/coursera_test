package dao;

import java.util.List;

import model.KeyList;
import model.Users;
import view.UserView;

public interface UserDAO {

	public void addUser(Users user);
	
	public void updateUser(Users user);
	
	public List<Users> userList();
	
	public Users getUserByUID(String uid);
	
	public void updateKeyList(KeyList keylist);
	
	public UserView getUserView(String uid);
}

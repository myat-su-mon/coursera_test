package dao;

import java.util.List;

import model.CurrentYear;
import model.SiteStatus;
import model.UserMessage;

public interface AdminTaskDAO {
	
	public CurrentYear getCurrentYear();
	
	public void updateCurrentYear(CurrentYear curYr);
	
	public SiteStatus getStatus();
	
	public void updateSiteStatus(SiteStatus status);
	
	public void addMessage(UserMessage message);
	
	public List<UserMessage> getMessages(int seen);

}

package application.personalIndexCardManager;

import java.util.List;

public class User {
	private String email;
	private String pass;
	private String securityQuest;
	private String securityAns;
	private List<Course> courses;
	
	public User(String email, String pass, String securityQuest, String securityAns){
		this.email = email;
		this.pass = pass;
		this.securityQuest = securityQuest;
		this.securityAns = securityAns;
	}
	
	@Override
	public String toString() {
		String userInfo = email + "," + pass + "," + securityQuest + "," + securityAns;
		return userInfo;
	}
}

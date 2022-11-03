package application;

import java.util.List;

public class User {
	private String email;
	private String pass;
	private String securityQuest;
	private String securityAns;
	private List<String> courses;
	
	User(String email, String pass, String securityQuest, String securityAns){
		this.email = email;
		this.pass = pass;
		this.securityQuest = securityQuest;
		this.securityAns = securityAns;
	}
}

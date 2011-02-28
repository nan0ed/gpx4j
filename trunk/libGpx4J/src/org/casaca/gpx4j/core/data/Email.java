package org.casaca.gpx4j.core.data;

public class Email extends BaseObject {
	private String user;
	private String domain;
	
	public Email(String user, String domain) throws IllegalArgumentException{
		if(user == null || domain == null) throw new IllegalArgumentException("User and domain must not be null");

		this.user = user;
		this.domain = domain;
	}

	public String getUser() {
		return user;
	}

	public String getDomain() {
		return domain;
	}
	
	public String toString(){
		return user+"@"+domain;
	}
}
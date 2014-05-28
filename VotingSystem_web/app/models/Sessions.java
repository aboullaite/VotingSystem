package models;

import play.db.ebean.Model;

public class Sessions extends Model{

	String session;

	public Sessions(String session) {
		
		this.session = session;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}
	
	
}

package controllers;



import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import play.data.*;

import javax.sql.DataSource;

import models.DatabaseConnection;
import models.Sessions;
import views.html.*;
import play.db.DB;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
   public static DatabaseConnection db=new DatabaseConnection();
   
   
   
    public static Result index() {
    	String login=session("email");
    	if(login == null) return redirect(
	            routes.Application.login()
	        );
    	else {
    		 DynamicForm requestData = Form.form().bindFromRequest();
       	 String sessionID = requestData.get("sessionId");
       	if(sessionID!=null){
       	 db.connect();
       	 String stat=db.getSessionStat(sessionID);
       	 List<Sessions> sessions=db.getsessions();
       	 db.close();
       	return ok(index.render(stat,sessions));
       	}
        db.connect();
      	 ArrayList<Sessions> sessions=db.getsessions();
      	 db.close();
    		return ok(index.render("",sessions));
    	}
    }
   
   
    public static Result login() {
        return ok(login.render(Form.form(Login.class)));
    }
    public static Result logout() {
    	session().clear();
    	return redirect(
	            routes.Application.login()
	        );
    }
    
    public static Result authenticate() {
    	   Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
    	    if (loginForm.hasErrors()) {
    	        return badRequest(login.render(loginForm));
    	    } else {
    	        session().clear();
    	        session("email", loginForm.get().email);
    	        return redirect(
    	            routes.Application.index()
    	        );
    	    }
    }
    public static Result saveVote(String idSession, String idVoter, String vote, String time) {
    	db.connect();
    	db.addVote(idSession, idVoter, vote, time);
    	db.close();
    	return ok("Done");
     
    }
    
    
    public static Result getVoteStats(){
    	 DynamicForm requestData = Form.form().bindFromRequest();
    	 String sessionID = requestData.get("sessionId");
    	 db.connect();
    	 String stat=db.getSessionStat(sessionID);
    	 db.close();
    	 
    	return ok(stat);
    }
  //login class
    public static class Login {

        public String email;
        public String password;
        public String validate() {
        	db.connect();
        	boolean login= db.authenticate(email, password);
        	db.close();
            if (login) {
            	return null;
            }
            return "Invalid email or password";
        }
    }
    
    public static class ListSession {

        public String email;
        public String password;
        public String validate() {
        	db.connect();
        	boolean login= db.authenticate(email, password);
        	db.close();
            if (login) {
            	return null;
            }
            return "Invalid email or password";
        }
    }

    
}

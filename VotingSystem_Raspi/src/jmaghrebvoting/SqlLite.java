/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmaghrebvoting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohammed
 */
public class SqlLite {

    private String dBPath = "/home/pi/db/jMaghrebVoting.db";
    private Connection connection = null;
    private Statement statement = null;

    //Connection to Database
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dBPath);
            statement = connection.createStatement();
            System.out.println("Connection to " + dBPath + ": Done");
        } catch (ClassNotFoundException notFoundException) {
            notFoundException.printStackTrace();
            System.out.println("Connection Error");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Connection Error");
        }
    }

    //Close connection

    public void close() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //add vote to database

    public void addVote(Vote vote) {
        String query = "";
        query += "INSERT INTO VOTES VALUES (NULL,";
        query += "'" + vote.getIdSession() + "', ";
        query += "'" + vote.getIdVoter() + "', ";
        query += "'" + vote.getVote() + "', ";
        query += "'" + vote.getTime() + "' ,";
        query += "'" + vote.getSyn() + "'); ";
        System.out.println(query);
        try {
            statement.executeUpdate(query);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //check if there is any vote wit hthe same Voter id and session id

    public boolean voteNotExist(String idVoter, String idSession) {
        String query = "Select * from votes where idSession='" + idSession + "' and idVoter='" + idVoter + "';";
        ResultSet res;
        try {
            res = statement.executeQuery(query);
            if (res.next()) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;

    }

    public ArrayList<Vote>  SyncVotes() {
        ArrayList<Vote> votes = new ArrayList<Vote>();
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM VOTES WHERE SYN='no';");
            while (rs.next()) {
                votes.add(new Vote(rs.getInt("id"), rs.getString("idSession"), rs.getString("idVoter"),  rs.getString("vote"),  new Date(rs.getString("time")),  rs.getString("syn")));
       
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return votes;
    }
   public void updateVotes(int id){
       String query="UPDATE votes set syn = 'yes' where id=+"+id+";";
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   }
}

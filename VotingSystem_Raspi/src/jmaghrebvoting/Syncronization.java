/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jmaghrebvoting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author mohammed
 */
public class Syncronization extends TimerTask{
    Timer timer;
    ArrayList<Vote> votes=new ArrayList<Vote>();
    public Syncronization(Timer timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        SqlLite db=new SqlLite();
        db.connect();
        votes=db.SyncVotes();
        db.close();
       votes.stream().forEach((vote) -> {
            try {
                
                String savevotesurl = "http://jmaghrebvoting.herokuapp.com/idSession/" + vote.getIdSession() + "/idVoter/" + URLEncoder.encode(vote.getIdVoter(),"UTF-8") + "/vote/" + vote.getVote() + "/time/" + URLEncoder.encode(vote.getTime().toString(),"UTF-8")+"";
                
                URL url = new URL(savevotesurl);
                URLConnection urlConnection = url.openConnection();
                 // Read the response
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(urlConnection.getInputStream()));
                String line = in.readLine();
                
                if (line.equals("Done")) {
                    db.connect();
                    db.updateVotes(vote.getId());
                    db.close();
                }
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
      
    }   
}

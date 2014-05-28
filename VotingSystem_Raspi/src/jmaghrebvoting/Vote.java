/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jmaghrebvoting;

import java.util.Date;

/**
 *
 * @author mohammed
 */
public class Vote {
    private Integer id;
    private String idSession;
    private String idVoter;
    private String vote;
    private Date time;
    private String syn;

    public Vote( String idSession, String idVoter, String vote,Date time, String syn) {
        this.idSession = idSession;
        this.idVoter = idVoter;
        this.vote = vote;
        this.time=time;
        this.syn = syn;
    }

    public Vote(Integer id, String idSession, String idVoter, String vote, Date time, String syn) {
        this.id = id;
        this.idSession = idSession;
        this.idVoter = idVoter;
        this.vote = vote;
        this.time = time;
        this.syn = syn;
    }
    
    

    public Integer getId() {
        return id;
    }

    public String getIdSession() {
        return idSession;
    }

    public String getIdVoter() {
        return idVoter;
    }

    public String getVote() {
        return vote;
    }

    public String getSyn() {
        return syn;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdSession(String idSession) {
        this.idSession = idSession;
    }

    public void setIdVoter(String idVoter) {
        this.idVoter = idVoter;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public void setSyn(String syn) {
        this.syn = syn;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
    
    
    
    
    
}

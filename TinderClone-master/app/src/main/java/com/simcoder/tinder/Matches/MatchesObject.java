package com.simcoder.tinder.Matches;

/**
 * Created by manel on 10/31/2017.
 */

public class MatchesObject {
    private String userId;
    private String name;
    //private String profileImageUrl;
    public String answers;
    public String priorities;
    public MatchesObject (String userId, String name, String ans, String prio){
        this.userId = userId;
        this.name = name;
        //this.profileImageUrl = profileImageUrl;
        this.answers = ans;
        this.priorities = prio;
    }

    public String getUserId(){
        return userId;
    }
    public void setUserID(String userID){
        this.userId = userId;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

}

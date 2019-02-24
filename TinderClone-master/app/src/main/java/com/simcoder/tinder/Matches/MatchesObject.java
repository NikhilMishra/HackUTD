package com.simcoder.tinder.Matches;

/**
 * Created by manel on 10/31/2017.
 */

public class MatchesObject {
    private String userId;
    private String name;
//    public String answers;
//    public String priorities;
    public String matchPercentage;
    private String profilePic;

    public MatchesObject (String userId, String name, String ans, String profpic){
        this.userId = userId;
        this.name = name;
        this.profilePic = profpic;
//        this.answers = ans;
//        this.priorities = prio;
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

    public String getProfileImageUrl(){
        return profilePic;
    }
    public void setProfileImageUrl(String profpic){
        this.profilePic = profpic;
    }

//    public String getPriorities(){
//        return priorities;
//    }
//    public void setPriorities(String prior){
//        this.priorities = prior;
//    }

    public String getMatchPercentage(){
        return matchPercentage;
    }
    public void setMatchPercentage(String match){
        this.matchPercentage = match;
    }

}

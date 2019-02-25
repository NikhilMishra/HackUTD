package com.simcoder.tinder.Cards;

/**
 * Created by manel on 9/5/2017.
 */

public class cards {
    private String userId;
    private String name;
//    public String answers;
//    public String priorities;
    public int matchPercentage;
    private String profilePic;

    public cards (String userId, String name, int matchp, String profpic){
        this.userId = userId;
        this.name = name;
//        this.answers = answers;
//        this.priorities = priorities;
        this.matchPercentage = matchp;
        this.profilePic = profpic;
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
}

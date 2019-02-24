package com.simcoder.tinder.Cards;

/**
 * Created by manel on 9/5/2017.
 */

public class cards {
    private String userId;
    private String name;
    public String answers;
    public String priorities;
    public int matchPercentage;
    public cards (String userId, String name, String answers, String priorities, int matchp){
        this.userId = userId;
        this.name = name;
        this.answers = answers;
        this.priorities = priorities;
        this.matchPercentage = matchp;
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

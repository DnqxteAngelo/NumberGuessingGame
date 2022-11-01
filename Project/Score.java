package com.mycompany.numberguessinggame;

public class Score {
    private String name, grade;
    private int highScore;
    
    public Score (String name, int highScore, String grade){
        this.name = name;
        this.highScore = highScore;
        this.grade = grade;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getHighScore(){
        return this.highScore;
    }
    public void setHighScore(int highScore){
        this.highScore = highScore;
    }
    public String getGrade(){
        return this.grade;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
}
package com.mycompany.numberguessinggame;
import java.util.Comparator;

public class ScoreComparator implements Comparator<Score>{
    @Override
    public int compare(Score a, Score b){
        if(a.getHighScore() == b.getHighScore()){
            return a.getName().compareTo(b.getName());
        }
        return b.getHighScore() - a.getHighScore();
    }   
}
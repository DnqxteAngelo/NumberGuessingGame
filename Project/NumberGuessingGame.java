package com.mycompany.numberguessinggame;
import java.util.*;

public class NumberGuessingGame {
    public static Random rand = new Random();
    public static Scanner input = new Scanner(System.in);
    public static List <Score> scoreList = new ArrayList<>();
    public static char exit, difficulty, retry, option;
    public static int points = 100;
    public static int count = 1;
    public static int highScore, guessNum, randomNum;
    public static String name, grade, comment;
    
    public static void casual(){
        do {
            randomNum = rand.nextInt(100) + 1;
            //System.out.println(randomNum);
            
            do {
		System.out.print("\nEnter your guess (1-100): ");
		guessNum = input. nextInt();

		if (guessNum == randomNum) {
                    System.out.println("Correct! You win!");
		} else if (randomNum > guessNum) {
                    System.out.println("Incorrect! The number is higher.");
                    count = count + 1;
		} else {
                    System.out.println("Incorrect! The number is lower.");
                    count = count + 1;
		}
            } while (guessNum != randomNum);
                if(count == 1){
                    comment = "Wow! You're a psychic!";
                }else if(count > 1 && count <= 3){
                    comment = "Excellent! You guessed it in a few tries.";
                }else if(count > 3 && count <= 7){
                    comment = "Very good! You guessed it right.";
                }else if(count > 7 && count <= 10){
                    comment = "Good! But you can do better.";
                }else if(count > 10 && count <= 15){
                    comment = "Not bad! Keep it up.";
                }else if(count > 15 && count <= 30){
                    comment = "Can't say you're good at this";
                }else if(count > 30 && count < 50){
                    comment = "At least you still guessed it.";
                }else if(count >= 50){
                    comment = "Wow! You finally got it!";
                }
                System.out.println("\nNumber of attempts: " + count + "\n" + comment);
		count = 1;
		System.out.println("\nWould you like to play again? (Y/N)");
		retry = input.next().charAt(0);
            } while (retry == 'Y' || retry == 'y');
    }
    
    public static void survival(){
        do {
            randomNum = rand.nextInt(100) + 1;
            //System.out.println(randomNum);
            System.out.println("\nScore: " + points);
            
            do {
		System.out.print("\nEnter your guess (1-100): ");
		guessNum = input. nextInt();

		if (guessNum == randomNum) {
                    System.out.println("Correct! You win!");
                    System.out.println("\nScore: " + points);
		} else if (randomNum > guessNum) {
                    System.out.println("Incorrect! The number is higher.");
                    points = points - 10;
                    System.out.println("\nScore: " + points);
		} else {
                    System.out.println("Incorrect! The number is lower.");
                    points = points - 10;
                    System.out.println("\nScore: " + points);
		}
            } while (guessNum != randomNum && points != 0);
            if(points == 100){
                comment = "You're a psychic!";
                System.out.println(comment);
            }else if(points < 100 && points >= 80){
                comment = "Excellent! You guessed it in a few tries.";
                System.out.println(comment);
            }else if(points < 80 && points >= 60){
                comment = "Very good! You guessed it right.";
                System.out.println(comment);
            }else if(points < 60 && points >= 40){
                comment = "Good! But you can do better.";
                System.out.println(comment);
            }else if(points < 40 && points >= 20){
                comment = "Not bad! Keep it up.";
                System.out.println(comment);
            }else if(points == 10){
                comment = "Clutch! You almost didn't got it.";
                System.out.println(comment);
            }
  
            if(points > 0){
                Score score = inputHighScore();
                addhighScore(score);
            }else{
                System.out.println("Better luck next time!");
            }
            System.out.println("\nHigh Scores");
            showHighScore();
                
            points = 100;
            count = 1;
            System.out.println("\nWould you like to play again? (Y/N)");
            retry = input.next().charAt(0);
        } while (retry == 'Y' || retry == 'y');
    }
    
    public static void addhighScore(Score score){
        scoreList.add(score);
        Collections.sort(scoreList, new ScoreComparator());
    }
    
    public static Score inputHighScore(){
        System.out.print("\nNew Score! \nEnter your name: ");
        name = input.next();
        highScore = points;
        if(highScore == 100){
            grade = "Psychic";
        }else if(highScore < 100 && highScore >= 80){
            grade = "Excellent";
        }else if(highScore < 80 && highScore >= 60){
            grade = "Very good";
        }else if(highScore < 60 && highScore >= 40){
            grade = "Good";
        }else if(highScore < 40 && highScore >= 20){
            grade = "Not bad";
        }else if(highScore == 10){
            grade = "Unlucky";
        }
        Score score = new Score (name, highScore, grade);
        return score;
    }
    
    public static void showHighScore(){
        for(Score score : scoreList){
            System.out.println("\nName: " + score.getName()
                    + "\nScore: " + score.getHighScore() + "\nGrade: " + score.getGrade());
        }  
    }
    
    public static void mainfunct(){
            do {
		System.out.println("Choose the difficulty. \n1. Casual \n2. Survival \n3. Exit");
		System.out.print("Difficulty: ");
		difficulty = input.next().charAt(0);

		switch (difficulty) {
                    case '1':
			casual();
                        break;
                    case '2':
			survival();
                        break;
                    case '3':
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nInvalid Option\n");
                        mainfunct();
                        break;
		}
                
		System.out.println("Would you like to exit? (Y/N)");
		exit = input.next().charAt(0);
		System.out.print("\n");
            } while (exit != 'Y' && exit != 'y');
    }
    
    public static void main(String[] args) {
        mainfunct();
    } 
}
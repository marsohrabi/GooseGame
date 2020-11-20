package cat;

import java.util.Random;
import java.util.Scanner;

/**
 * The Cat Class is the logic class for the Event of Cat
 * Who appears once per game on a 1% chance and gives questions
 * If you answer a wrong answer, you are insulted
 * If you answer correctly, you will receive a life lesson from the cat.
 * @author Romano Kim
 *
 */

public class Cat {
	
	private Random rng = new Random();
	boolean appearance = false;
	
	// Setter for appearance, if appeared before appear method doesnt work
	// Takes in boolean as an argument to change the appearance of the cat
	public void setAppearance(boolean appear) {
		appearance = appear;
	}
	
	// No param, Returns boolean 
	// Booealn is True if the cat will appear with a 1% Chance, unless it if has appeared before
	public boolean appear() {
		int appearChance = 0;
		int randomNumber = rng.nextInt(100);
		if (appearance != true) {
			// Numbers of 0 would trigger this
			if (appearChance >= randomNumber) {
				appearance = true;
			}
		}
		setAppearance(appearance);
		return appearance;
	}
	
	// No param, returns Int
	// Int returned defines what question will be asked
	// Choosing what kind of question will be asked to the player when it appears returns the question number
	public int catQuestion() {
		
		int randomNumber = rng.nextInt(100);
		int questionNum = 0;
		String question;
		
		// 50% Chance of getting these average question
		if (49 >= randomNumber){
			// 25% Chance of getting this math pattern question
			if (randomNumber%2 == 0) {
				//question = "1, 8, 11, 69, 88, 96, 101.. what is the next number?\n1. 117\n2. 111\n3. 123\n 106";
				questionNum = 1;
			}
			// 25% Chance of getting this Goose question
			else {
				//question = "What is the number of the Aesop Parable:\nThe Goose that laid the Golden Eggs?\n1. 15\n2. 63\n3. 87\n4. 29";
				questionNum = 2;
			}
		}
		
		// 50% Chance of getting these Extreme question
		else {
			// 25% Chance of this Extremely easy question
			if (randomNumber%2 == 0) {
				//question = "What's nine plus ten?\n1. 19\n2. 20\n3. 21\n4. 22";
				questionNum = 3;
			}
			// 25% Chance of getting this Extremely hard question
			else {
				//question = "What is a group of geese in flight specifically called?\n1. gaggle\n2. flock\n3. gosling\n4. skein";
				questionNum = 4;
			}
		}
		// Prints out the question according to rng
		return questionNum;
	}
	
	// Takes the quizNumber and the user input and returns if the answer is correct 
	public boolean catQuiz(char in, int quizNumber) {
		
		int quizNum = quizNumber;
		char userIn = in;
		boolean questionRight = false;
		
		if (quizNum == 1) {
			if (userIn == '2') {
				questionRight = true;
			}
		}
		
		else if (quizNum == 2) {
			if (userIn == '3') {
				questionRight = true;
			}
		}
		
		else if (quizNum == 3) {
			if (userIn == '1') {
				questionRight = true;
			}
		}
		
		else {
			if (userIn == '4'){
				questionRight = true;
			}
		}
		//if (questionRight) {
		//	System.out.println("You are right!\nType in anything to continue");
		//}
		//if (!questionRight) {
		//	System.out.println("You are wrong...\nType in anything to continue");
		//}
		return questionRight;
	}
	
	// No Param, returns int
	// Int returned defines which question to be asked
	// Practically same method as catQuestion, but for the end game cat
	public int gCatQuestion() {
		
		int randomNumber = rng.nextInt(100);
		int questionNum = 0;
		// private string question;
		
		// 50% Chance of getting map based questions
		if (49 >= randomNumber){
			// 25% Chance of getting this fence question
			if (randomNumber%2 == 0) {
				//question = "How many fences were there in the First map?";
				questionNum = 1;
			}
			// 25% Chance of getting this bush question
			else {
				//question = "How many bushes were there in the First map?";
				questionNum = 2;
			}
		}
		
		// 50% Chance of getting questions
		else {
			// 25% Chance of this Extremely easy question
			if (randomNumber%2 == 0) {
				//question = "How many eyes does a goose have?";
				questionNum = 3;
			}
			// 25% Chance of getting this Extremely hard question
			else {
				//question = "What is a group of geese in flight specifically called?";
				questionNum = 4;
			}
		}
		// Not used anymore
		//system.out.println(question)
		return questionNum;
	}
	
}

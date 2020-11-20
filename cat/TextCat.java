package cat;

import java.util.Scanner;

/** 
 * TextCat Class
 * Displays the cat class on the Text Version of the game
 * @Author Romano Kim
 **/
 
 public class TextCat {
	
	Cat catLogic = new Cat();
	
	int quizNum = 0;
	
	public int catQDisplay() {
	
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nThe Cat Has Appeared!!\nAnd it is asking you a question...");
		
		int quizNum = catLogic.catQuestion();
		
		if (quizNum == 1) {
			System.out.println("1, 8, 11, 69, 88, 96, 101.. what is the next number?\n1. 117\n2. 111\n3. 123\n4. 106");
		}
		
		else if (quizNum == 2) {
			System.out.println("What is the number of the Aesop Parable:\nThe Goose that laid the Golden Eggs?\n1. 15\n2. 63\n3. 87\n4. 29");
		}
		
		else if (quizNum == 3) {
			System.out.println("What's nine plus ten?\n1. 19\n2. 20\n3. 21\n4. 22");
		}
		else {
			System.out.println("What is a group of geese in flight specifically called?\n1. gaggle\n2. flock\n3. gosling\n4. skein");
		}
		System.out.println("What is your answer???\n\n");
		return quizNum;
	}
	
	public int gCatQDisplay() {
	
		System.out.println("/n/n/n/n/n/n/n/n/n/n/n/n/n/n/n/n/nThe Cat Has Appeared!!\nAnd it is asking you a question...");
		
		int quizNum = catLogic.gCatQuestion();
		
		if (quizNum == 1) {
			System.out.println("How much gross income does a farm need to be considered a farm?\n1. 30000\n2. 40000\n3. 50000\n4. 60000");
		}
		
		else if (quizNum == 2) {
			System.out.println("What is a female goose called?\n1. gaggle\n2. goose\n3. geese\n4. gosling");
		}
		
		else if (quizNum == 3) {
			System.out.println("How many fences were there on the first map?\n1. 25\n2. 19n3. 21\n4. 31");
		}
		else {
			System.out.println("How many bushes were there on the map?\n1. 13\n2. 4\n3. 6\n4. 9");
		}
		System.out.println("What is your answer???");
		return quizNum;
	}
	
	public void catADisplay (char in, int quizNum) {
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		boolean right = catLogic.catQuiz(in, quizNum);
		
		if (right) {
			if (quizNum == 3) {
				System.out.println("Its easy if you give up...");
			}
			else {
				System.out.println("People will say you should follow your dreams\nBut you should really be doing is what you need to do");
			}
		}
		
		else {
			System.out.println("You cant even get a simple question right\nBet you cant even get a job at being homeless");
		}
		System.out.println("The cat leaves...\n");
	}
 }
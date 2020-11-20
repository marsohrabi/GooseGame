import game.*;
import java.util.Scanner;

/**
 * This class is used to start the Goose Game.
 * @author Maryam Sohrabi
 */
public class GooseGame {

	/**
	 * The main method begins the Goose Game by reading the user's name and creating the Player and Map for the game.
	 * The user then specifies whether they want to play a text based or GUI game, and the game begins accordingly.
	 */
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println(" Welcome to The Goose Game! Please enter your name: ");
		
		String userName = scanner.nextLine();
		System.out.println("Enter 'g' to play a GUI game. Enter 't' to play a text based game. Do not enter the quotation marks.");
		char gameMode = scanner.next().charAt(0);
		boolean validGameMode = false;
		
		// The user will be prompted for input until a valid input is detected
		while (!validGameMode){
			if (gameMode == 'g'){
				// A GUI-based game will be created and run
				Game game = new GUIGame(userName);
				game.play();
				validGameMode = true;
			} else if (gameMode == 't'){
				// A text-based game will be created and run
				Game game = new TextGame(userName);
				game.play();
				validGameMode = true;
			} else {
				// The use will be prompted for another input if the last input was invalid
				System.out.println("Invalid input encountered. Enter 'g' or 't' without the quotation marks to begin your game.");
				gameMode = scanner.next().charAt(0);
			}
		}
		scanner.close();
	}

}

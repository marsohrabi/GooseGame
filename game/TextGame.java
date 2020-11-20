package game;
import java.util.Scanner;
import cat.*;

/**
 * This class is used to play The Goose Game in text mode. User input is collected through the w, a, s, d keys.
 * @author Maryam Sohrabi, Romano Kim
 */
public class TextGame extends Game {

	public TextGame(String userName) {
		super(userName);
	}

	@Override
	public void run() {
		setRunning(true);
		boolean instructions = false;
		Scanner scanner = new Scanner(System.in);
		Cat cat = new Cat();
		TextCat tCat = new TextCat();
		boolean cAppear = false;
		int q = 0;
		
		while (running){
			// Upon startup of a text game, the instructions will be displayed and the map will be printed
			if (!instructions){
				System.out.println("\nWelcome " + player.getName());
				System.out.print("\nUse the w, a, s and d keys to move around the map.\n" +
                                    "Your goal is to reach the X.\n" +
						"Press i to list the items in your inventory.\n" +
						"Press q to quit the game.\n" + 
						"Your location is shown as * on the map.\n" +
						"g is for grass - feel free to run around on the grass!\n" +
						"F, w, T, [, l, d, and r are tiles you can't move to.\n" +
						"Even numbers represent keys and odd numbers represent doors.\n\n" +
						"The map is ready for you below.\n" +
						"Have fun!\n\n\n\n\n\n\n");
				gameMap.print();
				instructions = true;
			} 
			
			if (instructions) {
					System.out.println("Enter your next move by entering w, a, s, or d, and press enter.");
					char userInput = scanner.next().charAt(0);
				if (userInput == 'q'){
					// Quits the game if 'q' is pressed
					setRunning(false);
				} else if (userInput == 'i'){
					// Prints the names of the items in the user's inventory
					System.out.println("Items in your inventory: ");
					super.inventory.printInventory();
					System.out.print("\n");
				} else if ((userInput == 'w' || userInput == 'a') || (userInput == 's' || userInput == 'd')){
					// Reacts by attemptin to move the player in the direction the use entered, then prints the map
					super.react(userInput);
					System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					super.gameMap.print();
				}
				if (q == 0) {
					if (cat.appear()) {
						q = tCat.catQDisplay();
						userInput = scanner.next().charAt(0);
						while (userInput != '1'&&userInput !='2'&&userInput !='3'&&userInput !='4') {
							System.out.print("Please put in a valid answer from 1~4\n");
							userInput = scanner.next().charAt(0);
						}
						tCat.catADisplay(userInput, q);
						gameMap.print();
					}
				}	
		}
		scanner.close();

	}

}

package game;
import java.awt.event.KeyEvent;

import maps.*;
import entities.*;

/**
 * The Game class is the parent of the TextGame and GUIGame classes. It is used to run the games and it 
 * holds the information relevant to all games. The Game class controls the reactions to the text-based 
 * and GUI-based games.
 * @author Maryam Sohrabi, Romano Kim
 *
 */
public abstract class Game{

	// The protected instance variables are declared as such in order to give access to the child classes
	// of the Game class.
	protected Player player;
	protected Inventory inventory;
	protected Map gameMap;
	//Cat cat;
	//GateCat gateCat;
	protected boolean running;
	private int gameStage = 1;

	/**
	 * Constructs a new Game using the name that the user enters.
	 * @param userName will be set as the player's name
	 */
	public Game(String userName){
		player = new Player(userName);
		inventory = new Inventory();
	}

	/**
	 * Initializes the game map and runs the game.
	 */
	public void play(){
		gameMap = new Map(gameStage);
		run();
	}

	/**
	 * This abstract class is implemented in Game's child classes.
	 */
	public abstract void run();

	/**
	 * This method controls the game's reaction in the GUI-based game, from the user's keyboard inputs.
	 * @param e the key that the user pressed
	 */
	public void react(KeyEvent e) {
		switch (e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			react('a');
			break;
		case KeyEvent.VK_DOWN:
			react('s');
			break;
		case KeyEvent.VK_RIGHT:
			react('d');
			break;
		case KeyEvent.VK_UP:
			react('w');
			break;

		}
	}

	/**
	 * Sets the game to run. This is required to start and stop the games.
	 * @param state true if the game is running, false if the game is ended
	 */
	public void setRunning(boolean state){
		running = state;
	}

	/**
	 * This method controls the game's reaction in the text-based game, from the characters the user enters.
	 * The method checks for valid movement in the map and checks the status of keys and gates in the map.
	 * If an invalid or illegal move is entered, the player will not be moved. When the player reaches the end
	 * of the stage, the next map will be initialized for play.
	 * @param userInput the character input from the user
	 */
	public void react(char userInput) {
		player.moveTemp(userInput);

		boolean canGoThroughGate = true;

		// If the attempted movement is within the map boundaries:

		if (player.getTempY()>=0 && player.getTempX()>=0 && player.getTempY()<gameMap.getMap().length && player.getTempX()<gameMap.getMap()[0].length){
			char nextPoint = gameMap.charAtPoint(player.getTempY(), player.getTempX());

			if(nextPoint == 'X'){
				gameStage++;
				gameMap = new Map(gameStage);
				inventory = new Inventory();
				if (gameStage<4){
					player.move(2,2);
				} else {
					player.move(5,7);
					setRunning(false);
					
				}

			} else{
				// If the terrain is good to move onto:		
				if (gameMap.isGoodTerrain(nextPoint)) {
					// If the next point has an item:
					if (gameMap.isItem(nextPoint)){
						// Add item to inventory
						inventory.addItemToInv(nextPoint);

						// If the item is a key:
						if (nextPoint == '0' || nextPoint == '2' || nextPoint == '4' || nextPoint == '6' || nextPoint == '8'){

							switch (nextPoint){
							case '0': gameMap.setKey(0); break;
							case '2': gameMap.setKey(1); break;
							case '4': gameMap.setKey(2); break;
							case '6': gameMap.setKey(3); break;
							case '8': gameMap.setKey(4); break;
							}

						} // If the next point is a gate:
					} else if (nextPoint == '1' || nextPoint == '3' || nextPoint == '5' || nextPoint == '7' || nextPoint == '9'){
						int keyNumber = 0;

						// Each gate number corresponds to a key
						switch (nextPoint){
						case '1': keyNumber = 0; break;
						case '3': keyNumber = 1; break;
						case '5': keyNumber = 2; break;
						case '7': keyNumber = 3; break;
						case '9': keyNumber = 4; break;
						}
						canGoThroughGate = gameMap.getKeyValue(keyNumber);
					}

					// move the player if there is no gate in the way or if the gate is open
					if (canGoThroughGate){
						gameMap.setTerrain(player.getY(), player.getX(), 'g');
						gameMap.setTerrain(player.getTempY(), player.getTempX(), '*');
						player.move(player.getTempY(), player.getTempX());
					}
				}

			}

		}

	}

}

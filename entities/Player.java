package entities;
import java.awt.event.KeyEvent;

/**
 * This class holds all of the information about the user's character in the game.
 * @author Steven La, Maryam Sohrabi
 */
public class Player {
	private String name;
	private int xCoord=2;
	private int yCoord=2;
	private int tempXCoord;
	private int tempYCoord;

	/**
	 * Constructor that takes a String and sets it as the player's name.
	 * @param userName the player's name
	 */
	public Player(String userName){
		name = userName;
	}
	
	/**
	 * Returns the player's name.
	 * @return the player's name
	 */
	public String getName(){
		return name;
	}

	/**
	 * Sets the player's X-coordinate.
	 * @param xcoord the integer that the player's X-coordinate will be set to
	 */
	public void setX(int xToSet){
		xCoord = xToSet;
	}

	/**
	 * Sets the player's Y-coordinate.
	 * @param xcoord the integer that the player's Y-coordinate will be set to
	 */
	public void setY(int yToSet){
		yCoord = yToSet;
	}

	/**
	 * Returns the player's X-coordinate.
	 */
	public int getX(){
		return xCoord;
	}

	/**
	 * Returns the player's Y-coordinate.
	 */
	public int getY(){
		return yCoord;
	}

	/**
	 * Returns the player's temporary X-coordinate.
	 * @return the player's temporary X-coordinate
	 */
	public int getTempX(){
		return tempXCoord;
	}
	/**
	 * Returns the player's temporary Y-coordinate.
	 * @return the player's temporary Y-coordinate
	 */
	public int getTempY(){
		return tempYCoord;
	}

	/**
	 * Temporarily moves the player based on arrow key input.
	 * @param movement the arrow key that was pressed (up, left, down, or right)
	 */
	public void moveTemp(KeyEvent movement){
		switch (movement.getKeyCode()){
		case KeyEvent.VK_LEFT: 
			tempXCoord = xCoord - 1;
			tempYCoord = yCoord;
			break;
		case KeyEvent.VK_RIGHT:
			tempXCoord = xCoord + 1;
			tempYCoord = yCoord;
			break;
		case KeyEvent.VK_DOWN:
			tempXCoord = xCoord;
			tempYCoord = yCoord + 1;
			break;
		case KeyEvent.VK_UP:
			tempXCoord = xCoord;
			tempYCoord = yCoord -1;
			break;
		}
	}

	/**
	 * Temporarily moves the player based on the character that was entered.
	 * @param movement the character entered (w, a, s, or d)
	 */
	public void moveTemp(char movement){
		switch (movement){
		case 'a':
			tempXCoord = xCoord - 1;
			tempYCoord = yCoord;
			break;
		case 'd':
			tempXCoord = xCoord + 1;
			tempYCoord = yCoord;
			break;
		case 's':
			tempXCoord = xCoord;
			tempYCoord = yCoord + 1;
			break;
		case 'w':
			tempXCoord = xCoord;
			tempYCoord = yCoord -1;
			break;
		}
	}

	/**
	 * Moves the player to the coordinates given.
	 * @param rowIndex the row in the map that the player will be moved to
	 * @param colIndex the column in the map that the player will be moved to
	 */
	public void move(int rowIndex, int colIndex){
		setY(rowIndex);
		setX(colIndex);
	}

}

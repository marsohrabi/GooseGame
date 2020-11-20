package game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

import tiles.Tile;

/**
 * This class is used to play The Goose Game in GUI mode. User input is collected through the arrow keys.
 * @author Maryam Sohrabi, Han Wang
 */
public class GUIGame extends Game implements KeyListener {

	private GooseGameGUI gui = new GooseGameGUI(this);

	/**
	 * Creates a new instance of the GUIGame and sets the user's name.
	 * @param userName the name the user enters in the console
	 */
	public GUIGame(String userName) {
		super(userName);
	}

	/**
	 * This method is called when the game is started. It will set the game window and populate
	 * the necessary Tiles for the map and inventory before painting the map.
	 */
	@Override
	public void run() {

		gui.getContentPane().addKeyListener(this);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setResizable(false);
		gui.getContentPane().setFocusable(true);
		gui.requestFocusInWindow();
		gui.setVisible(true);		

		// Add all starting map tiles to the GUI
		for (int rowIndex=0; rowIndex<gameMap.getMap().length; rowIndex++){
			for (int colIndex=0; colIndex<gameMap.getMap()[rowIndex].length; colIndex++){
				Tile tile = new Tile(gameMap.getMap()[rowIndex][colIndex], rowIndex, colIndex);
				gui.addTile(tile);
			}
		}

		// Add the starting inventory tiles to the GUI to begin
		for (int index=0; index<inventory.getItemChars().length; index++){
			if (inventory.getItemList()[index]){
				Tile tile = new Tile(inventory.getItemChars()[index], 10, index);
				gui.addInvTile(tile);
			}
		}
		gui.repaint();
	}

	/**
	 * This method is not used in this project.
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// No action required.

	}

	/**
	 * This method will take the user's input from the game window and handle the input.
	 * The game will end if the user presses 'q'.
	 * @param e the user's input through the keyboard
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		// The game will be closed if the user enters 'q'. If any other key is entered, the Game class
		// will react appropriately and the game window will be repainted.
		if (e.getKeyChar() == 'q'){
			gui.dispose();
			setRunning(false);

		} 
		else {
			react(e);
			gameMap.setTiles(gameMap.getMap());
			gui.tilesToDraw = gameMap.getTiles();
			inventory.setInventoryTiles(inventory.getItemChars());
			gui.inventoryTiles = inventory.getTiles();
			gui.repaint();
		}
	}

	/**
	 * This method is not used in this project.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// No action required.

	}

}

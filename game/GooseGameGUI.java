package game;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import tiles.Tile;

/**
 * Class used to display the Goose Game window to the user. GooseGameGUI takes keyboard
 * input which the GUIGame class handles.
 * @author Maryam, Han Wang
 *
 */
public class GooseGameGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private final int TILE_SIZE = 64;
	final int WINDOW_WIDTH = TILE_SIZE*15;
	final int WINDOW_HEIGHT = TILE_SIZE*11;

	// These ArrayLists are not declared private because they are references to the
	// map Tile and inventory Tile ArrayLists in the GUIGame class.
	ArrayList<Tile> tilesToDraw = new ArrayList<Tile>();
	ArrayList<Tile> inventoryTiles = new ArrayList<Tile>();

	/**
	 * Constructs a new GUI and creates the window where the game will be played.
	 * @param g the game that the user is playing in, where the logic of the game is held
	 */
	public GooseGameGUI(KeyListener listener){
		super("GOOSE GAME");

		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);	

		repaint();
	}

	/**
	 * Paints the map and inventory Tiles to the game window.
	 */
	@Override
	public void paint(Graphics canvas){
		super.paint(canvas);
		// Draw the map tiles
		for (Tile t : tilesToDraw){
			t.drawTile(canvas);
		}
		// Draw the inventory tiles
		for (Tile t: inventoryTiles){
			t.drawTile(canvas);
		}
	}

	/**
	 * This method adds a tile to the tiles arraylist.
	 * 
	 * @param t is the tile that is added to the tiles arraylist
	 */
	public void addTile(Tile t){
		tilesToDraw.add(t);
		//System.out.println("Tile added");
	}

	/**
	 * Adds the given inventory item Tile to the inventoryTiles ArrayList.
	 * @param itemTile inventory item Tile to be added
	 */
	public void addInvTile(Tile itemTile){
		inventoryTiles.add(itemTile);
	}

	/**
	 * This main class will create a new GUI for testing purposes.
	 *//*
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				 GooseGameGUI newGUI = new GooseGameGUI(this);
                      Map map = new Map(1);
                      map.setTiles(map.getMap());
                      newGUI.tilesToDraw = map.getTiles();
                      newGUI.paint(newGUI.getGraphics());


			}
		});
	}*/





}

package tiles;
import java.awt.Graphics;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Tile objects are used to store information that will be used to draw an image 
 * onto a Graphics object. Tile objects have coordinates, size, a type and an image. 
 * @author Maryam Sohrabi
 *
 */
public class Tile{

	private int xCoord, yCoord;
	private final int TILE_SIZE = 64;
	private String tileType;
	private BufferedImage tileImage;

	/**
	 * Constructs a new tile and imports the tile's image.
	 * @param c the character that represents the tile, usually from a .txt file
	 * @param yIndex the row index of the tile in the whole game map
	 * @param xIndex the column index of the tile in the whole game map
	 */
	public Tile(char c, int yIndex, int xIndex){
		xCoord = xIndex;
		yCoord = yIndex;

		switch (c){
		case 'X': tileType = "X"; break;
		case 'I': tileType = "I"; break;
		case '-': tileType = "-"; break;
		case 'g': tileType = "grass"; break;
		case '[': tileType = "["; break;
		case 'T': tileType = "T"; break;
		case 'Q': tileType = "Q"; break;
		case 'F': tileType = "fence"; break;
		case 'w': tileType = "water"; break;
		case '*': tileType = "player"; break;
		case '0': tileType = "key"; break;
		case '1': tileType = "gate"; break;
		case '2': tileType = "key"; break;
		case '3': tileType = "gate"; break;
		case '4': tileType = "key"; break;
		case '5': tileType = "gate"; break;
		case '6': tileType = "key"; break;
		case '7': tileType = "gate"; break;
		case '8': tileType = "key"; break;
		case '9': tileType = "gate"; break;
		case 'r': tileType = "rshrub"; break;
		case 'l': tileType = "lshrub"; break;
		case 'd': tileType = "dshrub"; break;
		}

		tileImage = loadTileImage(tileType + ".png");

	}

	/**
	 * Returns the column index of the tile.
	 */
	public int getXCoord(){
		return xCoord;
	}

	/**
	 * Returns the row index of the tile.
	 */
	public int getYCoord(){
		return yCoord;
	}

	/**
	 * @return the type of the tile.
	 */
	public String getTileType(){
		return tileType;
	}

	/**
	 * @return Image of the tile
	 */
	public BufferedImage getTileImage(){
		return tileImage;
	}

	/**
	 * @return size of the tile
	 */
	public int getTileSize(){
		return TILE_SIZE;
	}

	/**
	 * Loads the image of the tile given the type of tile.
	 * @param fileName the name of the image file corresponding to that type of tile
	 */
	public BufferedImage loadTileImage(String fileName){
		BufferedImage img = null;

		try{
			img = ImageIO.read(new File(fileName));
		} catch(IOException e){
			System.out.print("Could not load tile image");
		}

		return img;
	}

	/**
	 * Draws a tile to a Graphics object.
	 * @param g the Graphics object that the tile will be drawn onto
	 */
	public void drawTile(Graphics g){

		g.drawImage(tileImage, xCoord*TILE_SIZE, yCoord*TILE_SIZE, null);
	}

}
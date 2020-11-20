package maps;
import tiles.Tile;

import java.awt.Graphics;
import java.util.ArrayList;

public class TileMap {
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	// Constructs a tile map given the character map of the game
	public TileMap(char[][] charMap){
		for (int row=0; row<charMap.length; row++){
			for (int col=0; col<charMap[0].length; col++){
				tiles.add(new Tile(charMap[row][col], row, col));
			}
		}
	}
	
	public void clearTiles(){
		tiles.clear();
	}
	
	public void draw(Graphics canvas){
		for (Tile t: tiles){
			canvas.drawImage(t.getTileImage(), t.getXCoord()*t.getTileSize(), t.getYCoord()*t.getTileSize(), null);
		}
		
	}



}

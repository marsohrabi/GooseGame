package maps;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import tiles.Tile;

/**
 * The Map class holds all of the information that is required for the player to move around
 * in the game map. It is used in both text-based and GUI-based games. Map information is read from
 * text files in the project directory.
 * @author Maryam Sohrabi, Romano Kim
 *
 */
public class Map {
	private char[][] gameMap;
	private char[][] badTerrain;
	private char[][] itemsOnMap;
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	private boolean[] keys = new boolean[5];

	/**
	 * Constructor that sets the map, bad terrain, and items character arrays based on the game stage.
	 * @param stage the game stage that will be loaded
	 */
	public Map(int stage){
		initialize(stage);
	}

	/**
	 * Sets the tiles from the current character array of the game map.
	 * @param mapToSet the game map
	 */
	public void setTiles(char[][] mapToSet){
		tiles.clear();
		for (int rowIndex=0; rowIndex<gameMap.length; rowIndex++){
			for (int colIndex=0; colIndex<gameMap[rowIndex].length; colIndex++){
				Tile tile = new Tile(gameMap[rowIndex][colIndex], rowIndex, colIndex);
				tiles.add(tile);
			}
		}
	}

	/**
	 * Returns a copy of the game map array.
	 * @return a copy of the game map array
	 */
	public char[][] getMap(){
		char[][] mapToReturn = new char[gameMap.length][gameMap[0].length];

		for (int i=0; i<gameMap.length; i++){
			for (int j=0; j<gameMap[0].length; j++){
				mapToReturn[i][j] = gameMap[i][j];
			}
		}
		return mapToReturn;
	}

	/**
	 * Sets the character at a given index in the map array.
	 * @param rowIndex the row index of the character
	 * @param colIndex the column index of the character
	 * @param terrainToSet the new character that will be set at the given indices
	 */
	public void setTerrain(int rowIndex, int colIndex, char terrainToSet){
		gameMap[rowIndex][colIndex] = terrainToSet;
	}

	/**
	 * Returns the character in the game map at the index given.
	 * @param rowIndex the row index in the game map that will be checked
	 * @param colIndex the column index in the game map that will be checked
	 * @return the character at the given indices
	 */
	public char charAtPoint(int rowIndex, int colIndex){
		return gameMap[rowIndex][colIndex];
	}

	/**
	 * Checks the character provided as a parameter against the badTerrain array.
	 * Returns true if the character does not match any of the bad terrain characters.
	 * @param rowIndex the row index in the game map that will be checked
	 * @param colIndex the column index in the game map that will be checked
	 * @param terrainToCheck the character that will be compared to the list of characters that the player can't move to in the map
	 * @return true if the character at the index is good for the player to move to
	 */
	public boolean isGoodTerrain(char terrainToCheck){
		int badTerrainCounter = 0;

		for (int i = 0; i< badTerrain[0].length; i++){
			if (terrainToCheck == badTerrain[0][i]) {
				badTerrainCounter++;
			}
		}
		return (badTerrainCounter == 0);
	}

	/**
	 * Sets the key at the given index of the keys ArrayList to true when it is picked up.
	 * @param keyNum the index of the key that was picked up
	 */
	public void setKey(int keyNum){
		keys[keyNum] = true;
	}

	/**
	 * Checks if the key at the given index of the keys ArrayList has been picked up.
	 * @param keyIndex the index of the key being checked in the keys ArrayList 
	 * @return true if the key has been picked up
	 */
	public boolean getKeyValue(int keyIndex){
		boolean keyValue = keys[keyIndex];
		return keyValue;
	}

	/**
	 * Checks if the character given matches an item in the current stage of the game.
	 * @param charToCheck the character that will be checked
	 * @return true if the character matches an item in this stage of the game
	 */
	public boolean isItem(char charToCheck){
		int itemCounter = 0;

		for(int i=0; i<itemsOnMap[0].length; i++){
			if (charToCheck == itemsOnMap[0][i]){
				itemCounter++;
			}
		}
		return (itemCounter>0);
	}

	/**
	 * Prints the current game map to the console.
	 */
	public void print(){
		for (int i=0; i<gameMap.length; i++){
			for(int j=0; j<(gameMap[0].length-1); j++){
				System.out.print(gameMap[i][j]);
			}

			System.out.println(gameMap[i][(gameMap[0].length)-1]);
		}
	}

	/**
	 * Returns the tiles representing the current game map.
	 * @return the ArrayList holding the tiles of the game map
	 */
	public ArrayList<Tile> getTiles(){
		return tiles;
	}

	/**
	 * Sets the map, bad terrain, and item character arrays for the game stage given.
	 * @param stage the stage of the game for which the arrays will be loaded
	 */
	public void initialize(int stage){
		gameMap = textToCharArray("map" + stage + ".txt");
		badTerrain = textToCharArray("terrain.txt");
		itemsOnMap = textToCharArray("items.txt");

	}

	/**
	 * Takes a text file and converts its contents to a character array.
	 * @param fileName the name of the text file that will be converted into a character array
	 * @return the character array representation of the text file
	 */
	public char[][] textToCharArray(String fileName){
		int[] dim = getDimensions(fileName);

		char[][] arrayOutput = new char[dim[0]][dim[1]];

		try{
			char[] lineArray;

			String line;
			FileReader fr;
			BufferedReader br;

			fr = new FileReader("" +fileName);
			br = new BufferedReader(fr);
			line = br.readLine();

			for (int i =0; i<dim[0]; i++){
				line = br.readLine();
				lineArray = line.toCharArray();

				for (int j=0; j<dim[1]; j++){
					arrayOutput[i][j] = lineArray[j];

				}
			}

			br.close();
			fr.close();

		} catch (IOException e){
			System.out.println("Error reading text file");
		}

		return arrayOutput;
	}

	/**
	 * Returns an integer array holding the dimensions of the character array in a text file.
	 * The first line of the text file must be two integers corresponding to the row and column numbers of the array.
	 * @param fileName the name of the file whose dimensions will be returned
	 * @return the integer array holding the dimensions of the text file given
	 */
	public int[] getDimensions(String fileName){
		int[] dimensions = new int[2];

		try{
			File f = new File(""+fileName);
			Scanner sc = new Scanner(f);

			dimensions[0] = sc.nextInt();
			dimensions[1] = sc.nextInt();
			sc.close();

		} catch (IOException e){
			System.out.println("Error getting dimensions");
		}

		return dimensions;
	}


}

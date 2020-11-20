package entities;
import java.util.ArrayList;
import tiles.Tile;

/**
 * The Inventory class holds information about all of the items in the game. Items are added by the Game class
 * when the player moves onto a tile containing an item.
 * @author Steven La, Maryam Sohrabi
 */
public class Inventory {
	private boolean[] itemList;
	private String[] itemNames;
	private char[] itemChars;
	private ArrayList<Tile> invTiles = new ArrayList<Tile>();
	
	/**
	 * Creates a new Inventory and initializes the arrays used to store information.
	 */
	public Inventory(){
		itemList = new boolean[6];
		itemNames = new String[6];
		itemChars = new char[6];
		itemList[0] = true;
		setItemNameAndChar(0, 'I', "Title");
	}
	
	/**
	 * Returns a boolean array with a value for each item in the map.
	 * @return a true boolean array if all items have been picked up
	 */
	public boolean[] getItemList(){
		return itemList;
	}
	
	/**
	 * Returns the name of all items that have been picked up.
	 * @return the name of all the items that have been picked up
	 */
	public String[] getItemNames(){
		return itemNames;
	}
	
	/**
	 * Returns the character array representing the character of each item picked up.
	 * @return character array representing the character of each item picked up
	 */
	public char[] getItemChars(){
		return itemChars;
	}
	
	/**
	 * Takes the character representation of an item and adds the item to the inventory.
	 * @param item the character representing the item that will be added
	 */
	public void addItemToInv(char item){
		// Set the "Inventory:" sign at the beginning of the inventory strip
		itemList[0] = true;
		setItemNameAndChar(0, 'I', "");
		
		switch (item){
		case '0': 
			itemList[1] = true; 
			setItemNameAndChar(1, item, "Key0");
			break;
		case '2': 
			itemList[2] = true; 
			setItemNameAndChar(2, item, "Key1");
			break;
		case '4': 
			itemList[3] = true; 
			setItemNameAndChar(3, item, "Key2");
			break;
		case '6': 
			itemList[4] = true; 
			setItemNameAndChar(4, item, "Key3");
			break;
		case '8': 
			itemList[5] = true; 
			setItemNameAndChar(5, item, "Key4");
			break;
		}
	}
	
	/**
	 * Sets the itemNames array with the names of the items on the game map.
	 * @param itemChars the array holding all of the items on the game map
	 */
	public void setItemNameAndChar(int index, char item, String itemName){
			itemNames[index] = itemName;
			itemChars[index] = item;
	}
	
	/**
	 * Prints to the console the name of every item that has been picked up.
	 */
	public void printInventory(){
		for (int index=0; index<itemList.length; index++){
			if (itemList[index]){
				System.out.println(itemNames[index]);
			}
		}
	}
	
	/**
	 * Creates Tiles for each item that has been picked up and adds them to the invTiles ArrayList.
	 * @param itemsToSet character representing the item that is being added to the inventory
	 */
	public void setInventoryTiles(char[] itemsToSet){
		invTiles.clear();
		for (int i=0; i<itemChars.length; i++){
			if (itemList[i]){
				Tile tile = new Tile(itemChars[i], 10, i);
				invTiles.add(tile);
			}
		}
	}

	/**
	 * Returns the invTiles ArrayList. 
	 * @return ArrayList of Tiles for each item in the inventory
	 */
	public ArrayList<Tile> getTiles() {
		return invTiles;
	}
}

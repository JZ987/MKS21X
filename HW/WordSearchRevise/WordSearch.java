import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class WordSearch{
    private char[][]data;
    private Random randGen;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private int seed;


    /**Initialize the grid to the size specified 
     *fill all of the positions with '_'
     *@param rows is the starting height of the WordSearch
     *@param cols is the starting width of the WordSearch
     */
    public WordSearch(int rows,int cols, String fileName){
	data = new char[rows][cols];
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	loadWords(fileName);
	seed = (int)(Math.random()*10000);
	System.out.println("Seed: " + seed);
	randGen = new Random(seed);
	clear();
	//add in words and fill in the spaces.
	fillWithWords();
	fillIn();
    }

    /**Initialize the grid to the size specified 
     *fill all of the positions with '_'
     *@param rows is the starting height of the WordSearch
     *@param cols is the starting width of the WordSearch
     *@param fileName is the name of the file with the words you want to add
     *@param seed is a number that you can input to generate the same puzzle
     *@param key checks whether you want the answer key or the regular puzzle
     */
    public WordSearch(int rows, int cols, String fileName, int seed, String key){
	data = new char[rows][cols];
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	loadWords(fileName);
	System.out.println("Seed: " + seed);
	randGen = new Random(seed);
	clear();
	//check to print answer key or not.
	if(key.equals("key")){
	    fillWithWords();
	}else{
	    fillWithWords();
	    fillIn();
	}
    }
	
    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
	for(int i = 0; i < data.length; i++){
	    for(int j = 0; j < data[i].length; j++){
		data[i][j] = '_';
	    }
	}
    }

    /**Load words from a text file
     *add each word to wordsToAdd
     *@param fileName is the name of the file the program is trying to read
     */
    public void loadWords(String fileName){
	try{
	    Scanner in = new Scanner(new File(fileName));
	    //print each word in the text file:
	    while(in.hasNext()){
		String word = in.next();
		wordsToAdd.add(word.toUpperCase());
	    }
	}catch(FileNotFoundException e){
	    System.out.println("Invalid filename or path");
	    System.exit(1);
	    }
    }

    /** Randomly add the words within wordsToAdd to the WordSearch.
	Remove successfully added words from wordsToAdd and add it
	to wordsAdded.
    */
    public void fillWithWords(){
	int row, col, d1, d2, occurrence;
	for(int i = 0; i < wordsToAdd.size(); i++){
	    occurrence = 0;
	    row = randGen.nextInt(data.length);
	    col = randGen.nextInt(data[row].length);
	    d1 = randGen.nextInt(3) - 1;
	    d2 = randGen.nextInt(3) - 1;
	    while(occurrence <= 200){
		if(addWordRandom(wordsToAdd.get(i), row, col, d1, d2)){
		    addWordRandom(wordsToAdd.get(i), row, col, d1, d2);
		    wordsAdded.add(wordsToAdd.get(i));
		    wordsToAdd.remove(i);
		    i--;
		    break;
		}else{
		    row = randGen.nextInt(data.length);
		    col = randGen.nextInt(data[row].length);
		    d1 = randGen.nextInt(3) - 1;
		    d2 = randGen.nextInt(3) - 1;
		    occurrence++;
		}
	    }
	}
    }
    
    /**Print out wordsToAdd and wordsAdded
     @return the list of words inside each ArrayList
    */
    public String printWordList(){
	String x = "";
	String y = "";
	for(int i = 0; i < wordsToAdd.size(); i++){
	    x += wordsToAdd.get(i);
	    x += " ";
	}
	for(int i = 0; i < wordsAdded.size(); i++){
	    y += wordsAdded.get(i);
	    y += " ";
	}
	return "WordsToAdd: " + x + "\n" + "WordsAdded: " + y;
    }

    /**Add the word given randomly within the puzzle*/
    private boolean addWordRandom(String word, int row, int col, int d1, int d2){
	//check if fits
	try{
	    if(d1 == 0 && d2 == 0){
		return false;
	    }
	    for(int i = 0, x = row, y = col; i < word.length(); i++, x+=d1, y+=d2){
		if(data[x][y] != '_' && data[x][y] != word.charAt(i)){
		    return false;
		}
	    }
	}catch(ArrayIndexOutOfBoundsException e){
	    return false;
	}

	//add word
	for(int i = 0, x = row, y = col; i < word.length(); i++, x+=d1, y+=d2){
	    data[x][y] = word.charAt(i);
	}
	return true;
    }
    
    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    private boolean addWordHorizontal(String word,int row, int col){
	//check if fits
	try{
	    for(int i = 0; i < word.length(); i++){
		if(data[row][col+i] != '_' && data[row][col+i] != word.charAt(i)){
		    return false;
		}
	    }
	}catch(ArrayIndexOutOfBoundsException e){
	    return false;
	}
	//add word
	for(int i = 0; i < word.length(); i++){
	    data[row][col+i] = word.charAt(i);
	}
	return true;
    }

   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    private boolean addWordVertical(String word,int row, int col){
	//check if fits
	try{
	    for(int i = 0; i < word.length(); i++){
		if(data[row+i][col] != '_' && data[row+i][col] != word.charAt(i)){
		    return false;
		}
	    }
	}catch(ArrayIndexOutOfBoundsException e){
	    return false;
	}
	//add word
	for(int i = 0; i < word.length(); i++){
	    data[row+i][col] = word.charAt(i);
	}
	return true;
    }

    /** Fill in the underscores of the puzzle */
    private void fillIn(){
	for(int i = 0; i < data.length; i++){
	    for(int j = 0; j < data[i].length; j++){
		if(data[i][j] == '_'){
		    data[i][j] = (char)((randGen.nextInt(26) + 1) + 64);
		}
	    }
	}
    }
    
    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
	String temp = "";
	for(int i = 0; i < data.length; i++){
	    for(int j = 0; j < data[0].length; j++){
		temp += String.valueOf(data[i][j]) + " ";
	    }
	    temp += "\n";
	}
	return temp;
    }




    public static void main(String[] args){
	String format = "Format: java WordSearch (row) (column) (file name) (seed number) (key or not)";

	WordSearch puzzle;
	
	try{
	    if(args.length < 3){
		System.out.println(format);
	    }else if(args.length == 3){
		puzzle = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2]);
		System.out.println(puzzle);
		System.out.println(puzzle.printWordList());
	    }else if(args.length == 4){
		puzzle = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]), "placeholder");
		System.out.println(puzzle);
		System.out.println(puzzle.printWordList());
	    }else if(args.length == 5){
		puzzle = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]), args[4]);
		System.out.println(puzzle);
		System.out.println(puzzle.printWordList());
	    }
	}catch(Exception e){
	    System.out.println(format);
	}

	
    }
}

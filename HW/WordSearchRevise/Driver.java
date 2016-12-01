public class Driver{

     public static void main(String[] args){

	WordSearch WordGrid = new WordSearch(10, 10);
	
	System.out.println(WordGrid);

	WordGrid.loadWords("words.txt");
	System.out.println(WordGrid.printWordList());
	WordGrid.fillWithWords();
	System.out.println(WordGrid);
     }
}

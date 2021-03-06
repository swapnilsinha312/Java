import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class WordsInFilee{
	
	private HashMap<String, ArrayList<String>> myMap;
	
	public WordsInFilee(){
		
		myMap = new HashMap<>();
		
	}
	
	public static void main(String[] args){
		
		WordsInFilee myObj = new WordsInFilee();
		myObj.tester();
	}
	
	private void addWordsFromFile(File f){
		
		FileResource fr = new FileResource(f);
		String file= fr.asString();
		String filename = f.getName();
		for(String word : fr.words()){
			if(myMap.containsKey(word)){
				ArrayList<String> tempArrayList = myMap.get(word);
				tempArrayList.add(filename );
				myMap.put(word, tempArrayList);
			} else {
				ArrayList<String> tempArrayList = new ArrayList<String>();
				tempArrayList.add(filename);
				myMap.put(word, tempArrayList);
			}
		}
	}
	
	public void buildWordFileMap(){
		
		myMap.clear();
		DirectoryResource dr = new DirectoryResource();
		for(File f: dr.selectedFiles()){
			addWordsFromFile(f);
		}
		
		int maxNumberOfFiles = maxNumber();
		System.out.println("The maximum number of files that any word appears in, is: "+maxNumberOfFiles);
		
		int number = 5;
		int totalNumOfWords = 0;
		ArrayList<String> words = wordsInNumFile(number);
		
		System.out.println(" ");
		System.out.print("The words in "+ number +" files  is: ");
		for(int i=0;i<words.size();i++){
			System.out.print(words.get(i)+" ");
			totalNumOfWords++;
		}
	
		System.out.println( "\nThe total number of wors that appear in "+number+" of the selected files is "+ totalNumOfWords+". ");
		
		
		
		
		
	}
	
	public int maxNumber(){
		
		int maxValueInWords = 0;
		for (String key : myMap.keySet()){
			int currentSize = myMap.get(key).size();
			if (currentSize > maxValueInWords){
				maxValueInWords = currentSize;
			}
		}
		return maxValueInWords;
	}
	
	public ArrayList<String> wordsInNumFile(int number){
		
		ArrayList<String> tempArrayList = new ArrayList<>();
		for (String key : myMap.keySet()){
			int currentSize = myMap.get(key).size();
			if (currentSize == number){
				tempArrayList.add(key);
			}
		}
		return tempArrayList;
	}
	
	public void printFileIn(String word){
		
		for (String key: myMap.keySet()) {
			if (key.equals(word)){
				for (String elem: myMap.get(key)){
					System.out.println(elem);
				}
			}
		}
	}
	
	public void printMap(){
		
		System.out.println("");
		for (String key: myMap.keySet()) {
			System.out.print(key + ": ");
			for (String elem: myMap.get(key)){
				System.out.print(elem + ", "); 
			}
			System.out.println();
		}
		
	}
	
	public void tester(){
		
		buildWordFileMap();
		
	}

}

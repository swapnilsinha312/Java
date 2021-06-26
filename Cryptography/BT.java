import java.io.*;
import java.util.*;
import edu.duke.*;
class BT 
{
    private HashMap <String,ArrayList<String>> hm= new HashMap <String,ArrayList<String>>();
       public void tester ()
    {
       build(); 
    }
    public void build()
    {
        
        for(int i=0;i<5;i++)
        {
            System.out.println("Enter file"+(i+1));
            FileResource fr = new FileResource();             
            addWords(fr,String.valueOf(i+1));            
        }
        int maxnof= maxNumber();
        System.out.println("The maximum number of files that any word appears in, is: "+maxnof);
		
	int number = 5;
	int totalNumOfWords = 0;
	/*ArrayList<String> words = wordsInNumFile(number);
	System.out.println(" ");
	System.out.print("The no of words in "+ number +" files  is: "+words.size());
	words.clear();
	words = wordsInNumFile(4);
	System.out.print("The no of words in "+ "4" +" files  is: "+words.size());
	*/
        printFileIn("red");
        System.out.println();
        printFileIn("sad");
}
      
        private void addWords(FileResource aaa,String a){
		
	for(String aa:aaa.words())
	{
	if(hm.containsKey(aa)){
	    ArrayList<String> tempArrayList = hm.get(aa);
	    tempArrayList.add(a);
	    hm.put(aa, tempArrayList);
	} 
	else 
	{
	       ArrayList<String> tempArrayList = new ArrayList<String>();  
	       tempArrayList.add(a);
	       hm.put(aa, tempArrayList);
	}
		
	}
        }
        public int maxNumber(){
		
		int maxValueInWords = 0;
		for (String key : hm.keySet()){
			int currentSize = hm.get(key).size();
			if (currentSize > maxValueInWords){
				maxValueInWords = currentSize;
			}
		}
		return maxValueInWords;
	}
        public ArrayList<String> wordsInNumFile(int number)
        {
		
		ArrayList<String> tempArrayList = new ArrayList<>();
		for (String key : hm.keySet()){
			int currentSize = hm.get(key).size();
			if (currentSize == number){
				tempArrayList.add(key);
			}
		}
		return tempArrayList;
	}
	public void printFileIn(String word){
		
		for (String key: hm.keySet()) {
			if (key.equals(word)){
				for (String elem: hm.get(key)){
					System.out.print(" "+elem);
				}
			}
		}
	}
	public void printMap(){
		
		System.out.println("");
		for (String key:hm.keySet()) {
			System.out.print(key + ": ");
			for (String elem: hm.get(key)){
				System.out.print(elem + ", ");
			}
			System.out.println();
		}
		
	}
}  
    
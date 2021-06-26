import java.util.*;
import edu.duke.*;
class dnamap
{
    private HashMap<String,Integer> hm; 
    public dnamap()
    {
        hm= new HashMap<String,Integer>();
    }
    public void buildMap(int st,String dna){
        hm.clear(); 
        String add =""; 
        for(int i=st;i<dna.length();i++){
            add+=dna.charAt(i);
            add=add.toUpperCase();
            
            if(add.length()==3){
            if(hm.keySet().contains(add))
                hm.put(add,hm.get(add)+1);
            else 
                hm.put(add,1);
            add="";
        }}
    }
    public String mostCommon()
    {
        String key=""; int x=0;
        for(String aa:hm.keySet())
        {
            int z = hm.get(aa);
            if(z>x){
            x=z; key=aa;}
        } return key;
     }
     public void print(int st,int end)
    {
        for(String aa:hm.keySet()){
        if(hm.get(aa)>=st&& hm.get(aa)<=end) 
            System.out.println(aa+"\t"+hm.get(aa));
        }
    }
    public void tester(){
        FileResource fr= new FileResource ();
        for(String aaa :fr.lines()){  
        System.out.println(aaa);
        aaa.trim();
        for(int i=0;i<3;i++)
        {
            buildMap(i,aaa);
            String mc= mostCommon();
            System.out.println("Reading frame starting with "+i+" results in "+ hm.size()+"unique colors and most common codon is "+ mc+ "with count ");
            System.out.println("Counts of codon between 1 and 5 are");
            print(5,7);
        }
        
        
    }}
    
}
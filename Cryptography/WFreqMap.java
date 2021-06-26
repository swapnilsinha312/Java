import java.io.*;
import java.util.*;
import edu.duke.*;
public class WFreqMap
{
    public void count(int z)
    {
        FileResource fr= new FileResource();
        int t=0;
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        for(String w:fr.words())
        { w=w.toLowerCase();
            if(hm.keySet().contains(w))
            hm.put(w,hm.get(w)+1);
            else{
            hm.put(w,1);
            }
        } System.out.println("total "+t);
        for(String w:hm.keySet()){ int o=hm.get(w);
            if(o>z) System.out.println(w+" \t"+o);
    }
    
}}
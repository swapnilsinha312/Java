import java.util.*;
import java.io.*;
import edu.duke.*;
class WordFreq
{
    private ArrayList<String> W;
    private ArrayList<Integer> F; 
    private int max;
    public WordFreq()
    {
        W=new ArrayList<String>();
        F=new ArrayList<Integer>();
        max=0;
    }
    public void unique()
    {   W.clear();
        F.clear();
        FileResource fr= new FileResource();
        for(String aa:fr.words())
        {   aa=aa.toLowerCase();
            int ppp=W.indexOf(aa);
            if(ppp==-1)
            { 
            W.add(aa);F.add(1);}
            else{
            F.set(ppp,F.get(ppp)+1);if (F.get(ppp)>max) max=ppp;
        }
        } 
    }
    public void countFreq()
    {   unique();int cc=0;
        for(int i=0;i<W.size();i++)
        {   
            if(F.get(i)==1)
            {
                cc++; System.out.println(W.get(i)+"\t "+"\t"+F.get(i));
            }
        }
            System.out.println("THE no of unique words are"+cc);
     }       
    public void maxa()
    { countFreq();
        System.out.println(F.get(max)+"   "+W.get(max));
        System.out.println((Collections.max(F))+"   "+W.get(F.indexOf(Collections.max(F))));
    }
}

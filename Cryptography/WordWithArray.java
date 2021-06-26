
import java.util.*;
import edu.duke.*;
class WordWithArray
{
    private StorageResource sr;
    public WordWithArray()
    {
        sr=new StorageResource();
    }
    public void  readWords()
    {
        sr.clear();
        FileResource fr= new FileResource();
        for(String aa : fr.words())
        {
            sr.add(aa.toLowerCase());
        }
    }
    public boolean count(String l[], String w,int no)
    {
        int z=-1;
        for(int i=0;i<no;i++)
        {
            if(l[i].equals(w)) z++;
        }
        if(z==-1) return false;
        else return true;
    }
    public int noUW()
    {
        int no=0;
        String w[]=new String[sr.size()];
        for(String aa:sr.data())
        {
            if(! count(w,aa,no))
            {w[no]=aa;
                no++;}
        } return no;
       
    }
    public void tester()
    {
        readWords();
        System.out.println("Number of words read\t"+sr.size());
        System.out.println("Number words in array\t"+noUW());
    }
    
    
}

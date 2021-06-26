import java.util.*;
import edu.duke.*;
class CharsInPlay
{
    private ArrayList<String> names;
    private ArrayList<Integer> count;
    private int max;
    CharsInPlay()
    {
        names = new ArrayList<String>();
        count = new ArrayList<Integer>();
        max=0;
    }
    public void update(String per)
    {
        if(names.indexOf(per)==-1)
        {
            names.add(per);
            count.add(1);
        }
        else
        {
            int nn=names.indexOf(per);
            count.set(nn,count.get(nn)+1);
            if(max<count.get(nn))
            max = count.get(nn);
        }
    }
    public void findAllCharacters()
    {
        FileResource fr = new FileResource();
        for(String aa:fr.lines())
        {
            int p=aa.indexOf('.');
            if(p==-1) 
                continue;
            else
                update(aa.substring(0,p));
        }
    }
    public void tester()
    {
        findAllCharacters();
        for(int i=0;i<names.size();i++)
        if(count.get(i)>5)
        System.out.println(names.get(i)+"\t"+count.get(i));
        charWNP(10,15);
        
    }
    public void charWNP(int n1,int n2)
    {
        for(int i=0;i<names.size();i++)
        if(count.get(i)>=n1 && count.get(i)<=n2)
        System.out.println("\n\n\n\n"+names.get(i)+"\t"+count.get(i));
    }
    
}
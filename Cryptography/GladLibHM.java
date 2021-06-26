import edu.duke.*;
import java.util.*;
public class GladLibHM
{
    private HashMap<String,ArrayList<String>> category;
    private Random R;
    private ArrayList<String> tbc= new ArrayList<String>();
   
    public GladLibHM()
    { 
        category = new HashMap<String,ArrayList<String>>();
        IFS();
        R=new Random();
    }
  
    private void IFS()
    { String aa[]={ "adjective","noun","color","country","name","animal","time","verb","fruit"};
        for(String aaa:aa)
        { category.put(aaa,ReadIt(aaa));
        }
    }
    private String randomFrom(ArrayList<String> s)
    {
        int i=R.nextInt(s.size());
        return s.get(i);
    }
    private String getSub(String ll)
    {   
        if((tbc.contains(ll))) tbc.add(ll);
        if (ll.equals("number")) return String.valueOf(R.nextInt(50));
        if(!(category.keySet().contains(ll))) return "**UNKNOWN*";
        String ret= randomFrom(category.get(ll));
        return ret;
        
    }
    private String PW(String w)
    {
        int f1=w.indexOf('<');
        int f2=w.indexOf('>');
        if(f1==-1||f2==-1) return w;
        String pre=w.substring(0,f1);
        String post=w.substring(f2+1);
        String mid=getSub(w.substring(f1+1,f2));
        return pre+mid+post;
    }
    private void printOut(String s, int lineWidth)
    { int cw=0;
        for(String w:s.split("\\s+"))
        {
            if(cw+w.length()>lineWidth)
            {System.out.println(); cw=0;}
            System.out.print(w+" ");
            cw+=w.length()+1;
        
    }
             }
    private String fTemp()
    {
        String ss="";
        System.out.println("template file");
        FileResource res= new FileResource();
        for(String w:res.lines())
                ss+=PW(w);
        return ss;
        }
    public ArrayList<String> ReadIt(String s)
    {
        ArrayList<String> list=new ArrayList<String>() ; 
        System.out.println(s+" file ");
        FileResource res= new FileResource ();
            for(String ll:res.lines())
            list.add(ll);
        
                 return list;   
    }
    public void ms()
    {
        String temp=fTemp();
        printOut(temp,60);
    }      
    public static void main(String args[])
    { GladLibHM cc=new GladLibHM();
      cc.ms();
    }       
    public int totWIM()
    {
        int n=0;
        for(String a:category.keySet())
        {
            n+=category.get(a).size();
        }
        return n;
    }
    public int TWC()
    {
        return tbc.size();
    }
        
        
}
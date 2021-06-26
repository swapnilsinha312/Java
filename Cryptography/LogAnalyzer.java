
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer 
{
     private ArrayList<LogEntry> records;
     ArrayList<LogEntry> p=new ArrayList<LogEntry>();
   
     public LogAnalyzer() {
         // complete constructor
         records= new ArrayList<LogEntry>();
         
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr= new FileResource();
         for(String aa:fr.lines())
         {
             LogEntry a= LogEntry.parseEntry(aa);
             records.add(a);
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs()
     {   ArrayList <String> z= new ArrayList<String>();
         ArrayList<LogEntry> pp=new ArrayList<LogEntry>();
         for(LogEntry lll:records)
         {
             String q= lll.getIpAddress();
             if(!z.contains(q))
              {z.add(q); pp.add(lll);}
            }
            p=pp;
         return z.size();
       }
     public ArrayList<LogEntry> UIPVOD(String s)
     {   p.clear(); 
         ArrayList<String> z=new ArrayList<String>();
         int cc=0;
         for(LogEntry lll:records)
         {
             String q= lll.getAccessTime().toString().substring(4,10);
             String qq= lll.getIpAddress();
            
             if(s.equals(q) && !z.contains(qq))
              {p.add(lll); z.add(qq);cc++;
                 }
           }
          
         return p;
        }
     public int UNIPIR(int min, int max)
     { int nn=0;
         ArrayList<String> z=new ArrayList<String>();
          for(LogEntry lll:records)
         {
             int q= lll.getStatusCode(); String qq= lll.getIpAddress();
             if(q>=min&&q<=max&& !z.contains(qq))
             { nn++; z.add(qq);}
            }
         return nn;
        }
        public void pAHTN(int num)
        {
            
         ArrayList<String> z=new ArrayList<String>();
          for(LogEntry lll:records)
         {
             int q= lll.getStatusCode(); String qq= lll.getIpAddress();
             if(q>=num && !z.contains(qq))
             { System.out.println(lll.toString()); z.add(qq);}
            }
         
        }
        public HashMap<String,Integer> cvperip()
        {
            HashMap<String,Integer> aa= new HashMap<String,Integer>();
            for(LogEntry le:records)
            {
                String ip= le.getIpAddress();
                if(!aa.containsKey(ip)) aa.put(ip,1);
                else aa.put(ip,aa.get(ip)+1);
                
            } return aa;
        }
}

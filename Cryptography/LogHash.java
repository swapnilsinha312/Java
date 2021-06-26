
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogHash 
{
     private ArrayList<LogEntry> records;
     ArrayList<LogEntry> p=new ArrayList<LogEntry>();
   
     public LogHash() {
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
     public int mnvbyip(HashMap<String,Integer>aa)
     { int max=0;
         for(String ss:aa.keySet())
         {
             if(aa.get(ss)>max) max= aa.get(ss);
            }  return max;
        }
        
        public ArrayList<String> ipmv(HashMap<String,Integer>aa)
     { int max=0;
         ArrayList<String> ip= new ArrayList<String>();
         for(String ss:aa.keySet())
         {
             if(aa.get(ss)>max) max= aa.get(ss);
            }  
            for(String ss:aa.keySet())
         {
             if(aa.get(ss)==max)
             ip.add(ss);
            } 
            return ip;
            
        }
        public HashMap<String,ArrayList<String>> imfd()
        {
            HashMap<String,ArrayList<String>> aa= new HashMap<String,ArrayList<String>>();
            for(LogEntry le:records)
            {
                String day= le.getAccessTime().toString().substring(4,10);
                String ip= le.getIpAddress();
                if(!aa.containsKey(day)) 
                {
                    ArrayList<String> ss = new ArrayList<String>();
                    ss.add(ip);
                    aa.put(day,ss);
                }
                else 
                {
                    ArrayList<String> ss = aa.get(day);
                    ss.add(ip);
                    aa.put(day,ss);
                }
                
            } return aa;
        }
        public String  mipav( HashMap<String,ArrayList<String>> aa)
        {
            String uns=""; int uni=0;
         ArrayList<String> z=new ArrayList<String>();
         int cc=0;
         for(String qq:aa.keySet())
         {
            ArrayList<String> zz= aa.get(qq);          
             for(String ww: zz)
             {
                 
                  if(zz.size()>uni) {uni=zz.size(); uns=qq;}
           }
           
        } return uns;
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

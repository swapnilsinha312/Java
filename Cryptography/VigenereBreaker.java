import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        String ret="";
        for(int i=whichSlice;i<message.length();i+=totalSlices)
        {
            ret+=message.charAt(i);
        }
        return ret;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker abc= new CaesarCracker();
        for(int i=0;i<klength;i++)
        {
            String seg= sliceString(encrypted,i,klength);
            key[i]=abc.getKey(seg);
        }
        return key;
    }

    public void breakVigenere () {
        HashMap <String ,HashSet<String>> hm= new HashMap <String ,HashSet<String>>();
        String nol[]={"Danish"," Dutch"," English"," French"," German"," Italian", "Portuguese", " Spanish"};
        for(String ll:nol)
        {  System.out.println("Enter "+ll);
           FileResource dr= new FileResource();
           HashSet<String> d= readDictionary(dr);
           hm.put(ll,d);
        }
        System.out.println("Enter message");
        FileResource dr= new FileResource();
        String enc= dr.asString();
        String dec= breakForAllLang(enc,hm);
        //System.out.println("Decrypted, valid no=" +countWords(dec,d));
        System.out.println(dec.substring(0,100));
        
    }
    
    public HashSet<String> readDictionary(FileResource fr)
    {
        HashSet <String> abc= new HashSet <String>();
        for(String ss:fr.words())
        {
            ss=ss.toLowerCase();
            if(!abc.contains(ss)) 
                abc.add(ss);
        }
        return abc;
    }
    
    public int countWords(String m , HashSet<String> d)
    { 
        int n=0;
        for(String qq:m.split("\\W"))
        {
            qq=qq.toLowerCase();
            if(d.contains(qq))
            n++;
        }
           return n; 
    }
    
    public String breakForLang(String encrypted, HashSet<String> d)
    {
        String dec=""; 
        int bk=0;int bkk=0;
        for(int i=1;i<101;i++)
        {
            int kk[]=tryKeyLength(encrypted, i,mostCommonCharIn(d));
            VigenereCipher vc= new VigenereCipher(kk);
            String out= vc.decrypt(encrypted);
            int oo= countWords(out,d);
            if(bkk<oo) {bk=i; bkk=oo;}
        }
        int kk[]=tryKeyLength(encrypted, bk,'e');
            VigenereCipher vc= new VigenereCipher(kk);
            String out= vc.decrypt(encrypted);
        return out;
    }
    public char mostCommonCharIn(HashSet<String> d)
    {
        char ret='a'; int f=0;
        int cc[]= new int[26];
        for(String ss:d)
        { 
           for(int i=0;i<ss.length();i++)
           {    char iii=ss.charAt(i);
               if(iii>='a'&&iii<='z')
                    cc[(int)iii-97]++;
            }
        }
        for(int i=0;i<26;i++)
        {
           if(cc[i]>f){f=cc[i];ret=(char) (97+i);} 
        }
        return ret;
    }
    public String breakForAllLang(String enc, HashMap<String,HashSet<String>> dd)
    {
        String ret="";
        int freq=0; String lang="";
        for(String ppp:dd.keySet())
        {
        HashSet<String> ln=dd.get(ppp); 
        String qq= breakForLang(enc,ln);
        int zzz= countWords(qq,ln);
        if(zzz>freq) {freq=zzz;ret=qq; lang =ppp;}
        }
        System.out.println("\t\t"+lang+"\t\t");
        return ret;
        
    }
}

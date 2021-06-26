import java.util.*;
import edu.duke.*;
class IPTester
{
    public void testUniqueIP()
    {
        LogAnalyzer abc = new LogAnalyzer();
        abc.readFile("");
        int a=abc.countUniqueIPs();
        System.out.println("Unique inputs are "+a);
    }
    public void onOneDay()
    {
        LogAnalyzer abc = new LogAnalyzer();
        abc.readFile("");
        ArrayList<LogEntry> aaa=abc.UIPVOD("Mar 24");
        System.out.println(aaa.size());
        aaa.clear();
        aaa = abc.UIPVOD("Sep 30");
        System.out.println(aaa.size());
    }
    public void unipirt(int min,int max){
        LogAnalyzer abc = new LogAnalyzer();
        abc.readFile("");
        int aaa=abc.UNIPIR(min,max);
        System.out.println(aaa);
    }
    public void Higherthan(int n)
    {
        LogAnalyzer abc = new LogAnalyzer();
        abc.readFile("");
        abc.pAHTN(n);
    }
}
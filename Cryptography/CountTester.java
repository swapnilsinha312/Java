import java.util.*;
class CountTester
{
    public void testcounts()
    
    {
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("");
        HashMap<String,Integer> aa= la.cvperip();
        System.out.println(aa);
    }
    public void unip()
    {
        LogHash la= new LogHash();
        la.readFile("");
        HashMap<String,Integer> aa= la.cvperip();
        System.out.println(aa.size());
        System.out.println("Most frequent IP "+la.mnvbyip(aa));
    }
    public void MostVisitbyIP()
    {
        LogHash la= new LogHash();
        la.readFile("");
        HashMap<String,Integer> aa= la.cvperip();
        System.out.println(la.mnvbyip(aa));
    }
    public void IPMostVisit()
    {
        LogHash la= new LogHash();
        la.readFile("");
        HashMap<String,Integer> aa= la.cvperip();
        System.out.println(la.ipmv(aa));
    }
    public void DayWMIPV()
    {
        LogHash la= new LogHash();
        la.readFile("");
        HashMap<String,ArrayList<String>> aa= la.imfd();
        System.out.println(la.mipav(aa));
    }
    public void VisitOnADay(String date)
    {
        LogHash la= new LogHash();
        la.readFile("");
         HashMap<String,ArrayList<String>> aa= la.imfd();
        System.out.println(aa.get(date).size());
    }
    
}
class h3 extends h2
{
    public void m1()
    {System.out.println("m1 of h3");}
    public void m2()
    {System.out.println("m1 of h3 calling super");
    super.m2();
}
    public  static void main(String args[])
    {
        h1 abc;
        abc= new h3();
        abc.m2();
        h1 abcd;
        abcd= new h2();
        abcd.m2();
        abcd=abc;
        abcd.m2();
        
    }
}
public class CaesarCipherTwoKeys {
    
    private String alphabetUpper; 
    private String shiftedAlphabetUpper1;
    private String shiftedAlphabetUpper2;
    private int mainKey1;
    private int mainKey2;
    public CaesarCipherTwoKeys(int key1, int key2) {
        
        alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        shiftedAlphabetUpper1 = alphabetUpper.substring(key1) + alphabetUpper.substring(0,key1);
        
        shiftedAlphabetUpper2 = alphabetUpper.substring(key2) + alphabetUpper.substring(0,key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }
    public String encrypt(String input) 
    {
        input =input.toUpperCase();
        StringBuilder out= new StringBuilder();
        for (int index=0; index < input.length(); index++) {
            if(Character.isLetter(input.charAt(index)))
            {                 
            if (index % 2 == 0 ) {
                
                out.append(shiftedAlphabetUpper1.charAt(alphabetUpper.indexOf(input.charAt(index))));
            }
            else {
               out.append(shiftedAlphabetUpper2.charAt(alphabetUpper.indexOf(input.charAt(index)))); 
            }
        
        }
    
        
        else out.append(input.charAt(index));}
        System.out.println(out.toString().toLowerCase());
        
    
        return(out.toString().toLowerCase());
        
    }
}
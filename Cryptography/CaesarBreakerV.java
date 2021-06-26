import edu.duke.FileResource;

public class CaesarBreakerV {
    public int[] countOccurrencesOfLetters(String message) {
        //snippet from lecture
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k=0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }
    public int maxIndex(int[] values) {
        int maxDex = 0;
        for (int k=0; k < values.length; k++) {
            if (values[k] > values[maxDex]) {
                maxDex = k;
            }
        }
        return maxDex;
    }
    public String decrypt(String encrypted) {
        
        int[] freqs = countOccurrencesOfLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4-maxDex);
        }
        CaesarCipher cc = new CaesarCipher(26-dkey);
        return cc.encrypt(encrypted);
    }
    public String halfOfString(String message, int start) {
        StringBuilder halfString = new StringBuilder();
        for (int index=start;index < message.length();index += 2) {
            halfString.append(message.charAt(index));
        }
        return halfString.toString();
    }
    public int getKey(String s) {
        int[] letterFreqs = countOccurrencesOfLetters(s);
        int maxDex = maxIndex(letterFreqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4-maxDex);
        }
        return 26-dkey;
    }
    public String decryptTwoKeys(String encrypted) {
        String firstHalfEncrypted = halfOfString(encrypted,0);
        String secondHalfEncrypted = halfOfString(encrypted,1);
        int firstHalfKey = getKey(firstHalfEncrypted);
        int secondHalfKey = getKey(secondHalfEncrypted);
        CaesarCipherTwoKeys cc = new CaesarCipherTwoKeys(firstHalfKey,secondHalfKey);
        
        System.out.println("First decryption key:\t" + firstHalfKey + "\nSecond decryption key:\t"
                            + secondHalfKey);
                            
        return cc.encrypt(encrypted);
    }
    public void testDecrypt() {
        FileResource fileResource = new FileResource();
        String encrypted = fileResource.asString();
        System.out.println("Encrypted message:\n" + encrypted);
        System.out.println("\nDecrypted message:\n" + decryptTwoKeys(encrypted));
        
        String encrypted2 = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        System.out.println("Encrypted message:\n" + encrypted2);
        System.out.println("\nDecrypted message:\n" + decryptTwoKeys(encrypted2));
    }
}
package logica;

import javax.crypto.Cipher;

public class Descifrado {
    private static Cipher rsa;
    
    public Descifrado(){
        
    }
    
    public static String myDecript(String cypher) throws Exception{
        rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        new Keys().myKeys();
        rsa.init(Cipher.DECRYPT_MODE, new Keys().getLlavepublica());
        byte[] myrsa = rsa.doFinal(hexStringABytes(cypher));
        String txt = new String(myrsa);
        
        return txt;
    }
    
    private static byte[] hexStringABytes(String miniString) {
        miniString = miniString.replaceAll("\\s", "");
        int longitud = miniString.length();
        byte[] mybytes = new byte[longitud / 2];

        for (int i = 0; i < longitud; i += 2) {
            mybytes[i / 2] = (byte) ((Character.digit(miniString.charAt(i), 16) << 4)
                    + Character.digit(miniString.charAt(i + 1), 16));
        }

        return mybytes;
    }
}

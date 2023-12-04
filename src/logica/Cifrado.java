package logica;

import javax.crypto.Cipher;

public class Cifrado {
    private static Cipher rsa;
    
    public Cifrado(){
        
    }
    
    public static String myCipher(String text) throws Exception{      
        String miniencriptacion = "";
        new Keys().myKeys();
        rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        rsa.init(Cipher.ENCRYPT_MODE, new Keys().getLlaveprivada());
        
        byte[] msj = rsa.doFinal(text.getBytes());
        
        for(byte b : msj){
            miniencriptacion += String.format("%02X", b);
        }
        
        return miniencriptacion;
    }
}

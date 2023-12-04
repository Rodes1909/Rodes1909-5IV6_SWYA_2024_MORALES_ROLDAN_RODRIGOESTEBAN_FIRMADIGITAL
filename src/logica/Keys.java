package logica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Keys {
    private static PublicKey llavepublica;
    private static PrivateKey llaveprivada;
    
    public Keys(){
        
    }
    
    public static void generateKeys() throws Exception{
        KeyPairGenerator keyGenerator =  KeyPairGenerator.getInstance("RSA");
        KeyPair misLlaves = keyGenerator.generateKeyPair();
        
        llavepublica = misLlaves.getPublic();
        llaveprivada = misLlaves.getPrivate(); 
        saveKey(llavepublica, "public.key"); 
        saveKey(llaveprivada, "private.key");        
    }
    
    public static void saveKey(Key myKey, String myFile) throws Exception{
        byte[] llavesPubPriv = myKey.getEncoded();
        
        FileOutputStream fileOutput = new FileOutputStream(myFile);
        fileOutput.write(llavesPubPriv);
        fileOutput.close();
    }

    public static PublicKey loadpublickey(String myFile) throws Exception{
        FileInputStream fileInput = new FileInputStream(myFile);
        int numbytes = fileInput.available();
        byte[] myBytes = new byte[numbytes];
        fileInput.read(myBytes);
        fileInput.close();
        
        KeyFactory generateKeys = KeyFactory.getInstance("RSA");
        KeySpec keyspec = new X509EncodedKeySpec(myBytes);
        PublicKey fileKeys = generateKeys.generatePublic(keyspec);
        return fileKeys;
    }

    public static PrivateKey loadprivatekey(String myFile) throws Exception{
        FileInputStream fileInput = new FileInputStream(myFile);
        int numberBytes = fileInput.available();
        byte[] MyBytes = new byte[numberBytes];
        fileInput.read(MyBytes);
        fileInput.close();
        
        KeyFactory generateKeys = KeyFactory.getInstance("RSA");
        KeySpec keyspec = new PKCS8EncodedKeySpec(MyBytes);
        PrivateKey privateKeys = generateKeys.generatePrivate(keyspec);
        return privateKeys;
    }
    
    public static void myKeys(){
        try{
            llaveprivada = loadprivatekey("private.key");  
            llavepublica = loadpublickey("public.key");
        }
        catch(Exception e){
            
        }        
    }

    public PublicKey getLlavepublica() {
        return llavepublica;
    }

    public void setLlavepublica(PublicKey llavepublica) {
        this.llavepublica = llavepublica;
    }

    public PrivateKey getLlaveprivada() {
        return llaveprivada;
    }

    public void setLlaveprivada(PrivateKey llaveprivada) {
        this.llaveprivada = llaveprivada;
    }
}

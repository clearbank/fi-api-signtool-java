 import java.nio.file.Files;
 import java.nio.file.Paths;
 import java.security.Signature;
 import java.security.KeyFactory;
 import java.security.PrivateKey;
 import java.util.Base64;
 import java.security.spec.PKCS8EncodedKeySpec;
 
 public class Main {

   public static void main(String[] args) throws Exception {
     PrivateKey privateKey = getPrivateKeyFromFile("Data/Reference1.PrivateKey.pem");

     String requestBody = "{\"Message\":\"Hello World\"}";

     Signature signature = Signature.getInstance("SHA256withRSA");
     signature.initSign(privateKey);
     signature.update(requestBody.getBytes("UTF-8"));
     byte[] digitalSignature = signature.sign();
    
     System.out.println(Base64.getEncoder().encodeToString(digitalSignature));    
   }

   private static PrivateKey getPrivateKeyFromFile(String filename) throws Exception {
     String fileContents = new String(Files.readAllBytes(Paths.get(filename)));
     String privateKeyPem = fileContents
     .replace("-----BEGIN PRIVATE KEY-----", "")
     .replace("-----END PRIVATE KEY-----", "")
     .replaceAll("\r", "")
     .replaceAll("\n", "");
     return getPrivateKey(privateKeyPem);
   }
   
   private static PrivateKey getPrivateKey(String privateKeyPem) throws Exception {
     byte[] encodedKey = Base64.getDecoder().decode(privateKeyPem);
     PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedKey);
     KeyFactory keyFactory = KeyFactory.getInstance("RSA");
     return keyFactory.generatePrivate(keySpec);
   }
 }
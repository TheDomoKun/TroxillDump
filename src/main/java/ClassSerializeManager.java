import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public class ClassSerializeManager {
  public static Object getFromString(String paramString) throws IOException, ClassNotFoundException {
    byte[] arrayOfByte = Base64.getDecoder().decode(paramString);
    ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(arrayOfByte));
    Object object = objectInputStream.readObject();
    objectInputStream.close();
    return object;
  }
  
  public static String SerializetoString(Serializable paramSerializable) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
    objectOutputStream.writeObject(paramSerializable);
    objectOutputStream.close();
    return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class23.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
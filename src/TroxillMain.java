import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TroxillMain extends Exception {
  private static int counter;
  
  private static final ModuleManager ModuleManager = new ModuleManager();
  
  public static ModuleManager getModuleManager() {
    return ModuleManager;
  }
  
  private void EntryPoint() throws IOException {

    AntiDump.check();
    Socket sock = new Socket();
    sock.connect(new InetSocketAddress("",38091));
    OutputStream outputStream = sock.getOutputStream();
    InputStream inputStream = sock.getInputStream();
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    String str2 = bufferedReader.readLine();
    if (str2.equals("1")) {
      if (counter > 0)
        return;

      AntiDump.check();
      Initilizer.Startup();
      SocketSettings.StartConfigAutoSaveThread();
      SocketSettings.LoadModuleKeybindSettings(bufferedReader.readLine());
      SocketSettings.LoadBooleanSettings(bufferedReader.readLine());
      SocketSettings.LoadSliderSettings(bufferedReader.readLine());
      SocketSettings.LoadModuleStats(bufferedReader.readLine());
      counter++;
    }
  }

  
  public static String MEGA_MD5_HWID_GENERATOR_30000(String paramString1, String paramString2, String paramString3) {
    String str = paramString1 + paramString2 + paramString3;
    MessageDigest messageDigest = null;
    try {
      messageDigest = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
    messageDigest.update(str.getBytes());
    StringBuilder stringBuilder = new StringBuilder();
    byte[] arrayOfByte = messageDigest.digest();
    for (byte b : arrayOfByte) {
      String str1 = Integer.toHexString(0xFF & b);
      if (str1.length() == 1)
        stringBuilder.append('0'); 
      stringBuilder.append(str1);
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class17.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
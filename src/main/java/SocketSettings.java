import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class SocketSettings {
  private static Thread thread;

  
  public static void LoadModuleKeybindSettings(String paramString) {
    new Thread(() -> { // jdcore не вывез лямбду
      Method223(paramString);
    }).start();
  }
  
  public static void LoadBooleanSettings(String paramString) {
    new Thread(() -> { // jdcore не вывез лямбду
      Method221(paramString);
    }).start();
  }
  
  public static void LoadSliderSettings(String paramString) {
    new Thread(() -> { // jdcore не вывез лямбду
      Method219(paramString);
    }).start();
  }
  
  public static void LoadModuleStats(String paramString) {
    new Thread(() -> { // jdcore не вывез лямбду
      Method218(paramString);
    }).start();
  }
  
  public static void StartConfigAutoSaveThread() {// jdcore не вывез лямбду
    thread = new Thread(() -> {
      try {
        Method215();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
    thread.start();
  }
  
  private static void Method215() throws IOException {
    while (true) {
      try {
        Thread.sleep(300000L);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      Socket socket = new Socket();
      socket.connect(new InetSocketAddress("",38091));
      HashMap hashMap1 = (HashMap)ModuleManager.getModules().stream().collect(Collectors.toMap(Module::Method182, Module::Method181));
      HashMap<Object, Object> hashMap2 = new HashMap<>((Map<?, ?>)ModuleManager.getModules().stream().collect(Collectors.toMap(Module::Method182, SocketSettings::Method217)));
      HashMap<Object, Object> hashMap3 = new HashMap<>((Map<?, ?>)ModuleManager.getModules().stream().collect(Collectors.toMap(Module::Method182, SocketSettings::Method216)));
      HashMap hashMap4 = (HashMap)ModuleManager.getModules().stream().collect(Collectors.toMap(Module::Method182, Module::isToggled));
      OutputStream outputStream = socket.getOutputStream();
      String str = TroxillMain.MEGA_MD5_HWID_GENERATOR_30000(System.getenv("COMPUTERNAME"), System.getenv("PROCESSOR_IDENTIFIER"), System.getenv("PROCESSOR_LEVEL"));
      outputStream.write(str.getBytes(StandardCharsets.UTF_8));
      outputStream.write(str.getBytes(StandardCharsets.UTF_8));
      outputStream.write("\n".getBytes(StandardCharsets.UTF_8));
      outputStream.write((ClassSerializeManager.SerializetoString(hashMap1) + "\n").getBytes(StandardCharsets.UTF_8));
      outputStream.write((ClassSerializeManager.SerializetoString(hashMap2) + "\n").getBytes(StandardCharsets.UTF_8));
      outputStream.write((ClassSerializeManager.SerializetoString(hashMap3) + "\n").getBytes(StandardCharsets.UTF_8));
      outputStream.write((ClassSerializeManager.SerializetoString(hashMap4) + "\n").getBytes(StandardCharsets.UTF_8));
      outputStream.flush();
      outputStream.close();
      socket.close();
    } 
  }
  
  private static Map Method216(Module paramModule) {
    return (Map) SettingsStringManager.Method206(paramModule).stream().collect(Collectors.toMap(Setting::Method74, Setting::Method81));
  }
  
  private static Map Method217(Module paramModule) {
    return (Map) SettingsStringManager.Method206(paramModule).stream().collect(Collectors.toMap(Setting::Method74, Setting::Method79));
  }
  
  private static void Method218(String paramString) {
    HashMap hashMap = null;
    try {
      hashMap = (HashMap) ClassSerializeManager.getFromString(paramString);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    System.out.println(hashMap);
    for (Module Module : ModuleManager.getModules()) {
      if (hashMap.containsKey(Integer.valueOf(Module.Method182())))
        Module.Method186(((Boolean)hashMap.get(Integer.valueOf(Module.Method182()))).booleanValue()); 
    } 
  }
  
  private static void Method219(String paramString) {
    HashMap hashMap = null;
    try {
      hashMap = (HashMap) ClassSerializeManager.getFromString(paramString);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    System.out.println(hashMap);
    for (Module Module : ModuleManager.getModules()) {
      if (hashMap.containsKey(Integer.valueOf(Module.Method182()))) {
        HashMap hashMap1 = (HashMap)hashMap.get(Integer.valueOf(Module.Method182()));
       // hashMap1.forEach(this::Module220);
      } 
    } 
  }
  
  private static void Method220(Module paramModule, Integer paramInteger, Double paramDouble) {
    ((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(paramModule.Method182(), paramInteger.intValue()))).Method82(paramDouble.doubleValue());
  }
  
  private static void Method221(String paramString) {
    HashMap hashMap = null;
    try {
      hashMap = (HashMap) ClassSerializeManager.getFromString(paramString);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    System.out.println(hashMap);
    for (Module Module : ModuleManager.getModules()) {
      if (hashMap.containsKey(Integer.valueOf(Module.Method182()))) {
        HashMap hashMap1 = (HashMap)hashMap.get(Integer.valueOf(Module.Method182()));
       // hashMap1.forEach(Module::Method222);
      } 
    } 
  }
  
  private static void Method222(Module paramModule, Integer paramInteger, Boolean paramBoolean) {
    SettingsStringManager.Method207(paramModule.Method182(), paramInteger.intValue()).Method80(paramBoolean.booleanValue());
  }
  
  private static void Method223(String paramString) {
    HashMap hashMap = null;
    try {
      hashMap = (HashMap) ClassSerializeManager.getFromString(paramString);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    System.out.println(hashMap);
    for (Module Module : ModuleManager.getModules()) {
      if (hashMap.containsKey(Integer.valueOf(Module.Method182())))
        Module.Method185(((Integer)hashMap.get(Integer.valueOf(Module.Method182()))).intValue()); 
    } 
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class15.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
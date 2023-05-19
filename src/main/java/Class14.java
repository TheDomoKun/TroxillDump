import java.util.HashMap;

public class Class14 {
  public static HashMap Field161 = new HashMap<>();
  
  public static boolean Method201(int paramInt) {
    return Field161.containsKey(Integer.valueOf(paramInt))
            ?
            ((Boolean)Field161.get(Integer.valueOf(paramInt))).booleanValue()
            : false;
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class14.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
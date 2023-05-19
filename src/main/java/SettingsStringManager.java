import java.util.ArrayList;
import java.util.Set;

public class SettingsStringManager {
  private static final ArrayList<Setting> Field165 = new ArrayList<Setting>();
  
  public static void registerSetting(Setting paramSetting) {
    Field165.add(paramSetting);
  }
  
  public static ArrayList<Setting> getSettings() {
    return Field165;
  }
  
  public static ArrayList Method206(Module paramModule) {
    ArrayList<Setting> arrayList = new ArrayList();
    for (Setting setting : getSettings()) {
      if (setting.Method75().Method182() == paramModule.Method182())
        arrayList.add(setting);
    } 
    return arrayList;
  }
  
  public static Setting Method207(int paramInt1, int paramInt2) {
    for (Setting setting : getSettings()) {
      if (setting.Method75().Method182() == paramInt1 && setting.Method74() == paramInt2)
        return setting;
    } 
    return null;
  }
  
  public static char[] Method208(int paramInt1, int paramInt2) {
    if (paramInt1 == 1 && paramInt2 == 1)
      return new char[] { 'S', 'i', 'z', 'e', ':', ' ' }; 
    if (paramInt1 == 5 && paramInt2 == 1)
      return new char[] { 'L', 'e', 'g', 'i', 't', ':', ' ' }; 
    if (paramInt1 == 11 && paramInt2 == 1)
      return new char[] { 'J', 'u', 'm', 'p', ':', ' ' }; 
    if (paramInt1 == 17) {
      if (paramInt2 == 1)
        return new char[] { 'S', 'p', 'e', 'e', 'd', ':', ' ' }; 
      if (paramInt2 == 2)
        return new char[] { 'B', 'y', 'P', 'a', 's', 's' }; 
    } 
    if (paramInt1 == 18) {
      if (paramInt2 == 1)
        return new char[] { 'M', 'o', 'b', 's', ':', ' ' }; 
      if (paramInt2 == 2)
        return new char[] { 'R', 'a', 'n', 'd', 'o', 'm', ':', ' ' }; 
      if (paramInt2 == 3)
        return new char[] { 'D', 'i', 's', 't', 'a', 'n', 'c', 'e', ':', ' ' }; 
    } 
    if (paramInt1 == 22) {
      if (paramInt2 == 1)
        return new char[] { 'D', 'i', 's', 't', 'a', 'n', 'c', 'e', ':', ' ' }; 
      if (paramInt2 == 2)
        return new char[] { 
            'A', 'u', 't', 'o', 'D', 'i', 's', 'a', 'b', 'l', 
            'e', ':', ' ' }; 
    } 
    if (paramInt1 == 24 && paramInt2 == 1)
      return new char[] { 'D', 'e', 'l', 'a', 'y', ':', ' ' }; 
    if (paramInt1 == 25 && paramInt2 == 1)
      return new char[] { 'S', 'n', 'e', 'a', 'k', ':', ' ' }; 
    if (paramInt1 == 28) {
      if (paramInt2 == 1)
        return new char[] { 'D', 'i', 's', 't', 'a', 'n', 'c', 'e', ':', ' ' }; 
      if (paramInt2 == 2)
        return new char[] { 'D', 'e', 'l', 'a', 'y', ':', ' ' }; 
      if (paramInt2 == 3)
        return new char[] { 'R', 'a', 'n', 'd', 'o', 'm', ':', ' ' }; 
    } 
    if (paramInt1 == 29) {
      if (paramInt2 == 1)
        return new char[] { 'S', 'p', 'e', 'e', 'd', ':', ' ' }; 
      if (paramInt2 == 2)
        return new char[] { 'D', 'i', 's', 't', 'a', 'n', 'c', 'e', ':', ' ' }; 
      if (paramInt2 == 3)
        return new char[] { 
            'O', 'n', 'l', 'y', 'W', 'e', 'a', 'p', 'o', 'n', 
            ':', ' ' }; 
    } 
    return new char[0];
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class16.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
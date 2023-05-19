import net.minecraft.client.Minecraft;

public class Initilizer {
  static final boolean Field130 = !Initilizer.class.desiredAssertionStatus();
  
  public static void Startup() {
    Startupper.RegisterEvents();
    HookInjector.InjectKeyboardHook();
    HookInjector.InjectTimeTrackerHook();
    HookInjector.InjectMouseHelperHook();
    if (!Field130 && (Minecraft.getInstance()).player == null)
      throw new AssertionError(); 
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class47.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
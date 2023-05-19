//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class HookInjector {
  private static final Minecraft Field120 = Minecraft.getInstance();
  
  public static void InjectKeyboardHook() {
    KeyboardListenerHook keyboardListenerHook = new KeyboardListenerHook(Minecraft.getInstance());
    keyboardListenerHook.setupCallbacks(Field120.getMainWindow().getHandle());
    ObfuscationReflectionHelper.setPrivateValue(Minecraft.class, Field120, keyboardListenerHook, "keyboardListener");
  }
  
  public static void InjectTimeTrackerHook() {
    ObfuscationReflectionHelper.setPrivateValue(Minecraft.class, Field120, new TimeTrackerHook(System::nanoTime, HookInjector::Method152), "gameTimeTracker");
  }
  
  public static void InjectMouseHelperHook() {
    MouseHelperHook mouseHelperHook = new MouseHelperHook(Field120);
    ObfuscationReflectionHelper.setPrivateValue(Minecraft.class, Field120, mouseHelperHook, "mouseHelper");
    mouseHelperHook.registerCallbacks(Field120.getMainWindow().getHandle());
  }
  
  public static void RegisterPlayerHook() {
    Field120.playerController = new PlayerControllerHook(Field120, Field120.getConnection());
  }
  
  private static int Method152() {
    return 0;
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class30.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

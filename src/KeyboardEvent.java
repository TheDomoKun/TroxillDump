//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.client.Minecraft;
import net.minecraft.util.MovementInput;
import net.minecraftforge.client.event.InputEvent;

public class KeyboardEvent extends InputEvent {
  private final int Field97;
  
  private final int Field98;
  
  private final int Field99;
  
  private final int Field100;
  
  public static ClickGuiManager Field101;
  
  private static final Minecraft Field102 = Minecraft.getInstance();
  
  private static final MovementInputHook Field103 = new MovementInputHook((Minecraft.getInstance()).gameSettings);
  
  public KeyboardEvent(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.Field97 = paramInt1;
    this.Field98 = paramInt2;
    this.Field99 = paramInt3;
    this.Field100 = paramInt4;
    if (Field102.player != null && !Field102.player.movementInput.equals(Field103))
      Field102.player.movementInput = (MovementInput)Field103; 
    if (!SelfDestruct.Field181) {
      if (Field101 == null)
        Field101 = new ClickGuiManager();
      ModuleManager.onKeyboard(this);
      if (Method125() == 1 || Method125() == 2) {
        Class14.Field161.put(Integer.valueOf(getKey()), Boolean.valueOf(true));
      } else if (Method125() == 0) {
        Class14.Field161.put(Integer.valueOf(getKey()), Boolean.valueOf(false));
      } 
      if (Class14.Method201(344) && Field102.currentScreen == null)
        Field102.displayGuiScreen(Field101); 
    } 
  }
  
  public int getKey() {
    return this.Field97;
  }
  
  public int Method124() {
    return this.Field98;
  }
  
  public int Method125() {
    return this.Field99;
  }
  
  public int Method126() {
    return this.Field100;
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class39.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

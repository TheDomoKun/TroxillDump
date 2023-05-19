//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.client.Minecraft;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import package0.CustomPacketHandler;

public class Class38 {
  private World Field92;
  
  private boolean Field93 = true;
  
  private boolean Field94;
  
  static final boolean Field95 = !Class38.class.desiredAssertionStatus();
  
  public boolean Method120() {
    return ((Minecraft.getInstance()).player == null || (Minecraft.getInstance()).world == null);
  }
  
  public void Method121() {
    if (Method120()) {
      this.Field94 = false;
      return;
    } 
    if (!this.Field94) {
      new CustomPacketHandler(TroxillMain.getModuleManager());
      this.Field94 = true;
    } 
    if ((Minecraft.getInstance()).world == this.Field92) {
      if (this.Field93) {
        this.Field93 = false;
        if (!Field95 && (Minecraft.getInstance()).playerController == null)
          throw new AssertionError(); 
        GameType gameType = (Minecraft.getInstance()).playerController.getCurrentGameType();
        HookInjector.RegisterPlayerHook();
        if (!Field95 && (Minecraft.getInstance()).player == null)
          throw new AssertionError(); 
        (Minecraft.getInstance()).playerController.setGameType(gameType);
      } 
    } else {
      this.Field93 = true;
      this.Field92 = (World)(Minecraft.getInstance()).world;
    } 
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class38.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

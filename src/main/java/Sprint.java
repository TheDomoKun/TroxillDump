//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.client.gui.screen.ChatScreen;

public class Sprint extends Module {
  public Sprint() {
    super(Category.Movement, 2);
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    if (mc.player != null) {
      if (!mc.player.collidedHorizontally && Class14.Method201(87) && mc.currentScreen == null)
        mc.player.setSprinting(true);
      if (!mc.player.collidedHorizontally && Class14.Method201(87) && mc.currentScreen != null && ((Module) ModuleManager.getModules().get(24)).isToggled() && !(mc.currentScreen instanceof ChatScreen))
        mc.player.setSprinting(true);
    } 
    super.OnPlayerTick(paramPlayerTickEvent);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class64.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

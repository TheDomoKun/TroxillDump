//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerController;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class NoBreakDelay extends Module {
  static final boolean Field105 = !NoBreakDelay.class.desiredAssertionStatus();
  
  public NoBreakDelay() {
    super(Category.Player, 8);
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    if (!Field105 && (Minecraft.getInstance()).playerController == null)
      throw new AssertionError(); 
    ObfuscationReflectionHelper.setPrivateValue(PlayerController.class, (Minecraft.getInstance()).playerController, Integer.valueOf(0), "blockHitDelay");
    super.OnPlayerTick(paramPlayerTickEvent);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class70.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

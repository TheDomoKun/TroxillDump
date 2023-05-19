//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class NoJumpDelay extends Module {
  public NoJumpDelay() {
    super(Category.Movement, 3);
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    ClientPlayerEntity clientPlayerEntity = (Minecraft.getInstance()).player;
    if (clientPlayerEntity != null)
      ObfuscationReflectionHelper.setPrivateValue(LivingEntity.class, clientPlayerEntity, Integer.valueOf(0), "jumpTicks"); 
    super.OnPlayerTick(paramPlayerTickEvent);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class62.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

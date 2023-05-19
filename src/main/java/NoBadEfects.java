//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;

public class NoBadEfects extends Module {
  public NoBadEfects() {
    super(Category.Player, 15);
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    ClientPlayerEntity clientPlayerEntity = (Minecraft.getInstance()).player;
    if (clientPlayerEntity != null)
      for (EffectInstance effectInstance : mc.player.getActivePotionEffects()) {
        if (effectInstance.getPotion().getEffectType() == EffectType.HARMFUL)
          mc.player.removeActivePotionEffect(effectInstance.getPotion());
      }  
    super.OnPlayerTick(paramPlayerTickEvent);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class69.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

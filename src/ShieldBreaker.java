//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

public class ShieldBreaker extends Module {
  public ShieldBreaker() {
    super(Category.Ghost, 27);
  }
  
  public void onAttack(CustomPlayerEvent paramCustomPlayerEvent) {
    if (paramCustomPlayerEvent.Method122() instanceof PlayerEntity && paramCustomPlayerEvent.Method122() != mc.player && mc.player != null) {
      int i = mc.player.inventory.currentItem;
      int j = InventoryUtils.findAxe();
      PlayerEntity playerEntity = (PlayerEntity) paramCustomPlayerEvent.Method122();
      if (playerEntity.isActiveItemStackBlocking()) {
        if (j == -1)
          return; 
        InventoryUtils.Method61(j);
        if (mc.playerController != null) {
          ((PlayerControllerHook) mc.playerController).Method51((PlayerEntity) mc.player, (Entity)playerEntity);
          mc.player.swingArm(Hand.MAIN_HAND);
          mc.player.resetCooldown();
        } 
        InventoryUtils.Method61(i);
      } 
    } 
    super.onAttack(paramCustomPlayerEvent);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class56.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

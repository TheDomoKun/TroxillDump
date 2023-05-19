//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.util.Objects;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.play.server.SMountEntityPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;

public class ShieldAttack extends Module {
  public ShieldAttack() {
    super(Category.Ghost, 5);
    SettingsStringManager.registerSetting(new Setting(1, this, false));
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    RayTraceResult rayTraceResult = mc.objectMouseOver;
    if (rayTraceResult != null) {
      boolean bool = ((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Method182(), 1))).Method79();
      if (rayTraceResult.getType() == RayTraceResult.Type.ENTITY) {
        Entity entity = ((EntityRayTraceResult)rayTraceResult).getEntity();
        if (mc.player != null && mc.playerController != null && mc.player.isActiveItemStackBlocking() && mc.gameSettings.keyBindAttack.isKeyDown()) {
          KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKey(), false);
          mc.playerController.attackEntity((PlayerEntity) mc.player, entity);
          mc.player.swingArm(Hand.MAIN_HAND);
          (new Thread(bool::Method200)).start();
          mc.player.resetActiveHand();
          KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKey(), false);
        } 
      } else if (mc.player != null && mc.player.isActiveItemStackBlocking() && mc.gameSettings.keyBindAttack.isKeyDown()) {
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKey(), false);
        mc.player.connection.handleEntityAttach(new SMountEntityPacket((Entity) mc.player, null));
        mc.player.swingArm(Hand.MAIN_HAND);
        mc.player.resetCooldown();
        (new Thread(bool::Method199)).start();
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKey(), false);
      } 
    } 
    super.OnPlayerTick(paramPlayerTickEvent);
  }
  
  private static void Method199(boolean paramBoolean) {
    if (paramBoolean)
      Thread.sleep((100 + (int)(Math.random() * 20.0D))); 
    KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKey(), true);
  }
  
  private static void Method200(boolean paramBoolean) {
    if (paramBoolean)
      Thread.sleep((100 + (int)(Math.random() * 20.0D))); 
    KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKey(), true);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class55.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

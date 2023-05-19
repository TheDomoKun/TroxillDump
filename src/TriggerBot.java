//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;

public class TriggerBot extends Module {
  private final TimeHelper Field164 = new TimeHelper();
  
  public TriggerBot() {
    super(Category.Ghost, 18);
    SettingsStringManager.registerSetting(new Setting(1, this, false));
    SettingsStringManager.registerSetting(new Setting(2, this, false));
    SettingsStringManager.registerSetting(new Setting(3, this, 3.8D, 1.0D, 4.0D, false));
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    boolean bool = ((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Method182(), 2))).Method79();
    double d = ((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Method182(), 3))).Method81() - 0.6315093D;
    if (mc.player != null && mc.playerController != null && mc.currentScreen == null && !mc.player.isActiveItemStackBlocking()) {
      RayTraceResult rayTraceResult = (Minecraft.getInstance()).objectMouseOver;
      if (bool) {
        if (rayTraceResult != null && rayTraceResult.getType() == RayTraceResult.Type.ENTITY) {
          Entity entity = ((EntityRayTraceResult)rayTraceResult).getEntity();
          boolean bool1 = ((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Method182(), 1))).Method79();
          if (mc.player.getDistance(entity) <= d)
            if (!bool1) {
              if (entity instanceof PlayerEntity && mc.player.getCooledAttackStrength(0.0F) == 1.0F && this.Field164.Method27(Math.random() * 250.0D)) {
                mc.playerController.attackEntity((PlayerEntity) mc.player, ((EntityRayTraceResult)rayTraceResult).getEntity());
                mc.player.swingArm(Hand.MAIN_HAND);
                mc.player.resetCooldown();
                this.Field164.Method30();
              } 
            } else if ((entity instanceof net.minecraft.entity.MobEntity || entity instanceof PlayerEntity) && mc.player.getCooledAttackStrength(0.0F) == 1.0F && this.Field164.Method27(Math.random() * 250.0D)) {
              mc.playerController.attackEntity((PlayerEntity) mc.player, ((EntityRayTraceResult)rayTraceResult).getEntity());
              mc.player.swingArm(Hand.MAIN_HAND);
              mc.player.resetCooldown();
              this.Field164.Method30();
            }  
        } 
      } else if (rayTraceResult != null && rayTraceResult.getType() == RayTraceResult.Type.ENTITY) {
        Entity entity = ((EntityRayTraceResult)rayTraceResult).getEntity();
        boolean bool1 = ((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Method182(), 1))).Method79();
        if (mc.player.getDistance(entity) <= d)
          if (!bool1) {
            if (entity instanceof PlayerEntity && mc.player.getCooledAttackStrength(0.0F) == 1.0F) {
              mc.playerController.attackEntity((PlayerEntity) mc.player, entity);
              mc.player.swingArm(Hand.MAIN_HAND);
              mc.player.resetCooldown();
            } 
          } else if ((entity instanceof net.minecraft.entity.MobEntity || entity instanceof PlayerEntity) && mc.player.getCooledAttackStrength(0.0F) == 1.0F) {
            mc.playerController.attackEntity((PlayerEntity) mc.player, entity);
            mc.player.swingArm(Hand.MAIN_HAND);
            mc.player.resetCooldown();
          }  
      } 
    } 
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class57.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

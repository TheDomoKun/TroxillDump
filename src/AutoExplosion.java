//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class AutoExplosion extends Module {
  private final TimeHelper Field171 = new TimeHelper();
  
  public AutoExplosion() {
    super(Category.Ghost, 28);
    SettingsStringManager.registerSetting(new Setting(1, this, 4.0D, 1.0D, 5.0D, false));
    SettingsStringManager.registerSetting(new Setting(2, this, 250.0D, 10.0D, 750.0D, false));
    SettingsStringManager.registerSetting(new Setting(3, this, false));
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    if (mc.world != null && mc.player != null) {
      double d = ((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Method182(), 1))).Method81() - 0.6315093D;
      List list = (List)(new ArrayList((Collection) mc.world.getAllEntities())).stream().filter(AutoExplosion::Method234).collect(Collectors.toList());
      for (Entity entity : list) {
        if (mc.player.getDistance(entity) <= d) {
          boolean bool = ((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Method182(), 3))).Method79();
          double d1 = ((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Method182(), 2))).Method81();
          if (bool) {
            if (this.Field171.Method27(d1)) {
              if (mc.playerController == null)
                return; 
              mc.playerController.attackEntity((PlayerEntity) mc.player, entity);
              this.Field171.Method30();
            } 
            continue;
          } 
          if (this.Field171.Method27(d1 + Math.random() * 150.0D)) {
            if (mc.playerController == null)
              return; 
            mc.playerController.attackEntity((PlayerEntity) mc.player, entity);
            this.Field171.Method30();
          } 
        } 
      } 
    } 
    super.OnPlayerTick(paramPlayerTickEvent);
  }
  
  private static boolean Method234(Entity paramEntity) {
    return paramEntity instanceof net.minecraft.entity.item.EnderCrystalEntity;
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class51.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

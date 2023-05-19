//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.util.Objects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;

public class AimAssist extends Module {
  private Entity Field131;
  
  public AimAssist() {
    super(Category.Ghost, 29);
    SettingsStringManager.registerSetting(new Setting(1, this, 25.0D, 10.0D, 100.0D, true));
    SettingsStringManager.registerSetting(new Setting(2, this, 4.5D, 2.0D, 6.0D, false));
    SettingsStringManager.registerSetting(new Setting(3, this, false));
  }
  
  public static float[] Method175(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6) {
    double d1 = paramDouble4 - paramDouble1;
    double d2 = paramDouble5 - paramDouble2;
    double d3 = paramDouble6 - paramDouble3;
    double d4 = MathHelper.sqrt(d1 * d1 + d3 * d3);
    float f1 = (float)(Math.atan2(d3, d1) * 180.0D / Math.PI - 90.0D);
    float f2 = (float)-(Math.atan2(d2, d4) * 180.0D / Math.PI);
    return new float[] { f1, f2 };
  }
  
  private void Method176() {
    if (this.Field131 != null) {
      boolean bool1 = false;
      boolean bool2 = true;
      float f1 = 180.0F;
      float f2 = 90.0F;
      float f3 = (float)(((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Method182(), 1))).Method81() / 100.0D);
      float[] arrayOfFloat = Method178(this.Field131, f1, f2, f3, f3);
      mc.player.rotationYaw = arrayOfFloat[0];
      mc.player.rotationPitch = arrayOfFloat[1];
    } 
  }
  
  public static float[] Method177(Entity paramEntity1, Entity paramEntity2) {
    return Method175(paramEntity1.getPosX(), paramEntity1.getPosY() + paramEntity1.getEyeHeight(), paramEntity1.getPosZ(), paramEntity2.getPosX(), paramEntity2.getPosY() + (paramEntity2.getEyeHeight() / 1.5F), paramEntity2.getPosZ());
  }
  
  public static float[] Method178(Entity paramEntity, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    float[] arrayOfFloat = Method177((Entity) mc.player, paramEntity);
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat[1];
    boolean bool1 = (MathHelper.abs(MathHelper.wrapDegrees(f1 - mc.player.rotationYaw)) <= paramFloat1) ? true : false;
    boolean bool2 = (MathHelper.abs(MathHelper.wrapDegrees(f2 - mc.player.rotationPitch)) <= paramFloat2) ? true : false;
    if (bool1 && bool2) {
      float f3 = MathHelper.wrapDegrees(f1 - mc.player.rotationYaw) * paramFloat3 / 100.0F;
      float f4 = MathHelper.wrapDegrees(f2 - mc.player.rotationPitch) * paramFloat4 / 100.0F;
      return new float[] { mc.player.rotationYaw + f3, mc.player.rotationPitch + f4 };
    } 
    return new float[] { mc.player.rotationYaw, mc.player.rotationPitch };
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    double d = ((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Method182(), 2))).Method81();
    if (mc.player != null && mc.world != null) {
      if (this.Field131 == null)
        for (PlayerEntity playerEntity : mc.world.getPlayers()) {
          if (mc.player.getDistance((Entity)playerEntity) <= d && mc.player != playerEntity) {
            this.Field131 = (Entity)playerEntity;
            break;
          } 
        }  
      if (mc.player.getDistance(this.Field131) > d)
        this.Field131 = null; 
      if (this.Field131 == null)
        return; 
      if (mc.player.isAlive() && this.Field131.isAlive()) {
        boolean bool = ((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Method182(), 3))).Method79();
        if (bool) {
          Item item = mc.player.getHeldItemMainhand().getItem();
          if (item instanceof net.minecraft.item.SwordItem || item instanceof net.minecraft.item.AxeItem)
            Method176(); 
        } else {
          Method176();
        } 
      } 
    } 
    super.OnPlayerTick(paramPlayerTickEvent);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class49.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

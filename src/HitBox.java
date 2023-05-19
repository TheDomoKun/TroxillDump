//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;

public class HitBox extends Module {
  public HitBox() {
    super(Category.Ghost, 1);
    SettingsStringManager.registerSetting(new Setting(1, this, 0.3D, 0.26D, 1.0D, false));
  }

  @Override
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    if (mc.world == null)
      return;
    for (PlayerEntity playerEntity : mc.world.getPlayers()) {
      if (playerEntity != (Minecraft.getInstance()).player) {
        double d = ((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Method182(), 1))).Method81();
        playerEntity.setBoundingBox(new AxisAlignedBB(playerEntity.getPosX() - d, (playerEntity.getBoundingBox()).minY, playerEntity.getPosZ() - d, playerEntity.getPosX() + d, (playerEntity.getBoundingBox()).maxY, playerEntity.getPosZ() + d));
      }
    }
    super.OnPlayerTick(paramPlayerTickEvent);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class53.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

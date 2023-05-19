//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.util.Objects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SDisconnectPacket;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class PlayerLeave extends Module {
  public PlayerLeave() {
    super(Category.Player, 22);
    SettingsStringManager.registerSetting(new Setting(1, this, 50.0D, 10.0D, 100.0D, true));
    SettingsStringManager.registerSetting(new Setting(2, this, true));
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    if (mc.player != null && mc.world != null)
      for (PlayerEntity playerEntity : mc.world.getPlayers()) {
        if (mc.player.getDistance((Entity)playerEntity) < ((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Method182(), 1))).Method81() && mc.player.getDistance((Entity)playerEntity) != 0.0F) {
          mc.getConnection().sendPacket((IPacket)new SDisconnectPacket((ITextComponent)new StringTextComponent("Timed out")));
          if (((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Method182(), 2))).Method79())
            Method191(); 
          break;
        } 
      }  
    super.OnPlayerTick(paramPlayerTickEvent);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class72.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

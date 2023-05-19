//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.util.Objects;
import net.minecraft.client.settings.KeyBinding;

public class AntiAFK extends Module {
  private int Field169 = 0;
  
  public AntiAFK() {
    super(Category.Ghost, 11);
    SettingsStringManager.registerSetting(new Setting(1, this, false));
  }
  
  private void Method230() throws InterruptedException {
    if (mc.player == null)
      return; 
    for (byte b = 0; b < '´'; b++) {
      Thread.sleep(5L);
      mc.player.rotationYaw++;
    } 
  }
  
  private void Method231() {
    (new Thread(this::Method232)).start();
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    if (mc.player != null) {
      if (((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Method182(), 1))).Method79())
        mc.gameSettings.keyBindJump.setPressed(mc.player.isOnGround());
      this.Field169++;
      if (this.Field169 >= 8000) {
        Method231();
        this.Field169 = 0;
      } 
    } 
    super.OnPlayerTick(paramPlayerTickEvent);
  }
  
  private void Method232() {
    Method230();
    KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKey(), true);
    Thread.sleep(600L);
    KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKey(), false);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class50.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

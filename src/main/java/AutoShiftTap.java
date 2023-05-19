//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.client.settings.KeyBinding;

public class AutoShiftTap extends Module {
  private boolean Field170;
  
  public AutoShiftTap() {
    super(Category.Ghost, 23);
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    if (mc.player != null && !mc.player.isSneaking())
      if (mc.gameSettings.keyBindAttack.isKeyDown()) {
        if (!this.Field170) {
          this.Field170 = true;
          KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKey(), true);
          (new Thread(AutoShiftTap::Method233)).start();
          this.Field170 = true;
        } 
      } else {
        this.Field170 = false;
      }  
    super.OnPlayerTick(paramPlayerTickEvent);
  }
  
  private static void Method233() {
    Thread.sleep(100L);
    KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKey(), false);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class52.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

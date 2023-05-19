//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.util.Objects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.item.Item;

public class ChestStealer extends Module {
  TimeHelper Field32 = new TimeHelper();
  
  public ChestStealer() {
    super(Category.Player, 24);
    SettingsStringManager.registerSetting(new Setting(1, this, 10.0D, 1.0D, 100.0D, true));
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    if (mc.player == null)
      return; 
    if (mc.playerController == null)
      return; 
    int i = (int)((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Method182(), 1))).Method81();
    if (mc.player.openContainer instanceof ChestContainer) {
      ChestContainer chestContainer = (ChestContainer) mc.player.openContainer;
      for (byte b = 0; b < chestContainer.inventorySlots.size(); b++) {
        if (chestContainer.getLowerChestInventory().getStackInSlot(b).getItem() != Item.getItemById(0) && this.Field32.Method27(i)) {
          mc.playerController.windowClick(chestContainer.windowId, b, 0, ClickType.QUICK_MOVE, (PlayerEntity) mc.player);
          this.Field32.Method30();
        } 
      } 
    } 
    super.OnPlayerTick(paramPlayerTickEvent);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class65.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

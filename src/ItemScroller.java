//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.util.Objects;
import net.minecraft.client.gui.screen.inventory.ChestScreen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class ItemScroller extends Module {
  boolean Field0;
  
  public ItemScroller() {
    super(Category.Player, 10);
  }
  
  public void onInput(InputEventHOok paramInputEventHOok) {
    if (paramInputEventHOok.Method192() == 0)
      this.Field0 = (paramInputEventHOok.Method125() == 1);
    super.onInput(paramInputEventHOok);
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    if (Class14.Method201(340) && this.Field0 && mc.currentScreen != null && mc.player != null && mc.playerController != null) {
      if (mc.currentScreen instanceof InventoryScreen) {
        InventoryScreen inventoryScreen = (InventoryScreen) mc.currentScreen;
        if (inventoryScreen.getSlotUnderMouse() != null) {
          PlayerContainer playerContainer = (PlayerContainer) mc.player.openContainer;
          if (!((ItemStack)playerContainer.getInventory().get((inventoryScreen.getSlotUnderMouse()).slotNumber)).isEmpty())
            mc.playerController.windowClick(playerContainer.windowId, ((Slot)Objects.requireNonNull((T)inventoryScreen.getSlotUnderMouse())).slotNumber, 0, ClickType.QUICK_MOVE, (PlayerEntity) mc.player);
        } 
      } 
      if (mc.currentScreen instanceof ChestScreen) {
        ChestScreen chestScreen = (ChestScreen) mc.currentScreen;
        if (chestScreen.getSlotUnderMouse() != null) {
          ChestContainer chestContainer = (ChestContainer) mc.player.openContainer;
          mc.playerController.windowClick(chestContainer.windowId, ((Slot)Objects.requireNonNull((T)chestScreen.getSlotUnderMouse())).slotNumber, 0, ClickType.QUICK_MOVE, (PlayerEntity) mc.player);
        } 
      } 
    } 
    super.OnPlayerTick(paramPlayerTickEvent);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class67.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

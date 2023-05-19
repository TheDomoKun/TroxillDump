//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class ElytraSwap extends Module {
  public ElytraSwap() {
    super(Category.Movement, 19);
  }
  
  private boolean Method224(Item paramItem) {
    return (paramItem == Items.ELYTRA);
  }
  
  private boolean Method225(Item paramItem) {
    return (paramItem == Items.CHAINMAIL_CHESTPLATE || paramItem == Items.DIAMOND_CHESTPLATE || paramItem == Items.GOLDEN_CHESTPLATE || paramItem == Items.IRON_CHESTPLATE || paramItem == Items.LEATHER_CHESTPLATE || paramItem == Items.NETHERITE_CHESTPLATE);
  }
  
  public void Method58() {
    if (mc.player != null && mc.playerController != null) {
      PlayerContainer playerContainer = mc.player.container;
      if (!((Slot)playerContainer.inventorySlots.get(6)).getStack().isEmpty()) {
        if (Method224(((Slot)playerContainer.inventorySlots.get(6)).getStack().getItem())) {
          mc.playerController.windowClick(playerContainer.windowId, 6, 0, ClickType.QUICK_MOVE, (PlayerEntity) mc.player);
          for (Slot slot : playerContainer.inventorySlots) {
            Item item = slot.getStack().getItem();
            if (Method225(item)) {
              mc.playerController.windowClick(playerContainer.windowId, slot.slotNumber, 0, ClickType.QUICK_MOVE, (PlayerEntity) mc.player);
              break;
            } 
          } 
        } else if (Method225(((Slot)playerContainer.inventorySlots.get(6)).getStack().getItem())) {
          mc.playerController.windowClick(playerContainer.windowId, 6, 0, ClickType.QUICK_MOVE, (PlayerEntity) mc.player);
          for (Slot slot : playerContainer.inventorySlots) {
            Item item = slot.getStack().getItem();
            if (Method224(item)) {
              mc.playerController.windowClick(playerContainer.windowId, slot.slotNumber, 0, ClickType.QUICK_MOVE, (PlayerEntity) mc.player);
              break;
            } 
          } 
        } 
      } else {
        for (Slot slot : playerContainer.inventorySlots) {
          Item item = slot.getStack().getItem();
          if (Method224(item) || Method225(item))
            mc.playerController.windowClick(playerContainer.windowId, slot.slotNumber, 0, ClickType.QUICK_MOVE, (PlayerEntity) mc.player);
        } 
      } 
    } 
    Method191();
    super.Method58();
  }
  
  public void Method59() {
    super.Method59();
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class59.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

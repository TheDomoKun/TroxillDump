//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.client.CHeldItemChangePacket;
import net.minecraft.network.play.client.CPlayerTryUseItemPacket;
import net.minecraft.util.Hand;

public class MiddleClickPearl extends Module {
  public MiddleClickPearl() {
    super(Category.Player, 6);
  }
  
  public void onInput(InputEventHOok paramInputEventHOok) {
    if (mc.world == null || !mc.world.isRemote)
      return; 
    if (mc.player != null && paramInputEventHOok.Method192() == 2 && paramInputEventHOok.Method125() == 1)
      for (byte b = 0; b < 9; b++) {
        ItemStack itemStack = mc.player.inventory.getStackInSlot(b);
        if (itemStack.getItem() == Items.ENDER_PEARL && mc.currentScreen == null) {
          mc.player.connection.sendPacket((IPacket)new CHeldItemChangePacket(b));
          mc.player.connection.sendPacket((IPacket)new CPlayerTryUseItemPacket(Hand.MAIN_HAND));
          mc.player.connection.sendPacket((IPacket)new CHeldItemChangePacket(mc.player.inventory.currentItem));
        } 
      }  
    super.onInput(paramInputEventHOok);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class68.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

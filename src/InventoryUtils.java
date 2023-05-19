//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.client.CHeldItemChangePacket;

public class InventoryUtils {
  private static final Minecraft Field31 = Minecraft.getInstance();
  
  public static int findAxe() {
    if (Field31.player == null)
      return -1; 
    for (byte b = 0; b <= 9; b++) {
      ItemStack itemStack = Field31.player.inventory.getStackInSlot(b);
      if (itemStack.getItem() instanceof net.minecraft.item.AxeItem)
        return b; 
    } 
    return -1;
  }
  
  public static void Method61(int paramInt) {
    if (Field31.player == null)
      return; 
    Field31.player.connection.sendPacket((IPacket)new CHeldItemChangePacket(paramInt));
    Field31.player.inventory.currentItem = paramInt;
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class21.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

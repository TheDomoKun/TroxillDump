//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class FastPlace extends Module {
  private int Field2 = 0;
  
  public FastPlace() {
    super(Category.Player, 21);
  }
  
  public boolean Method16(Object paramObject, PacketDirection paramPacketDirection) {
    if (paramObject instanceof net.minecraft.network.play.client.CPlayerTryUseItemPacket) {
      if (this.Field2 >= 2) {
        ObfuscationReflectionHelper.setPrivateValue(Minecraft.class, mc, Integer.valueOf(1), "rightClickDelayTimer");
        this.Field2 = 0;
      } 
      this.Field2++;
    } 
    return super.Method16(paramObject, paramPacketDirection);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class66.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

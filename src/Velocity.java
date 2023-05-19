//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.network.play.server.SEntityVelocityPacket;

public class Velocity extends Module {
  public Velocity() {
    super(Category.Ghost, 7);
  }
  
  public boolean Method16(Object paramObject, PacketDirection paramPacketDirection) {
    if (isToggled() && mc.player != null && paramObject instanceof SEntityVelocityPacket) {
      SEntityVelocityPacket sEntityVelocityPacket = (SEntityVelocityPacket)paramObject;
      return (sEntityVelocityPacket.getEntityID() != mc.player.getEntityId());
    } 
    return true;
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class58.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

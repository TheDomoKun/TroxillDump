public class XCarry extends Module {
  public XCarry() {
    super(Category.Player, 30);
  }
  
  public boolean Method16(Object paramObject, PacketDirection paramPacketDirection) {
    return (paramObject instanceof net.minecraft.network.play.client.CCloseWindowPacket) ? false : super.Method16(paramObject, paramPacketDirection);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class73.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.client.entity.player.RemoteClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.client.CPlayerPacket;

public class Freecam extends Module {
  private RemoteClientPlayerEntity Field24;
  
  double Field25;
  
  double Field26;
  
  double Field27;
  
  float Field28;
  
  float Field29;
  
  public Freecam() {
    super(Category.Movement, 26);
  }
  
  public void Method58() {
    if (mc.player == null || mc.world == null)
      return; 
    super.Method58();
    this.Field25 = mc.player.getPosX();
    this.Field26 = mc.player.getPosY();
    this.Field27 = mc.player.getPosZ();
    this.Field28 = mc.player.rotationYaw;
    this.Field29 = mc.player.rotationPitch;
    this.Field24 = new RemoteClientPlayerEntity(mc.world, mc.player.getGameProfile());
    this.Field24.setHealth(mc.player.getHealth());
    this.Field24.setPositionAndRotation(this.Field25, (mc.player.getBoundingBox()).minY, this.Field27, mc.player.rotationYaw, mc.player.rotationPitch);
    this.Field24.rotationYawHead = mc.player.rotationYawHead;
    mc.world.addEntity(-1, (Entity)this.Field24);
  }
  
  public void Method59() {
    if (mc.player == null || mc.world == null)
      return; 
    super.Method59();
    mc.player.setPosition(this.Field25, this.Field26, this.Field27);
    mc.getConnection().sendPacket((IPacket)new CPlayerPacket.PositionPacket(mc.player.getPosX(), mc.player.getPosY() + 0.01D, mc.player.getPosZ(), mc.player.isOnGround()));
    mc.player.setHeadRotation(this.Field28, (int)this.Field29);
    mc.player.noClip = false;
    mc.world.removeEntityFromWorld(-1);
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    if (this.Field24 != null && !isToggled()) {
      mc.world.removeEntityFromWorld(-1);
      this.Field24 = null;
    } 
    super.OnPlayerTick(paramPlayerTickEvent);
  }
  
  public boolean Method16(Object paramObject, PacketDirection paramPacketDirection) {
    return (paramObject instanceof net.minecraft.network.play.server.SPlayerPositionLookPacket) ? false : super.Method16(paramObject, paramPacketDirection);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class60.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

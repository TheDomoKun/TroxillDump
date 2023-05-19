//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

package package0;

import ModuleManager;
import PacketDirection;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.play.ClientPlayNetHandler;

public class CustomPacketHandler extends ChannelDuplexHandler {
  private final ModuleManager Field30;
  
  public CustomPacketHandler(ModuleManager paramModuleManager) {
    this.Field30 = paramModuleManager;
    ChannelPipeline channelPipeline = ((ClientPlayNetHandler)Objects.<ClientPlayNetHandler>requireNonNull(Minecraft.getInstance().getConnection())).getNetworkManager().channel().pipeline();
    channelPipeline.addBefore("packet_handler", "PacketHandler", (ChannelHandler)this);
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject) throws Exception {
    if (this.Field30.Method37(paramObject, PacketDirection.IN))
      return; 
    super.channelRead(paramChannelHandlerContext, paramObject);
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise) throws Exception {
    if (this.Field30.Method37(paramObject, PacketDirection.OUT))
      return; 
    super.write(paramChannelHandlerContext, paramObject, paramChannelPromise);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\package0\Class18.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

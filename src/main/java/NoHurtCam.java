import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;

public class NoHurtCam extends Module {
  public NoHurtCam() {
    super(Category.Render, 16);
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    ClientPlayerEntity clientPlayerEntity = (Minecraft.getInstance()).player;
    if (clientPlayerEntity != null) {
      ((PlayerEntity)clientPlayerEntity).hurtResistantTime = 0;
      ((PlayerEntity)clientPlayerEntity).maxHurtTime = 0;
    } 
    super.OnPlayerTick(paramPlayerTickEvent);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
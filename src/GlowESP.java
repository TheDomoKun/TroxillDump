//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class GlowESP extends Module {
  private final List Field121 = new ArrayList();
  
  public GlowESP() {
    super(Category.Render, 12);
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    if (mc.world == null)
      return; 
    for (PlayerEntity playerEntity : mc.world.getPlayers()) {
      if (playerEntity != mc.player) {
        playerEntity.setGlowing(true);
        if (!this.Field121.contains(playerEntity))
          this.Field121.add(playerEntity); 
      } 
    } 
    super.OnPlayerTick(paramPlayerTickEvent);
  }
  
  public void Method59() {
    for (Entity entity : this.Field121)
      entity.setGlowing(false); 
    this.Field121.clear();
    super.Method59();
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

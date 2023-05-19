//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;

public class ItemEsp extends Module {
  private final List Field122 = new ArrayList();
  
  public ItemEsp() {
    super(Category.Render, 20);
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    if (mc.world == null)
      return; 
    if (mc.player == null)
      return; 
    for (Entity entity : mc.world.getAllEntities()) {
      if (entity instanceof net.minecraft.entity.item.ItemEntity) {
        if (!this.Field122.contains(entity))
          this.Field122.add(entity); 
        if (!entity.isGlowing())
          entity.setGlowing(true); 
      } 
    } 
    super.OnPlayerTick(paramPlayerTickEvent);
  }
  
  public void Method59() {
    this.Field122.forEach(Class2::Method153);
    super.Method59();
  }
  
  private static void Method153(Entity paramEntity) {
    paramEntity.setGlowing(false);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

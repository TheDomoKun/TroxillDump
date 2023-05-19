import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Cancelable;

@Cancelable
public class CustomPlayerEvent extends PlayerEvent {
  private final Entity Field96;
  
  public CustomPlayerEvent(PlayerEntity paramPlayerEntity, Entity paramEntity) {
    super(paramPlayerEntity);
    this.Field96 = paramEntity;
    ModuleManager.onAttackENtity(this);
  }
  
  public Entity Method122() {
    return this.Field96;
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class37.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
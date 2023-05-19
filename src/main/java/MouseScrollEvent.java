import net.minecraft.client.gui.screen.Screen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.Cancelable;

@Cancelable
public class MouseScrollEvent extends GuiScreenEvent.MouseScrollEvent {
  public MouseScrollEvent(Screen paramScreen, double paramDouble1, double paramDouble2, double paramDouble3) {
    super(paramScreen, paramDouble1, paramDouble2, paramDouble3);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class41.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
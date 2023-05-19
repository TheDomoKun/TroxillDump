import net.minecraft.client.gui.screen.Screen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.Cancelable;

public class ScrollManager extends GuiScreenEvent.MouseInputEvent {
  private final double Field141;
  
  public ScrollManager(Screen paramScreen, double paramDouble1, double paramDouble2, double paramDouble3) {
    super(paramScreen, paramDouble1, paramDouble2);
    this.Field141 = paramDouble3;
    if (paramScreen.getClass() == ClickGuiManager.class)
      ClickGuiManager.Method203((int)(getScrollDelta() * 3.0D));
  }
  
  public double getScrollDelta() {
    return this.Field141;
  }
  
  @Cancelable
  public static class Class41 extends GuiScreenEvent.MouseScrollEvent {
    public Class41(Screen param1Screen, double param1Double1, double param1Double2, double param1Double3) {
      super(param1Screen, param1Double1, param1Double2, param1Double3);
    }
  }
  
  @Cancelable
  public static class Class42 extends GuiScreenEvent.MouseScrollEvent {
    public Class42(Screen param1Screen, double param1Double1, double param1Double2, double param1Double3) {
      super(param1Screen, param1Double1, param1Double2, param1Double3);
    }
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class43.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
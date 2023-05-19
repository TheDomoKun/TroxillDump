import net.minecraftforge.client.event.InputEvent;

public class InputEventHOok extends InputEvent {
  private final int Field138;
  
  private final int Field139;
  
  private final int Field140;
  
  public InputEventHOok(int paramInt1, int paramInt2, int paramInt3) {
    this.Field138 = paramInt1;
    this.Field139 = paramInt2;
    this.Field140 = paramInt3;
    if (!SelfDestruct.Field181)
      ModuleManager.onInput(this);
  }
  
  public int Method192() {
    return this.Field138;
  }
  
  public int Method125() {
    return this.Field139;
  }
  
  public int Method193() {
    return this.Field140;
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class40.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
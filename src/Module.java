import net.minecraft.client.Minecraft;

public class Module {
  private int Field132;
  
  private int Field133;
  
  private Category Field134;
  
  private boolean Field135 = false;
  
  private boolean Field136 = false;
  
  public static Minecraft mc;
  
  public boolean Method179() {
    return this.Field136;
  }
  
  public void Method180(boolean paramBoolean) {
    this.Field136 = paramBoolean;
  }
  
  public int Method181() {
    return this.Field132;
  }
  
  public int Method182() {
    return this.Field133;
  }
  
  public Category Method183() {
    return this.Field134;
  }
  
  public boolean isToggled() {
    return this.Field135;
  }
  
  public void Method185(int paramInt) {
    this.Field132 = paramInt;
  }
  
  public Module(Category paramCategory, int paramInt) {
    mc = Minecraft.getInstance();
    this.Field134 = paramCategory;
    this.Field133 = paramInt;
  }
  
  public void Method186(boolean paramBoolean) {
    this.Field135 = paramBoolean;
  }
  
  public void Method58() {}
  
  public void Method59() {}
  
  public void onInput(InputEventHOok paramInputEventHOok) {}
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {}
  
  public void onAttack(CustomPlayerEvent paramCustomPlayerEvent) {}
  
  public void onHandRenderEvent(HandRenderEvent paramHandRenderEvent) {}
  
  public void onRenderBossbar(RenderBossbarEvent paramRenderBossbarEvent) {}
  
  public boolean Method16(Object paramObject, PacketDirection paramPacketDirection) {
    return true;
  }
  
  public void Method190(KeyboardEvent paramKeyboardEvent) {}
  
  public void Method191() {
    this.Field135 = !this.Field135;
    if (this.Field135) {
      Method58();
    } else {
      Method59();
    } 
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class48.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
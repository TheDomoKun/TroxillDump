//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

public class NoRain extends Module {
  private float Field104;
  
  public NoRain() {
    super(Category.Render, 13);
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    if (mc.world != null)
      mc.world.setRainStrength(0.0F);
    super.OnPlayerTick(paramPlayerTickEvent);
  }
  
  public void Method58() {
    if (mc.world != null)
      this.Field104 = mc.world.rainingStrength;
    super.Method58();
  }
  
  public void Method59() {
    if (mc.world != null)
      mc.world.setRainStrength(this.Field104);
    super.Method59();
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class4.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

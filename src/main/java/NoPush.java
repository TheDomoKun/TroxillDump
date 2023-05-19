//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

public class NoPush extends Module {
  private float Field118;
  
  public NoPush() {
    super(Category.Player, 14);
  }
  
  public void OnPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    if (mc.player != null)
      mc.player.entityCollisionReduction = 1.0F;
    super.OnPlayerTick(paramPlayerTickEvent);
  }
  
  public void Method58() {
    this.Field118 = (mc.player != null) ? mc.player.entityCollisionReduction : 0.0F;
  }
  
  public void Method59() {
    if (mc.player != null)
      mc.player.entityCollisionReduction = this.Field118;
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class71.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

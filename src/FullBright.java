//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.client.Minecraft;

public class FullBright extends Module {
  private double Field119;
  
  public FullBright() {
    super(Category.Render, 9);
  }
  
  public void Method58() {
    this.Field119 = (Minecraft.getInstance()).gameSettings.gamma;
    (Minecraft.getInstance()).gameSettings.gamma = 100.0D;
    super.Method58();
  }
  
  public void Method59() {
    (Minecraft.getInstance()).gameSettings.gamma = this.Field119;
    super.Method59();
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

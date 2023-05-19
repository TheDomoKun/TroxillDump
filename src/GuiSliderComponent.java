//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import com.mojang.blaze3d.matrix.MatrixStack;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class GuiSliderComponent extends GuiComponent {
  private final Setting Field142;
  
  private int Field143;
  
  private int Field144;
  
  private int Field145;
  
  private final int Field146;
  
  private final int Field147;
  
  private boolean Field148 = false;
  
  private boolean Field149;
  
  private final GuiButton Field150;
  
  private double Field151;
  
  public GuiSliderComponent(Setting paramSetting, GuiButton paramGuiButton, int paramInt1, int paramInt2) {
    this.Field142 = paramSetting;
    this.Field150 = paramGuiButton;
    this.Field144 = paramGuiButton.Field109;
    this.Field145 = paramGuiButton.Field110 + paramGuiButton.Field112;
    this.Field146 = paramGuiButton.Field111;
    this.Field147 = paramInt2;
    this.Field143 = paramInt1;
  }
  
  public void Method140() {
    MatrixStack matrixStack = new MatrixStack();
    Color color = this.Field149 ? new Color(-668325334, true) : new Color(-669575401, true);
    ClickGuiManager.fill(matrixStack, this.Field144, this.Field145 + this.Field143 + ClickGuiManager.Method202(), this.Field144 + this.Field146, this.Field145 + this.Field147 + this.Field143 + ClickGuiManager.Method202(), color.getRGB());
    ClickGuiManager.fill(matrixStack, this.Field144 + 1, this.Field145 + this.Field143 + 15 + ClickGuiManager.Method202(), this.Field144 + this.Field146 - 1, this.Field145 + this.Field143 + 18 + ClickGuiManager.Method202(), (new Color(1381653)).getRGB());
    RenderUtils.Method6(matrixStack, (this.Field144 + 2), (this.Field145 + this.Field143 + 16 + ClickGuiManager.Method202()), (int)(this.Field144 + this.Field151), (this.Field145 + this.Field143 + 17 + ClickGuiManager.Method202()), RainbowUtil.Method62(500, 1.0F, 1.0F).getRGB());
    int i = 0;
    for (char c : SettingsStringManager.Method208(this.Field150.Field113.Method182(), this.Field142.Method74())) {
      this.Field117.fontRenderer.drawStringWithShadow(matrixStack, c + "", (this.Field144 + i + 3), (this.Field145 + 2 + this.Field143 + ClickGuiManager.Method202()), -1);
      i += this.Field117.fontRenderer.getStringWidth(c + "") + 1;
    } 
    this.Field117.fontRenderer.drawStringWithShadow(matrixStack, "" + this.Field142.Method81(), (this.Field144 + i + 3), (this.Field145 + 2 + this.Field143 + ClickGuiManager.Method202()), -1);
  }
  
  public void Method146(int paramInt) {
    this.Field143 -= paramInt;
  }
  
  public void Method145(int paramInt) {
    this.Field143 += paramInt;
  }
  
  public int Method147() {
    return this.Field147;
  }
  
  public void Method141(int paramInt1, int paramInt2) {
    this.Field145 = this.Field150.Field110 + this.Field150.Field112;
    this.Field144 = this.Field150.Field109;
    this.Field149 = Method195(paramInt1, paramInt2, this.Field144, this.Field145 + this.Field143 + ClickGuiManager.Method202(), this.Field144 + this.Field146, this.Field145 + this.Field147 + this.Field143 + ClickGuiManager.Method202());
    double d1 = Math.min(this.Field146 - 4, Math.max(0, paramInt1 - this.Field144));
    double d2 = this.Field142.Method83();
    double d3 = this.Field142.Method84();
    this.Field151 = (this.Field146 - 4) * (this.Field142.Method81() - d2) / (d3 - d2) + 2.0D;
    if (this.Field148)
      if (d1 == 0.0D) {
        this.Field142.Method82(this.Field142.Method83());
      } else {
        double d = Method194(d1 / (this.Field146 - 4) * (d3 - d2) + d2, 2);
        this.Field142.Method82(d);
      }  
  }
  
  private static double Method194(double paramDouble, int paramInt) {
    if (paramInt < 0)
      throw new IllegalArgumentException(); 
    BigDecimal bigDecimal = new BigDecimal(paramDouble);
    bigDecimal = bigDecimal.setScale(paramInt, RoundingMode.HALF_UP);
    return bigDecimal.doubleValue();
  }
  
  public void Method142(int paramInt1, int paramInt2, int paramInt3) {
    if (this.Field149)
      this.Field148 = true; 
  }
  
  public void Method143(int paramInt1, int paramInt2, int paramInt3) {
    this.Field148 = false;
  }
  
  private static boolean Method195(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    return (paramInt1 > paramInt3 && paramInt2 > paramInt4 && paramInt1 < paramInt5 && paramInt2 < paramInt6);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class12.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import com.mojang.blaze3d.matrix.MatrixStack;
import java.awt.Color;
import net.minecraft.client.Minecraft;

public class GuiButtonComponent extends GuiComponent {
  private boolean Field172;
  
  private final Setting Field173;
  
  private final GuiButton Field174;
  
  private int Field175;
  
  private int Field176;
  
  private final int Field177;
  
  private final int Field178;
  
  public int Field179;
  
  private float Field180;
  
  public GuiButtonComponent(Setting paramSetting, GuiButton paramGuiButton, int paramInt1, int paramInt2) {
    this.Field173 = paramSetting;
    this.Field174 = paramGuiButton;
    this.Field175 = paramGuiButton.Field109;
    this.Field176 = paramGuiButton.Field110 + paramGuiButton.Field112;
    this.Field178 = paramGuiButton.Field111;
    this.Field177 = paramInt2;
    this.Field179 = paramInt1;
    if (paramSetting.Method79())
      Method235(); 
  }
  
  public void Method146(int paramInt) {
    this.Field179 -= paramInt;
  }
  
  public void Method145(int paramInt) {
    this.Field179 += paramInt;
  }
  
  public int Method147() {
    return this.Field177;
  }
  
  public void Method140() {
    MatrixStack matrixStack = new MatrixStack();
    Color color = this.Field172 ? new Color(-668325334, true) : new Color(-669575401, true);
    ClickGuiManager.fill(matrixStack, this.Field175, this.Field176 + this.Field179 + ClickGuiManager.Method202(), this.Field175 + this.Field178, this.Field176 + this.Field177 + this.Field179 + ClickGuiManager.Method202(), color.getRGB());
    int i = 0;
    for (char c : SettingsStringManager.Method208(this.Field174.Field113.Method182(), this.Field173.Method74())) {
      (Minecraft.getInstance()).fontRenderer.drawStringWithShadow(matrixStack, c + "", (this.Field175 + 3 + i), (this.Field176 + 2 + this.Field179 + ClickGuiManager.Method202()), -1);
      i += (Minecraft.getInstance()).fontRenderer.getStringWidth(c + "") + 1;
    } 
    RenderUtils.Method12(matrixStack, this.Field175 + 7, this.Field176 + 15 + this.Field179 + ClickGuiManager.Method202(), this.Field175 + 17, this.Field176 + 15 + this.Field179 + ClickGuiManager.Method202(), 2, this.Field173.Method79() ? new Color(45823) : new Color(7697781));
    RenderUtils.Method11((this.Field175 + 7) + this.Field180, (this.Field176 + 15 + this.Field179 + ClickGuiManager.Method202()), 3.5F, new Color(5832961));
  }
  
  public void Method235() {
    (new Thread(this::Method239)).start();
  }
  
  public void Method236() {
    (new Thread(this::Method238)).start();
  }
  
  public void Method141(int paramInt1, int paramInt2) {
    this.Field176 = this.Field174.Field110 + this.Field174.Field112;
    this.Field175 = this.Field174.Field109;
    this.Field172 = Method237(paramInt1, paramInt2, this.Field175, this.Field176 + this.Field179 + ClickGuiManager.Method202(), this.Field175 + this.Field178, this.Field176 + this.Field177 + this.Field179 + ClickGuiManager.Method202());
  }
  
  public void Method142(int paramInt1, int paramInt2, int paramInt3) {
    if (this.Field172 && this.Field174.Method129()) {
      this.Field173.Method80(!this.Field173.Method79());
      if (this.Field173.Method79()) {
        Method235();
      } else {
        Method236();
      } 
    } 
  }
  
  public static boolean Method237(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (paramDouble1 > paramInt1 && paramDouble2 > paramInt2 && paramDouble1 < paramInt3 && paramDouble2 < paramInt4);
  }
  
  private void Method238() {
    for (byte b = 0; b < 20; b++) {
      if (this.Field180 > 0.0F)
        this.Field180 = (float)(this.Field180 - 0.5D); 
      Thread.sleep(3L);
    } 
  }
  
  private void Method239() {
    for (byte b = 0; b < 20; b++) {
      this.Field180 = (float)(this.Field180 + 0.5D);
      Thread.sleep(3L);
    } 
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class10.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

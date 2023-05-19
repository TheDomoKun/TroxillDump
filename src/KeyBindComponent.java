//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import com.mojang.blaze3d.matrix.MatrixStack;
import java.awt.Color;
import org.lwjgl.glfw.GLFW;

public class KeyBindComponent extends GuiComponent {
  private boolean Field152;
  
  private int Field153;
  
  private int Field154;
  
  private final int Field155;
  
  private final int Field156;
  
  public int Field157;
  
  private boolean Field158;
  
  private final GuiButton Field159;
  
  private final Module Field160;
  
  private char[] Method196(int paramInt) {
    return (paramInt == 1) ? new char[] { 'E', 'n', 't', 'e', 'r', ' ', 'K', 'e', 'y' } : ((paramInt == 2) ? new char[] { 'K', 'e', 'y', ':', ' ' } : new char[0]);
  }
  
  public KeyBindComponent(GuiButton paramGuiButton, int paramInt1, int paramInt2) {
    this.Field159 = paramGuiButton;
    this.Field160 = paramGuiButton.Field113;
    this.Field153 = paramGuiButton.Field109;
    this.Field154 = paramGuiButton.Field110 + paramGuiButton.Field112;
    this.Field155 = paramGuiButton.Field111;
    this.Field156 = paramInt2;
    this.Field157 = paramInt1;
  }
  
  public void Method146(int paramInt) {
    this.Field157 -= paramInt;
  }
  
  public void Method145(int paramInt) {
    this.Field157 += paramInt;
  }
  
  public int Method147() {
    return this.Field156;
  }
  
  public void Method140() {
    int i = 0;
    MatrixStack matrixStack = new MatrixStack();
    Color color = this.Field152 ? new Color(-668325334, true) : new Color(-669575401, true);
    ClickGuiManager.fill(matrixStack, this.Field153, this.Field154 + this.Field157 + ClickGuiManager.Method202(), this.Field153 + this.Field155, this.Field154 + this.Field156 + this.Field157 + ClickGuiManager.Method202(), color.getRGB());
    if (this.Field158) {
      for (char c : Method196(1)) {
        this.Field117.fontRenderer.drawStringWithShadow(matrixStack, c + "", (this.Field153 + 3 + i), (this.Field154 + this.Field157 + 2 + ClickGuiManager.Method202()), -1);
        i += this.Field117.fontRenderer.getStringWidth(c + "") + 1;
      } 
    } else {
      for (char c : Method196(2)) {
        this.Field117.fontRenderer.drawStringWithShadow(matrixStack, c + "", (this.Field153 + 3 + i), (this.Field154 + this.Field157 + 2 + ClickGuiManager.Method202()), -1);
        i += this.Field117.fontRenderer.getStringWidth(c + "") + 1;
      } 
      this.Field117.fontRenderer.drawStringWithShadow(matrixStack, GLFW.glfwGetKeyName(this.Field160.Method181(), GLFW.glfwGetKeyScancode(this.Field160.Method181())).toUpperCase(), (this.Field153 + 3 + i), (this.Field154 + this.Field157 + 2 + ClickGuiManager.Method202()), -1);
    } 
    super.Method140();
  }
  
  public void Method141(int paramInt1, int paramInt2) {
    this.Field154 = this.Field159.Field110 + this.Field159.Field112;
    this.Field153 = this.Field159.Field109;
    this.Field152 = Method197(paramInt1, paramInt2, this.Field153, this.Field154 + this.Field157 + ClickGuiManager.Method202(), this.Field153 + this.Field155, this.Field154 + this.Field156 + this.Field157 + ClickGuiManager.Method202());
  }
  
  public void Method144(int paramInt) {
    if (this.Field158) {
      if (paramInt == 261 || paramInt == 256) {
        this.Field160.Method185(0);
        this.Field158 = false;
        return;
      } 
      this.Field160.Method185(paramInt);
      this.Field158 = false;
      (new Thread(this::Method198)).start();
    } 
    super.Method144(paramInt);
  }
  
  public void Method142(int paramInt1, int paramInt2, int paramInt3) {
    if (this.Field152) {
      this.Field158 = !this.Field158;
      this.Field160.Method180(this.Field158);
      if (this.Field158)
        for (GuiFrame guiFrame : ClickGuiManager.Field163) {
          for (GuiButton guiButton : guiFrame.Field45) {
            if (guiButton != this.Field159) {
              for (GuiComponent class7 : guiButton.Method131()) {
                if (class7 instanceof KeyBindComponent)
                  ((KeyBindComponent)class7).Field158 = false;
              } 
              guiButton.Field113.Method180(false);
            } 
          } 
        }  
    } 
  }
  
  public static boolean Method197(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (paramDouble1 > paramInt1 && paramDouble2 > paramInt2 && paramDouble1 < paramInt3 && paramDouble2 < paramInt4);
  }
  
  private void Method198() {
    Thread.sleep(50L);
    this.Field160.Method180(false);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class11.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

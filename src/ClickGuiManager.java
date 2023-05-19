//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import com.mojang.blaze3d.matrix.MatrixStack;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class ClickGuiManager extends Screen {
  private static int Field162;
  
  public static List<GuiFrame> Field163 = new ArrayList();
  
  public static int Method202() {
    return Field162;
  }
  
  public static void Method203(int paramInt) {
    Field162 += paramInt;
  }
  
  public ClickGuiManager() {
    super((ITextComponent)new StringTextComponent(""));
    byte b = 20;
    for (Category category : Category.values()) {
      Field163.add(new GuiFrame(b, 30, 100, 5, category));
      b += 115;
    } 
  }
  
  @ParametersAreNonnullByDefault
  public void render(MatrixStack paramMatrixStack, int paramInt1, int paramInt2, float paramFloat) {
    fill(paramMatrixStack, 0, 0, Minecraft.getInstance().getMainWindow().getScaledWidth(), Minecraft.getInstance().getMainWindow().getScaledHeight(), (new Color(1509949440, true)).getRGB());
    for (GuiFrame guiFrame : Field163)
      guiFrame.Method65(paramMatrixStack, paramInt1, paramInt2, paramFloat);
    super.render(paramMatrixStack, paramInt1, paramInt2, paramFloat);
  }
  
  public boolean keyPressed(int paramInt1, int paramInt2, int paramInt3) {
    for (GuiFrame guiFrame : Field163)
      guiFrame.Method66(paramInt1);
    return super.keyPressed(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean mouseClicked(double paramDouble1, double paramDouble2, int paramInt) {
    for (GuiFrame guiFrame : Field163)
      guiFrame.Method67(paramDouble1, paramDouble2, paramInt);
    return super.mouseClicked(paramDouble1, paramDouble2, paramInt);
  }
  
  public boolean mouseReleased(double paramDouble1, double paramDouble2, int paramInt) {
    for (GuiFrame guiFrame : Field163)
      guiFrame.Method68(paramDouble1, paramDouble2, paramInt);
    return super.mouseReleased(paramDouble1, paramDouble2, paramInt);
  }
  
  public boolean isPauseScreen() {
    return false;
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class13.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

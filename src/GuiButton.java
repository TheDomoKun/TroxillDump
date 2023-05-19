//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import com.mojang.blaze3d.matrix.MatrixStack;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;

public class GuiButton {
  public Minecraft Field107 = Minecraft.getInstance();
  
  private final ArrayList Field108 = new ArrayList();
  
  public int Field109;
  
  public int Field110;
  
  public int Field111;
  
  public int Field112;
  
  public Module Field113;
  
  private final GuiFrame Field114;
  
  private boolean Field115;
  
  private int Field116 = 0;
  
  public GuiButton(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Module paramModule, GuiFrame paramGuiFrame) {
    this.Field109 = paramInt1;
    this.Field110 = paramInt2;
    this.Field111 = paramInt3;
    this.Field112 = paramInt4;
    this.Field113 = paramModule;
    this.Field114 = paramGuiFrame;
    boolean bool = false;
    for (Setting setting : SettingsStringManager.Method206(paramModule)) {
      if (setting.Method87()) {
        this.Field108.add(new GuiSliderComponent(setting, this, bool, 20));
        bool += true;
      } 
      if (setting.Method86()) {
        this.Field108.add(new GuiButtonComponent(setting, this, bool, 20));
        bool += true;
      } 
    } 
    this.Field108.add(new KeyBindComponent(this, bool, 12));
  }
  
  public boolean Method129() {
    return this.Field115;
  }
  
  public GuiFrame Method130() {
    return this.Field114;
  }
  
  public List Method131() {
    return this.Field108;
  }
  
  public void Method132(MatrixStack paramMatrixStack, int paramInt1, int paramInt2, float paramFloat) {
    boolean bool = Method139(paramInt1, paramInt2, this.Field109, this.Field110 + this.Field116 + ClickGuiManager.Method202(), this.Field109 + this.Field111, this.Field110 + this.Field112 + this.Field116 + ClickGuiManager.Method202());
    Color color = bool ? new Color(-666483130, true) : new Color(-667996369, true);
    if (this.Field115) {
      ClickGuiManager.fill(paramMatrixStack, this.Field109, this.Field110 + this.Field116 + ClickGuiManager.Method202(), this.Field109 + this.Field111, this.Field110 + this.Field112 + this.Field116 + ClickGuiManager.Method202(), color.getRGB());
    } else {
      ClickGuiManager.fill(paramMatrixStack, this.Field109, this.Field110 + this.Field116 + ClickGuiManager.Method202(), this.Field109 + this.Field111, this.Field110 + this.Field112 + this.Field116 + ClickGuiManager.Method202(), color.getRGB());
    } 
    int i = 0;
    for (char c : ModuleManager.getModuleNameByID(this.Field113.Method182())) {
      this.Field107.fontRenderer.drawStringWithShadow(paramMatrixStack, c + "", (this.Field109 + 5 + i), this.Field110 + this.Field112 / 2.0F - 4.0F + this.Field116 + ClickGuiManager.Method202(), this.Field113.isToggled() ? RainbowUtil.Method62(100 * this.Field113.Method182(), 1.0F, 1.0F).getRGB() : -1);
      i += this.Field107.fontRenderer.getStringWidth(c + "") + 1;
    } 
    if (!this.Field108.isEmpty()) {
      if (this.Field108.size() > 1)
        this.Field107.fontRenderer.drawStringWithShadow(paramMatrixStack, "...", (this.Field109 + this.Field111 - 8), this.Field110 + this.Field112 / 2.0F - 5.0F + this.Field116 + ClickGuiManager.Method202(), -1);
      if (this.Field115)
        for (GuiComponent class7 : this.Field108) {
          class7.Method141(paramInt1, paramInt2);
          class7.Method140();
        }  
    } 
  }
  
  protected void Method133(int paramInt) {
    if (!this.Field108.isEmpty() && this.Field115)
      for (GuiComponent class7 : this.Field108)
        class7.Method144(paramInt);  
  }
  
  public void Method134(int paramInt) {
    this.Field116 += paramInt;
  }
  
  public void Method135(int paramInt) {
    this.Field116 -= paramInt;
  }
  
  private void Method136() {
    boolean bool = false;
    int i = 0;
    if (this.Field115) {
      for (GuiComponent class7 : this.Field108)
        i += class7.Method147(); 
      for (GuiButton guiButton : this.Field114.Field45) {
        if (bool) {
          guiButton.Method134(i);
          for (GuiComponent class7 : guiButton.Field108)
            class7.Method145(i); 
          continue;
        } 
        bool = (guiButton == this) ? true : false;
      } 
    } else {
      for (GuiComponent class7 : this.Field108)
        i += class7.Method147(); 
      for (GuiButton guiButton : this.Field114.Field45) {
        if (bool) {
          guiButton.Method135(i);
          for (GuiComponent class7 : guiButton.Field108)
            class7.Method146(i); 
          continue;
        } 
        bool = (guiButton == this) ? true : false;
      } 
    } 
  }
  
  public void Method137(double paramDouble1, double paramDouble2, int paramInt) {
    if (Method139(paramDouble1, paramDouble2, this.Field109, this.Field110 + this.Field116 + ClickGuiManager.Method202(), this.Field109 + this.Field111, this.Field110 + this.Field112 + this.Field116 + ClickGuiManager.Method202())) {
      if (paramInt == 1) {
        this.Field115 = !this.Field115;
        Method136();
      } 
      if (paramInt == 0)
        this.Field113.Method191(); 
    } 
    if (!this.Field108.isEmpty() && this.Field115)
      for (GuiComponent class7 : this.Field108)
        class7.Method142((int)paramDouble1, (int)paramDouble2, paramInt);  
  }
  
  public void Method138(double paramDouble1, double paramDouble2, int paramInt) {
    if (this.Field115 && !this.Field108.isEmpty())
      for (GuiComponent class7 : this.Field108)
        class7.Method143((int)paramDouble1, (int)paramDouble2, paramInt);  
  }
  
  public static boolean Method139(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (paramDouble1 > paramInt1 && paramDouble2 > paramInt2 && paramDouble1 < paramInt3 && paramDouble2 < paramInt4);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class6.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import com.mojang.blaze3d.matrix.MatrixStack;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;

public class GuiFrame {
  public Minecraft Field33 = Minecraft.getInstance();
  
  private int Field34;
  
  public int Field35;
  
  public int Field36;
  
  public int Field37;
  
  public int Field38;
  
  public int Field39;
  
  public int Field40;
  
  public boolean Field41;
  
  public boolean Field42;
  
  public Category Field43;
  
  private int Field44 = 35;
  
  public List Field45 = new ArrayList();
  
  public int Method63() {
    return this.Field34;
  }
  
  public void Method64(int paramInt) {
    this.Field34 = paramInt;
  }
  
  public GuiFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Category paramCategory) {
    this.Field39 = paramInt1;
    this.Field40 = paramInt2;
    this.Field35 = paramInt3;
    this.Field36 = paramInt4;
    this.Field43 = paramCategory;
    int i = paramInt2 + paramInt4 + 10;
    for (Module module : ModuleManager.getModules()) {
      if (module.Method183() == paramCategory) {
        this.Field45.add(new GuiButton(paramInt1, i, paramInt3, paramInt4 + 10, module, this));
        i += paramInt4;
      } 
    } 
  }
  
  public void Method65(MatrixStack paramMatrixStack, int paramInt1, int paramInt2, float paramFloat) {
    if (this.Field42) {
      this.Field39 = paramInt1 - this.Field38;
      this.Field40 = paramInt2 - this.Field37;
    } 
    RenderUtils.Method12(paramMatrixStack, this.Field39, this.Field40 + ClickGuiManager.Method202(), this.Field39 + this.Field35, this.Field40 + this.Field36 + ClickGuiManager.Method202(), 5, new Color(3342336));
    this.Field33.fontRenderer.drawStringWithShadow(paramMatrixStack, this.Field43.name(), this.Field39 + this.Field35 / 2.0F - this.Field33.fontRenderer.getStringWidth(this.Field43.name()) / 2.0F, this.Field40 + this.Field36 / 2.0F - 4.5F + ClickGuiManager.Method202(), -1);
    ClickGuiManager.fill(paramMatrixStack, this.Field39 + 15 + this.Field44, this.Field40 + 8 + ClickGuiManager.Method202(), this.Field39 + this.Field35 - 15 - this.Field44, this.Field40 + 9 + ClickGuiManager.Method202(), RainbowUtil.Method62(10, 1.0F, 1.0F).getRGB());
    if (this.Field41) {
      int i = this.Field40 + this.Field36;
      for (GuiButton guiButton : this.Field45) {
        guiButton.Field109 = this.Field39;
        guiButton.Field110 = i + 5;
        i += this.Field36 + 10;
        guiButton.Method132(paramMatrixStack, paramInt1, paramInt2, paramFloat);
      } 
    } 
  }
  
  public void Method66(int paramInt) {
    if (this.Field41)
      for (GuiButton guiButton : this.Field45)
        guiButton.Method133(paramInt);
  }
  
  public void Method67(double paramDouble1, double paramDouble2, int paramInt) {
    if (Method69(paramDouble1, paramDouble2, this.Field39 - 5, this.Field40 - 5 + ClickGuiManager.Method202(), this.Field39 + this.Field35 + 5, this.Field40 + this.Field36 + 5 + ClickGuiManager.Method202())) {
      boolean bool = false;
      GuiFrame guiFrame = null;
      for (GuiFrame class81 : ClickGuiManager.Field163) {
        if (!class81.equals(this) && Method69(paramDouble1, paramDouble2, class81.Field39 - 5, class81.Field40 - 5 + ClickGuiManager.Method202(), class81.Field39 + class81.Field35 + 5, class81.Field40 + class81.Field36 + 5 + ClickGuiManager.Method202())) {
          guiFrame = class81;
          break;
        } 
      } 
      if (guiFrame != null) {
        if (this.Field34 > guiFrame.Method63())
          bool = true; 
      } else {
        bool = true;
      } 
      if (bool)
        if (paramInt == 0) {
          for (GuiFrame class81 : ClickGuiManager.Field163) {
            if (class81.equals(this)) {
              ArrayList<GuiFrame> arrayList = new ArrayList();
              GuiFrame class82 = this;
              Method64(ClickGuiManager.Field163.size() - 1);
              byte b = 0;
              for (GuiFrame class83 : ClickGuiManager.Field163) {
                if (!class83.equals(this)) {
                  class83.Method64(b);
                  arrayList.add(class83);
                  b++;
                } 
              } 
              arrayList.add(class82);
              ClickGuiManager.Field163 = arrayList;
              break;
            } 
          } 
          this.Field38 = (int)(paramDouble1 - this.Field39);
          this.Field37 = (int)(paramDouble2 - this.Field40);
          this.Field42 = true;
        } else if (paramInt == 1) {
          this.Field41 = !this.Field41;
          if (this.Field41) {
            Method70();
          } else {
            Method71();
          } 
        }  
    } 
    if (this.Field41)
      for (GuiButton guiButton : this.Field45)
        guiButton.Method137(paramDouble1, paramDouble2, paramInt);
  }
  
  public void Method68(double paramDouble1, double paramDouble2, int paramInt) {
    this.Field42 = false;
    if (this.Field41)
      for (GuiButton guiButton : this.Field45)
        guiButton.Method138(paramDouble1, paramDouble2, paramInt);
  }
  
  public static boolean Method69(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (paramDouble1 > paramInt1 && paramDouble2 > paramInt2 && paramDouble1 < paramInt3 && paramDouble2 < paramInt4);
  }
  
  public void Method70() {
    (new Thread(this::Method73)).start();
  }
  
  public void Method71() {
    (new Thread(this::Method72)).start();
  }
  
  private void Method72() {
    for (byte b = 0; b < 35; b++) {
      if (this.Field44 < 35)
        this.Field44++; 
      Thread.sleep(2L);
    } 
  }
  
  private void Method73() {
    for (byte b = 0; b < 35; b++) {
      if (this.Field44 > 0)
        this.Field44--; 
      Thread.sleep(2L);
    } 
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class8.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import net.minecraft.client.Minecraft;

public class SelfDestruct extends Module {
  public static boolean Field181;
  
  public SelfDestruct() {
    super(Category.Ghost, 4);
  }
  
  public void Method58() {
    for (Module module : ModuleManager.getModules()) {
      if (module.isToggled())
        module.Method191();
    } 
    Class15.Method209();
    Minecraft.getInstance().displayGuiScreen(null);
    Field181 = true;
    super.Method58();
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class54.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

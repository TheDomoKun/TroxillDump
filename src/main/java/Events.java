//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.profiler.IProfileResult;
import net.minecraft.profiler.IResultableProfiler;

public class Events implements IResultableProfiler {
  public static IResultableProfiler Field90 = new Events();
  
  private final Minecraft Field91 = Minecraft.getInstance();
  
  public void startTick() {}
  
  public void endTick() {}
  
  public void startSection(String paramString) {
    if (!SelfDestruct.Field181) {
      if (paramString.contains("tick")) {
        Startupper.Method54().Method121();
        if (this.Field91.player != null)
          Startupper.Method55().Method172();
      } 
      if (paramString.contains("bossHealth"))
        Startupper.Method56().OnRenderBossbar();
    } 
  }
  
  public void startSection(Supplier paramSupplier) {}
  
  public void endSection() {}
  
  public void HandRenderEvent(String paramString) {
    if (!SelfDestruct.Field181 && paramString.contains("hand"))
      Startupper.Method57().HandRenderEvent();
  }
  
  public void endStartSection(Supplier paramSupplier) {}
  
  public void func_230035_c_(String paramString) {}
  
  public void func_230036_c_(Supplier paramSupplier) {}
  
  public IProfileResult getResults() {
    return null;
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class35.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

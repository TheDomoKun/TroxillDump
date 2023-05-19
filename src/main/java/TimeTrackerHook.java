//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import net.minecraft.profiler.EmptyProfiler;
import net.minecraft.profiler.IProfileResult;
import net.minecraft.profiler.IProfiler;
import net.minecraft.profiler.IResultableProfiler;
import net.minecraft.profiler.TimeTracker;

public class TimeTrackerHook extends TimeTracker {
  private final LongSupplier Field87;
  
  private final IntSupplier Field88;
  
  private IResultableProfiler Field89 = (IResultableProfiler)EmptyProfiler.INSTANCE;
  
  public TimeTrackerHook(LongSupplier paramLongSupplier, IntSupplier paramIntSupplier) {
    super(paramLongSupplier, paramIntSupplier);
    this.Field87 = paramLongSupplier;
    this.Field88 = paramIntSupplier;
  }
  
  public boolean func_233505_a_() {
    return (this.Field89 != Events.Field90);
  }
  
  public void func_233506_b_() {
    this.Field89 = Events.Field90;
  }
  
  public void func_233507_c_() {
    this.Field89 = new Events();
  }
  
  public IProfiler func_233508_d_() {
    return (IProfiler)this.Field89;
  }
  
  public IProfileResult func_233509_e_() {
    return this.Field89.getResults();
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class36.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

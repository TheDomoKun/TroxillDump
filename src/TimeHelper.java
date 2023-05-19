public class TimeHelper {
  public static float Field4;
  static long a,b;
  
  public static long Method21() {
    return System.currentTimeMillis();
  }
  
  public boolean Method22(float paramFloat) {

    return ((float)(Method21() - a) >= paramFloat);
  }
  
  public long Method23() {
    return System.nanoTime() / 1000000L;
  }
  
  public boolean Method24(long paramLong, boolean paramBoolean) {
    if (System.currentTimeMillis() - this.b > paramLong) {
      if (paramBoolean)
        Method30(); 
      return true;
    } 
    return false;
  }
  
  public long Method25() {
    return Method33() - this.a;
  }
  
  public void Method26(long paramLong) {
    this.a = Method33() - paramLong;
  }
  
  public boolean Method27(double paramDouble) {
    return ((Method23() - this.b) >= paramDouble);
  }
  
  public boolean Method28(float paramFloat) {
    return ((float)this.a >= paramFloat);
  }
  
  public void Method29() {

    a = Method21();
  }
  
  public void Method30() {
    this.b = Method23();
  }
  
  public boolean Method31(float paramFloat) {
    return ((float)(Method33() - this.a) >= paramFloat);
  }
  
  public void Method32(long paramLong) {
    this.b = paramLong;
  }
  
  public long Method33() {
    return Method23() - this.b;
  }
  
  static {
    a = -1L;
    Field4 = 1.0F;
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class24.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
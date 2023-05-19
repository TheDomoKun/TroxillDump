import java.util.ArrayList;

public class Setting {
  private final Module Field46;
  
  private final String Field47;
  
  private final int Field48;
  
  private String Field49;
  
  private ArrayList Field50;
  
  private boolean Field51;
  
  private double Field52;
  
  private double Field53;
  
  private double Field54;
  
  private boolean Field55 = false;
  
  private int Field56;
  
  public Setting(int paramInt, Module paramModule, boolean paramBoolean) {
    this.Field48 = paramInt;
    this.Field46 = paramModule;
    this.Field51 = paramBoolean;
    this.Field47 = "b";
  }
  
  public Setting(int paramInt, Module paramModule, double paramDouble1, double paramDouble2, double paramDouble3, boolean paramBoolean) {
    this.Field48 = paramInt;
    this.Field46 = paramModule;
    this.Field52 = paramDouble1;
    this.Field53 = paramDouble2;
    this.Field54 = paramDouble3;
    this.Field55 = paramBoolean;
    this.Field47 = "s";
  }
  
  public int Method74() {
    return this.Field48;
  }
  
  public Module Method75() {
    return this.Field46;
  }
  
  public String Method76() {
    return this.Field49;
  }
  
  public void Method77(String paramString) {
    this.Field49 = paramString;
  }
  
  public ArrayList Method78() {
    return this.Field50;
  }
  
  public boolean Method79() {
    return this.Field51;
  }
  
  public void Method80(boolean paramBoolean) {
    this.Field51 = paramBoolean;
  }
  
  public double Method81() {
    if (this.Field55)
      this.Field52 = (int)this.Field52; 
    return this.Field52;
  }
  
  public void Method82(double paramDouble) {
    this.Field52 = paramDouble;
  }
  
  public double Method83() {
    return this.Field53;
  }
  
  public double Method84() {
    return this.Field54;
  }
  
  public int Method85() {
    return this.Field56;
  }
  
  public boolean Method86() {
    return this.Field47.equalsIgnoreCase("b");
  }
  
  public boolean Method87() {
    return this.Field47.equalsIgnoreCase("s");
  }
  
  public boolean Method88() {
    return this.Field55;
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class9.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
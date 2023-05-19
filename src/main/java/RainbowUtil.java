import java.awt.Color;

public class RainbowUtil {
  public static Color Method62(int paramInt, float paramFloat1, float paramFloat2) {
    double d = Math.ceil(((System.currentTimeMillis() + paramInt) / 16L));
    d %= 360.0D;
    return Color.getHSBColor((float)(d / 360.0D), paramFloat1, paramFloat2);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class20.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
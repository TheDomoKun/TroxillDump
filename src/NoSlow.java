public class NoSlow extends Module {
  public NoSlow() {
    super(Category.Movement, 17);
    SettingsStringManager.registerSetting(new Setting(1, this, 3.5D, 0.1D, 5.0D, false));
    SettingsStringManager.registerSetting(new Setting(2, this, false));
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class63.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
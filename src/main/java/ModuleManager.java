//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;

public class ModuleManager {
  private static final ArrayList<Module> modules = new ArrayList<Module>();
  
  public static char[] getModuleNameByID(int paramInt) {
    return (paramInt == 1) ? new char[] { 'H', 'i', 't', 'B', 'o', 'x' } : ((paramInt == 2) ? new char[] { 'S', 'p', 'r', 'i', 'n', 't' } : ((paramInt == 3) ? new char[] { 
        'N', 'o', 'J', 'u', 'm', 'p', 'D', 'e', 'l', 'a', 
        'y' } : ((paramInt == 4) ? new char[] { 
        'S', 'e', 'l', 'f', 'D', 'e', 's', 't', 'r', 'u', 
        'c', 't' } : ((paramInt == 5) ? new char[] { 
        'S', 'h', 'i', 'e', 'l', 'd', 'A', 't', 't', 'a', 
        'c', 'k' } : ((paramInt == 6) ? new char[] { 'M', 'C', 'P' } : ((paramInt == 7) ? new char[] { 'V', 'e', 'l', 'o', 'c', 'i', 't', 'y' } : ((paramInt == 8) ? new char[] { 
        'N', 'o', 'B', 'r', 'e', 'a', 'k', 'D', 'e', 'l', 
        'a', 'y' } : ((paramInt == 9) ? new char[] { 'F', 'u', 'l', 'l', 'B', 'r', 'i', 'g', 'h', 't' } : ((paramInt == 10) ? new char[] { 
        'I', 't', 'e', 'm', 'S', 'c', 'r', 'o', 'l', 'l', 
        'e', 'r' } : ((paramInt == 11) ? new char[] { 'A', 'n', 't', 'i', 'A', 'F', 'K' } : ((paramInt == 12) ? new char[] { 'G', 'l', 'o', 'w', 'E', 's', 'p' } : ((paramInt == 13) ? new char[] { 'N', 'o', 'R', 'a', 'i', 'n' } : ((paramInt == 14) ? new char[] { 'N', 'o', 'P', 'u', 's', 'h' } : ((paramInt == 15) ? new char[] { 
        'N', 'o', 'B', 'a', 'd', 'E', 'f', 'f', 'e', 'c', 
        't', 's' } : ((paramInt == 16) ? new char[] { 'N', 'o', 'H', 'u', 'r', 't', 'C', 'a', 'm' } : ((paramInt == 17) ? new char[] { 'N', 'o', 'S', 'l', 'o', 'w' } : ((paramInt == 18) ? new char[] { 'T', 'r', 'i', 'g', 'g', 'e', 'r', 'B', 'o', 't' } : ((paramInt == 19) ? new char[] { 'E', 'l', 'y', 't', 'r', 'a', 'S', 'w', 'a', 'p' } : ((paramInt == 20) ? new char[] { 'I', 't', 'e', 'm', 'E', 'S', 'P' } : ((paramInt == 21) ? new char[] { 'F', 'a', 's', 't', 'U', 's', 'e' } : ((paramInt == 22) ? new char[] { 
        'P', 'l', 'a', 'y', 'e', 'r', 'L', 'e', 'a', 'v', 
        'e' } : ((paramInt == 23) ? new char[] { 
        'A', 'u', 't', 'o', 'S', 'h', 'i', 'f', 't', 'T', 
        'a', 'p' } : ((paramInt == 24) ? new char[] { 
        'C', 'h', 'e', 's', 't', 'S', 't', 'e', 'a', 'l', 
        'e', 'r' } : ((paramInt == 25) ? new char[] { 'I', 'n', 'v', 'W', 'a', 'l', 'k' } : ((paramInt == 26) ? new char[] { 'F', 'r', 'e', 'e', 'C', 'a', 'm' } : ((paramInt == 27) ? new char[] { 
        'S', 'h', 'i', 'e', 'l', 'd', 'B', 'r', 'e', 'a', 
        'k', 'e', 'r' } : ((paramInt == 28) ? new char[] { 
        'A', 'u', 't', 'o', 'E', 'x', 'p', 'l', 'o', 's', 
        'i', 'o', 'n' } : ((paramInt == 29) ? new char[] { 'A', 'i', 'm', 'A', 's', 's', 'i', 's', 't' } : ((paramInt == 30) ? new char[] { 'X', 'C', 'a', 'r', 'r', 'y' } : new char[0])))))))))))))))))))))))))))));
  }
  
  public ModuleManager() {
    modules.add(new HitBox());
    modules.add(new Sprint());
    modules.add(new NoJumpDelay());
    modules.add(new SelfDestruct());
    modules.add(new Velocity());
    modules.add(new NoBreakDelay());
    modules.add(new MiddleClickPearl());
    modules.add(new FullBright());
    modules.add(new ShieldAttack());
    modules.add(new ItemScroller());
    modules.add(new GlowESP());
    modules.add(new NoRain());
    modules.add(new NoPush());
    modules.add(new NoBadEfects());
    modules.add(new NoHurtCam());
    modules.add(new NoSlow());
    modules.add(new FastPlace());
    modules.add(new TriggerBot());
    modules.add(new ElytraSwap());
    modules.add(new ItemEsp());
    modules.add(new AntiAFK());
    modules.add(new PlayerLeave());
    modules.add(new AutoShiftTap());
    modules.add(new ChestStealer());
    modules.add(new InvWalk());
    modules.add(new Freecam());
    modules.add(new ShieldBreaker());
    modules.add(new AutoExplosion());
    modules.add(new AimAssist());
    modules.add(new XCarry());
  }
  
  public boolean Method37(Object paramObject, PacketDirection paramPacketDirection) {
    boolean bool = true;
    for (Module Module : modules) {
      if (!Module.isToggled() || (Minecraft.getInstance()).world == null)
        continue; 
      bool &= Module.Method16(paramObject, paramPacketDirection);
    } 
    return !bool;
  }
  
  public static List getEnabled() {
    ArrayList<Module> arrayList = new ArrayList();
    for (Module m : modules) {
      if (m.isToggled())
        arrayList.add(m);
    } 
    arrayList.sort(ModuleManager::Method48);
    return arrayList;
  }
  
  public static Module Method39(int paramInt) {
    for (Module Module : modules) {
      if (Module.Method182() == paramInt)
        return Module; 
    } 
    return null;
  }
  
  public static void Method40(Module paramModule) {
    modules.add(paramModule);
  }
  
  public static ArrayList<Module> getModules() {
    return modules;
  }
  
  public static void onPlayerTick(PlayerTickEvent paramPlayerTickEvent) {
    for (Module Module : modules) {
      if (Module.isToggled())
        Module.OnPlayerTick(paramPlayerTickEvent);
    } 
  }
  
  public static void onHandRender(HandRenderEvent paramHandRenderEvent) {
    for (Module Module : modules) {
      if (Module.isToggled())
        Module.onHandRenderEvent(paramHandRenderEvent);
    } 
  }
  
  public static void onBossbarRebder(RenderBossbarEvent paramRenderBossbarEvent) {
    for (Module Module : modules) {
      if (Module.isToggled())
        Module.onRenderBossbar(paramRenderBossbarEvent);
    } 
  }
  
  public static void onKeyboard(KeyboardEvent paramKeyboardEvent) {
    int i = paramKeyboardEvent.getKey();
    for (Module Module : modules) {
      if (Module.isToggled())
        Module.Method190(paramKeyboardEvent);
      if (((Minecraft.getInstance()).currentScreen == null || (Minecraft.getInstance()).currentScreen == KeyboardEvent.Field101) && i != 0 && i == Module.Method181() && !Module.Method179() && paramKeyboardEvent.Method125() == 1)
        Module.Method191(); 
    } 
  }
  
  public static void onInput(InputEventHOok paramInputEventHOok) {
    for (Module Module : modules) {
      if (Module.isToggled())
        Module.onInput(paramInputEventHOok);
    } 
  }
  
  public static void onAttackENtity(CustomPlayerEvent paramCustomPlayerEvent) {
    for (Module Module : modules) {
      if (Module.isToggled())
        Module.onAttack(paramCustomPlayerEvent);
    } 
  }
  
  private static int Method48(Module paramModule1, Module paramModule2) {
    int i = 0;
    Integer integer = Integer.valueOf(0);
    for (char c : getModuleNameByID(paramModule1.Method182()))
      i += (Minecraft.getInstance()).fontRenderer.getStringWidth(c + "") + 1; 
    for (char c : getModuleNameByID(paramModule2.Method182()))
      integer = Integer.valueOf(integer.intValue() + (Minecraft.getInstance()).fontRenderer.getStringWidth(c + "") + 1); 
    int j = integer.intValue() - i;
    return (j != 0) ? j : integer.compareTo(Integer.valueOf(i));
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class26.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

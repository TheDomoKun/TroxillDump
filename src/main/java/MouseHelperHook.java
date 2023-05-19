//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHelper;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraft.client.util.MouseSmoother;
import net.minecraft.client.util.NativeUtil;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

@OnlyIn(Dist.CLIENT)
public class MouseHelperHook extends MouseHelper {
  private final Minecraft Field69;
  
  private boolean Field70;
  
  private boolean Field71;
  
  private boolean Field72;
  
  private double Field73;
  
  private double Field74;
  
  private int Field75;
  
  private int Field76 = -1;
  
  private boolean Field77 = true;
  
  private int Field78;
  
  private double Field79;
  
  private final MouseSmoother Field80 = new MouseSmoother();
  
  private final MouseSmoother Field81 = new MouseSmoother();
  
  private double Field82;
  
  private double Field83;
  
  private double Field84;
  
  private double Field85 = Double.MIN_VALUE;
  
  private boolean Field86;
  
  public MouseHelperHook(Minecraft paramMinecraft) {
    super(paramMinecraft);
    this.Field69 = paramMinecraft;
  }
  
  private void Method101(long paramLong, int paramInt1, int paramInt2, int paramInt3) {
    // Byte code:
    //   0: lload_1
    //   1: aload_0
    //   2: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   5: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   8: invokevirtual getHandle : ()J
    //   11: lcmp
    //   12: ifne -> 536
    //   15: iload #4
    //   17: iconst_1
    //   18: if_icmpne -> 25
    //   21: iconst_1
    //   22: goto -> 26
    //   25: iconst_0
    //   26: istore #6
    //   28: getstatic net/minecraft/client/Minecraft.IS_RUNNING_ON_MAC : Z
    //   31: ifeq -> 85
    //   34: iload_3
    //   35: ifne -> 85
    //   38: iload #6
    //   40: ifeq -> 66
    //   43: iload #5
    //   45: iconst_2
    //   46: iand
    //   47: iconst_2
    //   48: if_icmpne -> 85
    //   51: iconst_1
    //   52: istore_3
    //   53: aload_0
    //   54: dup
    //   55: getfield Field75 : I
    //   58: iconst_1
    //   59: iadd
    //   60: putfield Field75 : I
    //   63: goto -> 85
    //   66: aload_0
    //   67: getfield Field75 : I
    //   70: ifle -> 85
    //   73: iconst_1
    //   74: istore_3
    //   75: aload_0
    //   76: dup
    //   77: getfield Field75 : I
    //   80: iconst_1
    //   81: isub
    //   82: putfield Field75 : I
    //   85: iload_3
    //   86: istore #7
    //   88: iload #6
    //   90: ifeq -> 137
    //   93: aload_0
    //   94: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   97: getfield gameSettings : Lnet/minecraft/client/GameSettings;
    //   100: getfield touchscreen : Z
    //   103: ifeq -> 121
    //   106: aload_0
    //   107: dup
    //   108: getfield Field78 : I
    //   111: dup_x1
    //   112: iconst_1
    //   113: iadd
    //   114: putfield Field78 : I
    //   117: ifle -> 121
    //   120: return
    //   121: aload_0
    //   122: iload #7
    //   124: putfield Field76 : I
    //   127: aload_0
    //   128: invokestatic getTime : ()D
    //   131: putfield Field79 : D
    //   134: goto -> 178
    //   137: aload_0
    //   138: getfield Field76 : I
    //   141: iconst_m1
    //   142: if_icmpeq -> 178
    //   145: aload_0
    //   146: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   149: getfield gameSettings : Lnet/minecraft/client/GameSettings;
    //   152: getfield touchscreen : Z
    //   155: ifeq -> 173
    //   158: aload_0
    //   159: dup
    //   160: getfield Field78 : I
    //   163: iconst_1
    //   164: isub
    //   165: dup_x1
    //   166: putfield Field78 : I
    //   169: ifle -> 173
    //   172: return
    //   173: aload_0
    //   174: iconst_m1
    //   175: putfield Field76 : I
    //   178: iload_3
    //   179: iload #4
    //   181: iload #5
    //   183: invokestatic onRawMouseClicked : (III)Z
    //   186: ifeq -> 190
    //   189: return
    //   190: iconst_1
    //   191: newarray boolean
    //   193: dup
    //   194: iconst_0
    //   195: iconst_0
    //   196: bastore
    //   197: astore #8
    //   199: aload_0
    //   200: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   203: getfield loadingGui : Lnet/minecraft/client/gui/LoadingGui;
    //   206: ifnonnull -> 370
    //   209: aload_0
    //   210: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   213: getfield currentScreen : Lnet/minecraft/client/gui/screen/Screen;
    //   216: ifnonnull -> 238
    //   219: aload_0
    //   220: getfield Field86 : Z
    //   223: ifne -> 370
    //   226: iload #6
    //   228: ifeq -> 370
    //   231: aload_0
    //   232: invokevirtual grabMouse : ()V
    //   235: goto -> 370
    //   238: aload_0
    //   239: getfield Field73 : D
    //   242: aload_0
    //   243: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   246: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   249: invokevirtual getScaledWidth : ()I
    //   252: i2d
    //   253: dmul
    //   254: aload_0
    //   255: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   258: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   261: invokevirtual getWidth : ()I
    //   264: i2d
    //   265: ddiv
    //   266: dstore #9
    //   268: aload_0
    //   269: getfield Field74 : D
    //   272: aload_0
    //   273: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   276: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   279: invokevirtual getScaledHeight : ()I
    //   282: i2d
    //   283: dmul
    //   284: aload_0
    //   285: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   288: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   291: invokevirtual getHeight : ()I
    //   294: i2d
    //   295: ddiv
    //   296: dstore #11
    //   298: iload #6
    //   300: ifeq -> 338
    //   303: aload_0
    //   304: aload #8
    //   306: dload #9
    //   308: dload #11
    //   310: iload #7
    //   312: <illegal opcode> run : (LClass33;[ZDDI)Ljava/lang/Runnable;
    //   317: ldc 'mouseClicked event handler'
    //   319: aload_0
    //   320: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   323: getfield currentScreen : Lnet/minecraft/client/gui/screen/Screen;
    //   326: invokevirtual getClass : ()Ljava/lang/Class;
    //   329: invokevirtual getCanonicalName : ()Ljava/lang/String;
    //   332: invokestatic wrapScreenError : (Ljava/lang/Runnable;Ljava/lang/String;Ljava/lang/String;)V
    //   335: goto -> 370
    //   338: aload_0
    //   339: aload #8
    //   341: dload #9
    //   343: dload #11
    //   345: iload #7
    //   347: <illegal opcode> run : (LClass33;[ZDDI)Ljava/lang/Runnable;
    //   352: ldc 'mouseReleased event handler'
    //   354: aload_0
    //   355: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   358: getfield currentScreen : Lnet/minecraft/client/gui/screen/Screen;
    //   361: invokevirtual getClass : ()Ljava/lang/Class;
    //   364: invokevirtual getCanonicalName : ()Ljava/lang/String;
    //   367: invokestatic wrapScreenError : (Ljava/lang/Runnable;Ljava/lang/String;Ljava/lang/String;)V
    //   370: aload #8
    //   372: iconst_0
    //   373: baload
    //   374: ifne -> 515
    //   377: aload_0
    //   378: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   381: getfield currentScreen : Lnet/minecraft/client/gui/screen/Screen;
    //   384: ifnull -> 400
    //   387: aload_0
    //   388: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   391: getfield currentScreen : Lnet/minecraft/client/gui/screen/Screen;
    //   394: getfield passEvents : Z
    //   397: ifeq -> 515
    //   400: aload_0
    //   401: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   404: getfield loadingGui : Lnet/minecraft/client/gui/LoadingGui;
    //   407: ifnonnull -> 515
    //   410: iload #7
    //   412: ifne -> 424
    //   415: aload_0
    //   416: iload #6
    //   418: putfield Field70 : Z
    //   421: goto -> 451
    //   424: iload #7
    //   426: iconst_2
    //   427: if_icmpne -> 439
    //   430: aload_0
    //   431: iload #6
    //   433: putfield Field71 : Z
    //   436: goto -> 451
    //   439: iload #7
    //   441: iconst_1
    //   442: if_icmpne -> 451
    //   445: aload_0
    //   446: iload #6
    //   448: putfield Field72 : Z
    //   451: getstatic net/minecraft/client/util/InputMappings$Type.MOUSE : Lnet/minecraft/client/util/InputMappings$Type;
    //   454: iload #7
    //   456: invokevirtual getOrMakeInput : (I)Lnet/minecraft/client/util/InputMappings$Input;
    //   459: iload #6
    //   461: invokestatic setKeyBindState : (Lnet/minecraft/client/util/InputMappings$Input;Z)V
    //   464: iload #6
    //   466: ifeq -> 515
    //   469: aload_0
    //   470: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   473: getfield player : Lnet/minecraft/client/entity/player/ClientPlayerEntity;
    //   476: invokevirtual isSpectator : ()Z
    //   479: ifeq -> 504
    //   482: iload #7
    //   484: iconst_2
    //   485: if_icmpne -> 504
    //   488: aload_0
    //   489: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   492: getfield ingameGUI : Lnet/minecraft/client/gui/IngameGui;
    //   495: invokevirtual getSpectatorGui : ()Lnet/minecraft/client/gui/SpectatorGui;
    //   498: invokevirtual onMiddleClick : ()V
    //   501: goto -> 515
    //   504: getstatic net/minecraft/client/util/InputMappings$Type.MOUSE : Lnet/minecraft/client/util/InputMappings$Type;
    //   507: iload #7
    //   509: invokevirtual getOrMakeInput : (I)Lnet/minecraft/client/util/InputMappings$Input;
    //   512: invokestatic onTick : (Lnet/minecraft/client/util/InputMappings$Input;)V
    //   515: iload_3
    //   516: iload #4
    //   518: iload #5
    //   520: invokestatic fireMouseInput : (III)V
    //   523: new Class40
    //   526: dup
    //   527: iload_3
    //   528: iload #4
    //   530: iload #5
    //   532: invokespecial <init> : (III)V
    //   535: pop
    //   536: return
  }
  
  private void Method102(long paramLong, double paramDouble1, double paramDouble2) {
    if (paramLong == Minecraft.getInstance().getMainWindow().getHandle()) {
      double d1 = paramDouble2;
      if (Minecraft.IS_RUNNING_ON_MAC && paramDouble2 == 0.0D)
        d1 = paramDouble1; 
      double d2 = (this.Field69.gameSettings.discreteMouseScroll ? Math.signum(d1) : d1) * this.Field69.gameSettings.mouseWheelSensitivity;
      if (this.Field69.loadingGui == null)
        if (this.Field69.currentScreen != null) {
          double d3 = this.Field73 * this.Field69.getMainWindow().getScaledWidth() / this.Field69.getMainWindow().getWidth();
          double d4 = this.Field74 * this.Field69.getMainWindow().getScaledHeight() / this.Field69.getMainWindow().getHeight();
          if (ForgeHooksClient.onGuiMouseScrollPre(this, this.Field69.currentScreen, d2))
            return; 
          if (this.Field69.currentScreen.mouseScrolled(d3, d4, d2))
            return; 
          ForgeHooksClient.onGuiMouseScrollPost(this, this.Field69.currentScreen, d2);
          new ScrollManager((Minecraft.getInstance()).currentScreen, this.Field73, this.Field74, d2);
        } else if (this.Field69.player != null) {
          if (this.Field84 != 0.0D && Math.signum(d2) != Math.signum(this.Field84))
            this.Field84 = 0.0D; 
          this.Field84 += d2;
          float f = (int)this.Field84;
          if (f == 0.0F)
            return; 
          this.Field84 -= f;
          if (ForgeHooksClient.onMouseScroll(this, d2))
            return; 
          if (this.Field69.player.isSpectator()) {
            if (this.Field69.ingameGUI.getSpectatorGui().isMenuActive()) {
              this.Field69.ingameGUI.getSpectatorGui().onMouseScroll(-f);
            } else {
              float f1 = MathHelper.clamp(this.Field69.player.abilities.getFlySpeed() + f * 0.005F, 0.0F, 0.2F);
              this.Field69.player.abilities.setFlySpeed(f1);
            } 
          } else {
            this.Field69.player.inventory.changeCurrentItem(f);
          } 
        }  
    } 
  }
  
  private void Method103(long paramLong, List paramList) {
    if (this.Field69.currentScreen != null)
      this.Field69.currentScreen.addPacks(paramList); 
  }
  
  public void registerCallbacks(long paramLong) {
    InputMappings.setMouseCallbacks(paramLong, this::Method116, this::Method114, this::Method112, this::Method110);
  }
  
  private void Method104(long paramLong, double paramDouble1, double paramDouble2) {
    // Byte code:
    //   0: lload_1
    //   1: invokestatic getInstance : ()Lnet/minecraft/client/Minecraft;
    //   4: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   7: invokevirtual getHandle : ()J
    //   10: lcmp
    //   11: ifne -> 343
    //   14: aload_0
    //   15: getfield Field77 : Z
    //   18: ifeq -> 37
    //   21: aload_0
    //   22: dload_3
    //   23: putfield Field73 : D
    //   26: aload_0
    //   27: dload #5
    //   29: putfield Field74 : D
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield Field77 : Z
    //   37: aload_0
    //   38: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   41: getfield currentScreen : Lnet/minecraft/client/gui/screen/Screen;
    //   44: astore #7
    //   46: aload #7
    //   48: ifnull -> 253
    //   51: aload_0
    //   52: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   55: getfield loadingGui : Lnet/minecraft/client/gui/LoadingGui;
    //   58: ifnonnull -> 253
    //   61: dload_3
    //   62: aload_0
    //   63: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   66: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   69: invokevirtual getScaledWidth : ()I
    //   72: i2d
    //   73: dmul
    //   74: aload_0
    //   75: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   78: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   81: invokevirtual getWidth : ()I
    //   84: i2d
    //   85: ddiv
    //   86: dstore #8
    //   88: dload #5
    //   90: aload_0
    //   91: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   94: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   97: invokevirtual getScaledHeight : ()I
    //   100: i2d
    //   101: dmul
    //   102: aload_0
    //   103: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   106: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   109: invokevirtual getHeight : ()I
    //   112: i2d
    //   113: ddiv
    //   114: dstore #10
    //   116: aload #7
    //   118: dload #8
    //   120: dload #10
    //   122: <illegal opcode> run : (Lnet/minecraft/client/gui/IGuiEventListener;DD)Ljava/lang/Runnable;
    //   127: ldc_w 'mouseMoved event handler'
    //   130: aload #7
    //   132: invokevirtual getClass : ()Ljava/lang/Class;
    //   135: invokevirtual getCanonicalName : ()Ljava/lang/String;
    //   138: invokestatic wrapScreenError : (Ljava/lang/Runnable;Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_0
    //   142: getfield Field76 : I
    //   145: iconst_m1
    //   146: if_icmpeq -> 253
    //   149: aload_0
    //   150: getfield Field79 : D
    //   153: dconst_0
    //   154: dcmpl
    //   155: ifle -> 253
    //   158: dload_3
    //   159: aload_0
    //   160: getfield Field73 : D
    //   163: dsub
    //   164: aload_0
    //   165: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   168: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   171: invokevirtual getScaledWidth : ()I
    //   174: i2d
    //   175: dmul
    //   176: aload_0
    //   177: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   180: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   183: invokevirtual getWidth : ()I
    //   186: i2d
    //   187: ddiv
    //   188: dstore #12
    //   190: dload #5
    //   192: aload_0
    //   193: getfield Field74 : D
    //   196: dsub
    //   197: aload_0
    //   198: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   201: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   204: invokevirtual getScaledHeight : ()I
    //   207: i2d
    //   208: dmul
    //   209: aload_0
    //   210: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   213: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   216: invokevirtual getHeight : ()I
    //   219: i2d
    //   220: ddiv
    //   221: dstore #14
    //   223: aload_0
    //   224: dload #8
    //   226: dload #10
    //   228: dload #12
    //   230: dload #14
    //   232: aload #7
    //   234: <illegal opcode> run : (LClass33;DDDDLnet/minecraft/client/gui/IGuiEventListener;)Ljava/lang/Runnable;
    //   239: ldc_w 'mouseDragged event handler'
    //   242: aload #7
    //   244: invokevirtual getClass : ()Ljava/lang/Class;
    //   247: invokevirtual getCanonicalName : ()Ljava/lang/String;
    //   250: invokestatic wrapScreenError : (Ljava/lang/Runnable;Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload_0
    //   254: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   257: invokevirtual getProfiler : ()Lnet/minecraft/profiler/IProfiler;
    //   260: ldc_w 'mouse'
    //   263: invokeinterface startSection : (Ljava/lang/String;)V
    //   268: aload_0
    //   269: invokevirtual isMouseGrabbed : ()Z
    //   272: ifeq -> 316
    //   275: aload_0
    //   276: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   279: invokevirtual isGameFocused : ()Z
    //   282: ifeq -> 316
    //   285: aload_0
    //   286: dup
    //   287: getfield Field82 : D
    //   290: dload_3
    //   291: aload_0
    //   292: getfield Field73 : D
    //   295: dsub
    //   296: dadd
    //   297: putfield Field82 : D
    //   300: aload_0
    //   301: dup
    //   302: getfield Field83 : D
    //   305: dload #5
    //   307: aload_0
    //   308: getfield Field74 : D
    //   311: dsub
    //   312: dadd
    //   313: putfield Field83 : D
    //   316: aload_0
    //   317: invokevirtual updatePlayerLook : ()V
    //   320: aload_0
    //   321: dload_3
    //   322: putfield Field73 : D
    //   325: aload_0
    //   326: dload #5
    //   328: putfield Field74 : D
    //   331: aload_0
    //   332: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   335: invokevirtual getProfiler : ()Lnet/minecraft/profiler/IProfiler;
    //   338: invokeinterface endSection : ()V
    //   343: return
  }
  
  public void updatePlayerLook() {
    double d1 = NativeUtil.getTime();
    double d2 = d1 - this.Field85;
    this.Field85 = d1;
    if (isMouseGrabbed() && this.Field69.isGameFocused()) {
      double d5;
      double d6;
      double d3 = this.Field69.gameSettings.mouseSensitivity * 0.6000000238418579D + 0.20000000298023224D;
      double d4 = d3 * d3 * d3 * 8.0D;
      if (this.Field69.gameSettings.smoothCamera) {
        double d7 = this.Field80.smooth(this.Field82 * d4, d2 * d4);
        double d8 = this.Field81.smooth(this.Field83 * d4, d2 * d4);
        d5 = d7;
        d6 = d8;
      } else {
        this.Field80.reset();
        this.Field81.reset();
        d5 = this.Field82 * d4;
        d6 = this.Field83 * d4;
      } 
      this.Field82 = 0.0D;
      this.Field83 = 0.0D;
      byte b = 1;
      if (this.Field69.gameSettings.invertMouse)
        b = -1; 
      this.Field69.getTutorial().onMouseMove(d5, d6);
      if (this.Field69.player != null)
        this.Field69.player.rotateTowards(d5, d6 * b); 
    } else {
      this.Field82 = 0.0D;
      this.Field83 = 0.0D;
    } 
  }
  
  public boolean isLeftDown() {
    return this.Field70;
  }
  
  public boolean isRightDown() {
    return this.Field72;
  }
  
  public boolean Method105() {
    return this.Field71;
  }
  
  public double getMouseX() {
    return this.Field73;
  }
  
  public double getMouseY() {
    return this.Field74;
  }
  
  public double Method106() {
    return this.Field82;
  }
  
  public double Method107() {
    return this.Field83;
  }
  
  public void setIgnoreFirstMove() {
    this.Field77 = true;
  }
  
  public boolean isMouseGrabbed() {
    return this.Field86;
  }
  
  public void grabMouse() {
    if (this.Field69.isGameFocused() && !this.Field86) {
      if (!Minecraft.IS_RUNNING_ON_MAC)
        KeyBinding.updateKeyBindState(); 
      this.Field86 = true;
      this.Field73 = (this.Field69.getMainWindow().getWidth() / 2);
      this.Field74 = (this.Field69.getMainWindow().getHeight() / 2);
      InputMappings.setCursorPosAndMode(this.Field69.getMainWindow().getHandle(), 212995, this.Field73, this.Field74);
      this.Field69.displayGuiScreen((Screen)null);
      ObfuscationReflectionHelper.setPrivateValue(Minecraft.class, Minecraft.getInstance(), Integer.valueOf(10000), "leftClickCounter");
      this.Field77 = true;
    } 
  }
  
  public void ungrabMouse() {
    if (this.Field86) {
      this.Field86 = false;
      this.Field73 = (this.Field69.getMainWindow().getWidth() / 2);
      this.Field74 = (this.Field69.getMainWindow().getHeight() / 2);
      InputMappings.setCursorPosAndMode(this.Field69.getMainWindow().getHandle(), 212993, this.Field73, this.Field74);
    } 
  }
  
  public void ignoreFirstMove() {
    this.Field77 = true;
  }
  
  private void Method108(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, IGuiEventListener paramIGuiEventListener) {
    if (ForgeHooksClient.onGuiMouseDragPre(this.Field69.currentScreen, paramDouble1, paramDouble2, this.Field76, paramDouble3, paramDouble4))
      return; 
    if (paramIGuiEventListener.mouseDragged(paramDouble1, paramDouble2, this.Field76, paramDouble3, paramDouble4))
      return; 
    ForgeHooksClient.onGuiMouseDragPost(this.Field69.currentScreen, paramDouble1, paramDouble2, this.Field76, paramDouble3, paramDouble4);
  }
  
  private static void Method109(IGuiEventListener paramIGuiEventListener, double paramDouble1, double paramDouble2) {
    paramIGuiEventListener.mouseMoved(paramDouble1, paramDouble2);
  }
  
  private void Method110(long paramLong1, int paramInt, long paramLong2) {
    // Byte code:
    //   0: iload_3
    //   1: anewarray java/nio/file/Path
    //   4: astore #6
    //   6: iconst_0
    //   7: istore #7
    //   9: iload #7
    //   11: iload_3
    //   12: if_icmpge -> 40
    //   15: aload #6
    //   17: iload #7
    //   19: lload #4
    //   21: iload #7
    //   23: invokestatic getName : (JI)Ljava/lang/String;
    //   26: iconst_0
    //   27: anewarray java/lang/String
    //   30: invokestatic get : (Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;
    //   33: aastore
    //   34: iinc #7, 1
    //   37: goto -> 9
    //   40: aload_0
    //   41: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   44: aload_0
    //   45: lload_1
    //   46: aload #6
    //   48: <illegal opcode> run : (LClass33;J[Ljava/nio/file/Path;)Ljava/lang/Runnable;
    //   53: invokevirtual execute : (Ljava/lang/Runnable;)V
    //   56: return
  }
  
  private void Method111(long paramLong, Path[] paramArrayOfPath) {
    Method103(paramLong, Arrays.asList(paramArrayOfPath));
  }
  
  private void Method112(long paramLong, double paramDouble1, double paramDouble2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   4: aload_0
    //   5: lload_1
    //   6: dload_3
    //   7: dload #5
    //   9: <illegal opcode> run : (LClass33;JDD)Ljava/lang/Runnable;
    //   14: invokevirtual execute : (Ljava/lang/Runnable;)V
    //   17: return
  }
  
  private void Method113(long paramLong, double paramDouble1, double paramDouble2) {
    Method102(paramLong, paramDouble1, paramDouble2);
  }
  
  private void Method114(long paramLong, int paramInt1, int paramInt2, int paramInt3) {
    // Byte code:
    //   0: aload_0
    //   1: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   4: aload_0
    //   5: lload_1
    //   6: iload_3
    //   7: iload #4
    //   9: iload #5
    //   11: <illegal opcode> run : (LClass33;JIII)Ljava/lang/Runnable;
    //   16: invokevirtual execute : (Ljava/lang/Runnable;)V
    //   19: return
  }
  
  private void Method115(long paramLong, int paramInt1, int paramInt2, int paramInt3) {
    Method101(paramLong, paramInt1, paramInt2, paramInt3);
  }
  
  private void Method116(long paramLong, double paramDouble1, double paramDouble2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield Field69 : Lnet/minecraft/client/Minecraft;
    //   4: aload_0
    //   5: lload_1
    //   6: dload_3
    //   7: dload #5
    //   9: <illegal opcode> run : (LClass33;JDD)Ljava/lang/Runnable;
    //   14: invokevirtual execute : (Ljava/lang/Runnable;)V
    //   17: return
  }
  
  private void Method117(long paramLong, double paramDouble1, double paramDouble2) {
    Method104(paramLong, paramDouble1, paramDouble2);
  }
  
  private void Method118(boolean[] paramArrayOfboolean, double paramDouble1, double paramDouble2, int paramInt) {
    paramArrayOfboolean[0] = ForgeHooksClient.onGuiMouseReleasedPre(this.Field69.currentScreen, paramDouble1, paramDouble2, paramInt);
    if (!paramArrayOfboolean[0])
      paramArrayOfboolean[0] = this.Field69.currentScreen.mouseReleased(paramDouble1, paramDouble2, paramInt); 
    if (!paramArrayOfboolean[0])
      paramArrayOfboolean[0] = ForgeHooksClient.onGuiMouseReleasedPost(this.Field69.currentScreen, paramDouble1, paramDouble2, paramInt); 
  }
  
  private void Method119(boolean[] paramArrayOfboolean, double paramDouble1, double paramDouble2, int paramInt) {
    paramArrayOfboolean[0] = ForgeHooksClient.onGuiMouseClickedPre(this.Field69.currentScreen, paramDouble1, paramDouble2, paramInt);
    if (!paramArrayOfboolean[0])
      paramArrayOfboolean[0] = this.Field69.currentScreen.mouseClicked(paramDouble1, paramDouble2, paramInt); 
    if (!paramArrayOfboolean[0])
      paramArrayOfboolean[0] = ForgeHooksClient.onGuiMouseClickedPost(this.Field69.currentScreen, paramDouble1, paramDouble2, paramInt); 
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class33.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

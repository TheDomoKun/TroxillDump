//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.util.Locale;
import javax.annotation.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.client.AbstractOption;
import net.minecraft.client.ClipboardHelper;
import net.minecraft.client.KeyboardListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.INestedGuiEventHandler;
import net.minecraft.client.gui.NewChatGui;
import net.minecraft.client.gui.screen.GamemodeSelectionScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.util.InputMappings;
import net.minecraft.command.arguments.BlockStateParser;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.ForgeHooksClient;

public class KeyboardListenerHook extends KeyboardListener {
  private final Minecraft Field123;
  
  private boolean Field124;
  
  private final ClipboardHelper Field125 = new ClipboardHelper();
  
  private boolean Field126;
  
  public KeyboardListenerHook(Minecraft paramMinecraft) {
    super(paramMinecraft);
    this.Field123 = paramMinecraft;
  }
  
  public void setupCallbacks(long paramLong) {
    InputMappings.setKeyCallbacks(paramLong, this::Method169, this::Method167);
  }
  
  private void Method154(long paramLong, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: lload_1
    //   1: aload_0
    //   2: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   5: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   8: invokevirtual getHandle : ()J
    //   11: lcmp
    //   12: ifne -> 133
    //   15: aload_0
    //   16: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   19: getfield currentScreen : Lnet/minecraft/client/gui/screen/Screen;
    //   22: astore #5
    //   24: aload #5
    //   26: ifnull -> 133
    //   29: aload_0
    //   30: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   33: invokevirtual getLoadingGui : ()Lnet/minecraft/client/gui/LoadingGui;
    //   36: ifnonnull -> 133
    //   39: iload_3
    //   40: invokestatic charCount : (I)I
    //   43: iconst_1
    //   44: if_icmpne -> 74
    //   47: aload_0
    //   48: iload_3
    //   49: iload #4
    //   51: aload #5
    //   53: <illegal opcode> run : (LClass32;IILnet/minecraft/client/gui/IGuiEventListener;)Ljava/lang/Runnable;
    //   58: ldc 'charTyped event handler'
    //   60: aload #5
    //   62: invokevirtual getClass : ()Ljava/lang/Class;
    //   65: invokevirtual getCanonicalName : ()Ljava/lang/String;
    //   68: invokestatic wrapScreenError : (Ljava/lang/Runnable;Ljava/lang/String;Ljava/lang/String;)V
    //   71: goto -> 133
    //   74: iload_3
    //   75: invokestatic toChars : (I)[C
    //   78: astore #6
    //   80: aload #6
    //   82: arraylength
    //   83: istore #7
    //   85: iconst_0
    //   86: istore #8
    //   88: iload #8
    //   90: iload #7
    //   92: if_icmpge -> 133
    //   95: aload #6
    //   97: iload #8
    //   99: caload
    //   100: istore #9
    //   102: aload_0
    //   103: iload #9
    //   105: iload #4
    //   107: aload #5
    //   109: <illegal opcode> run : (LClass32;CILnet/minecraft/client/gui/IGuiEventListener;)Ljava/lang/Runnable;
    //   114: ldc 'charTyped event handler'
    //   116: aload #5
    //   118: invokevirtual getClass : ()Ljava/lang/Class;
    //   121: invokevirtual getCanonicalName : ()Ljava/lang/String;
    //   124: invokestatic wrapScreenError : (Ljava/lang/Runnable;Ljava/lang/String;Ljava/lang/String;)V
    //   127: iinc #8, 1
    //   130: goto -> 88
    //   133: return
  }
  
  private void Method155(String paramString, Object... paramVarArgs) {
    this.Field123.ingameGUI.getChatGUI().printChatMessage((ITextComponent)(new StringTextComponent("")).appendSibling((ITextComponent)(new TranslationTextComponent("debug.prefix")).mergeStyle(new TextFormatting[] { TextFormatting.YELLOW, TextFormatting.BOLD })).appendString(" ").appendSibling((ITextComponent)new TranslationTextComponent(paramString, paramVarArgs)));
  }
  
  private void Method156(BlockState paramBlockState, BlockPos paramBlockPos, @Nullable CompoundNBT paramCompoundNBT) {
    if (paramCompoundNBT != null) {
      paramCompoundNBT.remove("x");
      paramCompoundNBT.remove("y");
      paramCompoundNBT.remove("z");
      paramCompoundNBT.remove("id");
    } 
    StringBuilder stringBuilder = new StringBuilder(BlockStateParser.toString(paramBlockState));
    if (paramCompoundNBT != null)
      stringBuilder.append(paramCompoundNBT); 
    String str = String.format(Locale.ROOT, "/setblock %d %d %d %s", new Object[] { Integer.valueOf(paramBlockPos.getX()), Integer.valueOf(paramBlockPos.getY()), Integer.valueOf(paramBlockPos.getZ()), stringBuilder });
    setClipboardString(str);
  }
  
  private void Method157(ResourceLocation paramResourceLocation, Vector3d paramVector3d, @Nullable CompoundNBT paramCompoundNBT) {
    String str;
    if (paramCompoundNBT != null) {
      paramCompoundNBT.remove("UUID");
      paramCompoundNBT.remove("Pos");
      paramCompoundNBT.remove("Dimension");
      String str1 = paramCompoundNBT.toFormattedComponent().getString();
      str = String.format(Locale.ROOT, "/summon %s %.2f %.2f %.2f %s", new Object[] { paramResourceLocation.toString(), Double.valueOf(paramVector3d.x), Double.valueOf(paramVector3d.y), Double.valueOf(paramVector3d.z), str1 });
    } else {
      str = String.format(Locale.ROOT, "/summon %s %.2f %.2f %.2f", new Object[] { paramResourceLocation.toString(), Double.valueOf(paramVector3d.x), Double.valueOf(paramVector3d.y), Double.valueOf(paramVector3d.z) });
    } 
    setClipboardString(str);
  }
  
  private void Method158(boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   4: getfield objectMouseOver : Lnet/minecraft/util/math/RayTraceResult;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnull -> 334
    //   12: getstatic Class31.Field127 : [I
    //   15: aload_3
    //   16: invokevirtual getType : ()Lnet/minecraft/util/math/RayTraceResult$Type;
    //   19: invokevirtual ordinal : ()I
    //   22: iaload
    //   23: lookupswitch default -> 334, 1 -> 48, 2 -> 203
    //   48: aload_3
    //   49: checkcast net/minecraft/util/math/BlockRayTraceResult
    //   52: invokevirtual getPos : ()Lnet/minecraft/util/math/BlockPos;
    //   55: astore #4
    //   57: aload_0
    //   58: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   61: getfield player : Lnet/minecraft/client/entity/player/ClientPlayerEntity;
    //   64: getfield world : Lnet/minecraft/world/World;
    //   67: aload #4
    //   69: invokevirtual getBlockState : (Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;
    //   72: astore #5
    //   74: iload_1
    //   75: ifeq -> 177
    //   78: iload_2
    //   79: ifeq -> 113
    //   82: aload_0
    //   83: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   86: getfield player : Lnet/minecraft/client/entity/player/ClientPlayerEntity;
    //   89: getfield connection : Lnet/minecraft/client/network/play/ClientPlayNetHandler;
    //   92: invokevirtual getNBTQueryManager : ()Lnet/minecraft/client/util/NBTQueryManager;
    //   95: aload #4
    //   97: aload_0
    //   98: aload #5
    //   100: aload #4
    //   102: <illegal opcode> accept : (LClass32;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;)Ljava/util/function/Consumer;
    //   107: invokevirtual queryTileEntity : (Lnet/minecraft/util/math/BlockPos;Ljava/util/function/Consumer;)V
    //   110: goto -> 334
    //   113: aload_0
    //   114: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   117: getfield player : Lnet/minecraft/client/entity/player/ClientPlayerEntity;
    //   120: getfield world : Lnet/minecraft/world/World;
    //   123: aload #4
    //   125: invokevirtual getTileEntity : (Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/tileentity/TileEntity;
    //   128: astore #6
    //   130: aload #6
    //   132: ifnull -> 150
    //   135: aload #6
    //   137: new net/minecraft/nbt/CompoundNBT
    //   140: dup
    //   141: invokespecial <init> : ()V
    //   144: invokevirtual write : (Lnet/minecraft/nbt/CompoundNBT;)Lnet/minecraft/nbt/CompoundNBT;
    //   147: goto -> 151
    //   150: aconst_null
    //   151: astore #7
    //   153: aload_0
    //   154: aload #5
    //   156: aload #4
    //   158: aload #7
    //   160: invokespecial Method156 : (Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/nbt/CompoundNBT;)V
    //   163: aload_0
    //   164: ldc_w 'debug.inspect.client.block'
    //   167: iconst_0
    //   168: anewarray java/lang/Object
    //   171: invokespecial Method155 : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: goto -> 334
    //   177: aload_0
    //   178: aload #5
    //   180: aload #4
    //   182: aconst_null
    //   183: checkcast net/minecraft/nbt/CompoundNBT
    //   186: invokespecial Method156 : (Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/nbt/CompoundNBT;)V
    //   189: aload_0
    //   190: ldc_w 'debug.inspect.client.block'
    //   193: iconst_0
    //   194: anewarray java/lang/Object
    //   197: invokespecial Method155 : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: goto -> 334
    //   203: aload_3
    //   204: checkcast net/minecraft/util/math/EntityRayTraceResult
    //   207: invokevirtual getEntity : ()Lnet/minecraft/entity/Entity;
    //   210: astore #6
    //   212: getstatic net/minecraft/util/registry/Registry.ENTITY_TYPE : Lnet/minecraft/util/registry/DefaultedRegistry;
    //   215: aload #6
    //   217: invokevirtual getType : ()Lnet/minecraft/entity/EntityType;
    //   220: invokevirtual getKey : (Ljava/lang/Object;)Lnet/minecraft/util/ResourceLocation;
    //   223: astore #7
    //   225: iload_1
    //   226: ifeq -> 308
    //   229: iload_2
    //   230: ifeq -> 267
    //   233: aload_0
    //   234: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   237: getfield player : Lnet/minecraft/client/entity/player/ClientPlayerEntity;
    //   240: getfield connection : Lnet/minecraft/client/network/play/ClientPlayNetHandler;
    //   243: invokevirtual getNBTQueryManager : ()Lnet/minecraft/client/util/NBTQueryManager;
    //   246: aload #6
    //   248: invokevirtual getEntityId : ()I
    //   251: aload_0
    //   252: aload #7
    //   254: aload #6
    //   256: <illegal opcode> accept : (LClass32;Lnet/minecraft/util/ResourceLocation;Lnet/minecraft/entity/Entity;)Ljava/util/function/Consumer;
    //   261: invokevirtual queryEntity : (ILjava/util/function/Consumer;)V
    //   264: goto -> 334
    //   267: aload #6
    //   269: new net/minecraft/nbt/CompoundNBT
    //   272: dup
    //   273: invokespecial <init> : ()V
    //   276: invokevirtual writeWithoutTypeId : (Lnet/minecraft/nbt/CompoundNBT;)Lnet/minecraft/nbt/CompoundNBT;
    //   279: astore #8
    //   281: aload_0
    //   282: aload #7
    //   284: aload #6
    //   286: invokevirtual getPositionVec : ()Lnet/minecraft/util/math/vector/Vector3d;
    //   289: aload #8
    //   291: invokespecial Method157 : (Lnet/minecraft/util/ResourceLocation;Lnet/minecraft/util/math/vector/Vector3d;Lnet/minecraft/nbt/CompoundNBT;)V
    //   294: aload_0
    //   295: ldc_w 'debug.inspect.client.entity'
    //   298: iconst_0
    //   299: anewarray java/lang/Object
    //   302: invokespecial Method155 : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   305: goto -> 334
    //   308: aload_0
    //   309: aload #7
    //   311: aload #6
    //   313: invokevirtual getPositionVec : ()Lnet/minecraft/util/math/vector/Vector3d;
    //   316: aconst_null
    //   317: checkcast net/minecraft/nbt/CompoundNBT
    //   320: invokespecial Method157 : (Lnet/minecraft/util/ResourceLocation;Lnet/minecraft/util/math/vector/Vector3d;Lnet/minecraft/nbt/CompoundNBT;)V
    //   323: aload_0
    //   324: ldc_w 'debug.inspect.client.entity'
    //   327: iconst_0
    //   328: anewarray java/lang/Object
    //   331: invokespecial Method155 : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   334: return
  }
  
  public void onKeyEvent(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: lload_1
    //   1: aload_0
    //   2: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   5: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   8: invokevirtual getHandle : ()J
    //   11: lcmp
    //   12: ifne -> 847
    //   15: aload_0
    //   16: getfield ば : J
    //   19: lconst_0
    //   20: lcmp
    //   21: ifle -> 69
    //   24: invokestatic getInstance : ()Lnet/minecraft/client/Minecraft;
    //   27: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   30: invokevirtual getHandle : ()J
    //   33: bipush #67
    //   35: invokestatic isKeyDown : (JI)Z
    //   38: ifeq -> 59
    //   41: invokestatic getInstance : ()Lnet/minecraft/client/Minecraft;
    //   44: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   47: invokevirtual getHandle : ()J
    //   50: sipush #292
    //   53: invokestatic isKeyDown : (JI)Z
    //   56: ifne -> 128
    //   59: aload_0
    //   60: ldc2_w -1
    //   63: putfield ば : J
    //   66: goto -> 128
    //   69: invokestatic getInstance : ()Lnet/minecraft/client/Minecraft;
    //   72: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   75: invokevirtual getHandle : ()J
    //   78: bipush #67
    //   80: invokestatic isKeyDown : (JI)Z
    //   83: ifeq -> 128
    //   86: invokestatic getInstance : ()Lnet/minecraft/client/Minecraft;
    //   89: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   92: invokevirtual getHandle : ()J
    //   95: sipush #292
    //   98: invokestatic isKeyDown : (JI)Z
    //   101: ifeq -> 128
    //   104: aload_0
    //   105: iconst_1
    //   106: putfield Field126 : Z
    //   109: aload_0
    //   110: invokestatic milliTime : ()J
    //   113: putfield ば : J
    //   116: aload_0
    //   117: invokestatic milliTime : ()J
    //   120: putfield ぱ : J
    //   123: aload_0
    //   124: lconst_0
    //   125: putfield ひ : J
    //   128: aload_0
    //   129: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   132: getfield currentScreen : Lnet/minecraft/client/gui/screen/Screen;
    //   135: astore #7
    //   137: aload_0
    //   138: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   141: getfield currentScreen : Lnet/minecraft/client/gui/screen/Screen;
    //   144: instanceof net/minecraft/client/gui/screen/ControlsScreen
    //   147: ifeq -> 169
    //   150: aload #7
    //   152: checkcast net/minecraft/client/gui/screen/ControlsScreen
    //   155: getfield time : J
    //   158: invokestatic milliTime : ()J
    //   161: ldc2_w 20
    //   164: lsub
    //   165: lcmp
    //   166: ifgt -> 336
    //   169: iload #5
    //   171: iconst_1
    //   172: if_icmpne -> 304
    //   175: aload_0
    //   176: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   179: getfield gameSettings : Lnet/minecraft/client/GameSettings;
    //   182: getfield keyBindFullscreen : Lnet/minecraft/client/settings/KeyBinding;
    //   185: iload_3
    //   186: iload #4
    //   188: invokevirtual matchesKey : (II)Z
    //   191: ifeq -> 235
    //   194: aload_0
    //   195: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   198: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   201: invokevirtual toggleFullscreen : ()V
    //   204: aload_0
    //   205: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   208: getfield gameSettings : Lnet/minecraft/client/GameSettings;
    //   211: aload_0
    //   212: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   215: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   218: invokevirtual isFullscreen : ()Z
    //   221: putfield fullscreen : Z
    //   224: aload_0
    //   225: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   228: getfield gameSettings : Lnet/minecraft/client/GameSettings;
    //   231: invokevirtual saveOptions : ()V
    //   234: return
    //   235: aload_0
    //   236: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   239: getfield gameSettings : Lnet/minecraft/client/GameSettings;
    //   242: getfield keyBindScreenshot : Lnet/minecraft/client/settings/KeyBinding;
    //   245: iload_3
    //   246: iload #4
    //   248: invokevirtual matchesKey : (II)Z
    //   251: ifeq -> 336
    //   254: invokestatic hasControlDown : ()Z
    //   257: ifeq -> 260
    //   260: aload_0
    //   261: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   264: getfield gameDir : Ljava/io/File;
    //   267: aload_0
    //   268: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   271: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   274: invokevirtual getFramebufferWidth : ()I
    //   277: aload_0
    //   278: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   281: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   284: invokevirtual getFramebufferHeight : ()I
    //   287: aload_0
    //   288: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   291: invokevirtual getFramebuffer : ()Lnet/minecraft/client/shader/Framebuffer;
    //   294: aload_0
    //   295: <illegal opcode> accept : (LClass32;)Ljava/util/function/Consumer;
    //   300: invokestatic saveScreenshot : (Ljava/io/File;IILnet/minecraft/client/shader/Framebuffer;Ljava/util/function/Consumer;)V
    //   303: return
    //   304: iload #5
    //   306: ifne -> 336
    //   309: aload_0
    //   310: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   313: getfield currentScreen : Lnet/minecraft/client/gui/screen/Screen;
    //   316: instanceof net/minecraft/client/gui/screen/ControlsScreen
    //   319: ifeq -> 336
    //   322: aload_0
    //   323: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   326: getfield currentScreen : Lnet/minecraft/client/gui/screen/Screen;
    //   329: checkcast net/minecraft/client/gui/screen/ControlsScreen
    //   332: aconst_null
    //   333: putfield buttonId : Lnet/minecraft/client/settings/KeyBinding;
    //   336: aload #7
    //   338: ifnull -> 370
    //   341: aload #7
    //   343: invokeinterface getListener : ()Lnet/minecraft/client/gui/IGuiEventListener;
    //   348: instanceof net/minecraft/client/gui/widget/TextFieldWidget
    //   351: ifeq -> 370
    //   354: aload #7
    //   356: invokeinterface getListener : ()Lnet/minecraft/client/gui/IGuiEventListener;
    //   361: checkcast net/minecraft/client/gui/widget/TextFieldWidget
    //   364: invokevirtual canWrite : ()Z
    //   367: ifne -> 374
    //   370: iconst_1
    //   371: goto -> 375
    //   374: iconst_0
    //   375: istore #8
    //   377: iload #5
    //   379: ifeq -> 429
    //   382: iload_3
    //   383: bipush #66
    //   385: if_icmpne -> 429
    //   388: invokestatic hasControlDown : ()Z
    //   391: ifeq -> 429
    //   394: iload #8
    //   396: ifeq -> 429
    //   399: getstatic net/minecraft/client/AbstractOption.NARRATOR : Lnet/minecraft/client/settings/IteratableOption;
    //   402: aload_0
    //   403: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   406: getfield gameSettings : Lnet/minecraft/client/GameSettings;
    //   409: iconst_1
    //   410: invokevirtual setValueIndex : (Lnet/minecraft/client/GameSettings;I)V
    //   413: aload #7
    //   415: instanceof net/minecraft/client/gui/screen/WithNarratorSettingsScreen
    //   418: ifeq -> 429
    //   421: aload #7
    //   423: checkcast net/minecraft/client/gui/screen/WithNarratorSettingsScreen
    //   426: invokevirtual func_243317_i : ()V
    //   429: aload #7
    //   431: ifnull -> 482
    //   434: iconst_1
    //   435: newarray boolean
    //   437: dup
    //   438: iconst_0
    //   439: iconst_0
    //   440: bastore
    //   441: astore #9
    //   443: aload_0
    //   444: iload #5
    //   446: aload #9
    //   448: iload_3
    //   449: iload #4
    //   451: iload #6
    //   453: aload #7
    //   455: <illegal opcode> run : (LClass32;I[ZIIILnet/minecraft/client/gui/INestedGuiEventHandler;)Ljava/lang/Runnable;
    //   460: ldc_w 'keyPressed event handler'
    //   463: aload #7
    //   465: invokevirtual getClass : ()Ljava/lang/Class;
    //   468: invokevirtual getCanonicalName : ()Ljava/lang/String;
    //   471: invokestatic wrapScreenError : (Ljava/lang/Runnable;Ljava/lang/String;Ljava/lang/String;)V
    //   474: aload #9
    //   476: iconst_0
    //   477: baload
    //   478: ifeq -> 482
    //   481: return
    //   482: aload_0
    //   483: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   486: getfield currentScreen : Lnet/minecraft/client/gui/screen/Screen;
    //   489: ifnull -> 505
    //   492: aload_0
    //   493: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   496: getfield currentScreen : Lnet/minecraft/client/gui/screen/Screen;
    //   499: getfield passEvents : Z
    //   502: ifeq -> 822
    //   505: iload_3
    //   506: iload #4
    //   508: invokestatic getInputByCode : (II)Lnet/minecraft/client/util/InputMappings$Input;
    //   511: astore #9
    //   513: iload #5
    //   515: ifne -> 645
    //   518: aload #9
    //   520: iconst_0
    //   521: invokestatic setKeyBindState : (Lnet/minecraft/client/util/InputMappings$Input;Z)V
    //   524: iload_3
    //   525: sipush #292
    //   528: if_icmpne -> 822
    //   531: aload_0
    //   532: getfield Field126 : Z
    //   535: ifeq -> 546
    //   538: aload_0
    //   539: iconst_0
    //   540: putfield Field126 : Z
    //   543: goto -> 822
    //   546: aload_0
    //   547: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   550: getfield gameSettings : Lnet/minecraft/client/GameSettings;
    //   553: aload_0
    //   554: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   557: getfield gameSettings : Lnet/minecraft/client/GameSettings;
    //   560: getfield showDebugInfo : Z
    //   563: ifne -> 570
    //   566: iconst_1
    //   567: goto -> 571
    //   570: iconst_0
    //   571: putfield showDebugInfo : Z
    //   574: aload_0
    //   575: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   578: getfield gameSettings : Lnet/minecraft/client/GameSettings;
    //   581: aload_0
    //   582: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   585: getfield gameSettings : Lnet/minecraft/client/GameSettings;
    //   588: getfield showDebugInfo : Z
    //   591: ifeq -> 604
    //   594: invokestatic hasShiftDown : ()Z
    //   597: ifeq -> 604
    //   600: iconst_1
    //   601: goto -> 605
    //   604: iconst_0
    //   605: putfield showDebugProfilerChart : Z
    //   608: aload_0
    //   609: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   612: getfield gameSettings : Lnet/minecraft/client/GameSettings;
    //   615: aload_0
    //   616: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   619: getfield gameSettings : Lnet/minecraft/client/GameSettings;
    //   622: getfield showDebugInfo : Z
    //   625: ifeq -> 638
    //   628: invokestatic hasAltDown : ()Z
    //   631: ifeq -> 638
    //   634: iconst_1
    //   635: goto -> 639
    //   638: iconst_0
    //   639: putfield showLagometer : Z
    //   642: goto -> 822
    //   645: iload_3
    //   646: sipush #293
    //   649: if_icmpne -> 672
    //   652: aload_0
    //   653: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   656: getfield gameRenderer : Lnet/minecraft/client/renderer/GameRenderer;
    //   659: ifnull -> 672
    //   662: aload_0
    //   663: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   666: getfield gameRenderer : Lnet/minecraft/client/renderer/GameRenderer;
    //   669: invokevirtual switchUseShader : ()V
    //   672: iconst_0
    //   673: istore #10
    //   675: aload_0
    //   676: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   679: getfield currentScreen : Lnet/minecraft/client/gui/screen/Screen;
    //   682: ifnonnull -> 797
    //   685: iload_3
    //   686: sipush #256
    //   689: if_icmpne -> 718
    //   692: invokestatic getInstance : ()Lnet/minecraft/client/Minecraft;
    //   695: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   698: invokevirtual getHandle : ()J
    //   701: sipush #292
    //   704: invokestatic isKeyDown : (JI)Z
    //   707: istore #11
    //   709: aload_0
    //   710: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   713: iload #11
    //   715: invokevirtual displayInGameMenu : (Z)V
    //   718: invokestatic getInstance : ()Lnet/minecraft/client/Minecraft;
    //   721: invokevirtual getMainWindow : ()Lnet/minecraft/client/MainWindow;
    //   724: invokevirtual getHandle : ()J
    //   727: sipush #292
    //   730: invokestatic isKeyDown : (JI)Z
    //   733: ifeq -> 748
    //   736: aload_0
    //   737: iload_3
    //   738: invokespecial Method159 : (I)Z
    //   741: ifeq -> 748
    //   744: iconst_1
    //   745: goto -> 749
    //   748: iconst_0
    //   749: istore #10
    //   751: aload_0
    //   752: dup
    //   753: getfield Field126 : Z
    //   756: iload #10
    //   758: ior
    //   759: putfield Field126 : Z
    //   762: iload_3
    //   763: sipush #290
    //   766: if_icmpne -> 797
    //   769: aload_0
    //   770: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   773: getfield gameSettings : Lnet/minecraft/client/GameSettings;
    //   776: aload_0
    //   777: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   780: getfield gameSettings : Lnet/minecraft/client/GameSettings;
    //   783: getfield hideGUI : Z
    //   786: ifne -> 793
    //   789: iconst_1
    //   790: goto -> 794
    //   793: iconst_0
    //   794: putfield hideGUI : Z
    //   797: iload #10
    //   799: ifeq -> 811
    //   802: aload #9
    //   804: iconst_0
    //   805: invokestatic setKeyBindState : (Lnet/minecraft/client/util/InputMappings$Input;Z)V
    //   808: goto -> 822
    //   811: aload #9
    //   813: iconst_1
    //   814: invokestatic setKeyBindState : (Lnet/minecraft/client/util/InputMappings$Input;Z)V
    //   817: aload #9
    //   819: invokestatic onTick : (Lnet/minecraft/client/util/InputMappings$Input;)V
    //   822: iload_3
    //   823: iload #4
    //   825: iload #5
    //   827: iload #6
    //   829: invokestatic fireKeyInput : (IIII)V
    //   832: new Class39
    //   835: dup
    //   836: iload_3
    //   837: iload #4
    //   839: iload #5
    //   841: iload #6
    //   843: invokespecial <init> : (IIII)V
    //   846: pop
    //   847: return
  }
  
  private boolean Method159(int paramInt) {
    boolean bool;
    ClientPlayNetHandler clientPlayNetHandler;
    boolean bool1;
    NewChatGui newChatGui;
    if (this.ば > 0L && this.ば < Util.milliTime() - 100L)
      return true; 
    switch (paramInt) {
      case 65:
        this.Field123.worldRenderer.loadRenderers();
        Method155("debug.reload_chunks.message", new Object[0]);
        return true;
      case 66:
        bool = !this.Field123.getRenderManager().isDebugBoundingBox() ? true : false;
        this.Field123.getRenderManager().setDebugBoundingBox(bool);
        Method155(bool ? "debug.show_hitboxes.on" : "debug.show_hitboxes.off", new Object[0]);
        return true;
      case 67:
        if (this.Field123.player.hasReducedDebug())
          return false; 
        clientPlayNetHandler = this.Field123.player.connection;
        if (clientPlayNetHandler == null)
          return false; 
        Method155("debug.copy_location.message", new Object[0]);
        setClipboardString(String.format(Locale.ROOT, "/execute in %s run tp @s %.2f %.2f %.2f %.2f %.2f", new Object[] { this.Field123.player.world.getDimensionKey().getLocation(), Double.valueOf(this.Field123.player.getPosX()), Double.valueOf(this.Field123.player.getPosY()), Double.valueOf(this.Field123.player.getPosZ()), Float.valueOf(this.Field123.player.rotationYaw), Float.valueOf(this.Field123.player.rotationPitch) }));
        return true;
      case 68:
        if (this.Field123.ingameGUI != null)
          this.Field123.ingameGUI.getChatGUI().clearChatMessages(false); 
        return true;
      case 70:
        AbstractOption.RENDER_DISTANCE.set(this.Field123.gameSettings, MathHelper.clamp((this.Field123.gameSettings.renderDistanceChunks + (Screen.hasShiftDown() ? -1 : 1)), AbstractOption.RENDER_DISTANCE.getMinValue(), AbstractOption.RENDER_DISTANCE.getMaxValue()));
        Method155("debug.cycle_renderdistance.message", new Object[] { Integer.valueOf(this.Field123.gameSettings.renderDistanceChunks) });
        return true;
      case 71:
        bool1 = this.Field123.debugRenderer.toggleChunkBorders();
        Method155(bool1 ? "debug.chunk_boundaries.on" : "debug.chunk_boundaries.off", new Object[0]);
        return true;
      case 72:
        this.Field123.gameSettings.advancedItemTooltips = !this.Field123.gameSettings.advancedItemTooltips;
        Method155(this.Field123.gameSettings.advancedItemTooltips ? "debug.advanced_tooltips.on" : "debug.advanced_tooltips.off", new Object[0]);
        this.Field123.gameSettings.saveOptions();
        return true;
      case 73:
        if (!this.Field123.player.hasReducedDebug())
          Method158(this.Field123.player.hasPermissionLevel(2), !Screen.hasShiftDown()); 
        return true;
      case 78:
        if (!this.Field123.player.hasPermissionLevel(2)) {
          Method155("debug.creative_spectator.error", new Object[0]);
        } else if (!this.Field123.player.isSpectator()) {
          this.Field123.player.sendChatMessage("/gamemode spectator");
        } else {
          this.Field123.player.sendChatMessage("/gamemode " + this.Field123.playerController.getPreviousGameType().getName());
        } 
        return true;
      case 80:
        this.Field123.gameSettings.pauseOnLostFocus = !this.Field123.gameSettings.pauseOnLostFocus;
        this.Field123.gameSettings.saveOptions();
        Method155(this.Field123.gameSettings.pauseOnLostFocus ? "debug.pause_focus.on" : "debug.pause_focus.off", new Object[0]);
        return true;
      case 81:
        Method155("debug.help.message", new Object[0]);
        newChatGui = this.Field123.ingameGUI.getChatGUI();
        newChatGui.printChatMessage((ITextComponent)new TranslationTextComponent("debug.reload_chunks.help"));
        newChatGui.printChatMessage((ITextComponent)new TranslationTextComponent("debug.show_hitboxes.help"));
        newChatGui.printChatMessage((ITextComponent)new TranslationTextComponent("debug.copy_location.help"));
        newChatGui.printChatMessage((ITextComponent)new TranslationTextComponent("debug.clear_chat.help"));
        newChatGui.printChatMessage((ITextComponent)new TranslationTextComponent("debug.cycle_renderdistance.help"));
        newChatGui.printChatMessage((ITextComponent)new TranslationTextComponent("debug.chunk_boundaries.help"));
        newChatGui.printChatMessage((ITextComponent)new TranslationTextComponent("debug.advanced_tooltips.help"));
        newChatGui.printChatMessage((ITextComponent)new TranslationTextComponent("debug.inspect.help"));
        newChatGui.printChatMessage((ITextComponent)new TranslationTextComponent("debug.creative_spectator.help"));
        newChatGui.printChatMessage((ITextComponent)new TranslationTextComponent("debug.pause_focus.help"));
        newChatGui.printChatMessage((ITextComponent)new TranslationTextComponent("debug.help.help"));
        newChatGui.printChatMessage((ITextComponent)new TranslationTextComponent("debug.reload_resourcepacks.help"));
        newChatGui.printChatMessage((ITextComponent)new TranslationTextComponent("debug.pause.help"));
        newChatGui.printChatMessage((ITextComponent)new TranslationTextComponent("debug.gamemodes.help"));
        return true;
      case 84:
        Method155("debug.reload_resourcepacks.message", new Object[0]);
        this.Field123.reloadResources();
        return true;
      case 293:
        if (!this.Field123.player.hasPermissionLevel(2)) {
          Method155("debug.gamemodes.error", new Object[0]);
        } else {
          this.Field123.displayGuiScreen((Screen)new GamemodeSelectionScreen());
        } 
        return true;
    } 
    return false;
  }
  
  private void Method160(int paramInt1, boolean[] paramArrayOfboolean, int paramInt2, int paramInt3, int paramInt4, INestedGuiEventHandler paramINestedGuiEventHandler) {
    if (paramInt1 != 1 && (paramInt1 != 2 || !this.Field124)) {
      if (paramInt1 == 0) {
        paramArrayOfboolean[0] = ForgeHooksClient.onGuiKeyReleasedPre(this.Field123.currentScreen, paramInt2, paramInt3, paramInt4);
        if (!paramArrayOfboolean[0])
          paramArrayOfboolean[0] = paramINestedGuiEventHandler.keyReleased(paramInt2, paramInt3, paramInt4); 
        if (!paramArrayOfboolean[0])
          paramArrayOfboolean[0] = ForgeHooksClient.onGuiKeyReleasedPost(this.Field123.currentScreen, paramInt2, paramInt3, paramInt4); 
      } 
    } else {
      paramArrayOfboolean[0] = ForgeHooksClient.onGuiKeyPressedPre(this.Field123.currentScreen, paramInt2, paramInt3, paramInt4);
      if (!paramArrayOfboolean[0])
        paramArrayOfboolean[0] = paramINestedGuiEventHandler.keyPressed(paramInt2, paramInt3, paramInt4); 
      if (!paramArrayOfboolean[0])
        paramArrayOfboolean[0] = ForgeHooksClient.onGuiKeyPressedPost(this.Field123.currentScreen, paramInt2, paramInt3, paramInt4); 
    } 
  }
  
  private void Method161(ITextComponent paramITextComponent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   4: aload_0
    //   5: aload_1
    //   6: <illegal opcode> run : (LClass32;Lnet/minecraft/util/text/ITextComponent;)Ljava/lang/Runnable;
    //   11: invokevirtual execute : (Ljava/lang/Runnable;)V
    //   14: return
  }
  
  private void Method162(ITextComponent paramITextComponent) {
    this.Field123.ingameGUI.getChatGUI().printChatMessage(paramITextComponent);
  }
  
  private void Method163(ResourceLocation paramResourceLocation, Entity paramEntity, CompoundNBT paramCompoundNBT) {
    Method157(paramResourceLocation, paramEntity.getPositionVec(), paramCompoundNBT);
    Method155("debug.inspect.server.entity", new Object[0]);
  }
  
  private void Method164(BlockState paramBlockState, BlockPos paramBlockPos, CompoundNBT paramCompoundNBT) {
    Method156(paramBlockState, paramBlockPos, paramCompoundNBT);
    Method155("debug.inspect.server.block", new Object[0]);
  }
  
  private void Method165(char paramChar, int paramInt, IGuiEventListener paramIGuiEventListener) {
    if (ForgeHooksClient.onGuiCharTypedPre(this.Field123.currentScreen, paramChar, paramInt))
      return; 
    if (paramIGuiEventListener.charTyped(paramChar, paramInt))
      return; 
    ForgeHooksClient.onGuiCharTypedPost(this.Field123.currentScreen, paramChar, paramInt);
  }
  
  private void Method166(int paramInt1, int paramInt2, IGuiEventListener paramIGuiEventListener) {
    if (ForgeHooksClient.onGuiCharTypedPre(this.Field123.currentScreen, (char)paramInt1, paramInt2))
      return; 
    if (paramIGuiEventListener.charTyped((char)paramInt1, paramInt2))
      return; 
    ForgeHooksClient.onGuiCharTypedPost(this.Field123.currentScreen, (char)paramInt1, paramInt2);
  }
  
  private void Method167(long paramLong, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   4: aload_0
    //   5: lload_1
    //   6: iload_3
    //   7: iload #4
    //   9: <illegal opcode> run : (LClass32;JII)Ljava/lang/Runnable;
    //   14: invokevirtual execute : (Ljava/lang/Runnable;)V
    //   17: return
  }
  
  private void Method168(long paramLong, int paramInt1, int paramInt2) {
    Method154(paramLong, paramInt1, paramInt2);
  }
  
  private void Method169(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: getfield Field123 : Lnet/minecraft/client/Minecraft;
    //   4: aload_0
    //   5: lload_1
    //   6: iload_3
    //   7: iload #4
    //   9: iload #5
    //   11: iload #6
    //   13: <illegal opcode> run : (LClass32;JIIII)Ljava/lang/Runnable;
    //   18: invokevirtual execute : (Ljava/lang/Runnable;)V
    //   21: return
  }
  
  private void Method170(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    onKeyEvent(paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

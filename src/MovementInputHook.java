//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import java.util.Objects;
import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.multiplayer.PlayerController;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MovementInputHook extends MovementInputFromOptions {
  private final GameSettings Field63;
  
  private static final Minecraft Field64 = Minecraft.getInstance();
  
  private static boolean Field65;
  
  private static final Module Field66 = ModuleManager.Method39(17);
  
  private static final Module Field67 = ModuleManager.Method39(25);
  
  private static final Module Field68 = ModuleManager.Method39(26);
  
  public MovementInputHook(GameSettings paramGameSettings) {
    super(paramGameSettings);
    this.Field63 = paramGameSettings;
  }
  
  public void tickMovement(boolean paramBoolean) {
    this.forwardKeyDown = this.Field63.keyBindForward.isKeyDown();
    this.backKeyDown = this.Field63.keyBindBack.isKeyDown();
    this.leftKeyDown = this.Field63.keyBindLeft.isKeyDown();
    this.rightKeyDown = this.Field63.keyBindRight.isKeyDown();
    this.moveForward = (this.forwardKeyDown == this.backKeyDown) ? 0.0F : (this.forwardKeyDown ? 1.0F : -1.0F);
    this.moveStrafe = (this.leftKeyDown == this.rightKeyDown) ? 0.0F : (this.leftKeyDown ? 1.0F : -1.0F);
    this.jump = this.Field63.keyBindJump.isKeyDown();
    this.sneaking = this.Field63.keyBindSneak.isKeyDown();
    if (!SelfDestruct.Field181) {
      if (Field67.isToggled() && !(Field64.currentScreen instanceof net.minecraft.client.gui.screen.ChatScreen) && Field64.currentScreen != null) {
        this.moveStrafe = 0.0F;
        this.moveForward = 0.0F;
        if (Class14.Method201(this.Field63.keyBindForward.getKey().getKeyCode()))
          this.moveForward++; 
        if (Class14.Method201(this.Field63.keyBindBack.getKey().getKeyCode()))
          this.moveForward--; 
        if (Class14.Method201(this.Field63.keyBindLeft.getKey().getKeyCode()))
          this.moveStrafe++; 
        if (Class14.Method201(this.Field63.keyBindRight.getKey().getKeyCode()))
          this.moveStrafe--; 
        this.jump = Class14.Method201(32);
        boolean bool = ((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Field67.Method182(), 1))).Method79();
        if (bool)
          this.sneaking = Class14.Method201(this.Field63.keyBindSneak.getKey().getKeyCode()); 
        if (this.sneaking) {
          this.moveStrafe = (float)(this.moveStrafe * 0.3D);
          this.moveForward = (float)(this.moveForward * 0.3D);
        } 
      } 
      if (Field68.isToggled()) {
        Field64.player.setMotion((Field64.player.getMotion()).x, 0.0D, (Field64.player.getMotion()).z);
        if (Class14.Method201(Field64.gameSettings.keyBindJump.getKey().getKeyCode()))
          Field64.player.setMotion((Field64.player.getMotion()).x, 1.0D, (Field64.player.getMotion()).z); 
        if (Class14.Method201(Field64.gameSettings.keyBindSneak.getKey().getKeyCode()))
          Field64.player.setMotion((Field64.player.getMotion()).x, -1.0D, (Field64.player.getMotion()).z); 
        Field64.player.noClip = true;
        Field64.playerController = new PlayerController(Field64, Field64.getConnection());
        Method100(1.0D);
      } 
      if (Field66.isToggled()) {
        ClientPlayerEntity clientPlayerEntity = (Minecraft.getInstance()).player;
        boolean bool = ((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Field66.Method182(), 2))).Method79();
        if (clientPlayerEntity != null)
          if (!clientPlayerEntity.isBeingRidden() && clientPlayerEntity.isHandActive()) {
            if (bool) {
              KeyBinding.setKeyBindState(Field64.gameSettings.keyBindJump.getKey(), Field64.player.isOnGround());
              if (!Field64.player.isOnGround())
                if (!Field65) {
                  KeyBinding.setKeyBindState(Field64.gameSettings.keyBindLeft.getKey(), true);
                  KeyBinding.setKeyBindState(Field64.gameSettings.keyBindRight.getKey(), false);
                  Field65 = true;
                } else {
                  KeyBinding.setKeyBindState(Field64.gameSettings.keyBindLeft.getKey(), false);
                  KeyBinding.setKeyBindState(Field64.gameSettings.keyBindRight.getKey(), true);
                  Field65 = false;
                }  
            } 
            double d = ((Setting)Objects.<Setting>requireNonNull(SettingsStringManager.Method207(Field66.Method182(), 1))).Method81();
            this.moveStrafe = (float)(this.moveStrafe * d);
            this.moveForward = (float)(this.moveForward * d);
          } else if (bool) {
            if (!Class14.Method201(65))
              KeyBinding.setKeyBindState(Field64.gameSettings.keyBindLeft.getKey(), false); 
            if (!Class14.Method201(68))
              KeyBinding.setKeyBindState(Field64.gameSettings.keyBindRight.getKey(), false); 
          }  
      } 
    } 
    if (paramBoolean) {
      this.moveStrafe = (float)(this.moveStrafe * 0.3D);
      this.moveForward = (float)(this.moveForward * 0.3D);
    } 
  }
  
  public static void Method100(double paramDouble) {
    double d1 = Field64.player.movementInput.moveForward;
    double d2 = Field64.player.movementInput.moveStrafe;
    float f = Field64.player.rotationYaw;
    if (d1 == 0.0D && d2 == 0.0D) {
      Field64.player.setMotion(0.0D, (Field64.player.getMotion()).y, 0.0D);
    } else {
      if (d1 != 0.0D) {
        if (d2 > 0.0D) {
          f += ((d1 > 0.0D) ? -45 : 45);
        } else if (d2 < 0.0D) {
          f += ((d1 > 0.0D) ? 45 : -45);
        } 
        d2 = 0.0D;
        if (d1 > 0.0D) {
          d1 = 1.0D;
        } else if (d1 < 0.0D) {
          d1 = -1.0D;
        } 
      } 
      double d3 = Math.cos(Math.toRadians((f + 90.0F)));
      double d4 = Math.sin(Math.toRadians((f + 90.0F)));
      Field64.player.setMotion(d1 * paramDouble * d3 + d2 * paramDouble * d4, (Field64.player.getMotion()).y, d1 * paramDouble * d4 - d2 * paramDouble * d3);
    } 
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class34.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

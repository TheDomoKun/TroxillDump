//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.multiplayer.PlayerController;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.util.ClientRecipeBook;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.client.CClickWindowPacket;
import net.minecraft.network.play.client.CCreativeInventoryActionPacket;
import net.minecraft.network.play.client.CEnchantItemPacket;
import net.minecraft.network.play.client.CHeldItemChangePacket;
import net.minecraft.network.play.client.CPickItemPacket;
import net.minecraft.network.play.client.CPlaceRecipePacket;
import net.minecraft.network.play.client.CPlayerDiggingPacket;
import net.minecraft.network.play.client.CPlayerTryUseItemOnBlockPacket;
import net.minecraft.network.play.client.CPlayerTryUseItemPacket;
import net.minecraft.network.play.client.CUseEntityPacket;
import net.minecraft.stats.StatisticsManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameType;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class PlayerControllerHook extends PlayerController {
  private static final Logger Field7 = LogManager.getLogger();
  
  private final Minecraft Field8;
  
  private final ClientPlayNetHandler Field9;
  
  private BlockPos Field10 = new BlockPos(-1, -1, -1);
  
  private ItemStack Field11 = ItemStack.EMPTY;
  
  private float Field12;
  
  private float Field13;
  
  private int Field14 = 5;
  
  private boolean Field15;
  
  private GameType Field16 = GameType.NOT_SET;
  
  private GameType Field17 = GameType.NOT_SET;
  
  private final Object2ObjectLinkedOpenHashMap Field18 = new Object2ObjectLinkedOpenHashMap();
  
  private int Field19;
  
  public PlayerControllerHook(Minecraft paramMinecraft, ClientPlayNetHandler paramClientPlayNetHandler) {
    super(paramMinecraft, paramClientPlayNetHandler);
    this.Field8 = paramMinecraft;
    this.Field9 = paramClientPlayNetHandler;
  }
  
  public void setPlayerCapabilities(PlayerEntity paramPlayerEntity) {
    this.Field16.configurePlayerCapabilities(paramPlayerEntity.abilities);
  }
  
  public void setPreviousGameType(GameType paramGameType) {
    this.Field17 = paramGameType;
  }
  
  public void setGameType(GameType paramGameType) {
    if (paramGameType != this.Field16)
      this.Field17 = this.Field16; 
    this.Field16 = paramGameType;
    this.Field16.configurePlayerCapabilities(this.Field8.player.abilities);
  }
  
  public boolean shouldDrawHUD() {
    return this.Field16.isSurvivalOrAdventure();
  }
  
  public boolean onPlayerDestroyBlock(BlockPos paramBlockPos) {
    if (this.Field8.player.getHeldItemMainhand().onBlockStartBreak(paramBlockPos, (PlayerEntity)this.Field8.player))
      return false; 
    if (this.Field8.player.blockActionRestricted((World)this.Field8.world, paramBlockPos, this.Field16))
      return false; 
    ClientWorld clientWorld = this.Field8.world;
    BlockState blockState = clientWorld.getBlockState(paramBlockPos);
    if (!this.Field8.player.getHeldItemMainhand().getItem().canPlayerBreakBlockWhileHolding(blockState, (World)clientWorld, paramBlockPos, (PlayerEntity)this.Field8.player))
      return false; 
    Block block = blockState.getBlock();
    if ((block instanceof net.minecraft.block.CommandBlockBlock || block instanceof net.minecraft.block.StructureBlock || block instanceof net.minecraft.block.JigsawBlock) && !this.Field8.player.canUseCommandBlock())
      return false; 
    if (blockState.isAir((IBlockReader)clientWorld, paramBlockPos))
      return false; 
    FluidState fluidState = clientWorld.getFluidState(paramBlockPos);
    boolean bool = blockState.removedByPlayer((World)clientWorld, paramBlockPos, (PlayerEntity)this.Field8.player, false, fluidState);
    if (bool)
      block.onPlayerDestroy((IWorld)clientWorld, paramBlockPos, blockState); 
    return bool;
  }
  
  public boolean clickBlock(BlockPos paramBlockPos, Direction paramDirection) {
    if (this.Field8.player.blockActionRestricted((World)this.Field8.world, paramBlockPos, this.Field16))
      return false; 
    if (!this.Field8.world.getWorldBorder().contains(paramBlockPos))
      return false; 
    if (this.Field16.isCreative()) {
      BlockState blockState = this.Field8.world.getBlockState(paramBlockPos);
      this.Field8.getTutorial().onHitBlock(this.Field8.world, paramBlockPos, blockState, 1.0F);
      Method52(CPlayerDiggingPacket.Action.START_DESTROY_BLOCK, paramBlockPos, paramDirection);
      if (!ForgeHooks.onLeftClickBlock((PlayerEntity)this.Field8.player, paramBlockPos, paramDirection).isCanceled())
        onPlayerDestroyBlock(paramBlockPos); 
      this.Field14 = 5;
    } else if (!this.Field15 || !Method49(paramBlockPos)) {
      if (this.Field15)
        Method52(CPlayerDiggingPacket.Action.ABORT_DESTROY_BLOCK, this.Field10, paramDirection); 
      PlayerInteractEvent.LeftClickBlock leftClickBlock = ForgeHooks.onLeftClickBlock((PlayerEntity)this.Field8.player, paramBlockPos, paramDirection);
      BlockState blockState = this.Field8.world.getBlockState(paramBlockPos);
      this.Field8.getTutorial().onHitBlock(this.Field8.world, paramBlockPos, blockState, 0.0F);
      Method52(CPlayerDiggingPacket.Action.START_DESTROY_BLOCK, paramBlockPos, paramDirection);
      boolean bool = !blockState.isAir((IBlockReader)this.Field8.world, paramBlockPos) ? true : false;
      if (bool && this.Field12 == 0.0F && leftClickBlock.getUseBlock() != Event.Result.DENY)
        blockState.onBlockClicked((World)this.Field8.world, paramBlockPos, (PlayerEntity)this.Field8.player); 
      if (leftClickBlock.getUseItem() == Event.Result.DENY)
        return true; 
      if (bool && blockState.getPlayerRelativeBlockHardness((PlayerEntity)this.Field8.player, (IBlockReader)this.Field8.player.world, paramBlockPos) >= 1.0F) {
        onPlayerDestroyBlock(paramBlockPos);
      } else {
        this.Field15 = true;
        this.Field10 = paramBlockPos;
        this.Field11 = this.Field8.player.getHeldItemMainhand();
        this.Field12 = 0.0F;
        this.Field13 = 0.0F;
        this.Field8.world.sendBlockBreakProgress(this.Field8.player.getEntityId(), this.Field10, (int)(this.Field12 * 10.0F) - 1);
      } 
    } 
    return true;
  }
  
  public void resetBlockRemoving() {
    if (this.Field15) {
      BlockState blockState = this.Field8.world.getBlockState(this.Field10);
      this.Field8.getTutorial().onHitBlock(this.Field8.world, this.Field10, blockState, -1.0F);
      Method52(CPlayerDiggingPacket.Action.ABORT_DESTROY_BLOCK, this.Field10, Direction.DOWN);
      this.Field15 = false;
      this.Field12 = 0.0F;
      this.Field8.world.sendBlockBreakProgress(this.Field8.player.getEntityId(), this.Field10, -1);
      this.Field8.player.resetCooldown();
    } 
  }
  
  public boolean onPlayerDamageBlock(BlockPos paramBlockPos, Direction paramDirection) {
    Method50();
    if (this.Field14 > 0) {
      this.Field14--;
      return true;
    } 
    if (this.Field16.isCreative() && this.Field8.world.getWorldBorder().contains(paramBlockPos)) {
      this.Field14 = 5;
      BlockState blockState = this.Field8.world.getBlockState(paramBlockPos);
      this.Field8.getTutorial().onHitBlock(this.Field8.world, paramBlockPos, blockState, 1.0F);
      Method52(CPlayerDiggingPacket.Action.START_DESTROY_BLOCK, paramBlockPos, paramDirection);
      if (!ForgeHooks.onLeftClickBlock((PlayerEntity)this.Field8.player, paramBlockPos, paramDirection).isCanceled())
        onPlayerDestroyBlock(paramBlockPos); 
      return true;
    } 
    if (Method49(paramBlockPos)) {
      BlockState blockState = this.Field8.world.getBlockState(paramBlockPos);
      if (blockState.isAir((IBlockReader)this.Field8.world, paramBlockPos)) {
        this.Field15 = false;
        return false;
      } 
      this.Field12 += blockState.getPlayerRelativeBlockHardness((PlayerEntity)this.Field8.player, (IBlockReader)this.Field8.player.world, paramBlockPos);
      if (this.Field13 % 4.0F == 0.0F) {
        SoundType soundType = blockState.getSoundType((IWorldReader)this.Field8.world, paramBlockPos, (Entity)this.Field8.player);
        this.Field8.getSoundHandler().play((ISound)new SimpleSound(soundType.getHitSound(), SoundCategory.BLOCKS, (soundType.getVolume() + 1.0F) / 8.0F, soundType.getPitch() * 0.5F, paramBlockPos));
      } 
      this.Field13++;
      this.Field8.getTutorial().onHitBlock(this.Field8.world, paramBlockPos, blockState, MathHelper.clamp(this.Field12, 0.0F, 1.0F));
      if (ForgeHooks.onLeftClickBlock((PlayerEntity)this.Field8.player, paramBlockPos, paramDirection).getUseItem() == Event.Result.DENY)
        return true; 
      if (this.Field12 >= 1.0F) {
        this.Field15 = false;
        Method52(CPlayerDiggingPacket.Action.STOP_DESTROY_BLOCK, paramBlockPos, paramDirection);
        onPlayerDestroyBlock(paramBlockPos);
        this.Field12 = 0.0F;
        this.Field13 = 0.0F;
        this.Field14 = 5;
      } 
      this.Field8.world.sendBlockBreakProgress(this.Field8.player.getEntityId(), this.Field10, (int)(this.Field12 * 10.0F) - 1);
      return true;
    } 
    return clickBlock(paramBlockPos, paramDirection);
  }
  
  public float getBlockReachDistance() {
    float f = (float)this.Field8.player.getAttribute((Attribute)ForgeMod.REACH_DISTANCE.get()).getValue();
    return this.Field16.isCreative() ? f : (f - 0.5F);
  }
  
  public void tick() {
    Method50();
    if (this.Field9.getNetworkManager().isChannelOpen()) {
      this.Field9.getNetworkManager().tick();
    } else {
      this.Field9.getNetworkManager().handleDisconnection();
    } 
  }
  
  private boolean Method49(BlockPos paramBlockPos) {
    ItemStack itemStack = this.Field8.player.getHeldItemMainhand();
    boolean bool = (this.Field11.isEmpty() && itemStack.isEmpty()) ? true : false;
    if (!this.Field11.isEmpty() && !itemStack.isEmpty())
      bool = !this.Field11.shouldCauseBlockBreakReset(itemStack) ? true : false; 
    return (paramBlockPos.equals(this.Field10) && bool);
  }
  
  private void Method50() {
    int i = this.Field8.player.inventory.currentItem;
    if (i != this.Field19) {
      this.Field19 = i;
      this.Field9.sendPacket((IPacket)new CHeldItemChangePacket(this.Field19));
    } 
  }
  
  public ActionResultType func_217292_a(ClientPlayerEntity paramClientPlayerEntity, ClientWorld paramClientWorld, Hand paramHand, BlockRayTraceResult paramBlockRayTraceResult) {
    Method50();
    BlockPos blockPos = paramBlockRayTraceResult.getPos();
    if (!this.Field8.world.getWorldBorder().contains(blockPos))
      return ActionResultType.FAIL; 
    ItemStack itemStack = paramClientPlayerEntity.getHeldItem(paramHand);
    PlayerInteractEvent.RightClickBlock rightClickBlock = ForgeHooks.onRightClickBlock((PlayerEntity)paramClientPlayerEntity, paramHand, blockPos, paramBlockRayTraceResult);
    if (rightClickBlock.isCanceled()) {
      this.Field9.sendPacket((IPacket)new CPlayerTryUseItemOnBlockPacket(paramHand, paramBlockRayTraceResult));
      return rightClickBlock.getCancellationResult();
    } 
    if (this.Field16 == GameType.SPECTATOR) {
      this.Field9.sendPacket((IPacket)new CPlayerTryUseItemOnBlockPacket(paramHand, paramBlockRayTraceResult));
      return ActionResultType.SUCCESS;
    } 
    ItemUseContext itemUseContext = new ItemUseContext((PlayerEntity)paramClientPlayerEntity, paramHand, paramBlockRayTraceResult);
    if (rightClickBlock.getUseItem() != Event.Result.DENY) {
      ActionResultType actionResultType = itemStack.onItemUseFirst(itemUseContext);
      if (actionResultType != ActionResultType.PASS) {
        this.Field9.sendPacket((IPacket)new CPlayerTryUseItemOnBlockPacket(paramHand, paramBlockRayTraceResult));
        return actionResultType;
      } 
    } 
    boolean bool1 = (!paramClientPlayerEntity.getHeldItemMainhand().doesSneakBypassUse((IWorldReader)paramClientWorld, blockPos, (PlayerEntity)paramClientPlayerEntity) || !paramClientPlayerEntity.getHeldItemOffhand().doesSneakBypassUse((IWorldReader)paramClientWorld, blockPos, (PlayerEntity)paramClientPlayerEntity)) ? true : false;
    boolean bool2 = (paramClientPlayerEntity.isSecondaryUseActive() && bool1) ? true : false;
    if (rightClickBlock.getUseBlock() == Event.Result.ALLOW || (rightClickBlock.getUseBlock() != Event.Result.DENY && !bool2)) {
      ActionResultType actionResultType = paramClientWorld.getBlockState(blockPos).onBlockActivated((World)paramClientWorld, (PlayerEntity)paramClientPlayerEntity, paramHand, paramBlockRayTraceResult);
      if (actionResultType.isSuccessOrConsume()) {
        this.Field9.sendPacket((IPacket)new CPlayerTryUseItemOnBlockPacket(paramHand, paramBlockRayTraceResult));
        return actionResultType;
      } 
    } 
    this.Field9.sendPacket((IPacket)new CPlayerTryUseItemOnBlockPacket(paramHand, paramBlockRayTraceResult));
    if (rightClickBlock.getUseItem() == Event.Result.DENY)
      return ActionResultType.PASS; 
    if (rightClickBlock.getUseItem() == Event.Result.ALLOW || (!itemStack.isEmpty() && !paramClientPlayerEntity.getCooldownTracker().hasCooldown(itemStack.getItem()))) {
      ActionResultType actionResultType;
      if (this.Field16.isCreative()) {
        int i = itemStack.getCount();
        actionResultType = itemStack.onItemUse(itemUseContext);
        itemStack.setCount(i);
      } else {
        actionResultType = itemStack.onItemUse(itemUseContext);
      } 
      return actionResultType;
    } 
    return ActionResultType.PASS;
  }
  
  public ActionResultType processRightClick(PlayerEntity paramPlayerEntity, World paramWorld, Hand paramHand) {
    if (this.Field16 == GameType.SPECTATOR)
      return ActionResultType.PASS; 
    Method50();
    this.Field9.sendPacket((IPacket)new CPlayerTryUseItemPacket(paramHand));
    ItemStack itemStack1 = paramPlayerEntity.getHeldItem(paramHand);
    if (paramPlayerEntity.getCooldownTracker().hasCooldown(itemStack1.getItem()))
      return ActionResultType.PASS; 
    ActionResultType actionResultType = ForgeHooks.onItemRightClick(paramPlayerEntity, paramHand);
    if (actionResultType != null)
      return actionResultType; 
    int i = itemStack1.getCount();
    ActionResult actionResult = itemStack1.useItemRightClick(paramWorld, paramPlayerEntity, paramHand);
    ItemStack itemStack2 = (ItemStack)actionResult.getResult();
    if (itemStack2 != itemStack1) {
      paramPlayerEntity.setHeldItem(paramHand, itemStack2);
      if (itemStack2.isEmpty())
        ForgeEventFactory.onPlayerDestroyItem(paramPlayerEntity, itemStack1, paramHand); 
    } 
    return actionResult.getType();
  }
  
  public ClientPlayerEntity createPlayer(ClientWorld paramClientWorld, StatisticsManager paramStatisticsManager, ClientRecipeBook paramClientRecipeBook) {
    return createPlayer(paramClientWorld, paramStatisticsManager, paramClientRecipeBook, false, false);
  }
  
  public ClientPlayerEntity createPlayer(ClientWorld paramClientWorld, StatisticsManager paramStatisticsManager, ClientRecipeBook paramClientRecipeBook, boolean paramBoolean1, boolean paramBoolean2) {
    return new ClientPlayerEntity(this.Field8, paramClientWorld, this.Field9, paramStatisticsManager, paramClientRecipeBook, paramBoolean1, paramBoolean2);
  }
  
  public void attackEntity(PlayerEntity paramPlayerEntity, Entity paramEntity) {
    Method50();
    this.Field9.sendPacket((IPacket)new CUseEntityPacket(paramEntity, paramPlayerEntity.isSneaking()));
    if (this.Field16 != GameType.SPECTATOR) {
      paramPlayerEntity.attackTargetEntityWithCurrentItem(paramEntity);
      paramPlayerEntity.resetCooldown();
      new CustomPlayerEvent(paramPlayerEntity, paramEntity);
    } 
  }
  
  public void Method51(PlayerEntity paramPlayerEntity, Entity paramEntity) {
    Method50();
    this.Field9.sendPacket((IPacket)new CUseEntityPacket(paramEntity, paramPlayerEntity.isSneaking()));
    if (this.Field16 != GameType.SPECTATOR) {
      paramPlayerEntity.attackTargetEntityWithCurrentItem(paramEntity);
      paramPlayerEntity.resetCooldown();
    } 
  }
  
  public ActionResultType interactWithEntity(PlayerEntity paramPlayerEntity, Entity paramEntity, Hand paramHand) {
    Method50();
    this.Field9.sendPacket((IPacket)new CUseEntityPacket(paramEntity, paramHand, paramPlayerEntity.isSneaking()));
    if (this.Field16 == GameType.SPECTATOR)
      return ActionResultType.PASS; 
    ActionResultType actionResultType = ForgeHooks.onInteractEntity(paramPlayerEntity, paramEntity, paramHand);
    return (actionResultType != null) ? actionResultType : ((this.Field16 == GameType.SPECTATOR) ? ActionResultType.PASS : paramPlayerEntity.interactOn(paramEntity, paramHand));
  }
  
  public ActionResultType interactWithEntity(PlayerEntity paramPlayerEntity, Entity paramEntity, EntityRayTraceResult paramEntityRayTraceResult, Hand paramHand) {
    Method50();
    Vector3d vector3d = paramEntityRayTraceResult.getHitVec().subtract(paramEntity.getPosX(), paramEntity.getPosY(), paramEntity.getPosZ());
    this.Field9.sendPacket((IPacket)new CUseEntityPacket(paramEntity, paramHand, vector3d, paramPlayerEntity.isSneaking()));
    if (this.Field16 == GameType.SPECTATOR)
      return ActionResultType.PASS; 
    ActionResultType actionResultType = ForgeHooks.onInteractEntityAt(paramPlayerEntity, paramEntity, (RayTraceResult)paramEntityRayTraceResult, paramHand);
    return (actionResultType != null) ? actionResultType : ((this.Field16 == GameType.SPECTATOR) ? ActionResultType.PASS : paramEntity.applyPlayerInteraction(paramPlayerEntity, vector3d, paramHand));
  }
  
  public ItemStack windowClick(int paramInt1, int paramInt2, int paramInt3, ClickType paramClickType, PlayerEntity paramPlayerEntity) {
    short s = paramPlayerEntity.openContainer.getNextTransactionID(paramPlayerEntity.inventory);
    ItemStack itemStack = paramPlayerEntity.openContainer.slotClick(paramInt2, paramInt3, paramClickType, paramPlayerEntity);
    this.Field9.sendPacket((IPacket)new CClickWindowPacket(paramInt1, paramInt2, paramInt3, paramClickType, itemStack, s));
    return itemStack;
  }
  
  public void sendPlaceRecipePacket(int paramInt, IRecipe paramIRecipe, boolean paramBoolean) {
    this.Field9.sendPacket((IPacket)new CPlaceRecipePacket(paramInt, paramIRecipe, paramBoolean));
  }
  
  public void sendEnchantPacket(int paramInt1, int paramInt2) {
    this.Field9.sendPacket((IPacket)new CEnchantItemPacket(paramInt1, paramInt2));
  }
  
  public void sendSlotPacket(ItemStack paramItemStack, int paramInt) {
    if (this.Field16.isCreative())
      this.Field9.sendPacket((IPacket)new CCreativeInventoryActionPacket(paramInt, paramItemStack)); 
  }
  
  public void sendPacketDropItem(ItemStack paramItemStack) {
    if (this.Field16.isCreative() && !paramItemStack.isEmpty())
      this.Field9.sendPacket((IPacket)new CCreativeInventoryActionPacket(-1, paramItemStack)); 
  }
  
  public void onStoppedUsingItem(PlayerEntity paramPlayerEntity) {
    Method50();
    this.Field9.sendPacket((IPacket)new CPlayerDiggingPacket(CPlayerDiggingPacket.Action.RELEASE_USE_ITEM, BlockPos.ZERO, Direction.DOWN));
    paramPlayerEntity.stopActiveHand();
  }
  
  public boolean gameIsSurvivalOrAdventure() {
    return this.Field16.isSurvivalOrAdventure();
  }
  
  public boolean isNotCreative() {
    return !this.Field16.isCreative();
  }
  
  public boolean isInCreativeMode() {
    return this.Field16.isCreative();
  }
  
  public boolean extendedReach() {
    return this.Field16.isCreative();
  }
  
  public boolean isRidingHorse() {
    return (this.Field8.player.isPassenger() && this.Field8.player.getRidingEntity() instanceof net.minecraft.entity.passive.horse.AbstractHorseEntity);
  }
  
  public boolean isSpectatorMode() {
    return (this.Field16 == GameType.SPECTATOR);
  }
  
  public GameType getPreviousGameType() {
    return this.Field17;
  }
  
  public GameType getCurrentGameType() {
    return this.Field16;
  }
  
  public boolean getIsHittingBlock() {
    return this.Field15;
  }
  
  public void pickItem(int paramInt) {
    this.Field9.sendPacket((IPacket)new CPickItemPacket(paramInt));
  }
  
  private void Method52(CPlayerDiggingPacket.Action paramAction, BlockPos paramBlockPos, Direction paramDirection) {
    ClientPlayerEntity clientPlayerEntity = this.Field8.player;
    this.Field18.put(Pair.of(paramBlockPos, paramAction), clientPlayerEntity.getPositionVec());
    this.Field9.sendPacket((IPacket)new CPlayerDiggingPacket(paramAction, paramBlockPos, paramDirection));
  }
  
  public void acknowledgePlayerDiggingReceived(ClientWorld paramClientWorld, BlockPos paramBlockPos, BlockState paramBlockState, CPlayerDiggingPacket.Action paramAction, boolean paramBoolean) {
    Vector3d vector3d = (Vector3d)this.Field18.remove(Pair.of(paramBlockPos, paramAction));
    BlockState blockState = paramClientWorld.getBlockState(paramBlockPos);
    if ((vector3d == null || !paramBoolean || (paramAction != CPlayerDiggingPacket.Action.START_DESTROY_BLOCK && blockState != paramBlockState)) && blockState != paramBlockState) {
      paramClientWorld.invalidateRegionAndSetBlock(paramBlockPos, paramBlockState);
      ClientPlayerEntity clientPlayerEntity = this.Field8.player;
      if (vector3d != null && paramClientWorld == ((PlayerEntity)clientPlayerEntity).world && clientPlayerEntity.func_242278_a(paramBlockPos, paramBlockState))
        clientPlayerEntity.setPositionWithinBounds(vector3d.x, vector3d.y, vector3d.z); 
    } 
    while (this.Field18.size() >= 50) {
      Pair pair = (Pair)this.Field18.firstKey();
      this.Field18.removeFirst();
      Field7.error("Too many unacked block actions, dropping " + pair);
    } 
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class29.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

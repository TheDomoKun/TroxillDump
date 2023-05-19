//Deobfuscated and remapped by TheDomoKun https://github.com/TheDomoKun/TroxillDump

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;

public class RenderUtils {
  private static final Minecraft Field1 = Minecraft.getInstance();
  
  public static void Method4(AxisAlignedBB paramAxisAlignedBB, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    Method8();
    Tessellator tessellator = Tessellator.getInstance();
    BufferBuilder bufferBuilder = tessellator.getBuffer();
    bufferBuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);
    WorldRenderer.drawBoundingBox(new MatrixStack(), (IVertexBuilder)bufferBuilder, paramAxisAlignedBB.minX, paramAxisAlignedBB.minY, paramAxisAlignedBB.minZ, paramAxisAlignedBB.maxX, paramAxisAlignedBB.maxY, paramAxisAlignedBB.maxZ, paramFloat1, paramFloat2, paramFloat3, paramFloat4 / 2.0F);
    tessellator.draw();
    bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
    bufferBuilder.pos(paramAxisAlignedBB.minX, paramAxisAlignedBB.minY, paramAxisAlignedBB.minZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(paramAxisAlignedBB.minX, paramAxisAlignedBB.minY, paramAxisAlignedBB.maxZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(paramAxisAlignedBB.maxX, paramAxisAlignedBB.minY, paramAxisAlignedBB.maxZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(paramAxisAlignedBB.maxX, paramAxisAlignedBB.minY, paramAxisAlignedBB.minZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(paramAxisAlignedBB.minX, paramAxisAlignedBB.minY, paramAxisAlignedBB.minZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(paramAxisAlignedBB.minX, paramAxisAlignedBB.maxY, paramAxisAlignedBB.minZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(paramAxisAlignedBB.maxX, paramAxisAlignedBB.maxY, paramAxisAlignedBB.minZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(paramAxisAlignedBB.maxX, paramAxisAlignedBB.maxY, paramAxisAlignedBB.maxZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(paramAxisAlignedBB.minX, paramAxisAlignedBB.maxY, paramAxisAlignedBB.maxZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(paramAxisAlignedBB.minX, paramAxisAlignedBB.maxY, paramAxisAlignedBB.minZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(paramAxisAlignedBB.minX, paramAxisAlignedBB.minY, paramAxisAlignedBB.maxZ).color(paramFloat1, paramFloat2, paramFloat3, 0.0F).endVertex();
    bufferBuilder.pos(paramAxisAlignedBB.minX, paramAxisAlignedBB.maxY, paramAxisAlignedBB.maxZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(paramAxisAlignedBB.maxX, paramAxisAlignedBB.minY, paramAxisAlignedBB.maxZ).color(paramFloat1, paramFloat2, paramFloat3, 0.0F).endVertex();
    bufferBuilder.pos(paramAxisAlignedBB.maxX, paramAxisAlignedBB.maxY, paramAxisAlignedBB.maxZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(paramAxisAlignedBB.maxX, paramAxisAlignedBB.minY, paramAxisAlignedBB.minZ).color(paramFloat1, paramFloat2, paramFloat3, 0.0F).endVertex();
    bufferBuilder.pos(paramAxisAlignedBB.maxX, paramAxisAlignedBB.maxY, paramAxisAlignedBB.minZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    tessellator.draw();
    Method9();
  }
  
  public static void Method5(AxisAlignedBB paramAxisAlignedBB, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    Method8();
    AxisAlignedBB axisAlignedBB = new AxisAlignedBB(paramAxisAlignedBB.minX - 0.1D, paramAxisAlignedBB.minY - 1.8D, paramAxisAlignedBB.minZ - 0.1D, paramAxisAlignedBB.maxX + 0.1D, paramAxisAlignedBB.maxY - 1.5D, paramAxisAlignedBB.maxZ + 0.1D);
    Tessellator tessellator = Tessellator.getInstance();
    BufferBuilder bufferBuilder = tessellator.getBuffer();
    bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
    bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(paramFloat1, paramFloat2, paramFloat3, 0.0F).endVertex();
    bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(paramFloat1, paramFloat2, paramFloat3, 0.0F).endVertex();
    bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(paramFloat1, paramFloat2, paramFloat3, 0.0F).endVertex();
    bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(paramFloat1, paramFloat2, paramFloat3, paramFloat4).endVertex();
    tessellator.draw();
    Method9();
  }
  
  public static void Method6(MatrixStack paramMatrixStack, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt) {
    if (paramDouble1 < paramDouble3) {
      double d = paramDouble1;
      paramDouble1 = paramDouble3;
      paramDouble3 = d;
    } 
    if (paramDouble2 < paramDouble4) {
      double d = paramDouble2;
      paramDouble2 = paramDouble4;
      paramDouble4 = d;
    } 
    float f1 = (paramInt >> 24 & 0xFF) / 255.0F;
    float f2 = (paramInt >> 16 & 0xFF) / 255.0F;
    float f3 = (paramInt >> 8 & 0xFF) / 255.0F;
    float f4 = (paramInt & 0xFF) / 255.0F;
    BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
    RenderSystem.enableBlend();
    RenderSystem.disableTexture();
    RenderSystem.defaultBlendFunc();
    Matrix4f matrix4f = paramMatrixStack.getLast().getMatrix();
    bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
    bufferBuilder.pos(matrix4f, (float)paramDouble1, (float)paramDouble4, 0.0F).color(f2, f3, f4, f1).endVertex();
    bufferBuilder.pos(matrix4f, (float)paramDouble3, (float)paramDouble4, 0.0F).color(f2, f3, f4, f1).endVertex();
    bufferBuilder.pos(matrix4f, (float)paramDouble3, (float)paramDouble2, 0.0F).color(f2, f3, f4, f1).endVertex();
    bufferBuilder.pos(matrix4f, (float)paramDouble1, (float)paramDouble2, 0.0F).color(f2, f3, f4, f1).endVertex();
    bufferBuilder.finishDrawing();
    WorldVertexBufferUploader.draw(bufferBuilder);
    RenderSystem.enableTexture();
    RenderSystem.disableBlend();
  }
  
  public static void Method7() {
    Vector3d vector3d = (Minecraft.getInstance()).renderViewEntity.getPositionVec();
    GL11.glRotated(MathHelper.wrapDegrees(((Minecraft.getInstance()).renderViewEntity.getPitchYaw()).x), 1.0D, 0.0D, 0.0D);
    GL11.glRotated(MathHelper.wrapDegrees(((Minecraft.getInstance()).renderViewEntity.getPitchYaw()).y + 180.0D), 0.0D, 1.0D, 0.0D);
    GL11.glTranslated(-vector3d.x, -vector3d.y, -vector3d.z);
  }
  
  public static void Method8() {
    GL11.glPushMatrix();
    GL11.glEnable(3042);
    GL14.glBlendFuncSeparate(770, 771, 1, 0);
    GL11.glLineWidth(2.5F);
    GL11.glDisable(3553);
    GL11.glEnable(2848);
    Method7();
  }
  
  public static void Method9() {
    GL11.glDisable(2848);
    GL11.glEnable(3553);
    GL11.glDisable(3042);
    GL11.glPopMatrix();
  }
  
  public static void Method10(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    Method8();
    GL11.glLineWidth(paramFloat4);
    Tessellator tessellator = Tessellator.getInstance();
    BufferBuilder bufferBuilder = tessellator.getBuffer();
    bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
    bufferBuilder.pos(paramDouble1, paramDouble2, paramDouble3).color(paramFloat1, paramFloat2, paramFloat3, 0.0F).endVertex();
    bufferBuilder.pos(paramDouble1, paramDouble2, paramDouble3).color(paramFloat1, paramFloat2, paramFloat3, 1.0F).endVertex();
    bufferBuilder.pos(paramDouble4, paramDouble5, paramDouble6).color(paramFloat1, paramFloat2, paramFloat3, 1.0F).endVertex();
    tessellator.draw();
    Method9();
  }
  
  public static void Method11(float paramFloat1, float paramFloat2, float paramFloat3, Color paramColor) {
    char c = 'Ũ';
    double d = 6.283185307179586D / c;
    GL11.glPushAttrib(8192);
    GL11.glEnable(3042);
    GL11.glDisable(3553);
    GL11.glBlendFunc(770, 771);
    GL11.glEnable(2848);
    GL11.glBegin(6);
    GL11.glColor4f(paramColor.getRed() / 255.0F, paramColor.getGreen() / 255.0F, paramColor.getBlue() / 255.0F, paramColor.getAlpha() / 255.0F);
    for (byte b = 0; b < c; b++) {
      float f1 = (float)(paramFloat3 * Math.sin(b * d));
      float f2 = (float)(paramFloat3 * Math.cos(b * d));
      GL11.glColor4f(paramColor.getRed() / 255.0F, paramColor.getGreen() / 255.0F, paramColor.getBlue() / 255.0F, paramColor.getAlpha() / 255.0F);
      GL11.glVertex2f(paramFloat1 + f1, paramFloat2 + f2);
    } 
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    GL11.glEnd();
    GL11.glPopAttrib();
  }
  
  public static void Method12(MatrixStack paramMatrixStack, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Color paramColor) {
    Method11(paramInt1, paramInt2, paramInt5, paramColor);
    Method11(paramInt1, paramInt4, paramInt5, paramColor);
    Method11(paramInt3, paramInt2, paramInt5, paramColor);
    Method11(paramInt3, paramInt4, paramInt5, paramColor);
    ClickGuiManager.fill(paramMatrixStack, paramInt1, paramInt2 - paramInt5, paramInt3, paramInt4 + paramInt5, paramColor.getRGB());
    ClickGuiManager.fill(paramMatrixStack, paramInt1 - paramInt5, paramInt2, paramInt3 + paramInt5, paramInt4, paramColor.getRGB());
  }
  
  public static void Method13() {
    Field1.gameRenderer.getLightTexture().disableLightmap();
    GL11.glEnable(3042);
    GL11.glEnable(3042);
    GL11.glBlendFunc(770, 771);
    GL11.glEnable(2848);
    GL11.glDisable(2896);
    GL11.glDisable(3553);
    GL11.glDisable(2929);
    GL11.glDepthMask(false);
  }
  
  public static void Method14() {
    GL11.glDisable(3042);
    GL11.glEnable(2896);
    GL11.glEnable(3553);
    GL11.glDisable(2848);
    GL11.glDisable(3042);
    GL11.glEnable(2929);
    GL11.glDepthMask(true);
    Field1.gameRenderer.getLightTexture().enableLightmap();
  }
  
  public static void Method15(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9, double paramDouble10) {
    GL11.glPushMatrix();
    Method13();
    GL11.glEnable(2848);
    GL11.glColor4d(paramDouble7, paramDouble8, paramDouble9, paramDouble10);
    GL11.glLineWidth(1.0F);
    GL11.glBegin(2);
    GL11.glVertex3d(paramDouble1, paramDouble2, paramDouble3);
    GL11.glVertex3d(paramDouble4, paramDouble5, paramDouble6);
    GL11.glEnd();
    Method14();
    GL11.glPopMatrix();
  }
}


/* Location:              D:\Deobfuscator-master\test\deobf2\GOV.jar!\Class22.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */

package net.rinkablu.lochwood.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.rinkablu.lochwood.Lockwood;
import net.rinkablu.lochwood.entity.custom.UnicornEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.rinkablu.lochwood.Lockwood;
import net.rinkablu.lochwood.entity.client.UnicornModel;
import net.rinkablu.lochwood.entity.custom.UnicornEntity;

public class UnicornRenderer extends MobRenderer<UnicornEntity, UnicornModel<UnicornEntity>> {
    public UnicornRenderer(EntityRendererProvider.Context context) {
        super(context, new UnicornModel<>(context.bakeLayer(UnicornModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(UnicornEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Lockwood.MOD_ID, "textures/entity/unicorn/unicorn_red.png");
    }

    @Override
    public void render(UnicornEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
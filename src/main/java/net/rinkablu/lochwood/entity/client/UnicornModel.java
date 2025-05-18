package net.rinkablu.lochwood.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.rinkablu.lochwood.entity.custom.UnicornEntity;



    public class UnicornModel<T extends UnicornEntity> extends HierarchicalModel<T> {
        // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
        public static final ModelLayerLocation LAYER_LOCATION =
                new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("Lockwood.MOD_ID", "unicorn"), "main");

        private final ModelPart unicorn;
        private final ModelPart body;
        private final ModelPart head;


        public UnicornModel(ModelPart root) {
            this.unicorn = root.getChild("unicorn");
            this.body = this.unicorn.getChild("body");
            this.head = this.body.getChild("head");


        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();

            PartDefinition unicorn = partdefinition.addOrReplaceChild("unicorn", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

            PartDefinition body = unicorn.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 63).addBox(0.0F, 3.0F, 0.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 0).addBox(-4.0F, -5.0F, -7.0F, 8.0F, 9.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, -2.0F));

            PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 51).addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 7.5F));

            PartDefinition tail3 = tail.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(52, 22).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 10.5F));

            PartDefinition tailtuft = tail3.addOrReplaceChild("tailtuft", CubeListBuilder.create().texOffs(29, 25).addBox(0.0F, -2.5F, 1.0F, 0.0F, 10.0F, 11.0F, new CubeDeformation(0.0F))
                    .texOffs(52, 34).addBox(-2.0F, -0.5F, 0.0F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 9.0F));

            PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(47, 0).addBox(0.0F, -13.5F, -1.0F, 0.0F, 12.0F, 9.0F, new CubeDeformation(0.0F))
                    .texOffs(28, 77).addBox(0.0F, -3.5F, -6.0F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 25).addBox(-2.5F, -10.5F, -4.0F, 5.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.5F, -6.0F));

            PartDefinition Head = neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(101, 43).mirror().addBox(1.0F, -4.5197F, -0.5035F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                    .texOffs(71, 46).addBox(-3.0F, -4.5197F, -0.5035F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(29, 47).addBox(-3.0F, -1.5197F, -6.5035F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.001F))
                    .texOffs(55, 69).addBox(-1.5F, 0.4803F, -9.5035F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                    .texOffs(29, 71).addBox(0.0F, 3.4803F, -5.5035F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.9803F, -1.4965F));

            PartDefinition facefur_r1 = Head.addOrReplaceChild("facefur_r1", CubeListBuilder.create().texOffs(3, 1).mirror().addBox(-4.0F, -4.0F, 1.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 3.4803F, -1.5035F, -0.26F, 0.9222F, 0.0552F));

            PartDefinition facefur_r2 = Head.addOrReplaceChild("facefur_r2", CubeListBuilder.create().texOffs(3, 8).addBox(-1.0F, -4.0F, 1.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 3.4803F, -1.5035F, -0.26F, -0.9222F, -0.0552F));

            PartDefinition eyes = Head.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(99, 34).addBox(3.0F, -2.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.002F))
                    .texOffs(66, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.002F)), PartPose.offset(-2.0F, 1.4803F, -5.5035F));

            PartDefinition horn = Head.addOrReplaceChild("horn", CubeListBuilder.create().texOffs(12, 76).addBox(-1.0F, 3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                    .texOffs(6, 75).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(5, 80).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5197F, -4.5035F, 0.2618F, 0.0F, 0.0F));

            PartDefinition legs = unicorn.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(-1.0F, -3.0F, 13.0F));

            PartDefinition BR = legs.addOrReplaceChild("BR", CubeListBuilder.create().texOffs(23, 60).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offset(-1.5F, -9.5F, -9.5F));

            PartDefinition BRB = BR.addOrReplaceChild("BRB", CubeListBuilder.create().texOffs(68, 69).addBox(0.0F, 0.0F, 2.8333F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                    .texOffs(66, 0).addBox(-1.5F, 4.0F, -1.1667F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.09F))
                    .texOffs(40, 60).addBox(-1.5F, 0.0F, -1.1667F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.5F, 0.6667F));

            PartDefinition FR = legs.addOrReplaceChild("FR", CubeListBuilder.create().texOffs(56, 46).addBox(-1.5F, -0.1667F, -2.1667F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
                    .texOffs(22, 71).addBox(0.0F, 1.8333F, 1.8333F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                    .texOffs(66, 8).addBox(-1.5F, 4.8333F, -2.1667F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.09F)), PartPose.offset(-1.5F, -6.8333F, -19.8333F));

            PartDefinition FL = legs.addOrReplaceChild("FL", CubeListBuilder.create().texOffs(98, 52).mirror().addBox(-1.5F, -0.1667F, -2.1667F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                    .texOffs(80, 67).mirror().addBox(0.0F, 1.8333F, 1.8333F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                    .texOffs(82, 42).mirror().addBox(-1.5F, 4.8333F, -2.1667F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.09F)).mirror(false), PartPose.offset(3.5F, -6.8333F, -19.8333F));

            PartDefinition BL = legs.addOrReplaceChild("BL", CubeListBuilder.create().texOffs(78, 19).mirror().addBox(-1.5F, -1.5F, -2.5F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offset(3.5F, -9.5F, -9.5F));

            PartDefinition BLB = BL.addOrReplaceChild("BLB", CubeListBuilder.create().texOffs(82, 32).mirror().addBox(-1.5F, 4.0F, -2.1667F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.09F)).mirror(false)
                    .texOffs(90, 67).mirror().addBox(0.0F, 0.0F, 1.8333F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                    .texOffs(79, 53).mirror().addBox(-1.5F, 0.0F, -2.1667F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.5F, 1.6667F));

            return LayerDefinition.create(meshdefinition, 128, 128);
        }

        @Override
        public void setupAnim(UnicornEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
           this.root().getAllParts().forEach(ModelPart::resetPose);
           this.applyHeadRotation(netHeadYaw,headPitch);

           this.animateWalk(UnicornAnimations.UNICORN_WALK,limbSwing,limbSwingAmount,2f,2.5f);
           this.animate(entity.idleAnimationState,UnicornAnimations.UNICORN_IDLE,ageInTicks,1f);
        }



        private void applyHeadRotation(float headYaw, float headPitch) {
            headYaw = Mth.clamp(headYaw,-30f,30f);
            headPitch = Mth.clamp(headPitch,-25f,45f);

            this.head.yRot = headYaw * ((float) Math.PI /180f);
            this.head.xRot = headPitch * ((float) Math.PI / 180f);
        }

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
            unicorn.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        }

        @Override
        public ModelPart root() {
            return body;
        }
    }


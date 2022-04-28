package com.titan.titancraft;// Made with Blockbench 4.2.3
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.titan.titancraft.SteelTitanEntity;
import com.titan.titancraft.TitanCraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;

public class SteelTitanModel<T extends SteelTitanEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TitanCraft.MODID, "steel_titan_model"), "main");
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;
	public float swimAmount;

	public SteelTitanModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
		this.rightLeg = root.getChild("rightLeg");
		this.leftLeg = root.getChild("leftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -6.0F, -5.0F, 29.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(24, 13).addBox(-1.05F, 3.0F, -1.5F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.5F))
		.texOffs(0, 27).addBox(-5.5F, -2.25F, -3.0F, 12.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(46, 30).addBox(-5.05F, 6.0F, -2.0F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 13).addBox(-3.75F, -12.0F, -2.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -2.0F));

		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(45, 43).addBox(-9.0F, 4.75F, -4.0F, 4.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(54, 21).addBox(-9.0F, -2.25F, -2.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(20, 43).addBox(-8.0F, 2.75F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -8.0F, 0.0F));

		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(0, 37).addBox(10.0F, 3.75F, -3.5F, 4.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(54, 13).addBox(10.0F, -3.25F, -2.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(28, 49).addBox(11.0F, 1.75F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(29, 32).addBox(-11.05F, -9.0F, -3.0F, 6.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(15, 58).addBox(-9.55F, 3.0F, -1.75F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(51, 36).addBox(-10.0F, 10.0F, -4.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(28, 53).addBox(-10.0F, 12.0F, -6.0F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-9.0F, 4.8824F, -0.5305F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 11.0F, 0.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(32, 13).addBox(3.95F, -9.0F, -3.0F, 6.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(14, 37).addBox(5.5F, 3.0F, -1.75F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 54).addBox(5.0F, 10.0F, -4.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(13, 47).addBox(5.0F, 12.0F, -6.0F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(6.0F, 4.8824F, 0.4695F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 11.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 129, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void prepareMobModel(T p_102861_, float p_102862_, float p_102863_, float p_102864_) {
		this.swimAmount = p_102861_.getSwimAmount(p_102864_);
		super.prepareMobModel(p_102861_, p_102862_, p_102863_, p_102864_);
	}

	@Override
	public void setupAnim(T p_102866_, float p_102867_, float p_102868_, float p_102869_, float p_102870_, float p_102871_) {
		boolean flag = p_102866_.getFallFlyingTicks() > 4;
		boolean flag1 = p_102866_.isVisuallySwimming();
		this.head.yRot = p_102870_ * ((float)Math.PI / 180F);
		if (flag) {
			this.head.xRot = (-(float)Math.PI / 4F);
		} else if (this.swimAmount > 0.0F) {
			if (flag1) {
				this.head.xRot = this.rotlerpRad(this.swimAmount, this.head.xRot, (-(float)Math.PI / 4F));
			} else {
				this.head.xRot = this.rotlerpRad(this.swimAmount, this.head.xRot, p_102871_ * ((float)Math.PI / 180F));
			}
		} else {
			this.head.xRot = p_102871_ * ((float)Math.PI / 180F);
		}

		this.body.yRot = 0.0F;
		this.rightArm.z = 0.0F;
		this.rightArm.x = -5.0F;
		this.leftArm.z = 0.0F;
		this.leftArm.x = 5.0F;
		float f = 1.0F;
		if (flag) {
			f = (float)p_102866_.getDeltaMovement().lengthSqr();
			f = f / 0.2F;
			f = f * f * f;
		}

		if (f < 1.0F) {
			f = 1.0F;
		}

		this.rightArm.xRot = Mth.cos(p_102867_ * 0.6662F + (float)Math.PI) * 2.0F * p_102868_ * 0.5F / f;
		this.leftArm.xRot = Mth.cos(p_102867_ * 0.6662F) * 2.0F * p_102868_ * 0.5F / f;
		this.rightArm.zRot = 0.0F;
		this.leftArm.zRot = 0.0F;
		this.rightLeg.xRot = Mth.cos(p_102867_ * 0.6662F) * 1.4F * p_102868_ / f;
		this.leftLeg.xRot = Mth.cos(p_102867_ * 0.6662F + (float)Math.PI) * 1.4F * p_102868_ / f;
		this.rightLeg.yRot = 0.0F;
		this.leftLeg.yRot = 0.0F;
		this.rightLeg.zRot = 0.0F;
		this.leftLeg.zRot = 0.0F;
		if (this.riding) {
			this.rightArm.xRot += (-(float)Math.PI / 5F);
			this.leftArm.xRot += (-(float)Math.PI / 5F);
			this.rightLeg.xRot = -1.4137167F;
			this.rightLeg.yRot = ((float)Math.PI / 10F);
			this.rightLeg.zRot = 0.07853982F;
			this.leftLeg.xRot = -1.4137167F;
			this.leftLeg.yRot = (-(float)Math.PI / 10F);
			this.leftLeg.zRot = -0.07853982F;
		}

		this.rightArm.yRot = 0.0F;
		this.leftArm.yRot = 0.0F;
		boolean flag2 = p_102866_.getMainArm() == HumanoidArm.RIGHT;

		this.setupAttackAnimation(p_102866_, p_102869_);
		this.body.xRot = 0.0F;
		this.rightLeg.z = 0.1F;
		this.leftLeg.z = 0.1F;
		this.rightLeg.y = 12.0F;
		this.leftLeg.y = 12.0F;
		this.head.y = 0.0F;
		this.body.y = 0.0F;
		this.leftArm.y = 2.0F;
		this.rightArm.y = 2.0F;


		if (this.swimAmount > 0.0F) {
			float f5 = p_102867_ % 26.0F;
			HumanoidArm humanoidarm = this.getAttackArm(p_102866_);
			float f1 = humanoidarm == HumanoidArm.RIGHT && this.attackTime > 0.0F ? 0.0F : this.swimAmount;
			float f2 = humanoidarm == HumanoidArm.LEFT && this.attackTime > 0.0F ? 0.0F : this.swimAmount;
			if (!p_102866_.isUsingItem()) {
				if (f5 < 14.0F) {
					this.leftArm.xRot = this.rotlerpRad(f2, this.leftArm.xRot, 0.0F);
					this.rightArm.xRot = Mth.lerp(f1, this.rightArm.xRot, 0.0F);
					this.leftArm.yRot = this.rotlerpRad(f2, this.leftArm.yRot, (float)Math.PI);
					this.rightArm.yRot = Mth.lerp(f1, this.rightArm.yRot, (float)Math.PI);
					this.leftArm.zRot = this.rotlerpRad(f2, this.leftArm.zRot, (float)Math.PI + 1.8707964F * this.quadraticArmUpdate(f5) / this.quadraticArmUpdate(14.0F));
					this.rightArm.zRot = Mth.lerp(f1, this.rightArm.zRot, (float)Math.PI - 1.8707964F * this.quadraticArmUpdate(f5) / this.quadraticArmUpdate(14.0F));
				} else if (f5 >= 14.0F && f5 < 22.0F) {
					float f6 = (f5 - 14.0F) / 8.0F;
					this.leftArm.xRot = this.rotlerpRad(f2, this.leftArm.xRot, ((float)Math.PI / 2F) * f6);
					this.rightArm.xRot = Mth.lerp(f1, this.rightArm.xRot, ((float)Math.PI / 2F) * f6);
					this.leftArm.yRot = this.rotlerpRad(f2, this.leftArm.yRot, (float)Math.PI);
					this.rightArm.yRot = Mth.lerp(f1, this.rightArm.yRot, (float)Math.PI);
					this.leftArm.zRot = this.rotlerpRad(f2, this.leftArm.zRot, 5.012389F - 1.8707964F * f6);
					this.rightArm.zRot = Mth.lerp(f1, this.rightArm.zRot, 1.2707963F + 1.8707964F * f6);
				} else if (f5 >= 22.0F && f5 < 26.0F) {
					float f3 = (f5 - 22.0F) / 4.0F;
					this.leftArm.xRot = this.rotlerpRad(f2, this.leftArm.xRot, ((float)Math.PI / 2F) - ((float)Math.PI / 2F) * f3);
					this.rightArm.xRot = Mth.lerp(f1, this.rightArm.xRot, ((float)Math.PI / 2F) - ((float)Math.PI / 2F) * f3);
					this.leftArm.yRot = this.rotlerpRad(f2, this.leftArm.yRot, (float)Math.PI);
					this.rightArm.yRot = Mth.lerp(f1, this.rightArm.yRot, (float)Math.PI);
					this.leftArm.zRot = this.rotlerpRad(f2, this.leftArm.zRot, (float)Math.PI);
					this.rightArm.zRot = Mth.lerp(f1, this.rightArm.zRot, (float)Math.PI);
				}
			}

			float f7 = 0.3F;
			float f4 = 0.33333334F;
			this.leftLeg.xRot = Mth.lerp(this.swimAmount, this.leftLeg.xRot, 0.3F * Mth.cos(p_102867_ * 0.33333334F + (float)Math.PI));
			this.rightLeg.xRot = Mth.lerp(this.swimAmount, this.rightLeg.xRot, 0.3F * Mth.cos(p_102867_ * 0.33333334F));
		}

	}

	protected float rotlerpRad(float p_102836_, float p_102837_, float p_102838_) {
		float f = (p_102838_ - p_102837_) % ((float)Math.PI * 2F);
		if (f < -(float)Math.PI) {
			f += ((float)Math.PI * 2F);
		}

		if (f >= (float)Math.PI) {
			f -= ((float)Math.PI * 2F);
		}

		return p_102837_ + p_102836_ * f;
	}

	protected void setupAttackAnimation(T p_102858_, float p_102859_) {
		if (!(this.attackTime <= 0.0F)) {
			HumanoidArm humanoidarm = this.getAttackArm(p_102858_);
			ModelPart modelpart = this.getArm(humanoidarm);
			float f = this.attackTime;
			this.body.yRot = Mth.sin(Mth.sqrt(f) * ((float)Math.PI * 2F)) * 0.2F;
			if (humanoidarm == HumanoidArm.LEFT) {
				this.body.yRot *= -1.0F;
			}

			this.rightArm.z = Mth.sin(this.body.yRot) * 5.0F;
			this.rightArm.x = -Mth.cos(this.body.yRot) * 5.0F;
			this.leftArm.z = -Mth.sin(this.body.yRot) * 5.0F;
			this.leftArm.x = Mth.cos(this.body.yRot) * 5.0F;
			this.rightArm.yRot += this.body.yRot;
			this.leftArm.yRot += this.body.yRot;
			this.leftArm.xRot += this.body.yRot;
			f = 1.0F - this.attackTime;
			f = f * f;
			f = f * f;
			f = 1.0F - f;
			float f1 = Mth.sin(f * (float)Math.PI);
			float f2 = Mth.sin(this.attackTime * (float)Math.PI) * -(this.head.xRot - 0.7F) * 0.75F;
			modelpart.xRot = (float)((double)modelpart.xRot - ((double)f1 * 1.2D + (double)f2));
			modelpart.yRot += this.body.yRot * 2.0F;
			modelpart.zRot += Mth.sin(this.attackTime * (float)Math.PI) * -0.4F;
		}
	}

	private HumanoidArm getAttackArm(T p_102857_) {
		HumanoidArm humanoidarm = p_102857_.getMainArm();
		return p_102857_.swingingArm == InteractionHand.MAIN_HAND ? humanoidarm : humanoidarm.getOpposite();
	}

	protected ModelPart getArm(HumanoidArm p_102852_) {
		return p_102852_ == HumanoidArm.LEFT ? this.leftArm : this.rightArm;
	}

	private float quadraticArmUpdate(float p_102834_) {
		return -65.0F * p_102834_ + p_102834_ * p_102834_;
	}
}
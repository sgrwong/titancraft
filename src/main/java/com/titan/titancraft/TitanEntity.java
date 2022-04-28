package com.titan.titancraft;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public abstract class TitanEntity extends PathfinderMob {

    int shootCharge;
    float explosionStrength;

    protected TitanEntity(EntityType<? extends PathfinderMob> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }

    /*
        Sets AI tasks for the mob
        1. Walk around aimlessly
        2. Look around aimlessly
         */
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (p_28879_) -> {
            return p_28879_ instanceof Enemy && !(p_28879_ instanceof Creeper);
        }));
    }

    private int charge = 0;

    @Override
    public void tick() {
        if (charge >= 400) {
            return;
        }
        charge++;
        super.tick();
    }

    /*
    Runs when the user clicks on the mob
    If the player has a diamond in hand mount the titan
     */
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack currentItem = player.getItemInHand(hand);
        super.mobInteract(player, hand);
        if (this.canAddPassenger(player)) {
            drainCharge();
            player.startRiding(this);
        }
        return InteractionResult.sidedSuccess(this.level.isClientSide());
    }

    /*
    Allows a rider to control the titan
    Needs reworking
     */
    @Override
    public void travel(Vec3 dir) {
        Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
        if (this.isVehicle()) {
            this.setYRot(entity.getYRot());
            this.yRotO = this.getYRot();
            this.setXRot(entity.getXRot() * 0.5F);
            this.setRot(this.getYRot(), this.getXRot());
            this.flyingSpeed = this.getSpeed() * 0.15F;
            this.yBodyRot = entity.getYRot();
            this.yHeadRot = entity.getYRot();
            this.maxUpStep = 1.0F;
            if (entity instanceof LivingEntity passenger) {
                this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
                float forward = passenger.zza;
                float strafe = passenger.xxa;
                super.travel(new Vec3(strafe, 0, forward));
            }
            this.animationSpeedOld = this.animationSpeed;
            double d1 = this.getX() - this.xo;
            double d0 = this.getZ() - this.zo;
            float f1 = (float) Math.sqrt(d1 * d1 + d0 * d0) * 4;
            if (f1 > 1.0F)
                f1 = 1.0F;
            this.animationSpeed += (f1 - this.animationSpeed) * 0.4F;
            this.animationPosition += this.animationSpeed;
            return;
        }
        this.maxUpStep = 0.5F;
        this.flyingSpeed = 0.02F;
        super.travel(dir);
    }

    public void drainCharge() {
        charge = 0;
    }

    @SubscribeEvent
    public static void playerClick(PlayerInteractEvent event) {
        var player = event.getPlayer();
        var level = player.level;
        if(player.getVehicle() instanceof TitanEntity vehicle) {
            if (vehicle.charge > vehicle.shootCharge) {
                vehicle.drainCharge();
                var looking = player.getLookAngle();
                Vec3 posVec = new Vec3(player.getX() + looking.x * 1.5D, player.getY() + looking.y, player.getZ() + looking.z * 1.5D);
                if (vehicle instanceof AluminiumTitanEntity) {
                    var fireball = new TitanLightningBall(level, player.getZ(), player.getY(), player.getZ(), looking.x, looking.y, looking.z);
                    fireball.setPos(posVec);
                    fireball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
                    level.addFreshEntity(fireball);
                }
                else {
                    var fireball = new TitanFireball(level, player.getZ(), player.getY(), player.getZ(), looking.x, looking.y, looking.z, vehicle.explosionStrength);
                    fireball.setPos(posVec);
                    fireball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
                    level.addFreshEntity(fireball);
                }
            }
        }
    }

    //Set attributes such as speed, health for the titan
    public static AttributeSupplier.Builder createAttributes(float movementSpeed) {
        AttributeSupplier.Builder attributes = Mob.createMobAttributes();
        attributes = attributes.add(Attributes.MOVEMENT_SPEED, movementSpeed);
        attributes = attributes.add(Attributes.MAX_HEALTH, 20);
        attributes = attributes.add(Attributes.ARMOR, 5);
        attributes = attributes.add(Attributes.ATTACK_DAMAGE, 10);
        return attributes;
    }
}


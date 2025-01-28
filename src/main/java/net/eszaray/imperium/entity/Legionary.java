package net.eszaray.imperium.entity;

import net.eszaray.imperium.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class Legionary extends PathfinderMob {
    public Legionary(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.25F, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 1.25F, 32.0F));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Mob.class, 5, false, false, (entity) -> {
            return entity instanceof Enemy && !(entity instanceof Creeper) && !(entity instanceof EnderMan) && !(entity instanceof Piglin);
        }));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0F));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createLivingAttributes().add(Attributes.MAX_HEALTH, 25.0).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 24.0D).add(Attributes.ATTACK_DAMAGE, 1.0D).add(Attributes.ENTITY_INTERACTION_RANGE, 10.0D);
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        RandomSource randomsource = level.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, difficulty);

        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(random, difficulty);

        ItemStack sword = new ItemStack(ModItems.IRON_LEGION_SWORD.get());
        ItemStack shield = new ItemStack(ModItems.LEGION_SHIELD.get());

        int color = 0xB02E26;

        shield.set(DataComponents.DYED_COLOR, new DyedItemColor(color, true));

        ItemStack head = new ItemStack(ModItems.IRON_LEGION_HELMET.get());
        ItemStack chest = new ItemStack(ModItems.IRON_LEGION_SEGMENTPLATE.get());
        ItemStack legs = new ItemStack(ModItems.IRON_LEGION_GREAVES.get());
        ItemStack feet = new ItemStack(ModItems.IRON_LEGION_BOOTS.get());

        chest.set(DataComponents.DYED_COLOR, new DyedItemColor(color, true));
        legs.set(DataComponents.DYED_COLOR, new DyedItemColor(color, true));

        this.setItemSlot(EquipmentSlot.MAINHAND, sword);
        this.setItemSlot(EquipmentSlot.OFFHAND, shield);

        this.setItemSlot(EquipmentSlot.CHEST, chest);
        this.setItemSlot(EquipmentSlot.HEAD, head);
        this.setItemSlot(EquipmentSlot.LEGS, legs);
        this.setItemSlot(EquipmentSlot.FEET, feet);
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        if (this.isInWater()) {
            this.waterSwimSound();
            this.playMuffledStepSound(state, pos);
        } else {
            BlockPos blockpos = this.getPrimaryStepSoundBlockPos(pos);
            if (!pos.equals(blockpos)) {
                BlockState blockstate = this.level().getBlockState(blockpos);
                if (blockstate.is(BlockTags.COMBINATION_STEP_SOUND_BLOCKS)) {
                    this.playCombinationStepSounds(blockstate, state, blockpos, pos);
                } else {
                    super.playStepSound(blockpos, blockstate);
                }
            } else {
                super.playStepSound(pos, state);
            }
        }

    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.updateSwingTime();

//         Switch target to the last target available
//        if(this.getLastHurtMob() != null) {
//            this.setTarget(this.getLastHurtMob());
//        }
    }

    @Override
    public boolean canAttack(LivingEntity target) {
        return super.canAttack(target);
    }
}

package violetcraft.entity;


import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import violetcraft.VioletCraftRegistry;

public class EntityMoonRabbit extends EntityAnimal
{
    public boolean field_152118_bv;
    public int timeUntilNextItem;
    public EntityMoonRabbit(World world) {
        super(world);
        this.setSize(0.4F, 0.5F);
		/*EntiyのAIを登録する*/
        this.getNavigator().setAvoidsWater(true);
        this.timeUntilNextItem = this.rand.nextInt(6000) + 6000;
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 0.8D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, Items.carrot, false));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, Items.golden_carrot, false));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, Items.wheat_seeds, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityWither.class, 6.0F, 1.0D, 1.2D));
        this.tasks.addTask(5, new EntityAIAvoidEntity(this, EntityWolf.class, 6.0F, 1.0D, 1.2D));
        this.tasks.addTask(6, new EntityAIWander(this, 0.8D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));


    }

    public boolean isAIEnabled()
    {
        return true;
    }
    @Override
    public EntityAgeable createChild(EntityAgeable p_90011_1_) {
        return new EntityMoonRabbit(this.worldObj);
    }

    /**MOBの速度やHPを変更するメソッド*/
    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2008D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(6D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10D);
    }
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        if (!this.worldObj.isRemote && !this.isChild() && !this.func_152116_bZ() && --this.timeUntilNextItem <= 0)
        {
            this.playSound("mob.chicken.plop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(VioletCraftRegistry.CookedMoonMeat, 1);
            this.timeUntilNextItem = this.rand.nextInt(6000) + 6000;
        }
    }

    public boolean isBreedingItem(ItemStack p_70877_1_)
    {
        return p_70877_1_ != null && p_70877_1_.getItem() instanceof ItemSeeds;
    }
    /**MOBの属性を返すメソッド*/
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }

    /**MOBのドロップアイテムを返すメソッド*/
    protected Item getDropItem() {
        return VioletCraftRegistry.RawMoonMeat;
    }

    protected void dropFewItems(boolean parRecentlyHit, int parLootingLevel) {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + parLootingLevel);
        int k;

        for (k = 0; k < j; ++k) {
            this.dropItem(VioletCraftRegistry.RawMoonMeat, 1);
        }
        if (this.isBurning()) {
            this.dropItem(VioletCraftRegistry.CookedMoonMeat, 1);
        } else {
            this.dropItem(VioletCraftRegistry.RawMoonMeat, 1);
        }
    }




    /**ダメージを食らうか否かを判定するメソッド*/
    @Override
    public boolean attackEntityFrom(DamageSource source, float damage)
    {

        if(source.isMagicDamage())
        {
            return false;
        }
        else if(source.isFireDamage())
        {
            return super.attackEntityFrom(source, damage * 2);
        }
        else
        {
            return super.attackEntityFrom(source, damage);
        }
    }
    public boolean func_152116_bZ()
    {
        return this.field_152118_bv;
    }
}

package blue.thejester.simpledelights;

import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vectorwing.farmersdelight.items.ConsumableItem;
import vectorwing.farmersdelight.registry.ModEffects;

import java.util.function.Supplier;

@Mod(SimpleDelights.MODID)
public class SimpleDelights
{

    public static final String MODID = "simpledelights";

    public static final ItemGroup ITEM_GROUP = new ItemGroup(SimpleDelights.MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(SDItems.CREAMCICLE.get());
        }
    };

    // Directly reference a log4j logger.
    public static final Logger log = LogManager.getLogger(MODID);

    public SimpleDelights() {
        SDItems.register();
    }
}

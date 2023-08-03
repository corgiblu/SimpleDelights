package blue.thejester.simpledelights;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SimpleDelights.MODID)
public class SimpleDelights
{

    public static final String MODID = "simpledelights";

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(SimpleDelights.MODID) {
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

package blue.thejester.simpledelights;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.items.ConsumableItem;
import vectorwing.farmersdelight.registry.ModEffects;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static blue.thejester.simpledelights.SimpleDelights.MODID;

public class SDItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> SQUASH_NOODLES = makeFood("squash_noodles", 3, 0.6f);
    public static final RegistryObject<Item> DINO_OATMEAL = makeBowlFood("dino_oatmeal", 8, 1.2f, comfort());
    public static final RegistryObject<Item> JAM_BAR = makeFood("jam_bar", 8, 1.2f, effect(Effects.MOVEMENT_SPEED, 500));
    public static final RegistryObject<Item> GRANOLA = makeFood("granola", 6, 1.2f);
    public static final RegistryObject<Item> GLAZED_YAMS = makeFood("glazed_yam", 7, 1.6f, comfort());
    public static final RegistryObject<Item> LETTUCE_WRAP = makeFood("lettuce_wrap", 11, 1.2f, effect(Effects.HEALTH_BOOST, 3000));
    public static final RegistryObject<Item> STRAWBERRY_SHORTCAKE = makeFood("strawberry_shortcake", 10, 1.2f, effect(Effects.REGENERATION, 240));
    public static final RegistryObject<Item> CHOCOLATE_STRAWBERRIES = makeFood("chocolate_strawberries", 4, 0.6f);
    public static final RegistryObject<Item> PLUM_PUDDING = makeFood("plum_pudding", 8, 1.6f, effect(Effects.DAMAGE_RESISTANCE, 900));
    public static final RegistryObject<Item> PLUM_PORK = makeFood("plum_pork", 12, 1.6f, effect(Effects.ABSORPTION, 240));
    public static final RegistryObject<Item> FRUIT_TART = makeFood("fruit_tart", 9, 1.6f, effect(Effects.MOVEMENT_SPEED, 600));
    public static final RegistryObject<Item> CREAMCICLE = makeFoodBase("creamcicle", 9, 1.6f, Items.STICK, 64, effect(Effects.FIRE_RESISTANCE, 600));
    public static final RegistryObject<Item> MANGO_HABANERO_WINGS = makeFood("mango_wings", 10, 1.6f, effect(Effects.FIRE_RESISTANCE, 3600));
    public static final RegistryObject<Item> SWEET_POTATO_CASSEROLE = makeBowlFood("sweet_potato_casserole", 10, 1.6f, nourishedLong());
    public static final RegistryObject<Item> STIR_FRY = makeBowlFood("stir_fry", 12, 1.f, nourishedLong());
    public static final RegistryObject<Item> DUBU_JJIGAE = makeBowlFood("dubu_jjigae", 10, 1.6f, comfort());
    public static final RegistryObject<Item> MAPO_TOFU = makeBowlFood("mapo_tofu", 12, 1.6f, nourishedLong());
    public static final RegistryObject<Item> CHOLENT = makeBowlFood("cholent", 12, 1.6f, comfort());
    public static final RegistryObject<Item> BERRY_KOMPOT = makeFoodBase("berry_kompot", 6, 1.2f, Items.GLASS_BOTTLE, 4, effect(Effects.MOVEMENT_SPEED, 1200));
    public static final RegistryObject<Item> PEAR_BISQUE = makeBowlFood("pear_bisque", 8, 1.6f, comfort());
    public static final RegistryObject<Item> ORANGE_CHICKEN = makeBowlFood("orange_chicken", 10, 1.6f, nourishedLong());
    public static final RegistryObject<Item> ORANGE_SORBET = makeBowlFood("orange_sorbet", 7, 1.2f, effect(Effects.MOVEMENT_SLOWDOWN, 200), effect(Effects.FIRE_RESISTANCE, 1200));
    public static final RegistryObject<Item> MANGO_SORBET = makeBowlFood("mango_sorbet", 7, 1.2f, effect(Effects.MOVEMENT_SLOWDOWN, 200), effect(Effects.FIRE_RESISTANCE, 1200));
    public static final RegistryObject<Item> SUMMER_SALAD = makeBowlFood("summer_salad", 9, 1.2f, effect(Effects.WATER_BREATHING, 200));

    private static RegistryObject<Item> makeBowlFood(String name, int hunger, float saturation, java.util.function.Supplier<EffectInstance>... effects) {
        return makeFoodBase(name, hunger, saturation, Items.BOWL, 16, effects);
    }

    private static RegistryObject<Item> makeFood(String name, int hunger, float saturation, java.util.function.Supplier<EffectInstance>... effects) {
        return makeFoodBase(name, hunger, saturation, null, 64, effects);
    }

    private static RegistryObject<Item> makeFoodBase(String name, int hunger, float saturation, Item container, int stack, java.util.function.Supplier<EffectInstance>... effects) {
        Food.Builder f = new Food.Builder().nutrition(hunger).saturationMod(saturation);
        for (Supplier<EffectInstance> effect : effects) {
            f.effect(effect, 1f);
        }
        return ITEMS.register(name, () -> new ConsumableItem(new Item.Properties().food(f.build()).craftRemainder(container).stacksTo(stack).tab(SimpleDelights.ITEM_GROUP)));
    }

    private static java.util.function.Supplier<EffectInstance> effect(Effect effect, int duration, int amp) {
        return () -> new EffectInstance(effect, duration, amp);
    }

    private static java.util.function.Supplier<EffectInstance> effect(Effect effect, int duration) {
        return () -> new EffectInstance(effect, duration, 0);
    }

    private static java.util.function.Supplier<EffectInstance> comfort() {
        return () -> new EffectInstance(ModEffects.COMFORT.get(), 4800, 0);
    }

    private static java.util.function.Supplier<EffectInstance> nourishedShort() {
        return () -> new EffectInstance(ModEffects.NOURISHED.get(), 4800, 0);
    }

    private static java.util.function.Supplier<EffectInstance> nourishedLong() {
        return () -> new EffectInstance(ModEffects.NOURISHED.get(), 9600, 0);
    }

    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static Collection<ResourceLocation> itemList() {
        return ITEMS.getEntries().stream().map(RegistryObject::getId).collect(Collectors.toList());
    }
}

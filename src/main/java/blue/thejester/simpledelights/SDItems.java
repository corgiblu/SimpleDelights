package blue.thejester.simpledelights;

import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static blue.thejester.simpledelights.SimpleDelights.MODID;

public class SDItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> SQUASH_NOODLES = makeFood("squash_noodles", 3, 0.6f);
    public static final RegistryObject<Item> DINO_OATMEAL = makeBowlFood("dino_oatmeal", 8, 1.2f, comfort());
    public static final RegistryObject<Item> JAM_BAR = makeFood("jam_bar", 8, 1.2f, effect(MobEffects.MOVEMENT_SPEED, 500));
    public static final RegistryObject<Item> GRANOLA = makeFood("granola", 6, 1.2f);
    public static final RegistryObject<Item> GLAZED_YAMS = makeFood("glazed_yam", 7, 1.6f, comfort());
    public static final RegistryObject<Item> LETTUCE_WRAP = makeFood("lettuce_wrap", 11, 1.2f, effect(MobEffects.HEALTH_BOOST, 3000));
    public static final RegistryObject<Item> STRAWBERRY_SHORTCAKE = makeFood("strawberry_shortcake", 10, 1.2f, effect(MobEffects.REGENERATION, 240));
    public static final RegistryObject<Item> CHOCOLATE_STRAWBERRIES = makeFood("chocolate_strawberries", 4, 0.6f);
    public static final RegistryObject<Item> PLUM_PUDDING = makeFood("plum_pudding", 8, 1.6f, effect(MobEffects.DAMAGE_RESISTANCE, 900));
    public static final RegistryObject<Item> PLUM_PORK = makeFood("plum_pork", 12, 1.6f, effect(MobEffects.ABSORPTION, 240));
    public static final RegistryObject<Item> FRUIT_TART = makeFood("fruit_tart", 9, 1.6f, effect(MobEffects.MOVEMENT_SPEED, 600));
    public static final RegistryObject<Item> CREAMCICLE = makeFoodBase("creamcicle", 9, 1.6f, Items.STICK, 64, effect(MobEffects.FIRE_RESISTANCE, 600));
    public static final RegistryObject<Item> MANGO_HABANERO_WINGS = makeFood("mango_wings", 10, 1.6f, effect(MobEffects.FIRE_RESISTANCE, 3600));
    public static final RegistryObject<Item> SWEET_POTATO_CASSEROLE = makeBowlFood("sweet_potato_casserole", 10, 1.6f, nourishedLong());
    public static final RegistryObject<Item> STIR_FRY = makeBowlFood("stir_fry", 12, 1.f, nourishedLong());
    public static final RegistryObject<Item> DUBU_JJIGAE = makeBowlFood("dubu_jjigae", 10, 1.6f, comfort());
    public static final RegistryObject<Item> MAPO_TOFU = makeBowlFood("mapo_tofu", 12, 1.6f, nourishedLong());
    public static final RegistryObject<Item> CHOLENT = makeBowlFood("cholent", 12, 1.6f, comfort());
    public static final RegistryObject<Item> BERRY_KOMPOT = makeFoodBase("berry_kompot", 6, 1.2f, Items.GLASS_BOTTLE, 4, effect(MobEffects.MOVEMENT_SPEED, 1200));
    public static final RegistryObject<Item> PEAR_BISQUE = makeBowlFood("pear_bisque", 8, 1.6f, comfort());
    public static final RegistryObject<Item> ORANGE_CHICKEN = makeBowlFood("orange_chicken", 10, 1.6f, nourishedLong());
    public static final RegistryObject<Item> ORANGE_SORBET = makeBowlFood("orange_sorbet", 7, 1.2f, effect(MobEffects.MOVEMENT_SLOWDOWN, 200), effect(MobEffects.FIRE_RESISTANCE, 1200));
    public static final RegistryObject<Item> MANGO_SORBET = makeBowlFood("mango_sorbet", 7, 1.2f, effect(MobEffects.MOVEMENT_SLOWDOWN, 200), effect(MobEffects.FIRE_RESISTANCE, 1200));
    public static final RegistryObject<Item> SUMMER_SALAD = makeBowlFood("summer_salad", 9, 1.2f, effect(MobEffects.WATER_BREATHING, 200));

    private static RegistryObject<Item> makeBowlFood(String name, int hunger, float saturation, java.util.function.Supplier<MobEffectInstance>... effects) {
        return makeFoodBase(name, hunger, saturation, Items.BOWL, 16, effects);
    }

    private static RegistryObject<Item> makeFood(String name, int hunger, float saturation, java.util.function.Supplier<MobEffectInstance>... effects) {
        return makeFoodBase(name, hunger, saturation, null, 64, effects);
    }

    private static RegistryObject<Item> makeFoodBase(String name, int hunger, float saturation, Item container, int stack, java.util.function.Supplier<MobEffectInstance>... effects) {
        FoodProperties.Builder f = new FoodProperties.Builder()
                .nutrition(hunger)
                .saturationMod(saturation);
        for (Supplier<MobEffectInstance> effect : effects) {
            f.effect(effect, 1f);
        }
        return ITEMS.register(name, () -> new ConsumableItem(
                new Item.Properties()
                        .food(f.build())
                        .craftRemainder(container)
                        .stacksTo(stack)
                        .tab(SimpleDelights.ITEM_GROUP)
        ));
    }

    private static java.util.function.Supplier<MobEffectInstance> effect(MobEffect effect, int duration, int amp) {
        return () -> new MobEffectInstance(effect, duration, amp);
    }

    private static java.util.function.Supplier<MobEffectInstance> effect(MobEffect effect, int duration) {
        return () -> new MobEffectInstance(effect, duration, 0);
    }

    private static java.util.function.Supplier<MobEffectInstance> comfort() {
        return () -> new MobEffectInstance(ModEffects.COMFORT.get(), 4800, 0);
    }

    private static java.util.function.Supplier<MobEffectInstance> nourishedShort() {
        return () -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 4800, 0);
    }

    private static java.util.function.Supplier<MobEffectInstance> nourishedLong() {
        return () -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 9600, 0);
    }

    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static Collection<ResourceLocation> itemList() {
        return ITEMS.getEntries().stream().map(RegistryObject::getId).collect(Collectors.toList());
    }
}

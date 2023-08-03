package blue.thejester.simpledelights;

import enemeez.simplefarming.common.registries.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = SimpleDelights.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SDDataGen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        event.getGenerator().addProvider(event.includeClient(),
                new ItemModelProvider(
                        event.getGenerator(),
                        SimpleDelights.MODID,
                        event.getExistingFileHelper()) {
            @Override
            protected void registerModels() {
                for (ResourceLocation item : SDItems.itemList()) {
                    withExistingParent(item.getPath(), "item/generated")
                            .texture("layer0",
                                    new ResourceLocation(
                                            SimpleDelights.MODID,
                                            "item/"+item.getPath()));
                }
            }
    });

        event.getGenerator().addProvider(event.includeClient(),
                new LanguageProvider(event.getGenerator(), SimpleDelights.MODID, "en_us") {
            @Override
            protected void addTranslations() {
                add(getItemTrans(SDItems.SQUASH_NOODLES), "Squash Noodles");
                add(getItemTrans(SDItems.DINO_OATMEAL), "Dinosaur Oatmeal");
                add(getItemTrans(SDItems.JAM_BAR), "Jam Bar");
                add(getItemTrans(SDItems.GRANOLA), "Granola");
                add(getItemTrans(SDItems.GLAZED_YAMS), "Glazed Yams");
                add(getItemTrans(SDItems.LETTUCE_WRAP), "Lettuce Wrap");
                add(getItemTrans(SDItems.STRAWBERRY_SHORTCAKE), "Strawberry Shortcake");
                add(getItemTrans(SDItems.CHOCOLATE_STRAWBERRIES), "Chocolate Strawberries");
                add(getItemTrans(SDItems.PLUM_PUDDING), "Plum Pudding");
                add(getItemTrans(SDItems.PLUM_PORK), "Plum Pork");
                add(getItemTrans(SDItems.FRUIT_TART), "Fruit Tart");
                add(getItemTrans(SDItems.CREAMCICLE), "Creamcicle");
                add(getItemTrans(SDItems.MANGO_HABANERO_WINGS), "Mango Habanero Wings");
                add(getItemTrans(SDItems.SWEET_POTATO_CASSEROLE), "Sweet Potato Casserole");
                add(getItemTrans(SDItems.STIR_FRY), "Stir Fry");
                add(getItemTrans(SDItems.DUBU_JJIGAE), "Dubu Jjigae");
                add(getItemTrans(SDItems.MAPO_TOFU), "Mapo Tofu");
                add(getItemTrans(SDItems.CHOLENT), "Cholent");
                add(getItemTrans(SDItems.BERRY_KOMPOT), "Berry Kompot");
                add(getItemTrans(SDItems.PEAR_BISQUE), "Pear Bisque");
                add(getItemTrans(SDItems.ORANGE_CHICKEN), "Orange Chicken");
                add(getItemTrans(SDItems.ORANGE_SORBET), "Orange Sorbet");
                add(getItemTrans(SDItems.MANGO_SORBET), "Mango Sorbet");
                add(getItemTrans(SDItems.SUMMER_SALAD), "Summer Salad");
                add("itemGroup.simpledelights", "Simple Delights");

                //Simple Farming Renames
                add(getItemTrans(ModItems.FRIED_RICE), "Omurice");
                add(getItemTrans(ModItems.EGG_SANDWICH), "Bacon Egg Sandwich");
                add(getItemTrans(ModItems.PUMPKIN_SOUP), "Pumpkin Sauce");
                add(getItemTrans(ModItems.FRUIT_SALAD), "Mixed Fruit");
                add(getItemTrans(ModItems.APPLE_PIE), "Apple Hand Pie");
                add(getItemTrans(ModItems.APRICOT_PIE), "Apricot Hand Pie");
                add(getItemTrans(ModItems.BLACKBERRY_PIE), "Blackberry Hand Pie");
                add(getItemTrans(ModItems.BLUEBERRY_PIE), "Blueberry Hand Pie");
                add(getItemTrans(ModItems.CHERRY_PIE), "Cherry Hand Pie");
                add(getItemTrans(ModItems.PEANUT_BUTTER_PIE), "Peanut Butter Hand Pie");
                add(getItemTrans(ModItems.PEAR_PIE), "Pear Hand Pie");
                add(getItemTrans(ModItems.PLUM_PIE), "Plum Hand Pie");
                add(getItemTrans(ModItems.RASPBERRY_PIE), "Raspberry Hand Pie");
                add(getItemTrans(ModItems.STRAWBERRY_PIE), "Strawberry Hand Pie");

                //Farmer's Delight renames
                add(getItemTrans(vectorwing.farmersdelight.common.registry.ModItems.SQUID_INK_PASTA), "Gourmet Squid Ink Pasta");
            }
        });
    }

    private static String getItemTrans(RegistryObject<Item> registryObject) {
        return "item." + registryObject.getId().getNamespace() + "." + registryObject.getId().getPath();
    }
}

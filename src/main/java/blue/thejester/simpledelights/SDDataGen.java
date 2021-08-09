package blue.thejester.simpledelights;

import enemeez.simplefarming.SimpleFarming;
import enemeez.simplefarming.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = SimpleDelights.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SDDataGen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        event.getGenerator().addProvider(new ItemModelProvider(event.getGenerator(), SimpleDelights.MODID, event.getExistingFileHelper()) {
            @Override
            protected void registerModels() {
                for (ResourceLocation item : SDItems.itemList()) {
                    withExistingParent(item.getPath(), "item/generated").texture("layer0", new ResourceLocation(SimpleDelights.MODID, "item/"+item.getPath()));
                }
            }
        });

        event.getGenerator().addProvider(new LanguageProvider(event.getGenerator(), SimpleDelights.MODID, "en_us") {
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

                //Simple Farming Renames
                add(getItemTrans(ModItems.fried_rice), "Omurice");
                add(getItemTrans(ModItems.egg_sandwich), "Bacon Egg Sandwich");
                add(getItemTrans(ModItems.pumpkin_soup), "Pumpkin Sauce");
                add(getItemTrans(ModItems.fruit_salad), "Mixed Fruit");
                add(getItemTrans(ModItems.apple_pie), "Apple Hand Pie");
                add(getItemTrans(ModItems.apricot_pie), "Apricot Hand Pie");
                add(getItemTrans(ModItems.blackberry_pie), "Blackberry Hand Pie");
                add(getItemTrans(ModItems.blueberry_pie), "Blueberry Hand Pie");
                add(getItemTrans(ModItems.cherry_pie), "Cherry Hand Pie");
                add(getItemTrans(ModItems.peanut_butter_pie), "Peanut Butter Hand Pie");
                add(getItemTrans(ModItems.pear_pie), "Pear Hand Pie");
                add(getItemTrans(ModItems.plum_pie), "Plum Hand Pie");
                add(getItemTrans(ModItems.raspberry_pie), "Raspberry Hand Pie");
                add(getItemTrans(ModItems.strawberry_pie), "Strawberry Hand Pie");

                //Farmer's Delight renames
                add(getItemTrans(vectorwing.farmersdelight.registry.ModItems.SQUID_INK_PASTA), "Gourmet Squid Ink Pasta");
            }
        });
    }

    private static String getItemTrans(RegistryObject<Item> registryObject) {
        return "item." + registryObject.getId().getNamespace() + "." + registryObject.getId().getPath();
    }

    private static String getItemTrans(Item registryObject) {
        return "item." + registryObject.getRegistryName().getNamespace() + "." + registryObject.getRegistryName().getPath();
    }
}

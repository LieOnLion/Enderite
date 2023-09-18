package io.github.lieonlion.enderite;

import com.mojang.logging.LogUtils;
import io.github.lieonlion.enderite.config.ClientConfigs;
import io.github.lieonlion.enderite.config.CommonConfigs;
import io.github.lieonlion.enderite.init.BlocksInit;
import io.github.lieonlion.enderite.init.ItemsInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Enderite.MODID)
public class Enderite {
    public static final String MODID = "lolenderite";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final ResourceLocation END_CITY_TREASURE_INJECTION_LOCATION = new ResourceLocation(MODID, "inject/chests/end_city_treasure");
    public static final ResourceLocation BG_TEXTURE = new ResourceLocation(MODID, "textures/gui/container/beacon.png");

    public Enderite() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemsInit.ITEMS.register(modEventBus);
        BlocksInit.BLOCKS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(ItemsInit::addItemsToCreativeTab);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfigs.SPEC, MODID + "-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfigs.SPEC, MODID + "-common.toml");
    }

    @SubscribeEvent
    public void loadLootTables(LootTableLoadEvent event) {
        if (event.getName().equals(BuiltInLootTables.END_CITY_TREASURE) && CommonConfigs.END_CITY_LOOT.get()) {
            event.getTable().addPool(LootPool.lootPool()
                    .add(LootTableReference.lootTableReference(Enderite.END_CITY_TREASURE_INJECTION_LOCATION))
                    .name(Enderite.MODID + "_injection").build());
        }
    }
}
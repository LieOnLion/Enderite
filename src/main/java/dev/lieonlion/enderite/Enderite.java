package dev.lieonlion.enderite;

import dev.lieonlion.enderite.init.BlocksInit;
import dev.lieonlion.enderite.init.ItemsInit;
import dev.lieonlion.enderite.mixin.LootTableAccessor;
import dev.lieonlion.enderite.world.OreGenerationInit;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootDataType;
import net.minecraft.loot.LootTables;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class Enderite implements ModInitializer {
	public static final String MODID = "lolenderite";
	public static final Identifier END_CITY_TREASURE_INJECTION_LOCATION = Enderite.asId("inject/chests/end_city_treasure");

	@Override
	public void onInitialize() {
		ItemsInit.registerItems();
		BlocksInit.registerBlocks();
		OreGenerationInit.generateOres();

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (id.equals(LootTables.END_CITY_TREASURE_CHEST)) {
				var pools = ((LootTableAccessor) Objects.requireNonNull(lootManager.getElement(LootDataType.LOOT_TABLES, END_CITY_TREASURE_INJECTION_LOCATION))).getPools();
				tableBuilder.pools(pools);
			}
		});
	}

	public static Identifier asId(String path) {
		return Identifier.of(MODID, path);
	}
}
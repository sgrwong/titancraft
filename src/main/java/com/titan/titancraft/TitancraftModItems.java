package com.titan.titancraft;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class TitancraftModItems {
    // Creates a deferred register to register our items into the game (this is then registered to a modbus in the Titancraft class)
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TitanCraft.MODID);

    // BELOW HERE IS FOR BLOCKITEMS
    public static final RegistryObject<BlockItem> landmine_grass_item = ITEMS.register("landmine_grass",
            () -> new BlockItem(TitancraftModBlocks.LANDMINE_GRASS.get(), new Item.Properties().tab(TitanCraft.TITANCRAFT_MISC)));
    public static final RegistryObject<BlockItem> landmine_sand_item = ITEMS.register("landmine_sand",
            () -> new BlockItem(TitancraftModBlocks.LANDMINE_SAND.get(), new Item.Properties().tab(TitanCraft.TITANCRAFT_MISC)));
    public static final RegistryObject<BlockItem> titanium_ore_item = ITEMS.register("titanium_ore",
            () -> new BlockItem(TitancraftModBlocks.TITANIUM_ORE.get(), new Item.Properties().tab(TitanCraft.TITANCRAFT_MATERIALS_TAB)));
    public static final RegistryObject<BlockItem> titanium_block_item = ITEMS.register("titanium_block",
            () -> new BlockItem(TitancraftModBlocks.TITANIUM_BLOCK.get(), new Item.Properties().tab(TitanCraft.TITANCRAFT_MATERIALS_TAB)));
    public static final RegistryObject<BlockItem> aluminium_ore_item = ITEMS.register("aluminium_ore",
            () -> new BlockItem(TitancraftModBlocks.ALUMINIUM_ORE.get(), new Item.Properties().tab(TitanCraft.TITANCRAFT_MATERIALS_TAB)));
    public static final RegistryObject<BlockItem> aluminium_block_item = ITEMS.register("aluminium_block",
            () -> new BlockItem(TitancraftModBlocks.ALUMINIUM_BLOCK.get(), new Item.Properties().tab(TitanCraft.TITANCRAFT_MATERIALS_TAB)));
    public static final RegistryObject<BlockItem> steel_block_item = ITEMS.register("steel_block",
            () -> new BlockItem(TitancraftModBlocks.STEEL_BLOCK.get(), new Item.Properties().tab(TitanCraft.TITANCRAFT_MATERIALS_TAB)));


    //Items
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_MATERIALS_TAB)));
    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_MATERIALS_TAB)));
    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_MATERIALS_TAB)));
    public static final RegistryObject<Item> RAW_ALUMINIUM = ITEMS.register("raw_aluminium", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_MATERIALS_TAB)));
    public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("aluminium_ingot", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_MATERIALS_TAB)));
    public static final RegistryObject<Item> ALUMINIUM_NUGGET = ITEMS.register("aluminium_nugget", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_MATERIALS_TAB)));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_MATERIALS_TAB)));
    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_MATERIALS_TAB)));



    //Crafting Materials
    public static final RegistryObject<Item> ALUMINIUM_WIRES = ITEMS.register("aluminium_wires", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));

    public static final RegistryObject<Item> ALUMINIUM_TITAN_PART = ITEMS.register("aluminium_titan_part", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> ALUMINIUM_TITAN_HEAD = ITEMS.register("aluminium_titan_head", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> ALUMINIUM_TITAN_BODY = ITEMS.register("aluminium_titan_body", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> ALUMINIUM_TITAN_LEFT_ARM = ITEMS.register("aluminium_titan_left_arm", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> ALUMINIUM_TITAN_RIGHT_ARM = ITEMS.register("aluminium_titan_right_arm", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> ALUMINIUM_TITAN_LEFT_LEG = ITEMS.register("aluminium_titan_left_leg", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> ALUMINIUM_TITAN_RIGHT_LEG = ITEMS.register("aluminium_titan_right_leg", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));

    public static final RegistryObject<Item> STEEL_TITAN_PART = ITEMS.register("steel_titan_part", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> STEEL_TITAN_HEAD = ITEMS.register("steel_titan_head", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> STEEL_TITAN_BODY = ITEMS.register("steel_titan_body", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> STEEL_TITAN_LEFT_ARM = ITEMS.register("steel_titan_left_arm", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> STEEL_TITAN_RIGHT_ARM = ITEMS.register("steel_titan_right_arm", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> STEEL_TITAN_LEFT_LEG = ITEMS.register("steel_titan_left_leg", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> STEEL_TITAN_RIGHT_LEG = ITEMS.register("steel_titan_right_leg", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));

    public static final RegistryObject<Item> TITANIUM_TITAN_PART = ITEMS.register("titanium_titan_part", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> TITANIUM_TITAN_HEAD = ITEMS.register("titanium_titan_head", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> TITANIUM_TITAN_BODY = ITEMS.register("titanium_titan_body", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> TITANIUM_TITAN_LEFT_ARM = ITEMS.register("titanium_titan_left_arm", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> TITANIUM_TITAN_RIGHT_ARM = ITEMS.register("titanium_titan_right_arm", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> TITANIUM_TITAN_LEFT_LEG = ITEMS.register("titanium_titan_left_leg", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));
    public static final RegistryObject<Item> TITANIUM_TITAN_RIGHT_LEG = ITEMS.register("titanium_titan_right_leg", () -> new Item(new Item.Properties().tab(TitanCraft.TITANCRAFT_ROBOT_PARTS_TAB)));

    // Spawn egg for Titan
    public static final RegistryObject<ForgeSpawnEggItem> ALUMINIUM_TITAN_BLUEPRINT = ITEMS.register("aluminium_titan_blueprint",
            () -> new ForgeSpawnEggItem(() -> TitancraftModEntities.ALUMINIUM_TITAN, 0x615654, 0x242120, new Item.Properties().tab(TitanCraft.TITANCRAFT_MISC)));

    public static final RegistryObject<ForgeSpawnEggItem> STEEL_TITAN_BLUEPRINT = ITEMS.register("steel_titan_blueprint",
            () -> new ForgeSpawnEggItem(() -> TitancraftModEntities.TITAN, 0x615654, 0x242120, new Item.Properties().tab(TitanCraft.TITANCRAFT_MISC)));

    public static final RegistryObject<ForgeSpawnEggItem> TITANIUM_TITAN_BLUEPRINT = ITEMS.register("titanium_titan_blueprint",
            () -> new ForgeSpawnEggItem(() -> TitancraftModEntities.TITANIUM_TITAN, 0x615654, 0x242120, new Item.Properties().tab(TitanCraft.TITANCRAFT_MISC)));


    // Spawn egg for MadBot
    public static final RegistryObject<ForgeSpawnEggItem> MADBOT_SPAWN_EGG = ITEMS.register("madbot_spawn_egg",
            () -> new ForgeSpawnEggItem(() -> TitancraftModEntities.MAD_BOT, 0x615654, 0x242120, new Item.Properties().tab(TitanCraft.TITANCRAFT_MISC)));
}

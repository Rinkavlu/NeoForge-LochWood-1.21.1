package net.rinkablu.lochwood.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.EventBus;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rinkablu.lochwood.Lockwood;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Lockwood.MOD_ID);


    public static final DeferredItem<Item> ANCIENTTREAT = ITEMS.register("ancienttreat",
            ()-> new Item(new Item.Properties()));



    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);


    }
}

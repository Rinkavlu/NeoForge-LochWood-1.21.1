package net.rinkablu.lochwood.event;

import net.rinkablu.lochwood.Lockwood;
import net.rinkablu.lochwood.entity.ModEntities;
import net.rinkablu.lochwood.entity.client.UnicornModel;
import net.rinkablu.lochwood.entity.custom.UnicornEntity;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = Lockwood.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(UnicornModel.LAYER_LOCATION, UnicornModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.UNICORN.get(), UnicornEntity.createAttributes().build());
    }
}

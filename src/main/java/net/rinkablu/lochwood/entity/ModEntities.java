package net.rinkablu.lochwood.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rinkablu.lochwood.Lockwood;
import net.rinkablu.lochwood.entity.custom.UnicornEntity;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Lockwood.MOD_ID);


public static final Supplier<EntityType<UnicornEntity>> UNICORN =
        ENTITY_TYPES.register("unicorn", () -> EntityType.Builder.of(UnicornEntity::new, MobCategory.CREATURE)
                .sized(1f,2f).build("unicorn"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

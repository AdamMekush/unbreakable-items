package dev.slide_am.unbreakable_items.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ItemStack.class)
public class ItemStackMixin {

	@Inject(method = "hurtAndBreak", at = @At("HEAD"), cancellable = true)
	public <T extends LivingEntity> void hurtAndBreak(int i, T livingEntity, Consumer<T> consumer, CallbackInfo info) {
		info.cancel();
	}
}
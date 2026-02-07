package zenith.utils.mixin.client;

import net.minecraft.client.particle.AbstractDustParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.AbstractDustParticleEffect; // <-- fixed import
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractDustParticle.class)
public abstract class ExampleClientMixin {

    @Inject(
        method = "<init>(Lnet/minecraft/client/world/ClientWorld;DDDDDDLnet/minecraft/particle/AbstractDustParticleEffect;Lnet/minecraft/client/particle/SpriteProvider;)V",
        at = @At("RETURN")
    )
    private void zenith$setRed(ClientWorld world, double x, double y, double z,
                               double velX, double velY, double velZ,
                               AbstractDustParticleEffect effect,
                               SpriteProvider spriteProvider,
                               CallbackInfo ci) {

        if (!world.getRegistryKey().getValue().getPath().equals("zenith")) return;


        ((AbstractDustParticle<?>) (Object) this).setColor(1f, 0f, 0f);
    }
}

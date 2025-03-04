package io.sc3.goodies.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class WorldgenProvider(
  out: FabricDataOutput,
  registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricDynamicRegistryProvider(out, registriesFuture) {
  override fun getName() = "sc-goodies worldgen"

  override fun configure(registries: RegistryWrapper.WrapperLookup, entries: Entries) {
    entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE))
  }
}

package io.github.lieonlion.enderite.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> ALLOW_CAPE_TEXTURE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> RECOLOUR_ELYTRA;

    static {
        BUILDER.push("Config for Enderite");

        BUILDER.push("Enderite Plated Elytra");
        ALLOW_CAPE_TEXTURE = BUILDER.comment("boolean - default | true")
                        .define("allow.cape.texture", true);
        RECOLOUR_ELYTRA = BUILDER.comment("boolean - default | false")
                .define("recolour.elytra", false);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}

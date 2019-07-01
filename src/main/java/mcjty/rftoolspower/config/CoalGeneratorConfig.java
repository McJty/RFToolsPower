package mcjty.rftoolspower.config;

import net.minecraftforge.common.ForgeConfigSpec;

// ----- Coal generator ------
public class CoalGeneratorConfig {

    public static final String SUB_CATEGORY_COALGENERATOR = "coalgenerator";

    public static ForgeConfigSpec.BooleanValue ENABLED;
    public static ForgeConfigSpec.IntValue MAXENERGY; // TODO change these to longs once Configuration supports them
    public static ForgeConfigSpec.IntValue SENDPERTICK;
    public static ForgeConfigSpec.IntValue CHARGEITEMPERTICK;
    public static ForgeConfigSpec.IntValue RFPERTICK;
    public static ForgeConfigSpec.IntValue TICKSPERCOAL;

    public static void setup(ForgeConfigSpec.Builder COMMON_BUILDER) {
        COMMON_BUILDER.comment("Coal generator settings").push(SUB_CATEGORY_COALGENERATOR);

        ENABLED = COMMON_BUILDER
                .comment("Whether the coal generator should exist")
                .define("enabled", true);

        RFPERTICK = COMMON_BUILDER
                .comment("Amount of RF generated per tick")
                .defineInRange("generatePerTick", 60, 0, Integer.MAX_VALUE);
        TICKSPERCOAL = COMMON_BUILDER
                .comment("Amount of ticks generated per coal")
                .defineInRange("ticksPerCoal", 600, 0, Integer.MAX_VALUE);
        MAXENERGY = COMMON_BUILDER
                .comment("Maximum RF storage that the generator can hold")
                .defineInRange("generatorMaxRF", 500000, 0, Integer.MAX_VALUE);
        SENDPERTICK = COMMON_BUILDER
                .comment("RF per tick that the generator can send")
                .defineInRange("generatorRFPerTick", 2000, 0, Integer.MAX_VALUE);
        CHARGEITEMPERTICK = COMMON_BUILDER
                .comment("RF per tick that the generator can charge items with")
                .defineInRange("generatorChargePerTick", 1000, 0, Integer.MAX_VALUE);

        COMMON_BUILDER.pop();
    }

}
package mcjty.rftoolspower.modules.endergenic.client;

import mcjty.rftoolspower.modules.endergenic.EndergenicModule;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraftforge.client.event.TextureStitchEvent;

public class ClientSetup {
    public static void initClient() {
        RenderTypeLookup.setRenderLayer(EndergenicModule.ENDERGENIC.get(), RenderType.getTranslucent());
    }

    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        if (!event.getMap().getTextureLocation().equals(AtlasTexture.LOCATION_BLOCKS_TEXTURE)) {
            return;
        }

        event.addSprite(EndergenicRenderer.HALO);
        event.addSprite(EndergenicRenderer.BLACKFLASH);
        event.addSprite(EndergenicRenderer.WHITEFLASH);
        event.addSprite(EndergenicRenderer.BLUEGLOW);
        event.addSprite(EndergenicRenderer.REDGLOW);
    }
}

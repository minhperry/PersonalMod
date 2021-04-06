package net.minhperry.suichat;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minhperry.suichat.listener.ChatListener;

import java.io.File;

@Mod(modid = ModInfo.MODID, name = ModInfo.MOD_NAME, version = ModInfo.VERSION, acceptedMinecraftVersions = "[1.8.9]", clientSideOnly = true, useMetadata = true)
public class Main
{
    public static final Minecraft mc = Minecraft.getMinecraft();

    // public static Config config = new Config();
    public static File modDir;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // modDir = new File(event.getModConfigurationDirectory(), "suichat");
        // if (!modDir.exists()) modDir.mkdirs();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new ChatListener());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}

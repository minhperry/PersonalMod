package net.minhperry;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minhperry.commands.Suimands;
import net.minhperry.core.Config;
import net.minhperry.listener.DuckListener;
import net.minhperry.listener.EZListener;
import net.minhperry.listener.JoinLeaveListener;
import net.minhperry.listener.SuibotListener;

import java.io.File;

@Mod(modid = ModInfo.MODID, name = ModInfo.MOD_NAME, version = ModInfo.VERSION, acceptedMinecraftVersions = "[1.8.9]", clientSideOnly = true, useMetadata = true)
public class Suichat
{
    public static final Minecraft mc = Minecraft.getMinecraft();

    public static Config config = new Config();
    public static File modDir;
    public static File jarFile = null;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        modDir = new File(event.getModConfigurationDirectory(), "suimod");
        if (!modDir.exists()) modDir.mkdirs();
        jarFile = event.getSourceFile();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModCoreInstaller.initializeModCore(mc.mcDataDir);

        config.preload();

        ClientCommandHandler.instance.registerCommand(new Suimands());

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new SuibotListener());
        MinecraftForge.EVENT_BUS.register(new JoinLeaveListener());
        // MinecraftForge.EVENT_BUS.register(new EZListener());
        MinecraftForge.EVENT_BUS.register(new DuckListener());
        MinecraftForge.EVENT_BUS.register(new JoinLeaveListener());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Join Infrared guild to be unbald");
        System.out.println("discord.gg/irontop");
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }
}

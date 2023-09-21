package com.minecraftbrasil.teddy.minecraftgui;

import com.minecraftbrasil.teddy.minecraftgui.gui.MenuExample;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftGui extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("menu").setExecutor(new MenuExample());
        getServer().getPluginManager().registerEvents(new MenuExample(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

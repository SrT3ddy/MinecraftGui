package com.minecraftbrasil.teddy.minecraftgui;

import com.minecraftbrasil.teddy.minecraftgui.commands.MenuCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecraftGui extends JavaPlugin {

    @Override
    public void onEnable() {
        // Registre o ouvinte de eventos
        getServer().getPluginManager().registerEvents(new MyListener(), this);

        // Registre seu comando personalizado para abrir o menu
        getCommand("menu").setExecutor(new MenuCommand());

        // Exiba uma mensagem informativa no console quando o plugin é ativado
        getLogger().info(" O plugin foi ativado com sucesso!");
    }

    @Override
    public void onDisable() {
        // Exiba uma mensagem informativa no console quando o plugin é desativado
        getLogger().info(" O plugin foi desativado.");
    }
}

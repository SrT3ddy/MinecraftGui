package com.minecraftbrasil.teddy.minecraftgui.commands;

import com.minecraftbrasil.teddy.minecraftgui.inventory.MyMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Este comando só pode ser usado por jogadores.");
            return true;
        }

        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("menu")) {
            // Crie e abra o menu para o jogador
            new MyMenu(player);
            return true;
        }

        return false;
    }
}

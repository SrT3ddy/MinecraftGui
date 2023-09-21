package com.minecraftbrasil.teddy.minecraftgui.gui;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;


import java.util.Arrays;

public class MenuExample implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (command.getName().equalsIgnoreCase("menu")) {
                // Crie um inventário para o menu
                Inventory menuInventory = player.getServer().createInventory(player, 27, "Exemplo de Menu");

                // Adicione itens ao menu nos slots 11, 13 e 15
                menuInventory.setItem(11, createItem(Material.DIAMOND_SWORD, "Item 1", "Descrição do Item 1"));
                menuInventory.setItem(13, createItem(Material.GOLDEN_APPLE, "Item 2", "Descrição do Item 2"));
                menuInventory.setItem(15, createItem(Material.BOW, "Item 3", "Descrição do Item 3"));

                // Abra o inventário para o jogador
                player.openInventory(menuInventory);
            }
        }

        return true;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null || clickedItem.getType() == Material.AIR) {
            return; // Não faça nada se o item clicado for nulo ou vazio.
        }

        // Verifique se o jogador está clicando no inventário do menu
        if (event.getInventory().getName().equals("Exemplo de Menu")) {
            event.setCancelled(true); // Bloqueie a remoção de itens do menu
        }
    }

    // Função auxiliar para criar itens com nome e descrição
    private ItemStack createItem(Material material, String name, String... lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }
}

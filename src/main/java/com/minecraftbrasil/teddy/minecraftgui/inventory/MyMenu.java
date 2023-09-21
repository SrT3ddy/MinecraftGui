package com.minecraftbrasil.teddy.minecraftgui.inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class MyMenu implements InventoryHolder {

    private Inventory inventory = Bukkit.createInventory(this, 3 * 9, "Meu menu");
    private Player target;
    private Plugin plugin; // Adicionamos uma referência ao plugin

    public MyMenu(Player player) {
        this.target = player;
        this.plugin = plugin;

        // Preencha o inventário com itens
        inventory.setItem(11, createItem(Material.DIAMOND_SWORD, "Espada Poderosa", "Clique para receber uma espada!"));
        inventory.setItem(13, createItem(Material.GOLDEN_APPLE, "Maçã Dourada", "Clique para receber uma maçã dourada!"));
        inventory.setItem(15, createItem(Material.BOW, "Arco Arcano", "Clique para receber um arco!"));

        // Abra o menu
        player.openInventory(inventory);
    }

    public boolean trigger(ItemStack clickedItem) {
        Player player = target;

        // Verifique se o item clicado não é nulo ou um espaço vazio
        if (clickedItem == null || clickedItem.getType() == Material.AIR) {
            return false;
        }

        // Verifique qual item foi clicado e conceda um item diferente ao jogador
        if (clickedItem.getType() == Material.DIAMOND_SWORD) {
            player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
        } else if (clickedItem.getType() == Material.GOLDEN_APPLE) {
            player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
        } else if (clickedItem.getType() == Material.BOW) {
            player.getInventory().addItem(new ItemStack(Material.BOW));
        }

        // Feche o inventário após clicar em um item
        player.closeInventory();

        return true;
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    private ItemStack createItem(Material material, String name, String... lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        // Defina o nome do item com estilo normal
        meta.setDisplayName(ChatColor.RESET + name);

        if (lore.length > 0) {
            List<String> loreList = new ArrayList<>();
            for (String line : lore) {
                // Defina cada linha da lore com estilo normal
                loreList.add(ChatColor.RESET + line);
            }
            meta.setLore(loreList);
        }

        item.setItemMeta(meta);
        return item;
    }
}


package com.minecraftbrasil.teddy.minecraftgui;

import com.minecraftbrasil.teddy.minecraftgui.inventory.MyMenu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MyListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        // Filtrar eventos inválidos
        if (event.getInventory() == null || event.getCurrentItem() == null) return;

        // Verifique se o inventário é uma instância do nosso menu
        if (event.getInventory().getHolder() instanceof MyMenu) {
            // Chame a função e mantenha seu estado
            boolean cancel = ((MyMenu) event.getInventory().getHolder()).trigger(event.getCurrentItem());
            // Defina o evento como cancelado com base no estado retornado
            event.setCancelled(cancel);
        }
    }
}

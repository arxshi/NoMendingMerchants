package me.arahis.nomendingmerchants.listeners;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class VillagerAcquireTradeListener implements Listener {

    @EventHandler
    public void onAcquire(VillagerAcquireTradeEvent event) {
        MerchantRecipe recipe = event.getRecipe();
        ItemStack result = recipe.getResult();
        if (result.getType().equals(Material.ENCHANTED_BOOK)) {
            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) result.getItemMeta();
            if (meta.getStoredEnchants().containsKey(Enchantment.MENDING)) {
                event.setCancelled(true);
                System.out.println("Mending book found and deleted");
            }
        } else {
            ItemMeta meta = result.getItemMeta();
            if(meta.getEnchants().containsKey(Enchantment.MENDING)) {
                event.setCancelled(true);
                System.out.println("Mending on item found and deleted");
            }
        }
    }
}

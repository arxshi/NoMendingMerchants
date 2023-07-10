package me.arahis.nomendingmerchants;

import me.arahis.nomendingmerchants.commands.MendingCoreCommand;
import me.arahis.nomendingmerchants.commands.subcommands.OffCommand;
import me.arahis.nomendingmerchants.commands.subcommands.OnCommand;
import me.arahis.nomendingmerchants.listeners.VillagerAcquireTradeListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoMendingMerchants extends JavaPlugin {

    private static NoMendingMerchants plugin;
    private MendingCoreCommand coreCommand;

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveConfig();

        plugin = this;
        coreCommand = new MendingCoreCommand();

        getCommand("mending").setExecutor(new MendingCoreCommand());

        Bukkit.getPluginManager().registerEvents(new VillagerAcquireTradeListener(), this);

    }

    public static NoMendingMerchants getPlugin() {
        return plugin;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

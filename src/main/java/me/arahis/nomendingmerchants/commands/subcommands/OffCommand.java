package me.arahis.nomendingmerchants.commands.subcommands;

import me.arahis.nomendingmerchants.NoMendingMerchants;
import me.arahis.nomendingmerchants.commands.SubCommand;
import me.arahis.nomendingmerchants.listeners.VillagerAcquireTradeListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class OffCommand extends SubCommand {
    @Override
    public String getName() {
        return "off";
    }

    @Override
    public String getDescription() {
        return "Выключает возможность появления починки у жителей";
    }

    @Override
    public String getSyntax() {
        return "/mending off";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        Bukkit.getPluginManager().registerEvents(new VillagerAcquireTradeListener(), NoMendingMerchants.getPlugin());
        sender.sendMessage("Mending now is off");

    }
}

package me.arahis.nomendingmerchants.commands.subcommands;

import me.arahis.nomendingmerchants.NoMendingMerchants;
import me.arahis.nomendingmerchants.commands.SubCommand;
import me.arahis.nomendingmerchants.listeners.VillagerAcquireTradeListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;

public class OnCommand extends SubCommand {
    @Override
    public String getName() {
        return "on";
    }

    @Override
    public String getDescription() {
        return "Включает возможность появление починки у жителей";
    }

    @Override
    public String getSyntax() {
        return "/mending on";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        VillagerAcquireTradeEvent.getHandlerList().unregister(NoMendingMerchants.getPlugin());
        sender.sendMessage("Mending now is on");

    }
}

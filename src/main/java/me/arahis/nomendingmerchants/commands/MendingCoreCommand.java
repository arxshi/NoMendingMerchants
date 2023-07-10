package me.arahis.nomendingmerchants.commands;

import me.arahis.nomendingmerchants.commands.subcommands.OffCommand;
import me.arahis.nomendingmerchants.commands.subcommands.OnCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MendingCoreCommand implements CommandExecutor {

    List<SubCommand> subCommands = new ArrayList<>();

    public MendingCoreCommand() {
        subCommands.add(new OffCommand());
        subCommands.add(new OnCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length > 0) {
            for(SubCommand subCommand : subCommands) {
                if(args[0].equals(subCommand.getName())) {
                    subCommand.execute(sender, args);
                } else {
                    sender.sendMessage("Unknown command");
                }
            }
        }
        return true;
    }
}

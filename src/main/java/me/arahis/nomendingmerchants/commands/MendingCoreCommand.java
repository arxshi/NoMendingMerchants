package me.arahis.nomendingmerchants.commands;

import me.arahis.nomendingmerchants.commands.subcommands.OffCommand;
import me.arahis.nomendingmerchants.commands.subcommands.OnCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MendingCoreCommand implements CommandExecutor, TabCompleter {

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
                }
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) return subCommands.stream().map(SubCommand::getName).collect(Collectors.toList());
        return null;
    }
}

package de.kumo.leviathan.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.kumo.leviathan.Main;

public class heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            p.setHealth(20);
            p.setFoodLevel(20);

        } else
            sender.sendMessage(Main.pre + Main.noperm);

        return false;
    }

}
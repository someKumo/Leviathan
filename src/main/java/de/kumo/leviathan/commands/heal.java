package de.kumo.leviathan.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.kumo.leviathan.Main;
import org.jetbrains.annotations.NotNull;

public class heal implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {

        //checks if player is "Human"
        if (sender instanceof Player) {
            Player player = (Player) sender;
            //checks if /heal needs OP from config
            if (Main.config.getBoolean("/heal needs OP")) {
                if (player.hasPermission("essentials.heal")) {
                    player.setHealth(20);
                    player.setFoodLevel(20);
                } else {
                    sender.sendMessage(Main.prefix + Main.noperm);
                }
            } else {
                player.setHealth(20);
                player.setFoodLevel(20);
            }


        } else {
            sender.sendMessage(Main.prefix + Main.noperm);
        }
        return false;
    }

}
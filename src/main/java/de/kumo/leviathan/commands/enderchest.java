package de.kumo.leviathan.commands;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.kumo.leviathan.Main;
import org.jetbrains.annotations.NotNull;

public class enderchest implements CommandExecutor {

    public static ArrayList<UUID> enderchest = new ArrayList<UUID>();

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {

        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);
        //checks if sender is player
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.prefix + Main.noperm);
            return true;
        }
        //checks if config says needs OP
        if (Main.config.getBoolean("/enderchest needs OP")) {
            //true
            //checks if Player has OP
            if (!player.hasPermission("essentials.enderchest")) {
                //Player does not have OP
                player.sendMessage(Main.prefix + Main.noperm);
                return true;
            } else {
                //Player has OP
                player.openInventory(target.getEnderChest());
                enderchest.contains(player.getUniqueId());
            }
        } else {
            //false
            if (args.length == 0) {
                player.openInventory(player.getEnderChest());
            } else if (args.length == 1) {
                if (!player.hasPermission("essentials.enderchest")) {
                    player.sendMessage(Main.prefix + Main.noperm);
                    return true;
                }
                if (target == null) {
                    player.sendMessage(Main.prefix + "§cThis Player is currently not online!");
                    return true;
                }
                player.openInventory(target.getEnderChest());
                enderchest.contains(player.getUniqueId());
            }
        }
        return false;
    }
}
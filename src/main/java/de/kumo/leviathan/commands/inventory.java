package de.kumo.leviathan.commands;

import de.kumo.leviathan.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.UUID;

public class inventory implements CommandExecutor {
    public static ArrayList<UUID> inventory = new ArrayList<UUID>();

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String Label, @NotNull String[] args) {

        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.prefix + Main.noperm);
            return true;
        }
        if (Main.config.getBoolean("/invetory needs OP")) {
            if (player.hasPermission("essentials.inventory")) {
                if (args.length == 0) {
                    player.openInventory(player.getInventory());
                } else if (args.length == 1) {
                    player.openInventory(target.getInventory());
                    inventory.contains(player.getUniqueId());
                }
            } else {
                player.sendMessage(Main.prefix + Main.noperm);
            }
        } else {
            if (args.length == 0) {
                player.openInventory(player.getInventory());
            } else if (args.length == 1) {
                player.openInventory(target.getInventory());
                inventory.contains(player.getUniqueId());
            }
        }
        return false;
    }
}

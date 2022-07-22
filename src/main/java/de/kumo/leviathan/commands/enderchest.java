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

        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + Main.noperm);
            return true;
        }

        Player p = (Player) sender;


        if (args.length == 0) {
            p.openInventory(p.getEnderChest());
        } else if (args.length == 1) {
            if (!p.hasPermission("essentials.enderchest")) {
                p.sendMessage(Main.pre + Main.noperm);
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                p.sendMessage(Main.pre + "§cThis Player is currently not online!");
                return true;
            }
            p.openInventory(target.getEnderChest());
            enderchest.contains(p.getUniqueId());
        }

        return false;
    }


}
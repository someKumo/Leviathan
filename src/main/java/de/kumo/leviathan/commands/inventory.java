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

        Player p = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + Main.noperm);
            return true;
        }
        if (args.length == 0) {
            p.openInventory(p.getInventory());
        } else if (args.length == 1) {
            p.openInventory(target.getInventory());
            inventory.contains(p.getUniqueId());
        }


        return false;
    }
}

package de.kumo.leviathan.commands;

import de.kumo.leviathan.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class vanish implements CommandExecutor {

    Main plugin;

    public vanish(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        Player player = (Player) sender;
        if (sender instanceof Player) {
            if (plugin.vanish.contains(player)) {
                for (Player people : Bukkit.getOnlinePlayers()) {
                    people.showPlayer(plugin, player);
                }
                plugin.vanish.remove(player);
                player.sendMessage(Main.prefix + "You are now visible to other players on the server.");
            } else if (!plugin.vanish.contains(player)) {
                for (Player people : Bukkit.getOnlinePlayers()) {
                    people.hidePlayer(plugin, player);
                }
                plugin.vanish.add(player);
                player.sendMessage(Main.prefix + "You are now invisible!");
            }
        } else {
            player.sendMessage(Main.prefix + Main.noperm);
        }

        return true;
    }
}

package de.kumo.leviathan.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import de.kumo.leviathan.Main;

import java.util.Objects;


public class mute implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

        if (!p.hasPermission("essentials.Mute")) {
            p.hasPermission(Main.prefix + Main.noperm);
        } else {
            if (args.length == 1) {
                if (Main.mute.contains(Objects.requireNonNull(target).getName())) {
                    p.sendMessage(Main.prefix + "§b" + target.getName() + " §7has been unmuted.");
                    Main.mute.remove(target.getName());
                } else {
                    p.sendMessage(Main.prefix + "§b" + target.getName() + " §7has been muted.");
                    Main.mute.add(target.getName());
                }
            } else {
                p.sendMessage("§3 Usage: §c /mute <Player>");
            }


        }


        return false;
    }

}

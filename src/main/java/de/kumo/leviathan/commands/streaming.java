package de.kumo.leviathan.commands;


import de.kumo.leviathan.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class streaming implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player)sender;
        Player target = Bukkit.getPlayer(args[0]);

        if(!p.hasPermission("essentials.live")) {
            p.hasPermission(Main.pre + Main.noperm);
        }
        if (args.length == 1) {
            if(sender instanceof Player){

            }
        } else {
            p.sendMessage(Main.pre + "§3 Usage: §c /live");
        }
















        return false;
    }
}

package de.kumo.leviathan.commands;

import de.kumo.leviathan.Main;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class workbench implements CommandExecutor {
    public boolean onCommand(CommandSender sender,  Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if(sender instanceof Player && (sender.hasPermission("essentials.workbench"))){
            p.openWorkbench(null, true);
            return true;
        } else {
            p.sendMessage(Main.pre + Main.noperm);
        }
        return false;
    }
}
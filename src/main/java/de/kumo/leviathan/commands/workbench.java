package de.kumo.leviathan.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class workbench implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender,  Command cmd, String label, String[] args) {

        if(sender instanceof Player && (sender.hasPermission("essentials.workbench"))){
            Player p = (Player)sender;

            p.openWorkbench(null, true);
            return true;
        }

        return false;
    }

}
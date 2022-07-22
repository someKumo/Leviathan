package de.kumo.leviathan.commands;


import de.kumo.leviathan.Main;

import java.awt.*;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class live implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {

        Player p = (Player) sender;

        if (args.length == 0) {
            if (Main.live.contains(Objects.requireNonNull(p).getName())) {
                p.sendMessage(Main.pre + Color.darkGray + "you're no longer Live!");
                Main.live.remove(p.getName());
            } else {
                p.sendMessage(Main.pre + Color.darkGray + "you're now Live!");
                Main.live.add(p.getName());
            }
        } else {
            p.sendMessage(Main.pre + "§3 Usage: §c /live");
        }


        return false;
    }
}

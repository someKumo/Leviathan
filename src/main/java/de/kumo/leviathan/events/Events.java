package de.kumo.leviathan.events;

import de.kumo.leviathan.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import static de.kumo.leviathan.Main.config;

public class Events implements Listener {

    Main plugin;

    public Events(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        for (int i = 0; i < Main.vanish.size(); i++) {
            player.hidePlayer(plugin, Main.vanish.get(i));
        }
    }

    @EventHandler
    public void DeathEvent(PlayerDeathEvent event) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(ChatColor.YELLOW + "F, " + event.getPlayer().getName());
        }
    }

    @EventHandler
    public void killEnderDragon(EntityDeathEvent e) {

        //Get Dead Entity
        Entity deadEntity = e.getEntity();

        //Get Killer
        Entity killer = e.getEntity().getKiller();


        if (killer instanceof Player && deadEntity instanceof EnderDragon) {
            Player player = (Player) killer;

            int killCount = 0;

            String path = "dragonkills." + player.getName().toLowerCase();

            if (config.contains(path)) {
                killCount = config.getInt(path);
            }
            //add one to the counter
            config.set(path, killCount + 1);
            plugin.saveConfig();

            player.sendMessage(ChatColor.GREEN + "You have killed a dragon!");
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage(ChatColor.GRAY + "The " + ChatColor.DARK_PURPLE + "Ender Dragon " + ChatColor.GRAY + "has been slayed!");
            }
        }
    }

    @EventHandler
    public void killWither(EntityDeathEvent e) {

        //Get Dead Entity
        Entity deadEntity = e.getEntity();

        //Get Killer
        Entity killer = e.getEntity().getKiller();


        if (killer instanceof Player && deadEntity instanceof Wither) {
            Player player = (Player) killer;

            int killCount = 0;

            String path = "witherkills." + player.getName().toLowerCase();

            if (Main.config.contains(path)) {
                killCount = config.getInt(path);
            }
            //add one to the counter
            Main.config.set(path, killCount + 1);
            plugin.saveConfig();

            player.sendMessage(ChatColor.GREEN + "You have killed the Wither!");
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage(ChatColor.GRAY + "The " + ChatColor.DARK_PURPLE + "Wither " + ChatColor.GRAY + "has been killed!");
            }
        }

    }


}

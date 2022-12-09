package de.kumo.leviathan;

import de.kumo.leviathan.commands.*;
import de.kumo.leviathan.events.Events;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.Objects;


public class Main extends JavaPlugin implements Listener {

    public static String prefix = "§8[§bLeviathan§8] | §7";
    public static String noperm = "§cSorry§7. Not today!";

    public static FileConfiguration config;

    public static ArrayList<String> mute = new ArrayList<>();
    public static ArrayList<String> live = new ArrayList<>();
    public static ArrayList<Player> vanish = new ArrayList<>();

    public void onEnable() {

        getServer().getPluginManager().registerEvents(new Events(this), this);

        //Config

        FileConfiguration config = getConfig();
        config.addDefault("Is the Config working?", true);
        config.addDefault("/enderchest needs OP", true);
        config.addDefault("/heal needs OP", true);
        config.addDefault("/inventory need OP", true);
        config.addDefault("witherkillcount", 0);
        config.addDefault("enderdragonkillcount", 0);
        config.options().copyDefaults(true);
        saveConfig();

        //Config Check

        if (config.getBoolean("Is the Config working?")) {
            Bukkit.getConsoleSender().sendMessage(Main.prefix + "Config is§a fine§7!");
        } else {
            Bukkit.getConsoleSender().sendMessage(Main.prefix + "Config is§c not§7 fine!");
        }
        Bukkit.getConsoleSender().sendMessage(Main.prefix + "§aSuccessfully§7 started up!");


        //Command Registration

        Objects.requireNonNull(getCommand("heal")).setExecutor(new heal());
        Objects.requireNonNull(getCommand("ec")).setExecutor(new enderchest());
        Objects.requireNonNull(getCommand("mute")).setExecutor(new mute());
        Objects.requireNonNull(getCommand("workbench")).setExecutor(new workbench());
    }


    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Main.prefix + "§cDeactivated§7!");
    }

}


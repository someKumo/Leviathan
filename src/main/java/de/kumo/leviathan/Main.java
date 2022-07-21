package de.kumo.leviathan;

import de.kumo.leviathan.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.Objects;


public class Main extends JavaPlugin implements Listener {

    public static String pre = "§8[§bLeviathan§8] | §7";
    public static String noperm = "§8Sorry. not today";

    FileConfiguration config = getConfig();

    public static ArrayList<String> mute = new ArrayList<>();
    public static ArrayList<String> live = new ArrayList<>();
    public static ArrayList<String> inventory = new ArrayList<>();



    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(Main.pre + "§8Leviathan started up");

        config.addDefault("is the Config working? (should be true)", true);
        config.options().copyDefaults(true);
        saveConfig();

        //Command Registration

        Objects.requireNonNull(getCommand("heal")).setExecutor(new heal());
        Objects.requireNonNull(getCommand("ec")).setExecutor(new enderchest());
        Objects.requireNonNull(getCommand("mute")).setExecutor(new mute());
        Objects.requireNonNull(getCommand("workbench")).setExecutor(new workbench());
        Objects.requireNonNull(getCommand("live")).setExecutor(new streaming());
        Objects.requireNonNull(getCommand("inventory")).setExecutor((new inventory()));
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§c Leviathan deactivated!");
    }

}


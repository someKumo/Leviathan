package de.kumo.leviathan;

import de.kumo.leviathan.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.Objects;


public class Main extends JavaPlugin {

    public static String pre = "§8[§bLeviathan§8] | §7";
    public static String noperm = "§8Sorry. not today";

    public static ArrayList<String> mute = new ArrayList<>();
    public static ArrayList<String> live = new ArrayList<>();
    public static ArrayList<String> inventory = new ArrayList<>();



    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(Main.pre + "§8booting...");
        Bukkit.getConsoleSender().sendMessage(Main.pre + "§8loading Libraries...");
        Bukkit.getConsoleSender().sendMessage(Main.pre + "§8loading Commands...");
        Bukkit.getConsoleSender().sendMessage(Main.pre + "§8loading Essentials...");
        Bukkit.getConsoleSender().sendMessage(Main.pre + "§8booting §2finished!");
        Bukkit.getConsoleSender().sendMessage(Main.pre + "§8Leviathan started up");

        //Command Registration

        Objects.requireNonNull(getCommand("heal")).setExecutor(new heal());
        Objects.requireNonNull(getCommand("ec")).setExecutor(new enderchest());
        Objects.requireNonNull(getCommand("mute")).setExecutor(new mute());
        Objects.requireNonNull(getCommand("workbench")).setExecutor(new workbench());
        Objects.requireNonNull(getCommand("live")).setExecutor(new streaming());





    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§c Leviathan deactivated!");
    }

}


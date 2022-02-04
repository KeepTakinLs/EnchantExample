package com.keep.ExampleEnchant;

import com.keep.ExampleEnchant.Enchant.DamageEnchant;
import com.keep.ExampleEnchant.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class ExampleEnchant extends JavaPlugin {

    @Override
    public void onEnable() {
        Utils.console("ExampleEnchants LOADED");
        Utils.console("&2&lMade by&f: &a&nKeepTakinLs#0001");
        registerEvents();
        registerCommands();
        saveDefaultConfig();
    }
    public HashMap<Player, Long> cooldown = new HashMap();

    public void registerListener(Listener listener) { Bukkit.getServer().getPluginManager().registerEvents(listener, this); }

    public void registerEvents() {
        registerListener(new DamageEnchant());
    }
    public void registerCommands() {
    }
}

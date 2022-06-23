package me.xingyan.potion;

import me.xingyan.potion.Commands.CompleterTab;
import me.xingyan.potion.Commands.PotionCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Potion extends JavaPlugin {

    public static Plugin plugin = null;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getCommand("potion").setExecutor(new PotionCommand());
        getCommand("potion").setTabCompleter(new CompleterTab());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

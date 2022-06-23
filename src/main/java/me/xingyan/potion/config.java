package me.xingyan.potion;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

import static me.xingyan.potion.Potion.plugin;

public class config {

    File configFile = new File(plugin.getDataFolder()+"/config.yml");

    YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);

    private final String prefix = config.getString("prefix");
    private final String messageerrornotfound = config.getString("message.error.notfound");
    private final String messageerroramplifierbigger = config.getString("message.error.amplifier.bigger");
    private final String messageerroramplifiersmaller = config.getString("message.error.amplifier.smaller");
    private final String messageerrordurationbigger = config.getString("message.error.duration.bigger");
    private final String messageerrordurationsmaller = config.getString("message.error.duration.smaller");
    private final String messagesuccessfulget = config.getString("message.successful.get");
    private final String messagereload = config.getString("message.reload");
    private final String messageerrorplayeronly = config.getString("message.error.playeronly");

    public String getPrefix(){
        return prefix;
    }
    public String getMessageerrornotfound() { return messageerrornotfound; }
    public String getMessageerroramplifierbigger() {return messageerroramplifierbigger;}
    public String getMessageerroramplifiersmaller() {return messageerroramplifiersmaller;}
    public String getMessageerrordurationbigger() {return messageerrordurationbigger;}
    public String getMessageerrordurationsmaller() {return messageerrordurationsmaller;}
    public String getMessagesuccessfulget() {return messagesuccessfulget;}
    public String getMessagereload() {return messagereload;}
    public String getMessageerrorplayeronly() {return messageerrorplayeronly;}

    public void reloadconfig(){
        config = YamlConfiguration.loadConfiguration(configFile);
    }
}

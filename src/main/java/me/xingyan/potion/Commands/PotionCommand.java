package me.xingyan.potion.Commands;

import me.xingyan.potion.Statics.PotionColor;
import me.xingyan.potion.Statics.RomanNumber;
import me.xingyan.potion.Statics.vanillatobukkit;
import me.xingyan.potion.config;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class PotionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        String prefix = ChatColor.translateAlternateColorCodes('&', new config().getPrefix());
        String messageerrornotfound = ChatColor.translateAlternateColorCodes('&', new config().getMessageerrornotfound());
        String messageerroramplifierbigger = ChatColor.translateAlternateColorCodes('&', new config().getMessageerroramplifierbigger());
        String messageerroramplifiersmaller = ChatColor.translateAlternateColorCodes('&', new config().getMessageerroramplifiersmaller());
        String messageerrordurationbigger = ChatColor.translateAlternateColorCodes('&', new config().getMessageerrordurationbigger());
        String messageerrordurationsmaller = ChatColor.translateAlternateColorCodes('&', new config().getMessageerrordurationsmaller());
        String messagesuccessfulget = ChatColor.translateAlternateColorCodes('&', new config().getMessagesuccessfulget());
        String messagereload = ChatColor.translateAlternateColorCodes('&', new config().getMessagereload());
        String messageerrorplayeronly = ChatColor.translateAlternateColorCodes('&', new config().getMessageerrorplayeronly());

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("potion.admin")){
                if(args.length==0){
                    player.sendMessage(prefix+"/potion get <effect> <duration> <amplifier>");
                    player.sendMessage(prefix+"/potion reload");
                    return true;
                }
                if(args.length>=4){
                    if(args[0].equals("get")){
                        if(Long.parseLong(args[3])<=0) {
                            player.sendMessage(prefix+messageerroramplifiersmaller);
                            return true;
                        }
                        if(Long.parseLong(args[3])>=129) {
                            player.sendMessage(prefix+ChatColor.RED+messageerroramplifierbigger);
                            return true;
                        }
                        if(Long.parseLong(args[2])>=Long.parseLong("536870912")){
                            player.sendMessage(prefix+messageerrordurationbigger);
                            return true;
                        }
                        if(Long.parseLong(args[2])<=Long.parseLong("0")){
                            player.sendMessage(prefix+messageerrordurationsmaller);
                            return true;
                        }
                        if(PotionEffectType.getByName(vanillatobukkit.tobukkit(args[1])) == null){
                            player.sendMessage(prefix+messageerrornotfound);
                            return true;
                        }
                        player.getInventory().addItem(createpotion(PotionEffectType.getByName(vanillatobukkit.tobukkit(args[1])), Integer.parseInt(args[2])*20, Integer.parseInt(args[3])-1));
                        int remainder = Integer.parseInt(args[2]);
                        int mins = remainder / 60;
                        remainder = remainder - mins * 60;
                        String secs = String.valueOf(remainder);
                        if(secs.equals("0")){
                            secs = "00";
                        }
                        String potionname = WordUtils.capitalizeFully(vanillatobukkit.tovanilla(PotionEffectType.getByName(vanillatobukkit.tobukkit(args[1])).getName()).toLowerCase(Locale.ROOT).replace("_", " "));
                        String potionlevel = RomanNumber.toRoman(Integer.parseInt(args[2]));
                        String potiontime = "("+mins+":"+secs+")";
                        String finalget = messagesuccessfulget.replace("%potion%", potionname).replace("%level%", potionlevel).replace("%time%", potiontime);
                        player.sendMessage(prefix+finalget);
                        return true;
                    }
                }
                if(args[0].equals("reload")){
                    new config().reloadconfig();
                    player.sendMessage(prefix+messagereload);
                    return true;
                }
            }
        }else{
            sender.sendMessage(prefix+messageerrorplayeronly);
            return true;
        }

        return true;
    }


    private static ItemStack createpotion(PotionEffectType effect, int duration, int amplifier){
        //, int duration, int amplifier
        ItemStack is = new ItemStack(Material.POTION);
        PotionMeta pm = (PotionMeta) is.getItemMeta();
        //pm.addCustomEffect(new PotionEffect(effect, duration, amplifier), true);
        pm.addCustomEffect(new PotionEffect(effect, duration, amplifier), true);
        pm.setColor(Color.fromRGB(PotionColor.color(effect)));
        is.setItemMeta(pm);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(ChatColor.WHITE+WordUtils.capitalizeFully(vanillatobukkit.tovanilla(effect.getName()).toLowerCase(Locale.ROOT).replace("_", " "))+" Potion");
        is.setItemMeta(im);
        return is;
    }
}

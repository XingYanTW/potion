package me.xingyan.potion.Commands;

import me.xingyan.potion.Statics.PotionColor;
import me.xingyan.potion.Statics.RomanNumber;
import me.xingyan.potion.Statics.vanillatobukkit;
import org.apache.commons.lang.StringUtils;
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
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("potion.admin")){
                if(args.length==0){
                    player.sendMessage("Usage:/potion <effect> <duration> <amplifier>");
                    return true;
                }
                if(args.length>=3){
                    if(Long.parseLong(args[2])<=0) {
                        player.sendMessage(ChatColor.RED+"Amplifier Must Bigger Than 0");
                        return true;
                    }
                    if(Long.parseLong(args[2])>=129) {
                        player.sendMessage(ChatColor.RED+"Amplifier Must Smaller Than 129");
                        return true;
                    }
                    if(Long.parseLong(args[1])>=Long.parseLong("536870912")){
                        player.sendMessage(ChatColor.RED+"duration Must Smaller Than 536870912");
                        return true;
                    }
                    if(Long.parseLong(args[1])<=Long.parseLong("0")){
                        player.sendMessage(ChatColor.RED+"duration Must Bigger Than 0");
                        return true;
                    }
                    //player.getInventory().addItem(createpotion(PotionEffectType.getByName(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                    if(PotionEffectType.getByName(vanillatobukkit.tobukkit(args[0])) == null){
                        player.sendMessage(ChatColor.RED+"Potion Not Found!");
                        return true;
                    }
                    player.getInventory().addItem(createpotion(PotionEffectType.getByName(vanillatobukkit.tobukkit(args[0])), Integer.parseInt(args[1])*20, Integer.parseInt(args[2])-1));
                    int remainder = Integer.parseInt(args[1]);
                    int mins = remainder / 60;
                    remainder = remainder - mins * 60;
                    String secs = String.valueOf(remainder);
                    if(secs.equals("0")){
                        secs = "00";
                    }
                    player.sendMessage(ChatColor.GREEN+"Successful Gave A "+ WordUtils.capitalizeFully(vanillatobukkit.tovanilla(PotionEffectType.getByName(vanillatobukkit.tobukkit(args[0])).getName()).toLowerCase(Locale.ROOT).replace("_", " "))+" "+RomanNumber.toRoman(Integer.parseInt(args[2]))+" Potion! ("+mins+":"+secs+")");
                    return true;
                }
            }
        }else{
            sender.sendMessage(ChatColor.RED+"Player Only Command.");
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

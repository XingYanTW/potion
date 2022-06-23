package me.xingyan.potion.Commands;

import me.xingyan.potion.Potion;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompleterTab implements TabCompleter {


    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length==1){
            //create new array
            final List<String> completions = new ArrayList<>();
            List<String> potioneffects = new ArrayList<>();

            for (PotionEffectType potion : PotionEffectType.values()){
                potioneffects.add(potion.getName());
            }

            //copy matches of first argument from list (ex: if first arg is 'm' will return just 'minecraft')
            StringUtil.copyPartialMatches(args[0], potioneffects, completions);
            //sort the list
            Collections.sort(completions);
            return completions;
        }else if(args.length==3){
            final List<String> completions = new ArrayList<>();
            List<String> amplifier = new ArrayList<>();

            for (int i=0; i<128; i++){
                amplifier.add(String.valueOf(i));
            }
            //copy matches of first argument from list (ex: if first arg is 'm' will return just 'minecraft')
            StringUtil.copyPartialMatches(args[0], amplifier, completions);
            //sort the list
            Collections.sort(completions);
            return completions;
        }else{
            return new ArrayList<>();
        }
    }
}

package me.xingyan.potion.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompleterTab implements TabCompleter {

    private static final List<String> COMMANDS = Arrays.asList("get", "reload");


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==1){
            //create new array
            final List<String> completions = new ArrayList<>();
            //copy matches of first argument from list (ex: if first arg is 'm' will return just 'minecraft')
            StringUtil.copyPartialMatches(args[0], COMMANDS, completions);
            //sort the list
            Collections.sort(completions);
            return completions;
        }
        if(args.length==2){
            if(args[0].equals("get")){
                final List<String> completions = new ArrayList<>();
                List<String> potioneffects = new ArrayList<>();

                for (PotionEffectType potion : PotionEffectType.values()){
                    potioneffects.add(potion.getName());
                }

                //copy matches of first argument from list (ex: if first arg is 'm' will return just 'minecraft')
                StringUtil.copyPartialMatches(args[1], potioneffects, completions);
                //sort the list
                Collections.sort(completions);
                return completions;
            }
        }
        return new ArrayList<>();
    }
}

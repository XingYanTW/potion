package me.xingyan.potion.Statics;

import java.util.Locale;

public class vanillatobukkit {

    public static String tobukkit(String potionname) {
        switch (potionname.toLowerCase(Locale.ROOT)) {
            case "haste":
                return "FAST_DIGGING";
            case "instant_damage":
                return "HARM";
            case "instant_health":
                return "HEAL";
            case "jump_boost":
                return "JUMP";
            case "mining_fatigue":
                return "SLOW_DIGGING";
            case "nausea":
                return "CONFUSION";
            case "resistance":
                return "DAMAGE_RESISTANCE";
            case "slowness":
                return "SLOW";
            case "strength":
                return "INCREASE_DAMAGE";
        }

        return potionname;
    }

    public static String tovanilla(String potionname) {
        switch (potionname.toUpperCase(Locale.ROOT)) {
            case "FAST_DIGGING":
                return "haste";
            case "HARM":
                return "instant_damage";
            case "HEAL":
                return "instant_health";
            case "JUMP":
                return "jump_boost";
            case "SLOW_DIGGING":
                return "mining_fatigue";
            case "CONFUSION":
                return "nausea";
            case "DAMAGE_RESISTANCE":
                return "resistance";
            case "SLOW":
                return "slowness";
            case "INCREASE_DAMAGE":
                return "strength";
        }

        return potionname;
    }
}

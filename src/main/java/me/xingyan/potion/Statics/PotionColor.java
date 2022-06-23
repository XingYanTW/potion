package me.xingyan.potion.Statics;

import org.bukkit.potion.PotionEffectType;

public class PotionColor {

    public static int color(PotionEffectType pet){

        switch (pet.getName()){
            case "NIGHT_VISION":
                return 0x2020A4;
            case "INVISIBILITY":
                return 0x818595;
            case "JUMP":
                return 0x23FC4D;
            case "FIRE_RESISTANCE":
                return 0xE89D3B;
            case "SPEED":
                return 0x7EB2CA;
            case "SLOW":
                return 0x5C6E83;
            case "WATER_BREATHING":
                return 0x2F549C;
            case "HEAL":
                return 0xFC2524;
            case "HARM":
                return 0x440A09;
            case "POISON":
                return 0x4F9632;
            case "REGENERATION":
                return 0xD15EAE;
            case "INCREASE_DAMAGE":
                return 0x962524;
            case "WEAKNESS":
                return 0x494E49;
            case "LUCK":
                return 0x349C00;
            case "SLOW_FALLING":
                return 0xFCF4D5;
        }

        return 0xFC00FC;
    }

}

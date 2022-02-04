package com.keep.ExampleEnchant.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.tr7zw.nbtapi.NBTItem;


public class EnchantsUtils {

    public static boolean hasCustomEnchant(ItemStack item, String enchantment) { // Checks if an item has an enchant
        if(!Utils.isNull(item)) {
            NBTItem nbtItem = new NBTItem(item);
            if(nbtItem.hasNBTData()) {
                for(String key : nbtItem.getKeys()) {
                    if(key.startsWith("ae_enchantment")) {
                        if(key.split(";")[1].equalsIgnoreCase(enchantment)) {
                            return key.split(";")[1].equalsIgnoreCase(enchantment);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static int getEnchantLevel(ItemStack item, String enchantment) { // Checks the enchant level on an item
        if(!Utils.isNull(item)) {
            NBTItem nbtItem = new NBTItem(item);
            if(nbtItem.hasNBTData()) {
                for(String key : nbtItem.getKeys()) {
                    if(key.startsWith("ae_enchantment") &&
                            key.split(";")[1].equalsIgnoreCase(enchantment)) {
                        //return nbtItem.getInteger(key.split(";")[1]); - Old method to get the level of the enchantment, due to NBT composition changing the code had to be adjusted too.
                        return nbtItem.getInteger(key).intValue();
                    }

                }
            }
        }
        return 0;
    }

    public static int getLevelStack(Player player, String enchantment) { // Gets the total enchant level on full armor pieces
        int levelStack = 0;
        for(ItemStack item : player.getInventory().getArmorContents()) { // Checks all armor for each enchant
            if(EnchantsUtils.hasCustomEnchant(item, enchantment)) {
                levelStack += EnchantsUtils.getEnchantLevel(item, enchantment); // Calculates the total level on all armor pieces
            }
        }
        return levelStack;
    }
}



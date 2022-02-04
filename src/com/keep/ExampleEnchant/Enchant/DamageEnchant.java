package com.keep.ExampleEnchant.Enchant;

import com.keep.ExampleEnchant.ExampleEnchant;
import com.keep.ExampleEnchant.Utils.EnchantsUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.concurrent.ThreadLocalRandom;

public class DamageEnchant implements Listener {

    public ExampleEnchant main;
    @EventHandler
    public void onDamageEnchantEvent(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            Player attacker = (Player) e.getDamager();
            Player victim = (Player) e.getEntity();

            if (EnchantsUtils.hasCustomEnchant(attacker.getItemInHand(), "Damage")) { // Get Enchant on the Item
                if (ThreadLocalRandom.current().nextInt(101) <= 50) { // Percentage of the enchant working
                    e.setDamage(e.getDamage() * 1.25); // Enchant Action
                    /*
                    Would recomend having a world guard check so enchants don't proc in safezones
                    Also you may need faction checks for some enchants so they don't proc on faction members
                     */
                }
            }
        }
    }
}

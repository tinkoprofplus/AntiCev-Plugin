package net.tinkoprof.anticev.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageListener implements Listener {

    @EventHandler
    public void onCrystalDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof EnderCrystal)) return;
        if (!(event.getEntity() instanceof Player)) return;

        EnderCrystal crystal = (EnderCrystal) event.getDamager();
        Block underBlock = crystal.getLocation().getBlock().getRelative(0, -1, 0);

        if (underBlock.getType() == Material.AIR) {
            event.setDamage(0.0);
        }
    }
}

package net.tinkoprof.anticev.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class CrystalListener implements Listener {

    @EventHandler
    public void onCrystalExplode(EntityExplodeEvent event) {
        if (!(event.getEntity() instanceof EnderCrystal)) return;

        EnderCrystal crystal = (EnderCrystal) event.getEntity();
        Block underBlock = crystal.getLocation().getBlock().getRelative(0, -1, 0);

        if (underBlock.getType() == Material.AIR) {
            event.setCancelled(true);
            crystal.remove();
        }
    }

    @EventHandler
    public void onPlayerPlaceCrystal(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        ItemStack item = event.getItem();
        if (item == null) return;
        if (item.getType() != Material.END_CRYSTAL) return;

        Block clickedBlock = event.getClickedBlock();
        if (clickedBlock == null) return;

        Block underBlock = clickedBlock.getRelative(0, 1, 0).getRelative(0, -1, 0);
        if (underBlock.getType() == Material.AIR) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("Go play cc you fucking cev user");
        }
    }
}

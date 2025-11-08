package net.tinkoprof.anticev;

import net.tinkoprof.anticev.listeners.*;

import org.bukkit.plugin.java.JavaPlugin;

public final class AntiCev extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("AntiCev developed by Tinkoprof bcz HumanBeing fucking hate cev/civ user faggots");
        getServer().getPluginManager().registerEvents(new CrystalListener(), this);
        getServer().getPluginManager().registerEvents(new DamageListener(), this);
        getLogger().info("AntiCev is loaded!");;
    }

    @Override
    public void onDisable() {
        getLogger().info("AntiCev is disabled!");
    }
}

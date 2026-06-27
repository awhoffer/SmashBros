package org.mcmaster01.listeners;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;

import net.kyori.adventure.text.Component;


public class PlayerToggleSneakListener implements Listener {

@EventHandler
private void onPlayerToggleSneak(PlayerToggleSneakEvent event){
Player player = event.getPlayer();
if(event.isSneaking()){
Material blockBelow = player.getLocation().add(0, -0.1, 0).getBlock().getType();
//if player is in the air and sneaking then allow for a smash by setting the "playersmash" property to true.
if(blockBelow == Material.AIR || blockBelow == Material.CAVE_AIR){
player.getPersistentDataContainer().set(new NamespacedKey(NamespacedKey.BUKKIT, "playersmash"), 
PersistentDataType.BOOLEAN, true);
player.setVelocity(new Vector(0, -1, 0));
}
//lets check to see if player is trying to negate a grab by seeing if metadata 'playerGrabbed' was set to true. False if it wasn't set.
if(player.getPersistentDataContainer().
getOrDefault(new NamespacedKey(NamespacedKey.BUKKIT, "playergrabbed"),  PersistentDataType.BOOLEAN,false)){
//get players location when mounted and target location a block behind it  
Location targetLocation = player.getLocation().subtract(1, 0, 0);

//dismount the player and tp 1 block back
player.leaveVehicle();
player.teleport(targetLocation);
//have no message in Action Bar
player.sendActionBar(Component.text());
}
    
}

}
}

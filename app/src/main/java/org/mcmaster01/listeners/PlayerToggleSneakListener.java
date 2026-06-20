package org.mcmaster01.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class PlayerToggleSneakListener implements Listener {

@EventHandler
private void onPlayerSmash(PlayerToggleSneakEvent event){

Player player = event.getPlayer();
Material blockBelow = player.getLocation().add(0, -0.1, 0).getBlock().getType();
//if player is in the air then allow for a smash
if(blockBelow == Material.AIR || blockBelow == Material.CAVE_AIR){
player.getLocation().getNearbyPlayers(3, 3, null).forEach(enemy->{
//get the damage incurred and based on that give them a velocity to shoot them backwards. Damage points will be added in entity hit event. 
//this is still in progress :)
}

);


}


}    
    
}
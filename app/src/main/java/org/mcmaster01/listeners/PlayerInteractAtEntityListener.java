package org.mcmaster01.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.mcmaster01.events.PlayerGrabEvent;;

public class PlayerInteractAtEntityListener implements Listener {
@EventHandler
private void onPlayerInteractEntity(PlayerInteractAtEntityEvent event){
Player player = event.getPlayer();    
if(event.getRightClicked() instanceof Player && player.getPassengers().isEmpty()){
Player playerToGrab = (Player)event.getRightClicked();    
//player is attempting to grab player. So now lets call the grab event.
PlayerGrabEvent grabEvent = new PlayerGrabEvent(player,playerToGrab); 
grabEvent.callEvent();
}
}    


    
}

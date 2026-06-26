package org.mcmaster01.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.mcmaster01.events.PlayerGrabEvent;;

public class PlayerInteractEntityListener implements Listener {
@EventHandler
private void onPlayerInteractEntity(PlayerInteractEntityEvent event){
Player player = event.getPlayer();    
if(event.getRightClicked() instanceof Player){
Player playerToGrab = (Player)event.getRightClicked();    
//player is attempting to grab player. So now lets call the grab event.
PlayerGrabEvent grabEvent = new PlayerGrabEvent(player,playerToGrab); 
grabEvent.callEvent();
}


}    


    
}

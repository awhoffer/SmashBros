package org.mcmaster01.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.mcmaster01.events.PlayerThrowEvent;

public class PlayerInteractListener implements Listener {
    @EventHandler
    private void onPlayerInteract(PlayerInteractEvent event){
    //check to see if player has another player grabbed and if they left clicked to throw
    Player player = event.getPlayer();
    if(event.getAction().isLeftClick() && player.getPassengers().size()==1){
       if(player.getPassengers().get(0) instanceof Player){
        Player grabbedPlayer =(Player)player.getPassengers().get(0);
        //now call the throw event since player wants to throw the other player
        PlayerThrowEvent playerThrowEvent = new PlayerThrowEvent(player, grabbedPlayer);
        playerThrowEvent.callEvent();
       }
        
    }    

    }


}

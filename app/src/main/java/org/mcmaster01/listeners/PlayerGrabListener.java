package org.mcmaster01.listeners;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;
import org.mcmaster01.events.PlayerGrabEvent;

import net.kyori.adventure.text.Component;
/*
Listener for the PlayerGrabEvent which adds Player on top of the player that wants to grab.
*/
public class PlayerGrabListener implements Listener {

    @EventHandler
    private void onPlayerGrab(PlayerGrabEvent event){
    Player playerToGrab = event.getPlayerToGrab();
    Player player = event.getPlayer();
    //add player as passenger to the player that wants to grab    
    player.addPassenger(event.getPlayerToGrab());   
    //set metadata for the player grabbed with value of true
    playerToGrab.getPersistentDataContainer().set(new NamespacedKey(NamespacedKey.BUKKIT, "playergrabbed"), PersistentDataType.BOOLEAN,true);
    //now send player a message telling him he can negate grab by using shift
    playerToGrab.sendActionBar(Component.text("Tap \"Shift\" to Negate Grab")); 
}



}
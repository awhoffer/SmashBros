package org.mcmaster01.listeners;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;
import org.mcmaster01.events.PlayerThrowEvent;

public class PlayerThrowListener implements Listener{
@EventHandler
private void onPlayerThrow(PlayerThrowEvent event){
        Player player = event.getPlayer();
        Player grabbedPlayer = event.getGrabbedPlayer();
        //dismount and throw the grabbed player
        grabbedPlayer.leaveVehicle();
        grabbedPlayer.setVelocity(player.getLocation().getDirection().multiply(new Vector(3,1,1)));
        //set metadata for playergrabbed to false
        grabbedPlayer.getPersistentDataContainer().set(new NamespacedKey(NamespacedKey.BUKKIT, "playergrabbed"), 
        PersistentDataType.BOOLEAN,false);

}


}
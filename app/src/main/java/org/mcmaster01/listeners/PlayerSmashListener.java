package org.mcmaster01.listeners;

import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;
import org.mcmaster01.events.PlayerSmashEvent;

public class PlayerSmashListener implements Listener{
    

 @EventHandler
 private void onPlayerSmash(PlayerSmashEvent event){

 Player player = event.getPlayer(); 
if(player.getExp()==.99f){return;}
 player.getLocation().getNearbyPlayers(3, 1, null).forEach(enemy->{
if(enemy.getUniqueId()!= player.getUniqueId()){
//get the damage incurred and based on that deal knockback to shoot them backwards. Damage points will be added in entity hit event to determine. 
//for now lets just shoot them back
enemy.knockback(4, player.getLocation().getX(), player.getLocation().getZ());
}
}
);
//do a particle effect
player.spawnParticle(Particle.EGG_CRACK,player.getLocation(),27,3,0,3);
//smash player smash event has ended so set the value back to false.
player.getPersistentDataContainer().set(new NamespacedKey(NamespacedKey.BUKKIT, "playersmash"), PersistentDataType.BOOLEAN, false);

 }   
}

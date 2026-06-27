package org.mcmaster01.listeners;

import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;
import org.mcmaster01.events.PlayerSmashEvent;

import com.destroystokyo.paper.ParticleBuilder;



public class PlayerSmashListener implements Listener{
    

 @EventHandler
 private void onPlayerSmash(PlayerSmashEvent event){

 Player player = event.getPlayer(); 
if(player.getExp()==.99f){return;}
 player.getLocation().getNearbyPlayers(3, 2, null).forEach(enemy->{
if(enemy.getUniqueId()!= player.getUniqueId()){
//get the damage incurred and based on that deal knockback to shoot them backwards. Damage points will be added in entity hit event to determine. 
//for now lets just shoot them back
enemy.knockback(4, player.getLocation().getX(), player.getLocation().getZ());
//add damage points to the scoreboard - this needs implemented
}
}
);
player.getWorld().playSound(player,Sound.ITEM_MACE_SMASH_GROUND_HEAVY,1f,0f);
//create the particle using builder
ParticleBuilder particleBuilder = new ParticleBuilder(Particle.BLOCK_CRUMBLE)
.location(player.getLocation())
.data(player.getLocation().add(0, -0.1, 0).getBlock().getBlockData())
.offset(3, 2, 3)
.count(108)
.receivers(50);
//do a particle effect
//player.spawnParticle(Particle.BLOCK_CRUMBLE,player.getLocation(),108,3,2,3,player.getLocation().add(0, -0.1, 0).getBlock().getBlockData());
particleBuilder.spawn();
//smash player smash event has ended so set the value back to false.
player.getPersistentDataContainer().set(new NamespacedKey(NamespacedKey.BUKKIT, "playersmash"), PersistentDataType.BOOLEAN, false);

 }   
}

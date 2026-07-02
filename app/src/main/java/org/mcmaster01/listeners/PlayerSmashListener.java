package org.mcmaster01.listeners;

import java.util.Collection;

import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scoreboard.Score;
import org.mcmaster01.events.PlayerSmashEvent;

import com.destroystokyo.paper.ParticleBuilder;




public class PlayerSmashListener implements Listener{
 private final int damage = 10;   

 @EventHandler
 private void onPlayerSmash(PlayerSmashEvent event){

 Player player = event.getPlayer(); 
if(player.getExp()==.99f){return;}
 Collection<Player> enemyCollection =player.getLocation().getNearbyPlayers(3, 2, playerObj->!playerObj.getUniqueId().equals(player.getUniqueId()));
 for(Player enemy: enemyCollection){
Score enemyDamageScore = enemy.getScoreboard().getObjective("damagepercentage").getScore(enemy.getName());
//get the damage incurred and based on that deal knockback to shoot them backwards. Damage points will be added in entity hit event to determine. 
int currentDamage = enemyDamageScore.getScore();
int damageAfterSmash = currentDamage + damage;
//shoot them back
enemy.setVelocity(player.getLocation().getDirection().multiply(determineVelocityStrength(currentDamage)));
//set the score to the new dmg point percentage
enemyDamageScore.setScore(damageAfterSmash);

}  
player.getWorld().playSound(player,Sound.ITEM_MACE_SMASH_GROUND_HEAVY,1f,0f);
//create the particle using builder
ParticleBuilder particleBuilder = new ParticleBuilder(Particle.BLOCK_CRUMBLE)
.location(player.getLocation())
.data(player.getLocation().add(0, -0.1, 0).getBlock().getBlockData())
.offset(3, 2, 3)
.count(108)
.receivers(50);
//do a particle effect
particleBuilder.spawn();
//smash player smash event has ended so set the value back to false.
player.getPersistentDataContainer().set(new NamespacedKey(NamespacedKey.BUKKIT,"playersmash"), 
PersistentDataType.BOOLEAN, false);
 }
 
 
 private double determineVelocityStrength(int pDamagePoints){
    if(pDamagePoints>=0 && pDamagePoints<20){
        return 3d;
    }else if(pDamagePoints>=20 &&pDamagePoints<40){
        return 4d;
    }else if(pDamagePoints>=40 && pDamagePoints<60){
        return 5d;
    }else if (pDamagePoints>=60&& pDamagePoints<80){
        return 7d;
    }else if(pDamagePoints>=80){
        return 9d;
    }else{return 0d;}
    
 }
}

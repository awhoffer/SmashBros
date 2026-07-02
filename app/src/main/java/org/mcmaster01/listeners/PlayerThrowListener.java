package org.mcmaster01.listeners;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scoreboard.Score;
import org.mcmaster01.events.PlayerThrowEvent;


public class PlayerThrowListener implements Listener{
private final int damage = 10;
@EventHandler
private void onPlayerThrow(PlayerThrowEvent event){    
        Player player = event.getPlayer();
        Player grabbedPlayer = event.getGrabbedPlayer();
        //dismount and throw the grabbed player
        grabbedPlayer.leaveVehicle();
        PersistentDataContainer grabbedPlayerDataContainer = grabbedPlayer.getPersistentDataContainer(); 
        //get the percentdamage objective from grabbed player
        Score playerDamageScore = grabbedPlayer.getScoreboard().getObjective("damagepercentage").getScore(grabbedPlayer.getName());
        //get the current number of damage points
        int currentDamage = playerDamageScore.getScore();
        int damagerAfterThrow = currentDamage+damage;
        grabbedPlayer.setVelocity(player.getLocation().getDirection().multiply(determineVelocityStrength(currentDamage)));
        //set the damage 
        playerDamageScore.setScore(damagerAfterThrow);  
        //set metadata for playergrabbed to false
        grabbedPlayerDataContainer.set(new NamespacedKey(NamespacedKey.BUKKIT,"playergrabbed"), 
        PersistentDataType.BOOLEAN,false);
        //set display name of grabbed player to new dmg point percentage
        playerDamageScore.setScore(damagerAfterThrow);
}

 private double determineVelocityStrength(int pDamagePoints){
    if(pDamagePoints>=0 && pDamagePoints<20){
        return 1d;
    }else if(pDamagePoints>=20 &&pDamagePoints<40){
        return 1.5d;
    }else if(pDamagePoints>=40 && pDamagePoints<60){
        return 2d;
    }else if (pDamagePoints>=60&& pDamagePoints<80){
        return 3d;
    }else if(pDamagePoints>=80){
        return 4d;
    }else{return 0d;}
    
 }
}
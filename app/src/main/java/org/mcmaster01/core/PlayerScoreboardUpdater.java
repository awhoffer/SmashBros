package org.mcmaster01.core;




import org.bukkit.entity.Player;

import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;



/**
 * 
 * PlayerScoreboardUpdater updates the individual scoreboards so that damage point percentage can be shown
 * below the player's name
 */
public class PlayerScoreboardUpdater implements Runnable{
Plugin mPlugin;
    public PlayerScoreboardUpdater(Plugin pPlugin){
        this.mPlugin = pPlugin;
}    
    @Override
    public void run() {
        if(!mPlugin.getServer().getOnlinePlayers().isEmpty()){
           for(Player onlinePlayer : mPlugin.getServer().getOnlinePlayers()){
                Scoreboard sb = onlinePlayer.getScoreboard();
            Objective playerDamageObjective = sb.getObjective("damagepercentage");
            if (playerDamageObjective != null) {
            for(Player otherPlayer : mPlugin.getServer().getOnlinePlayers()){
            //we only want other players so we can update the current onlinePlayer object's scoreboard
            if(!otherPlayer.getName().equals(onlinePlayer.getName()) && 
            otherPlayer.getScoreboard().getObjective("damagepercentage")!=null){
            // Sets the score for damage percentage of other player in player's scoreboard so that the player
            //can see the damage percentage below name of other player on their client 
            playerDamageObjective.getScore(otherPlayer.getName()).setScore(otherPlayer.getScoreboard().getObjective("damagepercentage").getScore(otherPlayer.getName()).getScore()); 
            }    
      
            }    

            }

           } 
            

        }
    }
    
}

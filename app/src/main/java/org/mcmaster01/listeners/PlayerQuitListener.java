package org.mcmaster01.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener{
    
  @EventHandler
  private void onPlayerQuit(PlayerQuitEvent event){
    Player player = event.getPlayer();
    //set players scoreboard back to the main scoreboard so the instance of the scoreboard given to player on Join event can get
    //deleter from memory
    player.setScoreboard(player.getServer().getScoreboardManager().getMainScoreboard());
    
    

  }  
    
}

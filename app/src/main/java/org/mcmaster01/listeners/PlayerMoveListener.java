package org.mcmaster01.listeners;


import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
/*
    Event Listener for when the Player double jumps. Double Jumping is determined based on the PlayerMoveEvent
 */
public class PlayerMoveListener implements Listener {

@EventHandler    
private void onPlayerDoubleJump(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR) {
            return;
        }

        //determine if player is back on the ground by checking block under player
         Material blockBelow = player.getLocation().add(0, -0.1, 0).getBlock().getType();
        // Check if the player is standing on the ground before allowing for double jump
        if (blockBelow != Material.CAVE_AIR && blockBelow !=Material.AIR && !player.getAllowFlight()) {
            player.setAllowFlight(true); // Reset the double jump
            //set exp bar to full so that it shows the player can jump 
            player.setExp(.99f);
        }


}

}

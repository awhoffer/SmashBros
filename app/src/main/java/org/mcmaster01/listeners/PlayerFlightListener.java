package org.mcmaster01.listeners;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class PlayerFlightListener implements Listener{

    @EventHandler
    private void onPlayerFlight(PlayerToggleFlightEvent event){
        Player player = event.getPlayer();
       if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR) {
            return; // Don't interfere with creative flight
        }
 event.setCancelled(true); // Stop them from hovering
player.setAllowFlight(false); // Consume the double jump
//set the exp bar to empty to show player cannot jump
player.setExp(0f);
double playerPitch = player.getLocation().getDirection().getY();
//check player head pitch to determine a higher jump vs a long jump(i.e. skip jump)
if(playerPitch<=-.66d||playerPitch>.49d){
// Apply upward and forward boost 
player.setVelocity(player.getLocation().getDirection().multiply(2).setY(1));
}else{
//skip jump occurs
player.setVelocity(player.getLocation().getDirection().multiply(2));
} 
//play jump sound
player.playSound(player,Sound.ENTITY_IRON_GOLEM_STEP,1f,1.3f);       
    }

}
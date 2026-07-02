package org.mcmaster01.listeners;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

public class PlayerJoinListener implements Listener{

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event){
    Player player = event.getPlayer();
    Component textComponent = Component.text().content("Welcome To SmashBros Server ").color(TextColor.color(0x50C878))
    .append(Component.text().content(player.getName()).color(TextColor.color(0xFF0000))).build();    
    player.setExp(.99f);
    player.sendMessage(textComponent);
    int defaultDamagePoints = 0; 
    
    //set player meta data damagepoints to zero
    player.getPersistentDataContainer().set(new NamespacedKey(NamespacedKey.BUKKIT,"damagepoints"), PersistentDataType.INTEGER,0);
    //now lets create a scoreboard which will display the damage they incur when in a match
    Scoreboard playerScoreboard = player.getServer().getScoreboardManager().getNewScoreboard();

    Objective playerObjective = 
    playerScoreboard.registerNewObjective("damagepercentage",Criteria.DUMMY,Component.text("%"));    
    
    //now lets set the display name to show 0% for damage as we have 0% damage
    playerObjective.getScore(player.getName()).setScore(defaultDamagePoints);
    //playerObjective.numberFormat(NumberFormat.blank());
    playerObjective.setDisplaySlot(DisplaySlot.BELOW_NAME);

    //assign scoreboard to player
    player.setScoreboard(playerScoreboard);
    };






    }
    




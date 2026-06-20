package org.mcmaster01.listeners;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

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
    }
    



}
package org.mcmaster01.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerThrowEvent extends Event {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    Player mPlayer;
    Player mGrabbedPlayer;
    public PlayerThrowEvent(Player pPlayer, Player pGrabbedPlayer){
     this.mPlayer = pPlayer;
     this.mGrabbedPlayer = pGrabbedPlayer;   
    }


     public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }


    public Player getPlayer(){
        return mPlayer;
    }

    public Player getGrabbedPlayer(){
        return mGrabbedPlayer;
    }
}

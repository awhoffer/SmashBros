package org.mcmaster01.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class PlayerGrabEvent extends Event {
  private static final HandlerList HANDLER_LIST = new HandlerList();
    private Player mPlayer;
    private Player mPlayerToGrab;

    public PlayerGrabEvent(Player pPlayer, Player pPlayerToGrab){
        this.mPlayer = pPlayer;
        this.mPlayerToGrab = pPlayerToGrab;
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
    public Player getPlayerToGrab(){
        return mPlayerToGrab;
    }

    
}

package org.mcmaster01.events;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class PlayerSmashEvent extends Event{

    private static final HandlerList HANDLER_LIST = new HandlerList();
    private Player mPlayer;

    public PlayerSmashEvent(Player pPlayer){
        this.mPlayer = pPlayer;
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

    



}
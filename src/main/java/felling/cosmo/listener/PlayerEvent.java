package felling.cosmo.listener;

import felling.cosmo.CosmoFelling;
import felling.cosmo.classes.FellingCaches;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerEvent implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getAction() == Action.LEFT_CLICK_BLOCK){
            if(event.getClickedBlock().getLocation().getBlockY() == (event.getPlayer().getLocation().getBlockY() + 1)){
                if(CosmoFelling.map.containsKey(event.getClickedBlock().getType())){
                    if(!CosmoFelling.map2.containsKey(event.getClickedBlock().getLocation())){
                        CosmoFelling.map2.put(event.getClickedBlock().getLocation(), new FellingCaches(event.getClickedBlock().getLocation(), CosmoFelling.map.get(event.getClickedBlock().getType())));
                    }else{
                        CosmoFelling.map2.get(event.getClickedBlock().getLocation()).increase();
                    }
                }
            }
        }

    }
}

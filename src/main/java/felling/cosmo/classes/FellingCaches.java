package felling.cosmo.classes;

import felling.cosmo.CosmoFelling;
import felling.cosmo.util.FAWEHandler;
import org.bukkit.Location;

import java.util.LinkedHashMap;

public class FellingCaches {
    Location loc;
    FellingTypes ft;
    LinkedHashMap<String, Integer> a;
    String curr;
    int now = 0;
    int counter = 0;
    public FellingCaches(Location loc, FellingTypes ft){
        this.loc = loc;
        this.ft = ft;
        this.a = ft.clonedMap();
        curr = (String)a.keySet().toArray()[0];
    }
    public void increase(){
        counter++;
        System.out.println(curr + " and "+counter);
        if(a.get(curr) <= counter){
          //  FAWEHandler.pasteSchematic(curr, loc, false);
            counter = 0;
            now++;
            if(a.keySet().size() > now){
                curr = (String)a.keySet().toArray()[now];
            }
            else{
                if(ft.getFinish() != null){
                    //  FAWEHandler.pasteSchematic(ft.getFinish(), loc, false);
                }
                CosmoFelling.map2.remove(loc);
            }

        }
    }
}

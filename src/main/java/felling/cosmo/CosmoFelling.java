package felling.cosmo;

import felling.cosmo.classes.FellingCaches;
import felling.cosmo.classes.FellingTypes;
import felling.cosmo.listener.PlayerEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class CosmoFelling extends JavaPlugin {
    public static HashMap<Material, FellingTypes> map = new HashMap<Material, FellingTypes>();
    public static HashMap<Location, FellingCaches> map2 = new HashMap<Location, FellingCaches>();
    public static CosmoFelling INSTANCE;
    public void onEnable(){
        this.saveDefaultConfig();
        INSTANCE = this;
        getServer().getPluginManager().registerEvents(new PlayerEvent(), this);
        loadALL();
    }
    public void loadALL(){
        if(getConfig().contains("종류")){
            for(String s : getConfig().getConfigurationSection("종류").getKeys(false)){
                if(getConfig().contains("종류."+s+".블럭아이디")){
                    map.put(Material.getMaterial(getConfig().getInt("종류."+s+".블럭아이디")), new FellingTypes(s));
                }
            }
        }
    }
}

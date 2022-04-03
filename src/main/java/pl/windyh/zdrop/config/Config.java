package pl.windyh.zdrop.config;

import org.bukkit.Material;
import pl.windyh.zdrop.ZDrop;

import java.util.ArrayList;
import java.util.List;

public class Config {

    public final boolean addItemToPlayerInventory = ZDrop.getPluginInst().getConfig().getBoolean("add-to-player-inventory");
    public final boolean blockOreDrop = ZDrop.getPluginInst().getConfig().getBoolean("block-ore-drop");
    public final List<Material> blockedOres = new ArrayList<Material>();
    public Config(){
        for(String s : ZDrop.getPluginInst().getConfig().getStringList("blocked-ores")){
            blockedOres.add(Material.matchMaterial(s));
        }
    }


}

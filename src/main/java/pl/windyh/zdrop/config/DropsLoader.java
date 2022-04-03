package pl.windyh.zdrop.config;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import pl.windyh.zdrop.models.Drop;
import pl.windyh.zdrop.models.DropGroup;

public class DropsLoader {




    public static void loadDrops(){
        DropGroup.getDropGroups().clear();
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(Files.drops);
        for(String s : yml.getKeys(false)) {
            ConfigurationSection cs1 = yml.getConfigurationSection(s);
            DropGroup dropGroup = new DropGroup(s, cs1.getInt("priority"));
            ConfigurationSection dropSources = cs1.getConfigurationSection("drops");
            for (String dropSource : dropSources.getKeys(false)) {
                ConfigurationSection drops = dropSources.getConfigurationSection(dropSource);
                for (String drop : drops.getKeys(false)) {
                    ConfigurationSection dropConfig = drops.getConfigurationSection(drop);
                    Drop drop1 = new Drop(Material.matchMaterial(dropSource), Material.matchMaterial(drop), dropConfig.getInt("quantity"), dropConfig.getDouble("chance"));
                    drop1.setMessage((dropConfig.getString("message")==null) ? null : dropConfig.getString("message"));
                    dropGroup.addDrop(drop1);
                }
            }
            DropGroup.addDropGroup(dropGroup);
        }
        DropGroup.sortList();
    }
}

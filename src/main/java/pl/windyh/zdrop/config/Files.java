package pl.windyh.zdrop.config;

import pl.windyh.zdrop.ZDrop;

import java.io.File;

public class Files {

    public static final File mainDir = ZDrop.getPluginInst().getDataFolder();
    public static final File drops = new File(mainDir, "drop.yml");
    public static final File config = new File(mainDir, "config.yml");

    public static void checkFiles(){
        if(!drops.exists()) ZDrop.getPluginInst().saveResource("drop.yml", false);
        if(!config.exists()) ZDrop.getPluginInst().saveDefaultConfig();
    }
}

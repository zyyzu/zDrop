package pl.windyh.zdrop;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.C;
import pl.windyh.zdrop.commands.CommandHandler;
import pl.windyh.zdrop.config.Config;
import pl.windyh.zdrop.config.DropsLoader;
import pl.windyh.zdrop.config.Files;
import pl.windyh.zdrop.listeners.BlockDrop;
import pl.windyh.zdrop.listeners.BlockDropOverride;

public final class ZDrop extends JavaPlugin {

    private static ZDrop pluginInst;
    private static Config cfg;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"===: zDrop is loading...");
        pluginInst = this;
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"===: Checking files...");
        Files.checkFiles();
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"===: Checking completed");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"===: Loading drops...");
        DropsLoader.loadDrops();
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"===: Loading drops completed");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"===: Loading listeners...");
        Bukkit.getPluginManager().registerEvents(new BlockDropOverride(), this);
        Bukkit.getPluginManager().registerEvents(new BlockDrop(), this);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"===: Listeners loaded");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"===: Loading config...");
        cfg = new Config();
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"===: Config loaded");
        getCommand("reload").setExecutor(new CommandHandler());
        getCommand("drop").setExecutor(new CommandHandler());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"===: zDrop loaded!");
    }

    @Override
    public void onDisable() {



        pluginInst = this;
    }
    public static ZDrop getPluginInst(){
        return pluginInst;
    }
    public static Config getCfg(){
        return cfg;
    }
    public static void rewriteConfig(){
        cfg = new Config();
    }

}

package pl.windyh.zdrop.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import pl.windyh.zdrop.ZDrop;
import pl.windyh.zdrop.config.DropsLoader;

public class ReloadCmd {

    public ReloadCmd(CommandSender sender, String[] args){
        if(args.length!=1){
            sender.sendMessage("Poprawne uzycie: /reload (all/config/drops)");
            return;
        }
        if(args[0].equalsIgnoreCase("all")){
            sender.sendMessage(ChatColor.GREEN+"Przeladowano konfiguracje!");
            ZDrop.rewriteConfig();
            DropsLoader.loadDrops();
            return;
        }
        if(args[0].equalsIgnoreCase("config")){
            sender.sendMessage(ChatColor.GREEN+"Przeladowano konfiguracje!");
            ZDrop.rewriteConfig();
            return;
        }
        if(args[0].equalsIgnoreCase("drops")){
            sender.sendMessage(ChatColor.GREEN+"Przeladowano konfiguracje!");
            DropsLoader.loadDrops();
            return;
        }

    }
}

package pl.windyh.zdrop.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("reload")){
            new ReloadCmd(sender, args);
            return true;
        }
        if(command.getName().equalsIgnoreCase("drop")){
            new DropCmd(sender, command, label, args);
            return true;
        }
        return false;
    }
}

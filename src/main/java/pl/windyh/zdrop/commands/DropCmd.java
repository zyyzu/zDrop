package pl.windyh.zdrop.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.windyh.zdrop.models.DropGroup;

import java.util.ArrayList;

public class DropCmd {

    public DropCmd(CommandSender sender, Command command, String label, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Ta komenda może zostać wywołana tylko przez gracza");
            return;
        }
        if(!sender.hasPermission("zdrop.drop")){
            sender.sendMessage(ChatColor.RED+"Nie masz uprawnień do tej komendy!");
            return;
        }
        Player player = (Player) sender;

        DropGroup group = DropGroup.getGroup(player);
        Inventory dropInv = Bukkit.createInventory(player, 54, "Dropy");
        ItemStack closeButton = new ItemStack(Material.BARRIER, 1);
        ItemMeta meta = closeButton.getItemMeta();
        meta.setDisplayName("Zamknij");
        closeButton.setItemMeta(meta);
        dropInv.setItem(53, closeButton);
        for(int i = 0; i<group.getDrops().size(); i++){
            dropInv.setItem(i, new ItemStack(group.getDrops().get(i).getDrop()));
        }
        player.openInventory(dropInv);
    }
}

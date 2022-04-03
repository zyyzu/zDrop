package pl.windyh.zdrop.listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import pl.windyh.zdrop.ZDrop;
import pl.windyh.zdrop.models.Drop;
import pl.windyh.zdrop.models.DropGroup;

public class BlockDrop implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Player p = event.getPlayer();
        DropGroup dg = DropGroup.getGroup(p);
        if(dg==null) return;
        double randomDouble = Math.random() * 1000;
        for(Drop d : dg.getDrops()){
            if(!event.getBlock().getType().equals(d.getSource())){
                continue;
            }
            if(d.getChance()*10>=randomDouble){
                event.setCancelled(true);
                event.getBlock().setType(Material.AIR);
                ItemStack toDrop = new ItemStack(d.getDrop(), d.getQuantity());
                if(ZDrop.getCfg().addItemToPlayerInventory) event.getPlayer().getInventory().addItem(toDrop);
                else event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), toDrop);
                if(d.getMessage()!=null) event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', d.getMessage()));
            }
        }
    }
}

package pl.windyh.zdrop.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import pl.windyh.zdrop.ZDrop;

public class BlockDropOverride implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if(!ZDrop.getCfg().blockOreDrop) return;
        Material broken = event.getBlock().getType();
        if(ZDrop.getCfg().blockedOres.contains(broken)){
            event.setCancelled(true);
            event.getBlock().setType(Material.AIR);
            ItemStack cobble = new ItemStack(Material.COBBLESTONE, 1);
            if(ZDrop.getCfg().addItemToPlayerInventory) event.getPlayer().getInventory().addItem(cobble);
            else event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), cobble);
        }
    }
}

package pl.windyh.zdrop.models;

import org.bukkit.entity.Player;
import pl.windyh.zdrop.config.DropComparator;

import java.util.ArrayList;
import java.util.List;

public class DropGroup{

    private String permission;
    private int priority;
    private List<Drop> drops = new ArrayList<Drop>();

    private static List<DropGroup> dropGroups = new ArrayList<DropGroup>();


    public static void addDropGroup(DropGroup dg){
        dropGroups.add(dg);
    }
    public static void removeDropGroup(DropGroup dg){
        dropGroups.remove(dg);
    }

    public DropGroup(String permission, int priority) {
        this.permission = permission;
        this.priority = priority;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<Drop> getDrops() {
        return drops;
    }

    public void setDrops(List<Drop> drops) {
        this.drops = drops;
    }
    public void addDrop(Drop d){
        if(!this.drops.contains(d)) this.drops.add(d);
    }
    public void removeDrop(Drop d){
        if(this.drops.contains(d)) this.drops.remove(d);
    }

    public static void sortList(){
        dropGroups.sort(new DropComparator());
    }
    public static List<DropGroup> getDropGroups() {
        return new ArrayList<>(dropGroups);
    }

    public static DropGroup getGroup (Player p){
        for(DropGroup forDG : DropGroup.getDropGroups()){
            if(p.hasPermission("zdrop.dropgroup."+forDG)){
                return forDG;
            }
        }
        return null;
    }
}

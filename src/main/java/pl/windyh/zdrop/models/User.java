package pl.windyh.zdrop.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    private List<Drop> blockedDrops = new ArrayList<>();
    private UUID uuid;
    private static List<User> users = new ArrayList<>();

    public User(UUID uuid){
        this.uuid = uuid;
    }

    public List<Drop> getBlockedDrops() {
        return blockedDrops;
    }

    public void setBlockedDrops(List<Drop> blockedDrops) {
        this.blockedDrops = blockedDrops;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void blockDrop(Drop d){
        blockedDrops.add(d);
    }
    public void unBlockDrop(Drop d){
        blockedDrops.remove(d);
    }
}
